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
import com.amf.user.profile.constants.UserProfileConstants;
import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.impl.BasicInfoImpl;
import com.amf.user.profile.model.impl.GeneralProfileImpl;
import com.amf.user.profile.service.base.GeneralProfileServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
		"json.web.service.context.path=GeneralProfile"
	},
	service = AopService.class
)
public class GeneralProfileServiceImpl extends GeneralProfileServiceBaseImpl {

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(model.class.name=com.amf.user.profile.model.GeneralProfile)"
	)
	private volatile ModelResourcePermission<GeneralProfile> modelResourcePermission;

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(resource.name=" + UserProfileConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission portletResourcePermission;

	public GeneralProfile getGeneralProfileByUserId(
			long userId) throws PortalException {

		GeneralProfile generalProfile = generalProfileLocalService.getGeneralProfileByUserId(userId);

//		if (generalProfile != null) {
//			modelResourcePermission.check(
//					getPermissionChecker(), generalProfile, AmfActionKeys.VIEW_GENERAL_PROFILE);
//		}

		return generalProfile;
	}

	public GeneralProfile addGeneralProfile(
			long userId,
			String aboutMe,
			String favoriteQuotes,
			ServiceContext serviceContext) throws PortalException {

//		portletResourcePermission.check(
//				getPermissionChecker(), serviceContext.getScopeGroupId(),
//				ActionKeys.ADD_ENTRY);

		GeneralProfile generalProfile = generalProfileLocalService.addGeneralProfile(userId, aboutMe, favoriteQuotes, serviceContext);

		return generalProfile;
	}

	public GeneralProfile updateGeneralProfile(
			long generalProfileId,
			String aboutMe,
			String favoriteQuotes,
			ServiceContext serviceContext) throws PortalException {

//		modelResourcePermission.check(
//				getPermissionChecker(), generalProfileId, ActionKeys.UPDATE);

		GeneralProfile generalProfile = generalProfileLocalService.updateGeneralProfile(generalProfileId, aboutMe, favoriteQuotes, serviceContext);

		return generalProfile;
	}

}