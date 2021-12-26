/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.amf.user.profile.service.impl;

import com.amf.user.profile.constants.AmfActionKeys;
import com.amf.user.profile.constants.AmfUserProfilePrivacy;
import com.amf.user.profile.constants.UserProfileConstants;
import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.impl.BasicInfoImpl;
import com.amf.user.profile.service.base.BasicInfoServiceBaseImpl;
import com.amf.user.profile.service.base.GeneralProfileServiceBaseImpl;
import com.amf.user.profile.service.util.ResourcePermissionUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Resource;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ResourceLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=userprofile",
		"json.web.service.context.path=BasicInfo"
	},
	service = AopService.class
)
public class BasicInfoServiceImpl extends BasicInfoServiceBaseImpl {

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(model.class.name=com.amf.user.profile.model.BasicInfo)"
	)
	private volatile ModelResourcePermission<BasicInfo> modelResourcePermission;

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(resource.name=" + UserProfileConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission portletResourcePermission;

	@Reference
	private CounterLocalService counterLocalService;

	@Override
	public BasicInfo getBasicInfo(long userId, ServiceContext serviceContext) throws PortalException {

		BasicInfo basicInfo = basicInfoLocalService.getBasicInfo(userId);

		// add resource
		long scCompanyId = serviceContext.getCompanyId();
		long scGroupId = serviceContext.getScopeGroupId();
		long scUserId = serviceContext.getUserId();

		String className = BasicInfo.class.getName();
		long primaryKey = userId;
		int scopeId = ResourceConstants.SCOPE_INDIVIDUAL;

		Resource resource = ResourceLocalServiceUtil.getResource(scCompanyId, className, scopeId, String.valueOf(primaryKey));
		if (resource == null) {
			ResourceLocalServiceUtil.addResources(
					scCompanyId,
					scGroupId,
					scUserId,
					className,
					primaryKey,
					true, true, true);
		}

		Role roleMember = RoleLocalServiceUtil.getRole(scCompanyId, RoleConstants.SITE_MEMBER);
		Role roleGuest = RoleLocalServiceUtil.getRole(scCompanyId, RoleConstants.GUEST);
		String actionId = AmfActionKeys.VIEW_BASIC_INFO;
		long[] rolesIds = {
				roleMember.getPrimaryKey(), roleGuest.getPrimaryKey()
		};

		if (!ResourcePermissionLocalServiceUtil.hasResourcePermission(scCompanyId, className, scopeId, String.valueOf(primaryKey),rolesIds, actionId)) {
			ResourcePermissionUtil.addResourcePermissionForDefault(scCompanyId, className, scopeId, primaryKey, actionId);

			ResourcePermissionUtil.updatePermission(
					actionId,
					AmfUserProfilePrivacy.PRIVATE,
					scCompanyId,
					className,
					primaryKey,
					scopeId
			);
		}

//		modelResourcePermission.check(getPermissionChecker(), basicInfo, actionId);

		return basicInfo;
	}

	@Override
	public BasicInfo updateBasicInfo(
			long userId, String firstName, String lastName, boolean male, Date birthDay,
			ServiceContext serviceContext) throws PortalException {

//		modelResourcePermission.check(
//				getPermissionChecker(), userId, ActionKeys.UPDATE);

		return basicInfoLocalService.updateBasicInfo(userId, firstName, lastName, male, birthDay, serviceContext);
	}


}