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
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.service.base.GeneralProfileLocalServiceBaseImpl;

import com.amf.user.profile.service.util.ResourcePermissionUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.*;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.amf.user.profile.model.GeneralProfile",
	service = AopService.class
)
public class GeneralProfileLocalServiceImpl
	extends GeneralProfileLocalServiceBaseImpl {

	public GeneralProfile getGeneralProfileByUserId(long userId) throws PortalException {

		GeneralProfile generalProfile = generalProfilePersistence.fetchByUserId(userId);

		return generalProfile;
	}

	public GeneralProfile addGeneralProfile(
			long userId,
			String aboutMe,
			String favoriteQuotes,
			ServiceContext serviceContext) throws PortalException {

		GeneralProfile generalProfile =
				generalProfilePersistence.create(CounterLocalServiceUtil.increment(GeneralProfile.class.getName()));

		User user = UserLocalServiceUtil.getUser(userId);
		generalProfile.setCompanyId(user.getCompanyId());
		generalProfile.setGroupId(serviceContext.getScopeGroupId());
		generalProfile.setUserId(user.getUserId());
		generalProfile.setUserName(user.getScreenName());
		generalProfile.setCreateDate(new Date());
		generalProfile.setModifiedDate(new Date());
		generalProfile.setAboutMe(aboutMe);
		generalProfile.setFavoriteQuotes(favoriteQuotes);
		super.addGeneralProfile(generalProfile);

		// add resource
		long scCompanyId = serviceContext.getCompanyId();
		long scGroupId = serviceContext.getScopeGroupId();
		long scUserId = serviceContext.getUserId();
		String className = GeneralProfile.class.getName();
		long primaryKey = generalProfile.getGeneralProfileId();

		resourceLocalService.addResources(
				scCompanyId,
				scGroupId,
				scUserId,
				className,
				primaryKey,
				true, true, true);

		// update permission : default to PUBLIC
		ResourcePermissionUtil.updatePermission(
				AmfActionKeys.VIEW_GENERAL_PROFILE,
				AmfUserProfilePrivacy.PRIVATE,
				scCompanyId,
				className,
				primaryKey,
				ResourceConstants.SCOPE_INDIVIDUAL
		);

		return generalProfile;
	}

	public GeneralProfile updateGeneralProfile(
			long generalProfileId,
			String aboutMe,
			String favoriteQuotes,
			ServiceContext serviceContext) throws PortalException {

		GeneralProfile generalProfile = generalProfilePersistence.findByPrimaryKey(generalProfileId);

		generalProfile.setModifiedDate(new Date());
		generalProfile.setAboutMe(aboutMe);
		generalProfile.setFavoriteQuotes(favoriteQuotes);
		super.updateGeneralProfile(generalProfile);

		return generalProfile;
	}

}