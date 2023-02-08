package com.platon.pwa.login.service.config;

import aQute.bnd.annotation.ProviderType;
import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.platon.pwa.login.service.constants.LoginServiceKeys;

@ProviderType
@ExtendedObjectClassDefinition(
        category = LoginServiceKeys.CONFIGURATION_CATEGORY,
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
        id = LoginServiceKeys.WIDGET_CONFIGURATION_NAME,
        localization = LoginServiceKeys.CONFIGURATION_LOCALIZATION
)
public interface LoginServiceConfiguration {

    @Meta.AD(
            deflt = "",
            required = false
    )
    String endpoint();

    @Meta.AD(
            deflt = "",
            required = false
    )
    String loginApi();
}
