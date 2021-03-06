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

package com.amf.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserExternalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalService
 * @generated
 */
public class UserExternalServiceWrapper
	implements ServiceWrapper<UserExternalService>, UserExternalService {

	public UserExternalServiceWrapper(UserExternalService userExternalService) {
		_userExternalService = userExternalService;
	}

	@Override
	public com.amf.registration.model.UserExternal addUserExternal(
			String firstName, String lastName, String emailAddress,
			String userName, int male, java.util.Date birthday, String password,
			String homePhoneNumber, String mobilePhoneNumber, String address1,
			String address2, String city, long state, String zipCode,
			String queryQuestion, String queryAnswer,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userExternalService.addUserExternal(
			firstName, lastName, emailAddress, userName, male, birthday,
			password, homePhoneNumber, mobilePhoneNumber, address1, address2,
			city, state, zipCode, queryQuestion, queryAnswer, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userExternalService.getOSGiServiceIdentifier();
	}

	@Override
	public UserExternalService getWrappedService() {
		return _userExternalService;
	}

	@Override
	public void setWrappedService(UserExternalService userExternalService) {
		_userExternalService = userExternalService;
	}

	private UserExternalService _userExternalService;

}