package com.amf.user.profile.web.internal.security.permission.resource;

import com.amf.user.profile.model.BasicInfo;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = BasicInfoPermission.class
)
public class BasicInfoPermission {

    private static ModelResourcePermission<BasicInfo> modelResourcePermission;

    @Reference(
        target = "(model.class.name=com.amf.user.profile.model.BasicInfo)",
        unbind = "-"
    )
    protected void setEntryModelPermission(
            ModelResourcePermission<BasicInfo> _modelResourcePermission) {
        modelResourcePermission = _modelResourcePermission;
    }

    public static boolean contains(
            PermissionChecker permissionChecker, BasicInfo basicInfo,
            String actionId)
            throws PortalException {

        return modelResourcePermission.contains(permissionChecker, basicInfo, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long userId, String actionId)
            throws PortalException {
        return modelResourcePermission.contains(permissionChecker, userId, actionId);
    }


}
