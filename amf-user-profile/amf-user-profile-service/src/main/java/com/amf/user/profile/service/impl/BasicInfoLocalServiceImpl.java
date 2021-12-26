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
import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.impl.BasicInfoImpl;
import com.amf.user.profile.service.base.BasicInfoLocalServiceBaseImpl;
import com.amf.user.profile.service.util.ResourcePermissionUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Resource;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.*;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.amf.user.profile.model.BasicInfo",
	service = AopService.class
)
public class BasicInfoLocalServiceImpl
	extends BasicInfoLocalServiceBaseImpl {

	@Override
	public BasicInfo getBasicInfo(long userId) throws PortalException {
		BasicInfo basicInfo = new BasicInfoImpl();

		//basic
		User user = userLocalService.getUserById(userId);
		basicInfo.setCompanyId(user.getCompanyId());
		basicInfo.setGroupId(user.getGroupId());
		basicInfo.setUserId(user.getUserId());
		basicInfo.setFirstName(user.getFirstName());
		basicInfo.setLastName(user.getLastName());

		//contact
		Contact contact = contactLocalService.getContact(user.getContactId());
		basicInfo.setMale(contact.getMale());
		basicInfo.setBirthday(contact.getBirthday());

		return basicInfo;
	}

	@Override
	public BasicInfo updateBasicInfo(
			long userId, String firstName, String lastName, boolean male, Date birthDay,
			ServiceContext serviceContext) throws PortalException {

		BasicInfo basicInfo = new BasicInfoImpl();

		//user
		User user = userLocalService.getUserById(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		userLocalService.updateUser(user);

		basicInfo.setCompanyId(user.getCompanyId());
		basicInfo.setGroupId(user.getGroupId());
		basicInfo.setUserId(userId);
		basicInfo.setFirstName(firstName);
		basicInfo.setLastName(lastName);

		//contact
		Contact contact = null;
		if (user.getContactId() != 0) {
			contact = contactLocalService.getContact(user.getContactId());
		}
		if (contact == null) {
			contact = contactLocalService.createContact(CounterLocalServiceUtil.increment(Contact.class.getName()));
			contact.setBirthday(birthDay);
			contact.setMale(male);
			contactLocalService.addContact(contact);
		} else {
			contact.setBirthday(birthDay);
			contact.setMale(male);
			contactLocalService.updateContact(contact);
		}
		basicInfo.setMale(male);
		basicInfo.setBirthday(birthDay);

		return basicInfo;
	}

}