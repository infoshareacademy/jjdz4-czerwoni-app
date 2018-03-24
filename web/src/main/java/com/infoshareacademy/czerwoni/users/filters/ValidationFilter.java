package com.infoshareacademy.czerwoni.users.filters;

import com.infoshareacademy.czerwoni.users.ejb.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(
        filterName = "ValidationFilter",
        urlPatterns = {"/login"}
)
public class ValidationFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(ValidationFilter.class);
    private static final String TOKEN_VIOLATION = "Niezgodność tokenow !";
    private static final String NO_COOKIE_OR_EMPTY = "Brak ciasteczka... ktoś był głodny? ;-)";

    @Inject
    private TokenService tokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        Cookie tokenCookie = tokenService.fetchTokenCookie(httpReq);

        if (tokenCookie == null || tokenCookie.getValue().trim().equals("")) {
            LOG.info(NO_COOKIE_OR_EMPTY);
            httpResp.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else if (validateTokens(tokenCookie, servletRequest, httpResp)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean validateTokens(Cookie tokenCookie, ServletRequest servletRequest, HttpServletResponse httpResp) throws IOException {
        boolean isValid;
        String tokenFromReq = servletRequest.getParameter("token");

        isValid = (tokenFromReq != null);
        if (isValid) {
            isValid = tokenFromReq.equals(tokenCookie.getValue());
        }
        if (!isValid) {
            LOG.warn(TOKEN_VIOLATION);
            httpResp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
        return isValid;
    }
}
