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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MovieInterest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovieInterest
 * @generated
 */
public class MovieInterestWrapper
	extends BaseModelWrapper<MovieInterest>
	implements ModelWrapper<MovieInterest>, MovieInterest {

	public MovieInterestWrapper(MovieInterest movieInterest) {
		super(movieInterest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("movieInterestId", getMovieInterestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("favoriteMovie", getFavoriteMovie());
		attributes.put("favoriteGenreId", getFavoriteGenreId());
		attributes.put("leastFavoriteMovie", getLeastFavoriteMovie());
		attributes.put("favoriteActor", getFavoriteActor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long movieInterestId = (Long)attributes.get("movieInterestId");

		if (movieInterestId != null) {
			setMovieInterestId(movieInterestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String favoriteMovie = (String)attributes.get("favoriteMovie");

		if (favoriteMovie != null) {
			setFavoriteMovie(favoriteMovie);
		}

		Long favoriteGenreId = (Long)attributes.get("favoriteGenreId");

		if (favoriteGenreId != null) {
			setFavoriteGenreId(favoriteGenreId);
		}

		String leastFavoriteMovie = (String)attributes.get(
			"leastFavoriteMovie");

		if (leastFavoriteMovie != null) {
			setLeastFavoriteMovie(leastFavoriteMovie);
		}

		String favoriteActor = (String)attributes.get("favoriteActor");

		if (favoriteActor != null) {
			setFavoriteActor(favoriteActor);
		}
	}

	@Override
	public MovieInterest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this movie interest.
	 *
	 * @return the company ID of this movie interest
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this movie interest.
	 *
	 * @return the create date of this movie interest
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the favorite actor of this movie interest.
	 *
	 * @return the favorite actor of this movie interest
	 */
	@Override
	public String getFavoriteActor() {
		return model.getFavoriteActor();
	}

	/**
	 * Returns the favorite genre ID of this movie interest.
	 *
	 * @return the favorite genre ID of this movie interest
	 */
	@Override
	public long getFavoriteGenreId() {
		return model.getFavoriteGenreId();
	}

	/**
	 * Returns the favorite movie of this movie interest.
	 *
	 * @return the favorite movie of this movie interest
	 */
	@Override
	public String getFavoriteMovie() {
		return model.getFavoriteMovie();
	}

	/**
	 * Returns the group ID of this movie interest.
	 *
	 * @return the group ID of this movie interest
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the least favorite movie of this movie interest.
	 *
	 * @return the least favorite movie of this movie interest
	 */
	@Override
	public String getLeastFavoriteMovie() {
		return model.getLeastFavoriteMovie();
	}

	/**
	 * Returns the modified date of this movie interest.
	 *
	 * @return the modified date of this movie interest
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the movie interest ID of this movie interest.
	 *
	 * @return the movie interest ID of this movie interest
	 */
	@Override
	public long getMovieInterestId() {
		return model.getMovieInterestId();
	}

	/**
	 * Returns the primary key of this movie interest.
	 *
	 * @return the primary key of this movie interest
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this movie interest.
	 *
	 * @return the user ID of this movie interest
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this movie interest.
	 *
	 * @return the user name of this movie interest
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this movie interest.
	 *
	 * @return the user uuid of this movie interest
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
	 * Sets the company ID of this movie interest.
	 *
	 * @param companyId the company ID of this movie interest
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this movie interest.
	 *
	 * @param createDate the create date of this movie interest
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the favorite actor of this movie interest.
	 *
	 * @param favoriteActor the favorite actor of this movie interest
	 */
	@Override
	public void setFavoriteActor(String favoriteActor) {
		model.setFavoriteActor(favoriteActor);
	}

	/**
	 * Sets the favorite genre ID of this movie interest.
	 *
	 * @param favoriteGenreId the favorite genre ID of this movie interest
	 */
	@Override
	public void setFavoriteGenreId(long favoriteGenreId) {
		model.setFavoriteGenreId(favoriteGenreId);
	}

	/**
	 * Sets the favorite movie of this movie interest.
	 *
	 * @param favoriteMovie the favorite movie of this movie interest
	 */
	@Override
	public void setFavoriteMovie(String favoriteMovie) {
		model.setFavoriteMovie(favoriteMovie);
	}

	/**
	 * Sets the group ID of this movie interest.
	 *
	 * @param groupId the group ID of this movie interest
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the least favorite movie of this movie interest.
	 *
	 * @param leastFavoriteMovie the least favorite movie of this movie interest
	 */
	@Override
	public void setLeastFavoriteMovie(String leastFavoriteMovie) {
		model.setLeastFavoriteMovie(leastFavoriteMovie);
	}

	/**
	 * Sets the modified date of this movie interest.
	 *
	 * @param modifiedDate the modified date of this movie interest
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the movie interest ID of this movie interest.
	 *
	 * @param movieInterestId the movie interest ID of this movie interest
	 */
	@Override
	public void setMovieInterestId(long movieInterestId) {
		model.setMovieInterestId(movieInterestId);
	}

	/**
	 * Sets the primary key of this movie interest.
	 *
	 * @param primaryKey the primary key of this movie interest
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this movie interest.
	 *
	 * @param userId the user ID of this movie interest
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this movie interest.
	 *
	 * @param userName the user name of this movie interest
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this movie interest.
	 *
	 * @param userUuid the user uuid of this movie interest
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MovieInterestWrapper wrap(MovieInterest movieInterest) {
		return new MovieInterestWrapper(movieInterest);
	}

}