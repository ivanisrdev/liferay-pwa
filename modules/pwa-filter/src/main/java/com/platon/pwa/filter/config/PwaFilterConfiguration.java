package com.platon.pwa.filter.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.ProviderType;
import aQute.bnd.annotation.metatype.Meta;
import com.platon.pwa.filter.constants.PwaFilterKeys;

@ProviderType
@ExtendedObjectClassDefinition(
        category = PwaFilterKeys.CONFIGURATION_CATEGORY,
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
        id = PwaFilterKeys.WIDGET_CONFIGURATION_NAME,
        localization = PwaFilterKeys.CONFIGURATION_LOCALIZATION
)
public interface PwaFilterConfiguration {

    @Meta.AD(
            deflt = "Service-Worker-Allowed",
            required = false
    )
    String nameHeader();

    @Meta.AD(
            deflt = "/",
            required = false
    )
    String scope();
    
}
