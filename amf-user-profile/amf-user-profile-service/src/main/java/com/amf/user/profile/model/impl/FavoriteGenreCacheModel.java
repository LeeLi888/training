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

import com.amf.user.profile.model.FavoriteGenre;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FavoriteGenre in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FavoriteGenreCacheModel
	implements CacheModel<FavoriteGenre>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FavoriteGenreCacheModel)) {
			return false;
		}

		FavoriteGenreCacheModel favoriteGenreCacheModel =
			(FavoriteGenreCacheModel)object;

		if (favoriteGenreId == favoriteGenreCacheModel.favoriteGenreId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, favoriteGenreId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{favoriteGenreId=");
		sb.append(favoriteGenreId);
		sb.append(", favoriteGenreName=");
		sb.append(favoriteGenreName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FavoriteGenre toEntityModel() {
		FavoriteGenreImpl favoriteGenreImpl = new FavoriteGenreImpl();

		favoriteGenreImpl.setFavoriteGenreId(favoriteGenreId);

		if (favoriteGenreName == null) {
			favoriteGenreImpl.setFavoriteGenreName("");
		}
		else {
			favoriteGenreImpl.setFavoriteGenreName(favoriteGenreName);
		}

		favoriteGenreImpl.resetOriginalValues();

		return favoriteGenreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		favoriteGenreId = objectInput.readLong();
		favoriteGenreName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(favoriteGenreId);

		if (favoriteGenreName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(favoriteGenreName);
		}
	}

	public long favoriteGenreId;
	public String favoriteGenreName;

}