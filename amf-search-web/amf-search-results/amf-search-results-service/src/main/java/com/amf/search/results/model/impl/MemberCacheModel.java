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

package com.amf.search.results.model.impl;

import com.amf.search.results.model.Member;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Member in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MemberCacheModel implements CacheModel<Member>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MemberCacheModel)) {
			return false;
		}

		MemberCacheModel memberCacheModel = (MemberCacheModel)object;

		if (memberId == memberCacheModel.memberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{memberId=");
		sb.append(memberId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Member toEntityModel() {
		MemberImpl memberImpl = new MemberImpl();

		memberImpl.setMemberId(memberId);
		memberImpl.setGroupId(groupId);
		memberImpl.setCompanyId(companyId);

		if (zipCode == null) {
			memberImpl.setZipCode("");
		}
		else {
			memberImpl.setZipCode(zipCode);
		}

		if (firstName == null) {
			memberImpl.setFirstName("");
		}
		else {
			memberImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			memberImpl.setLastName("");
		}
		else {
			memberImpl.setLastName(lastName);
		}

		if (screenName == null) {
			memberImpl.setScreenName("");
		}
		else {
			memberImpl.setScreenName(screenName);
		}

		if (emailAddress == null) {
			memberImpl.setEmailAddress("");
		}
		else {
			memberImpl.setEmailAddress(emailAddress);
		}

		if (createDate == Long.MIN_VALUE) {
			memberImpl.setCreateDate(null);
		}
		else {
			memberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memberImpl.setModifiedDate(null);
		}
		else {
			memberImpl.setModifiedDate(new Date(modifiedDate));
		}

		memberImpl.resetOriginalValues();

		return memberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		zipCode = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		screenName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(memberId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (screenName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long memberId;
	public long groupId;
	public long companyId;
	public String zipCode;
	public String firstName;
	public String lastName;
	public String screenName;
	public String emailAddress;
	public long createDate;
	public long modifiedDate;

}