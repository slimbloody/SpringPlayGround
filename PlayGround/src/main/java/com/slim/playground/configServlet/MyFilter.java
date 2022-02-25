package com.slim.playground.configServlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

// @WebServlet(urlPatterns = "/*", name = "myFilter")
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        log.info("MyFilter: before doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("MyFilter: after doFilter");
    }

    @Override
    public void destroy() {
        log.info("MyFilter destroy");
    }
}
