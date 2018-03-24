package com.infoshareacademy.czerwoni.users.ejb;

import java.security.SecureRandom;
import java.util.Arrays;
import javax.ejb.Stateless;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Stateless
public class TokenServiceBean implements TokenService {

    private final SecureRandom secureRandom = new SecureRandom();

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
    public Cookie fetchTokenCookie(HttpServletRequest httpReq) {
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
