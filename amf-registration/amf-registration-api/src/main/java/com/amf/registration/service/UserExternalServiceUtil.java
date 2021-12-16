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

import com.amf.registration.model.UserExternal;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for UserExternal. This utility wraps
 * <code>com.amf.registration.service.impl.UserExternalServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalService
 * @generated
 */
public class UserExternalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.registration.service.impl.UserExternalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static UserExternal addUserExternal(
			long groupId, String firstName, String lastName,
			String emailAddress, String userName, int male,
			java.util.Date birthday, String password, String homePhoneNumber,
			String mobilePhoneNumber, String address1, String address2,
			String city, long state, String zipCode, String queryQuestion,
			String queryAnswer,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addUserExternal(
			groupId, firstName, lastName, emailAddress, userName, male,
			birthday, password, homePhoneNumber, mobilePhoneNumber, address1,
			address2, city, state, zipCode, queryQuestion, queryAnswer,
			serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UserExternalService getService() {
		return _service;
	}

	private static volatile UserExternalService _service;

}