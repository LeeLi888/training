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

package com.amf.search.results.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Member}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Member
 * @generated
 */
public class MemberWrapper
	extends BaseModelWrapper<Member> implements Member, ModelWrapper<Member> {

	public MemberWrapper(Member member) {
		super(member);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberId", getMemberId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("zipCode", getZipCode());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("screenName", getScreenName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Member cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this member.
	 *
	 * @return the company ID of this member
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this member.
	 *
	 * @return the create date of this member
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email address of this member.
	 *
	 * @return the email address of this member
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the first name of this member.
	 *
	 * @return the first name of this member
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this member.
	 *
	 * @return the group ID of this member
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last name of this member.
	 *
	 * @return the last name of this member
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the member ID of this member.
	 *
	 * @return the member ID of this member
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the modified date of this member.
	 *
	 * @return the modified date of this member
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this member.
	 *
	 * @return the primary key of this member
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the screen name of this member.
	 *
	 * @return the screen name of this member
	 */
	@Override
	public String getScreenName() {
		return model.getScreenName();
	}

	/**
	 * Returns the zip code of this member.
	 *
	 * @return the zip code of this member
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this member.
	 *
	 * @param companyId the company ID of this member
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this member.
	 *
	 * @param createDate the create date of this member
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email address of this member.
	 *
	 * @param emailAddress the email address of this member
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the first name of this member.
	 *
	 * @param firstName the first name of this member
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this member.
	 *
	 * @param groupId the group ID of this member
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last name of this member.
	 *
	 * @param lastName the last name of this member
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the member ID of this member.
	 *
	 * @param memberId the member ID of this member
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the modified date of this member.
	 *
	 * @param modifiedDate the modified date of this member
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this member.
	 *
	 * @param primaryKey the primary key of this member
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the screen name of this member.
	 *
	 * @param screenName the screen name of this member
	 */
	@Override
	public void setScreenName(String screenName) {
		model.setScreenName(screenName);
	}

	/**
	 * Sets the zip code of this member.
	 *
	 * @param zipCode the zip code of this member
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected MemberWrapper wrap(Member member) {
		return new MemberWrapper(member);
	}

}