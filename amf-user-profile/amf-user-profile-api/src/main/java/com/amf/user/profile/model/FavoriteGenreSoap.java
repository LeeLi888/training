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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.user.profile.service.http.FavoriteGenreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FavoriteGenreSoap implements Serializable {

	public static FavoriteGenreSoap toSoapModel(FavoriteGenre model) {
		FavoriteGenreSoap soapModel = new FavoriteGenreSoap();

		soapModel.setFavoriteGenreId(model.getFavoriteGenreId());
		soapModel.setFavoriteGenreName(model.getFavoriteGenreName());

		return soapModel;
	}

	public static FavoriteGenreSoap[] toSoapModels(FavoriteGenre[] models) {
		FavoriteGenreSoap[] soapModels = new FavoriteGenreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FavoriteGenreSoap[][] toSoapModels(FavoriteGenre[][] models) {
		FavoriteGenreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FavoriteGenreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FavoriteGenreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FavoriteGenreSoap[] toSoapModels(List<FavoriteGenre> models) {
		List<FavoriteGenreSoap> soapModels = new ArrayList<FavoriteGenreSoap>(
			models.size());

		for (FavoriteGenre model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FavoriteGenreSoap[soapModels.size()]);
	}

	public FavoriteGenreSoap() {
	}

	public long getPrimaryKey() {
		return _favoriteGenreId;
	}

	public void setPrimaryKey(long pk) {
		setFavoriteGenreId(pk);
	}

	public long getFavoriteGenreId() {
		return _favoriteGenreId;
	}

	public void setFavoriteGenreId(long favoriteGenreId) {
		_favoriteGenreId = favoriteGenreId;
	}

	public String getFavoriteGenreName() {
		return _favoriteGenreName;
	}

	public void setFavoriteGenreName(String favoriteGenreName) {
		_favoriteGenreName = favoriteGenreName;
	}

	private long _favoriteGenreId;
	private String _favoriteGenreName;

}