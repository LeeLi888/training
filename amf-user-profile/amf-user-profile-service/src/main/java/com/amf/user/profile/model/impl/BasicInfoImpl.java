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

package com.amf.user.profile.model.impl;

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.FavoriteGenre;
import com.liferay.expando.kernel.model.ExpandoBridge;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class BasicInfoImpl implements BasicInfo {

    private long userId;

    private String firstName;

    private String lastName;

    private boolean male;

    private Date birthday;

    private long companyId;

    private long groupId;

    private Date createDate;

    private Date modifiedDate;

    private String userName;

    private String userUuid;

    private Serializable primaryKeyObj;

    private long primaryKey;

    @Override
    public long getCompanyId() {
        return companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public long getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean isMale() {
        return male;
    }

    @Override
    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public Date getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserUuid() {
        return userUuid;
    }

    @Override
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return null;
    }

    @Override
    public Class<?> getModelClass() {
        return BasicInfo.class;
    }

    @Override
    public String getModelClassName() {
        return BasicInfo.class.getName();
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        if (primaryKeyObj == null) {
            primaryKeyObj = userId;
        }
        return primaryKeyObj;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        this.primaryKeyObj = primaryKeyObj;
    }

    @Override
    public long getPrimaryKey() {
        if (primaryKey == 0) {
            primaryKey = userId;
        }
        return primaryKey;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }


}
