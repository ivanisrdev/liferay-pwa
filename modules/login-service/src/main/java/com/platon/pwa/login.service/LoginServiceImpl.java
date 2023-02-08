package com.platon.pwa.login.service;

import com.platon.pwa.login.service.config.LoginServiceConfiguration;
import com.platon.pwa.login.service.constants.LoginServiceKeys;
import lombok.extern.slf4j.Slf4j;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Slf4j
@Component(
        immediate = true,
        configurationPid = LoginServiceKeys.WIDGET_CONFIGURATION_NAME,
        service = LoginService.class
)
public class LoginServiceImpl implements LoginService {
    
    @Reference
    private LoginServiceConfiguration configuration;
    
    @Override
    public String login() {
        log.info("Not implemented!!! {}", configuration.endpoint());
        return null;
    }
}
