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
import com.amf.registration.service.base.UserExternalLocalServiceBaseImpl;

import com.amf.registration.validator.RegistValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.amf.registration.model.UserExternal",
	service = AopService.class
)
public class UserExternalLocalServiceImpl extends UserExternalLocalServiceBaseImpl {

	@Reference
	private RegistValidator _registValidator;

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

		long companyId = serviceContext.getCompanyId();
		Date createDate = new Date();
		Date modifiedDate = new Date();

		_registValidator.validate(companyId, userName, birthday);

		// add UserExternal
		long userId = counterLocalService.increment(User.class.getName());
		long userExternalId = counterLocalService.increment(UserExternal.class.getName());
		UserExternal userExternal = super.createUserExternal(userExternalId);
		userExternal.setCompanyId(companyId);
		userExternal.setUserId(userId);
		userExternal.setMale(male);
		userExternal.setCreateDate(createDate);
		userExternal.setModifiedDate(modifiedDate);
		userExternal = super.addUserExternal(userExternal);

		long contactId = counterLocalService.increment(Contact.class.getName());

		// add User
		User user = userLocalService.createUser(userId);
		user.setCompanyId(companyId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLanguageId("en_US");
		user.setTimeZoneId("UTC");
		user.setContactId(contactId);
		user.setEmailAddress(emailAddress);
		user.setScreenName(userName);
		user.setPassword(password);
		user.setReminderQueryQuestion(queryQuestion);
		user.setReminderQueryAnswer(queryAnswer);
		user.setAgreedToTermsOfUse(true);
		userLocalService.addUser(user);

		// add contract
		Contact contact = contactLocalService.createContact(contactId);
		contact.setCompanyId(companyId);
		contact.setUserId(userId);
		contact.setCreateDate(createDate);
		contact.setModifiedDate(modifiedDate);
		contact.setBirthday(birthday);
		contactLocalService.addContact(contact);

		// add phone home
		long phoneIdHome = counterLocalService.increment(Phone.class.getName());
		Phone phoneHome = phoneLocalService.createPhone(phoneIdHome);
		phoneHome.setCompanyId(companyId);
		phoneHome.setUserId(userId);
		phoneHome.setNumber(homePhoneNumber);
		phoneHome.setCreateDate(createDate);
		phoneHome.setModifiedDate(modifiedDate);
		phoneLocalService.addPhone(phoneHome);

		// add phone mobile
		long phoneIdMobile = counterLocalService.increment(Phone.class.getName());
		Phone phoneMobile = phoneLocalService.createPhone(phoneIdMobile);
		phoneMobile.setCompanyId(companyId);
		phoneMobile.setUserId(userId);
		phoneMobile.setNumber(mobilePhoneNumber);
		phoneMobile.setCreateDate(createDate);
		phoneMobile.setModifiedDate(modifiedDate);
		phoneLocalService.addPhone(phoneMobile);

		// add address
		long addressId = counterLocalService.increment(Address.class.getName());
		Address address = addressLocalService.createAddress(addressId);
		address.setCompanyId(companyId);
		address.setUserId(userId);
		address.setCreateDate(createDate);
		address.setModifiedDate(modifiedDate);
		address.setStreet1(address1);
		address.setStreet2(address2);
		address.setCity(city);
		address.setRegionId(state);
		address.setZip(zipCode);
		addressLocalService.addAddress(address);

		return userExternal;
	}

}