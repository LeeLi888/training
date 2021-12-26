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

package com.amf.user.profile.service;

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.GeneralProfile;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

/**
 * Provides the remote service utility for GeneralProfile. This utility wraps
 * <code>com.amf.user.profile.service.impl.GeneralProfileServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see GeneralProfileService
 * @generated
 */
public class BasicInfoServiceUtil {

	public static BasicInfo getBasicInfo(long userId, ServiceContext serviceContext) throws PortalException {
		return getService().getBasicInfo(userId, serviceContext);
	}

	public static BasicInfo updateBasicInfo(
			long userId,
			String firstName,
			String lastName,
			boolean male,
			Date birthDay,
			ServiceContext serviceContext
	) throws PortalException {
		return getService().updateBasicInfo(userId, firstName, lastName, male, birthDay, serviceContext);
	}

	public static BasicInfoService getService() {
		return _service;
	}

	private static volatile BasicInfoService _service;
}