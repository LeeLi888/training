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

import com.amf.user.profile.model.GeneralProfile;

import com.liferay.portal.kernel.exception.PortalException;

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
public class GeneralProfileServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.user.profile.service.impl.GeneralProfileServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static GeneralProfile addGeneralProfile(
			long userId, String aboutMe, String favoriteQuotes,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addGeneralProfile(
			userId, aboutMe, favoriteQuotes, serviceContext);
	}

	public static GeneralProfile getGeneralProfileByUserId(long userId)
		throws PortalException {

		return getService().getGeneralProfileByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static GeneralProfile updateGeneralProfile(
			long generalProfileId, String aboutMe, String favoriteQuotes,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateGeneralProfile(
			generalProfileId, aboutMe, favoriteQuotes, serviceContext);
	}

	public static GeneralProfileService getService() {
		return _service;
	}

	private static volatile GeneralProfileService _service;

}