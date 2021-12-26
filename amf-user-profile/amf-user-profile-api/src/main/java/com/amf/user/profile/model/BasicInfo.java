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

package com.amf.user.profile.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.Date;

/**
 * The extended model interface for the FavoriteGenre service. Represents a row in the &quot;AmfUserProfile_FavoriteGenre&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenreModel
 * @generated
 */
@ImplementationClassName("com.amf.user.profile.model.impl.BasicInfoImpl")
@ProviderType
public interface BasicInfo extends GroupedModel {
    public long getCompanyId();
    public void setCompanyId(long companyId);

    public long getGroupId();
    public void setGroupId(long groupId);

    public long getUserId();
    public void setUserId(long userId);

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public boolean isMale();
    public void setMale(boolean male);

    public Date getBirthday();
    public void setBirthday(Date birthday);

    public long getPrimaryKey();
    public void setPrimaryKey(long primaryKey);

    public Serializable getPrimaryKeyObj();

}