package com.amf.user.profile.internal.security.permission.resource.definitaion;

import com.amf.user.profile.constants.UserProfileConstants;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = PortletResourcePermissionDefinition.class
)
public class UserProfilePortletResourcePermissionDefinition implements PortletResourcePermissionDefinition {

    @Reference
    private StagingPermission stagingPermission;

    @Override
    public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {
        return new PortletResourcePermissionLogic[] {
                new StagedPortletPermissionLogic(
                        stagingPermission,
                        "com_amf_user_profile_web_AmfUserProfilePortlet")
        };
    }

    @Override
    public String getResourceName() {
        return UserProfileConstants.RESOURCE_NAME;
    }

}
