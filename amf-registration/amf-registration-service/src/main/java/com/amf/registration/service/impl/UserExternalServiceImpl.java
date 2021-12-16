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

package com.amf.registration.service.impl;

import com.amf.registration.model.UserExternal;
import com.amf.registration.service.base.UserExternalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=amfregistration",
		"json.web.service.context.path=UserExternal"
	},
	service = AopService.class
)
public class UserExternalServiceImpl extends UserExternalServiceBaseImpl {

	public UserExternal addUserExternal(
			long groupId,
			String firstName,
			String lastName,
			String emailAddress,
			String userName, //screenName
			int male,
			Date birthday,
			String password,
			String homePhoneNumber,
			String mobilePhoneNumber,
			String address1,
			String address2,
			String city,
			long state,
			String zipCode,
			String queryQuestion,
			String queryAnswer,
			ServiceContext serviceContext) throws PortalException {

		System.out.println("#----- remote sevice called");

		UserExternal userExternal =
				userExternalLocalService.addUserExternal(groupId, firstName, lastName, emailAddress,
						userName, male, birthday, password, homePhoneNumber, mobilePhoneNumber,
						address1, address2, city, state, zipCode, queryQuestion, queryAnswer, serviceContext);

		return userExternal;

	}

}