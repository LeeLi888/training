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

package com.amf.registration.model.impl;

import com.amf.registration.model.UserExternal;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserExternal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserExternalCacheModel
	implements CacheModel<UserExternal>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserExternalCacheModel)) {
			return false;
		}

		UserExternalCacheModel userExternalCacheModel =
			(UserExternalCacheModel)object;

		if (userExternalId == userExternalCacheModel.userExternalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userExternalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{userExternalId=");
		sb.append(userExternalId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", male=");
		sb.append(male);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserExternal toEntityModel() {
		UserExternalImpl userExternalImpl = new UserExternalImpl();

		userExternalImpl.setUserExternalId(userExternalId);
		userExternalImpl.setCompanyId(companyId);
		userExternalImpl.setUserId(userId);
		userExternalImpl.setMale(male);

		if (createDate == Long.MIN_VALUE) {
			userExternalImpl.setCreateDate(null);
		}
		else {
			userExternalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userExternalImpl.setModifiedDate(null);
		}
		else {
			userExternalImpl.setModifiedDate(new Date(modifiedDate));
		}

		userExternalImpl.resetOriginalValues();

		return userExternalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userExternalId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();

		male = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userExternalId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		objectOutput.writeInt(male);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long userExternalId;
	public long companyId;
	public long userId;
	public int male;
	public long createDate;
	public long modifiedDate;

}