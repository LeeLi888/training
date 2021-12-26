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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FavoriteGenre}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenre
 * @generated
 */
public class FavoriteGenreWrapper
	extends BaseModelWrapper<FavoriteGenre>
	implements FavoriteGenre, ModelWrapper<FavoriteGenre> {

	public FavoriteGenreWrapper(FavoriteGenre favoriteGenre) {
		super(favoriteGenre);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("favoriteGenreId", getFavoriteGenreId());
		attributes.put("favoriteGenreName", getFavoriteGenreName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long favoriteGenreId = (Long)attributes.get("favoriteGenreId");

		if (favoriteGenreId != null) {
			setFavoriteGenreId(favoriteGenreId);
		}

		String favoriteGenreName = (String)attributes.get("favoriteGenreName");

		if (favoriteGenreName != null) {
			setFavoriteGenreName(favoriteGenreName);
		}
	}

	@Override
	public FavoriteGenre cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the favorite genre ID of this favorite genre.
	 *
	 * @return the favorite genre ID of this favorite genre
	 */
	@Override
	public long getFavoriteGenreId() {
		return model.getFavoriteGenreId();
	}

	/**
	 * Returns the favorite genre name of this favorite genre.
	 *
	 * @return the favorite genre name of this favorite genre
	 */
	@Override
	public String getFavoriteGenreName() {
		return model.getFavoriteGenreName();
	}

	/**
	 * Returns the primary key of this favorite genre.
	 *
	 * @return the primary key of this favorite genre
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the favorite genre ID of this favorite genre.
	 *
	 * @param favoriteGenreId the favorite genre ID of this favorite genre
	 */
	@Override
	public void setFavoriteGenreId(long favoriteGenreId) {
		model.setFavoriteGenreId(favoriteGenreId);
	}

	/**
	 * Sets the favorite genre name of this favorite genre.
	 *
	 * @param favoriteGenreName the favorite genre name of this favorite genre
	 */
	@Override
	public void setFavoriteGenreName(String favoriteGenreName) {
		model.setFavoriteGenreName(favoriteGenreName);
	}

	/**
	 * Sets the primary key of this favorite genre.
	 *
	 * @param primaryKey the primary key of this favorite genre
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected FavoriteGenreWrapper wrap(FavoriteGenre favoriteGenre) {
		return new FavoriteGenreWrapper(favoriteGenre);
	}

}