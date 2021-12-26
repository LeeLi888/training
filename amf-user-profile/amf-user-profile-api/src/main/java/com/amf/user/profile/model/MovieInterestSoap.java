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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.user.profile.service.http.MovieInterestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MovieInterestSoap implements Serializable {

	public static MovieInterestSoap toSoapModel(MovieInterest model) {
		MovieInterestSoap soapModel = new MovieInterestSoap();

		soapModel.setMovieInterestId(model.getMovieInterestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFavoriteMovie(model.getFavoriteMovie());
		soapModel.setFavoriteGenreId(model.getFavoriteGenreId());
		soapModel.setLeastFavoriteMovie(model.getLeastFavoriteMovie());
		soapModel.setFavoriteActor(model.getFavoriteActor());

		return soapModel;
	}

	public static MovieInterestSoap[] toSoapModels(MovieInterest[] models) {
		MovieInterestSoap[] soapModels = new MovieInterestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MovieInterestSoap[][] toSoapModels(MovieInterest[][] models) {
		MovieInterestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MovieInterestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MovieInterestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MovieInterestSoap[] toSoapModels(List<MovieInterest> models) {
		List<MovieInterestSoap> soapModels = new ArrayList<MovieInterestSoap>(
			models.size());

		for (MovieInterest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MovieInterestSoap[soapModels.size()]);
	}

	public MovieInterestSoap() {
	}

	public long getPrimaryKey() {
		return _movieInterestId;
	}

	public void setPrimaryKey(long pk) {
		setMovieInterestId(pk);
	}

	public long getMovieInterestId() {
		return _movieInterestId;
	}

	public void setMovieInterestId(long movieInterestId) {
		_movieInterestId = movieInterestId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getFavoriteMovie() {
		return _favoriteMovie;
	}

	public void setFavoriteMovie(String favoriteMovie) {
		_favoriteMovie = favoriteMovie;
	}

	public long getFavoriteGenreId() {
		return _favoriteGenreId;
	}

	public void setFavoriteGenreId(long favoriteGenreId) {
		_favoriteGenreId = favoriteGenreId;
	}

	public String getLeastFavoriteMovie() {
		return _leastFavoriteMovie;
	}

	public void setLeastFavoriteMovie(String leastFavoriteMovie) {
		_leastFavoriteMovie = leastFavoriteMovie;
	}

	public String getFavoriteActor() {
		return _favoriteActor;
	}

	public void setFavoriteActor(String favoriteActor) {
		_favoriteActor = favoriteActor;
	}

	private long _movieInterestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _favoriteMovie;
	private long _favoriteGenreId;
	private String _leastFavoriteMovie;
	private String _favoriteActor;

}