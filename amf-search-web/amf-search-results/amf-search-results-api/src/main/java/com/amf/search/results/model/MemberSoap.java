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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.search.results.service.http.MemberServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MemberSoap implements Serializable {

	public static MemberSoap toSoapModel(Member model) {
		MemberSoap soapModel = new MemberSoap();

		soapModel.setMemberId(model.getMemberId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MemberSoap[] toSoapModels(Member[] models) {
		MemberSoap[] soapModels = new MemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[][] toSoapModels(Member[][] models) {
		MemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[] toSoapModels(List<Member> models) {
		List<MemberSoap> soapModels = new ArrayList<MemberSoap>(models.size());

		for (Member model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberSoap[soapModels.size()]);
	}

	public MemberSoap() {
	}

	public long getPrimaryKey() {
		return _memberId;
	}

	public void setPrimaryKey(long pk) {
		setMemberId(pk);
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
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

	private long _memberId;
	private long _groupId;
	private long _companyId;
	private String _zipCode;
	private String _firstName;
	private String _lastName;
	private String _screenName;
	private String _emailAddress;
	private Date _createDate;
	private Date _modifiedDate;

}