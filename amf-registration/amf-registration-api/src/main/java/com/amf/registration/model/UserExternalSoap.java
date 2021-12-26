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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.registration.service.http.UserExternalServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserExternalSoap implements Serializable {

	public static UserExternalSoap toSoapModel(UserExternal model) {
		UserExternalSoap soapModel = new UserExternalSoap();

		soapModel.setUserExternalId(model.getUserExternalId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setMale(model.getMale());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UserExternalSoap[] toSoapModels(UserExternal[] models) {
		UserExternalSoap[] soapModels = new UserExternalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserExternalSoap[][] toSoapModels(UserExternal[][] models) {
		UserExternalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserExternalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserExternalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserExternalSoap[] toSoapModels(List<UserExternal> models) {
		List<UserExternalSoap> soapModels = new ArrayList<UserExternalSoap>(
			models.size());

		for (UserExternal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserExternalSoap[soapModels.size()]);
	}

	public UserExternalSoap() {
	}

	public long getPrimaryKey() {
		return _userExternalId;
	}

	public void setPrimaryKey(long pk) {
		setUserExternalId(pk);
	}

	public long getUserExternalId() {
		return _userExternalId;
	}

	public void setUserExternalId(long userExternalId) {
		_userExternalId = userExternalId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public int getMale() {
		return _male;
	}

	public void setMale(int male) {
		_male = male;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _userExternalId;
	private long _companyId;
	private long _userId;
	private int _male;
	private Date _createDate;
	private Date _modifiedDate;

}