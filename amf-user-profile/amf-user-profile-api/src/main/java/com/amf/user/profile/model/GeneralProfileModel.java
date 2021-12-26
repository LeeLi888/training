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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the GeneralProfile service. Represents a row in the &quot;AmfUserProfile_GeneralProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.amf.user.profile.model.impl.GeneralProfileModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.amf.user.profile.model.impl.GeneralProfileImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GeneralProfile
 * @generated
 */
@ProviderType
public interface GeneralProfileModel
	extends BaseModel<GeneralProfile>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a general profile model instance should use the {@link GeneralProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this general profile.
	 *
	 * @return the primary key of this general profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this general profile.
	 *
	 * @param primaryKey the primary key of this general profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the general profile ID of this general profile.
	 *
	 * @return the general profile ID of this general profile
	 */
	public long getGeneralProfileId();

	/**
	 * Sets the general profile ID of this general profile.
	 *
	 * @param generalProfileId the general profile ID of this general profile
	 */
	public void setGeneralProfileId(long generalProfileId);

	/**
	 * Returns the group ID of this general profile.
	 *
	 * @return the group ID of this general profile
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this general profile.
	 *
	 * @param groupId the group ID of this general profile
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this general profile.
	 *
	 * @return the company ID of this general profile
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this general profile.
	 *
	 * @param companyId the company ID of this general profile
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this general profile.
	 *
	 * @return the user ID of this general profile
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this general profile.
	 *
	 * @param userId the user ID of this general profile
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this general profile.
	 *
	 * @return the user uuid of this general profile
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this general profile.
	 *
	 * @param userUuid the user uuid of this general profile
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this general profile.
	 *
	 * @return the user name of this general profile
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this general profile.
	 *
	 * @param userName the user name of this general profile
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this general profile.
	 *
	 * @return the create date of this general profile
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this general profile.
	 *
	 * @param createDate the create date of this general profile
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this general profile.
	 *
	 * @return the modified date of this general profile
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this general profile.
	 *
	 * @param modifiedDate the modified date of this general profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the about me of this general profile.
	 *
	 * @return the about me of this general profile
	 */
	@AutoEscape
	public String getAboutMe();

	/**
	 * Sets the about me of this general profile.
	 *
	 * @param aboutMe the about me of this general profile
	 */
	public void setAboutMe(String aboutMe);

	/**
	 * Returns the favorite quotes of this general profile.
	 *
	 * @return the favorite quotes of this general profile
	 */
	@AutoEscape
	public String getFavoriteQuotes();

	/**
	 * Sets the favorite quotes of this general profile.
	 *
	 * @param favoriteQuotes the favorite quotes of this general profile
	 */
	public void setFavoriteQuotes(String favoriteQuotes);

	@Override
	public GeneralProfile cloneWithOriginalValues();

}