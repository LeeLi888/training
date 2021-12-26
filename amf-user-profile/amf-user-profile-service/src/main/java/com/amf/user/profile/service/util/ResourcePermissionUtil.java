package com.amf.user.profile.service.util;

import com.amf.user.profile.constants.AmfActionKeys;
import com.amf.user.profile.constants.AmfUserProfilePrivacy;
import com.amf.user.profile.model.GeneralProfile;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

public class ResourcePermissionUtil {

    public static void addResourcePermissionForDefault(long scCompanyId, String className, int scopeId, long primaryKey, String actionId) throws PortalException {
        long guestRoleId = RoleLocalServiceUtil.getRole(scCompanyId, RoleConstants.GUEST).getRoleId();
        long userRoleId = RoleLocalServiceUtil.getRole(scCompanyId, RoleConstants.SITE_MEMBER).getRoleId();

        ResourcePermissionLocalServiceUtil.setResourcePermissions(scCompanyId, className, scopeId, String.valueOf(primaryKey), guestRoleId, new String[] {actionId});
        ResourcePermissionLocalServiceUtil.setResourcePermissions(scCompanyId, className, scopeId, String.valueOf(primaryKey), userRoleId, new String[] {actionId});
    }

    public static void updatePermission(String actionId, int permissionKey, long companyId, String className, long primaryKey, int scopeId) throws PortalException {
        //add permission
        long guestRoleId = RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST).getRoleId();
        long memberRoleId = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER).getRoleId();

        ResourcePermission guestPermission = ResourcePermissionLocalServiceUtil
                .fetchResourcePermission(companyId, className, scopeId, String.valueOf(primaryKey), guestRoleId);

        ResourcePermission memberPermission = ResourcePermissionLocalServiceUtil
                .fetchResourcePermission(companyId, className, scopeId, String.valueOf(primaryKey), memberRoleId);

        switch (permissionKey) {
            case AmfUserProfilePrivacy.PUBLIC:
                guestPermission.addResourceAction(actionId);
                memberPermission.addResourceAction(actionId);
                ResourcePermissionLocalServiceUtil.updateResourcePermission(guestPermission);
                ResourcePermissionLocalServiceUtil.updateResourcePermission(memberPermission);
                break;
            case AmfUserProfilePrivacy.PROTECTED:
                guestPermission.removeResourceAction(actionId);
                memberPermission.addResourceAction(actionId);
                ResourcePermissionLocalServiceUtil.updateResourcePermission(guestPermission);
                ResourcePermissionLocalServiceUtil.updateResourcePermission(memberPermission);
                break;
            case AmfUserProfilePrivacy.PRIVATE:
                guestPermission.removeResourceAction(actionId);
                memberPermission.removeResourceAction(actionId);
                ResourcePermissionLocalServiceUtil.updateResourcePermission(guestPermission);
                ResourcePermissionLocalServiceUtil.updateResourcePermission(memberPermission);
                break;
            default:
                throw new IllegalArgumentException("Invalid permission key: " + permissionKey);
        }
    }

}
