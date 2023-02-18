package com.platon.pwa.filter;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.platon.pwa.filter.config.PwaFilterConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
        
        private PwaFilterConfiguration  configuration;

        @Override
        public void init(final FilterConfig filterConfig) {
                // default implementation ignored
        }

        @Override
        public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, 
                             final FilterChain chain) throws IOException, ServletException {
                final HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.addHeader(configuration.nameHeader(), configuration.scope());
                chain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy() {
                // default implementation ignored
        }

        @Activate
        @Modified
        protected void active(Map<String, Object> properties) {
                configuration = ConfigurableUtil.createConfigurable(PwaFilterConfiguration.class, properties);
        }

}
