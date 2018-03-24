package com.infoshareacademy.czerwoni.users.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "ValidationFilter",
        urlPatterns = {"/login"}
)
public class ValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
 /* STEP 2: Verifying CSRF token using "Double Submit Cookie" approach */
        //If CSRF token cookie is absent from the request then we provide one in response but we stop the process at this stage.
        //Using this way we implement the first providing of token

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
