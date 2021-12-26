package com.amf.user.profile.web.internal.security.permission.resource;

import com.amf.user.profile.model.GeneralProfile;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = GeneralProfilePermission.class
)
public class GeneralProfilePermission {

    private static ModelResourcePermission<GeneralProfile> modelResourcePermission;

    @Reference(
        target = "(model.class.name=com.amf.user.profile.model.GeneralProfile)",
        unbind = "-"
    )
    protected void setEntryModelPermission(
            ModelResourcePermission<GeneralProfile> _modelResourcePermission) {
        modelResourcePermission = _modelResourcePermission;
    }

    public static boolean contains(
            PermissionChecker permissionChecker, GeneralProfile generalProfile,
            String actionId)
            throws PortalException {

        return modelResourcePermission.contains(permissionChecker, generalProfile, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long generalProfileId, String actionId)
            throws PortalException {
        return modelResourcePermission.contains(permissionChecker, generalProfileId, actionId);
    }


}
