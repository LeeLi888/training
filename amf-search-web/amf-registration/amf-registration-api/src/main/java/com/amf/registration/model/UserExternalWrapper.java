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

package com.amf.registration.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserExternal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserExternal
 * @generated
 */
public class UserExternalWrapper
	extends BaseModelWrapper<UserExternal>
	implements ModelWrapper<UserExternal>, UserExternal {

	public UserExternalWrapper(UserExternal userExternal) {
		super(userExternal);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userExternalId", getUserExternalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("male", getMale());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userExternalId = (Long)attributes.get("userExternalId");

		if (userExternalId != null) {
			setUserExternalId(userExternalId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer male = (Integer)attributes.get("male");

		if (male != null) {
			setMale(male);
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
	public UserExternal cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this user external.
	 *
	 * @return the company ID of this user external
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user external.
	 *
	 * @return the create date of this user external
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the male of this user external.
	 *
	 * @return the male of this user external
	 */
	@Override
	public int getMale() {
		return model.getMale();
	}

	/**
	 * Returns the modified date of this user external.
	 *
	 * @return the modified date of this user external
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user external.
	 *
	 * @return the primary key of this user external
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user external ID of this user external.
	 *
	 * @return the user external ID of this user external
	 */
	@Override
	public long getUserExternalId() {
		return model.getUserExternalId();
	}

	/**
	 * Returns the user ID of this user external.
	 *
	 * @return the user ID of this user external
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this user external.
	 *
	 * @return the user uuid of this user external
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this user external.
	 *
	 * @param companyId the company ID of this user external
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user external.
	 *
	 * @param createDate the create date of this user external
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the male of this user external.
	 *
	 * @param male the male of this user external
	 */
	@Override
	public void setMale(int male) {
		model.setMale(male);
	}

	/**
	 * Sets the modified date of this user external.
	 *
	 * @param modifiedDate the modified date of this user external
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user external.
	 *
	 * @param primaryKey the primary key of this user external
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user external ID of this user external.
	 *
	 * @param userExternalId the user external ID of this user external
	 */
	@Override
	public void setUserExternalId(long userExternalId) {
		model.setUserExternalId(userExternalId);
	}

	/**
	 * Sets the user ID of this user external.
	 *
	 * @param userId the user ID of this user external
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this user external.
	 *
	 * @param userUuid the user uuid of this user external
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserExternalWrapper wrap(UserExternal userExternal) {
		return new UserExternalWrapper(userExternal);
	}

}