package com.infoshareacademy.czerwoni.users.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.ejb.Stateless;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Stateless
public class TokenServiceBean implements TokenService {

    private final SecureRandom secureRandom = new SecureRandom();
    private static final Logger LOG = LoggerFactory.getLogger(TokenServiceBean.class);
    private static final String TOKEN_VIOLATION = "Niezgodność tokenów!";
    private static final String NO_COOKIE_OR_EMPTY = "Brak cookie (lub puste)!";

    private static final String CSRF_TOKEN_NAME = "X-TOKEN";
    public static final String LOGIN_URI = "/login";

    @Override
    public String generateToken() {
        byte[] buffer = new byte[50];
        this.secureRandom.nextBytes(buffer);
        return DatatypeConverter.printHexBinary(buffer);
    }

    @Override
    public String buildCookieName(String reqURI) {
        String backendServiceName = reqURI.replaceAll("/", "-");
        return CSRF_TOKEN_NAME + "-" + backendServiceName;
    }

    @Override
    public boolean validateTokens(ServletRequest servletReq) throws IOException {
        HttpServletRequest httpReq = (HttpServletRequest) servletReq;

        Cookie tokenCookie = fetchTokenCookie(httpReq);
        if (!isTokenCookieValid(tokenCookie)) {
            return false;
        }

        String tokenFromReq = servletReq.getParameter("token");
        return areTokensIdentical(tokenCookie, tokenFromReq);
    }

    private boolean areTokensIdentical(Cookie tokenCookie, String tokenFromReq) {
        boolean areValid = (tokenFromReq != null) && tokenFromReq.equals(tokenCookie.getValue());
        if (!areValid) {
            LOG.warn(TOKEN_VIOLATION);
        }
        return areValid;
    }

    private Boolean isTokenCookieValid(Cookie tokenCookie) {

        boolean isValid = !(tokenCookie == null || tokenCookie.getValue().trim().equals(""));
        if (!isValid) {
            LOG.info(NO_COOKIE_OR_EMPTY);
        }
        return isValid;
    }

    private Cookie fetchTokenCookie(HttpServletRequest httpReq) {
        Cookie cookie = null;
        if (httpReq.getCookies() != null) {
            String cookieExpectedName = buildCookieName(httpReq.getRequestURI());
            cookie = Arrays.stream(httpReq.getCookies())
                    .filter(c -> c.getName().equals(cookieExpectedName))
                    .findFirst()
                    .orElse(null);
        }
        return cookie;
    }
}
