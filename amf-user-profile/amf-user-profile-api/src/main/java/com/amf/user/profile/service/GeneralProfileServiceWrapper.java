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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeneralProfileService}.
 *
 * @author Brian Wing Shun Chan
 * @see GeneralProfileService
 * @generated
 */
public class GeneralProfileServiceWrapper
	implements GeneralProfileService, ServiceWrapper<GeneralProfileService> {

	public GeneralProfileServiceWrapper(
		GeneralProfileService generalProfileService) {

		_generalProfileService = generalProfileService;
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile addGeneralProfile(
			long userId, String aboutMe, String favoriteQuotes,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileService.addGeneralProfile(
			userId, aboutMe, favoriteQuotes, serviceContext);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile getGeneralProfileByUserId(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileService.getGeneralProfileByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _generalProfileService.getOSGiServiceIdentifier();
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile updateGeneralProfile(
			long generalProfileId, String aboutMe, String favoriteQuotes,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileService.updateGeneralProfile(
			generalProfileId, aboutMe, favoriteQuotes, serviceContext);
	}

	@Override
	public GeneralProfileService getWrappedService() {
		return _generalProfileService;
	}

	@Override
	public void setWrappedService(GeneralProfileService generalProfileService) {
		_generalProfileService = generalProfileService;
	}

	private GeneralProfileService _generalProfileService;

}