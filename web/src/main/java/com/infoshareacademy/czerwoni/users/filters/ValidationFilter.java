package com.infoshareacademy.czerwoni.users.filters;

import com.infoshareacademy.czerwoni.users.ejb.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.infoshareacademy.czerwoni.users.ejb.TokenServiceBean.LOGIN_URI;

@WebFilter(
        filterName = "ValidationFilter",
        urlPatterns = {LOGIN_URI}
)
public class ValidationFilter implements Filter {

    @Inject
    private TokenService tokenService;

    private static final Logger LOG = LoggerFactory.getLogger(ValidationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.debug("Filter init");
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
        LOG.debug("Filter shutdown");
    }

}
