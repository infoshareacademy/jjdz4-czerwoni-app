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

        Cookie tokenCookie = null;
        String deniedReason;

        if (httpReq.getCookies() != null) {
            String cookieExpectedName = tokenService.buildCookieName(httpReq.getRequestURI());
            tokenCookie = Arrays.stream(httpReq.getCookies())
                    .filter(c -> c.getName().equals(cookieExpectedName))
                    .findFirst()
                    .orElse(null);
        }
        if (tokenCookie == null || tokenCookie.getValue().trim().equals("")) {
            deniedReason = NO_COOKIE_OR_EMPTY;
            LOG.info(deniedReason);
            httpResp.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            String tokenFromReq = servletRequest.getParameter("token");
            if (!tokenFromReq.equals(tokenCookie.getValue())) {
                deniedReason = TOKEN_VIOLATION;
                LOG.warn(deniedReason);
                httpResp.sendError(HttpServletResponse.SC_FORBIDDEN, deniedReason);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
