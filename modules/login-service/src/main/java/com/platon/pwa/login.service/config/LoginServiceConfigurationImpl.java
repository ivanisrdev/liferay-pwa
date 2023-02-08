package com.platon.pwa.login.service.config;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.platon.pwa.login.service.constants.LoginServiceKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.util.Map;

@Component(
        immediate = true,
        configurationPid = LoginServiceKeys.WIDGET_CONFIGURATION_NAME,
        service = LoginServiceConfiguration.class
)
public class LoginServiceConfigurationImpl implements LoginServiceConfiguration{
    
    private LoginServiceConfiguration configuration;

    @Activate
    @Modified
    protected void active(Map<String, Object> properties) {
        configuration = ConfigurableUtil.createConfigurable(LoginServiceConfiguration.class, properties);
    }
    
    @Override
    public String endpoint() {
        return configuration.endpoint();
    }

    @Override
    public String loginApi() {
        return configuration.loginApi();
    }
}
