package com.alfazid.siasd.utilities;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by cigist on 06/07/19.
 */
@Component
public class AppFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Remote Host:"+servletRequest.getRemoteHost());
        System.out.println("Remote Address:"+servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {

    }
}
