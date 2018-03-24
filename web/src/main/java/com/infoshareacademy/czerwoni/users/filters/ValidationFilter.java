package com.infoshareacademy.czerwoni.users.filters;

import com.infoshareacademy.czerwoni.users.ejb.TokenService;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.infoshareacademy.czerwoni.users.ejb.TokenService.LOGIN_URI;

@WebFilter(
        filterName = "ValidationFilter",
        urlPatterns = {LOGIN_URI}
)
public class ValidationFilter implements Filter {

    @Inject
    private TokenService tokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (tokenService.validateTokens(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
            httpResp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {

    }

}
