package com.platon.pwa.filter;

import org.osgi.service.component.annotations.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "servlet-context-name=",
                "servlet-filter-name=PWA support servlet Filter",
                "url-pattern=/*"
        },
        service = Filter.class
)
public class PwaFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) {
                
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
                final HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.addHeader("Service-Worker-Allowed", "/");
                chain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy() {

        }

}
