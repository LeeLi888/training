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

import com.amf.user.profile.model.MovieInterest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MovieInterest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MovieInterestCacheModel
	implements CacheModel<MovieInterest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MovieInterestCacheModel)) {
			return false;
		}

		MovieInterestCacheModel movieInterestCacheModel =
			(MovieInterestCacheModel)object;

		if (movieInterestId == movieInterestCacheModel.movieInterestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, movieInterestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{movieInterestId=");
		sb.append(movieInterestId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", favoriteMovie=");
		sb.append(favoriteMovie);
		sb.append(", favoriteGenreId=");
		sb.append(favoriteGenreId);
		sb.append(", leastFavoriteMovie=");
		sb.append(leastFavoriteMovie);
		sb.append(", favoriteActor=");
		sb.append(favoriteActor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MovieInterest toEntityModel() {
		MovieInterestImpl movieInterestImpl = new MovieInterestImpl();

		movieInterestImpl.setMovieInterestId(movieInterestId);
		movieInterestImpl.setGroupId(groupId);
		movieInterestImpl.setCompanyId(companyId);
		movieInterestImpl.setUserId(userId);

		if (userName == null) {
			movieInterestImpl.setUserName("");
		}
		else {
			movieInterestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			movieInterestImpl.setCreateDate(null);
		}
		else {
			movieInterestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			movieInterestImpl.setModifiedDate(null);
		}
		else {
			movieInterestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (favoriteMovie == null) {
			movieInterestImpl.setFavoriteMovie("");
		}
		else {
			movieInterestImpl.setFavoriteMovie(favoriteMovie);
		}

		movieInterestImpl.setFavoriteGenreId(favoriteGenreId);

		if (leastFavoriteMovie == null) {
			movieInterestImpl.setLeastFavoriteMovie("");
		}
		else {
			movieInterestImpl.setLeastFavoriteMovie(leastFavoriteMovie);
		}

		if (favoriteActor == null) {
			movieInterestImpl.setFavoriteActor("");
		}
		else {
			movieInterestImpl.setFavoriteActor(favoriteActor);
		}

		movieInterestImpl.resetOriginalValues();

		return movieInterestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		movieInterestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		favoriteMovie = objectInput.readUTF();

		favoriteGenreId = objectInput.readLong();
		leastFavoriteMovie = objectInput.readUTF();
		favoriteActor = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(movieInterestId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (favoriteMovie == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(favoriteMovie);
		}

		objectOutput.writeLong(favoriteGenreId);

		if (leastFavoriteMovie == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leastFavoriteMovie);
		}

		if (favoriteActor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(favoriteActor);
		}
	}

	public long movieInterestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String favoriteMovie;
	public long favoriteGenreId;
	public String leastFavoriteMovie;
	public String favoriteActor;

}