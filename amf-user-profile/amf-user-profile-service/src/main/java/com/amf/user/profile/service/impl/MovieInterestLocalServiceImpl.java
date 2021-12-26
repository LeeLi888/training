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

package com.amf.user.profile.service.impl;

import com.amf.user.profile.constants.AmfActionKeys;
import com.amf.user.profile.constants.AmfUserProfilePrivacy;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.base.MovieInterestLocalServiceBaseImpl;

import com.amf.user.profile.service.util.ResourcePermissionUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.amf.user.profile.model.MovieInterest",
	service = AopService.class
)
public class MovieInterestLocalServiceImpl
	extends MovieInterestLocalServiceBaseImpl {

	public MovieInterest getMovieInterestByUserId(
			long userId) throws PortalException {

		MovieInterest movieInterest = movieInterestPersistence.fetchByUserId(userId);

		return movieInterest;
	}

	public MovieInterest addMovieInterest(
			long userId,
			String favoriteMovie,
			long favoriteGenreId,
			String leastFavoriteMovie,
			String favoriteActor,
			ServiceContext serviceContext) throws PortalException {

		MovieInterest movieInterest =
				movieInterestPersistence.create(CounterLocalServiceUtil.increment(MovieInterest.class.getName()));

		User user = UserLocalServiceUtil.getUser(userId);
		movieInterest.setCompanyId(user.getCompanyId());
		movieInterest.setGroupId(serviceContext.getScopeGroupId());
		movieInterest.setUserId(user.getUserId());
		movieInterest.setUserName(user.getScreenName());
		movieInterest.setCreateDate(new Date());
		movieInterest.setModifiedDate(new Date());
		movieInterest.setFavoriteMovie(favoriteMovie);
		movieInterest.setFavoriteGenreId(favoriteGenreId);
		movieInterest.setLeastFavoriteMovie(leastFavoriteMovie);
		movieInterest.setFavoriteActor(favoriteActor);
		super.addMovieInterest(movieInterest);

		// add resource
		long scCompanyId = serviceContext.getCompanyId();
		long scGroupId = serviceContext.getScopeGroupId();
		long scUserId = serviceContext.getUserId();
		String className = MovieInterest.class.getName();
		long primaryKey = movieInterest.getMovieInterestId();

		resourceLocalService.addResources(
				scCompanyId,
				scGroupId,
				scUserId,
				className,
				primaryKey,
				true, true, true);

		// update permission : default to PUBLIC
		ResourcePermissionUtil.updatePermission(
				AmfActionKeys.VIEW_MOVIE_INTEREST,
				AmfUserProfilePrivacy.PRIVATE,
				scCompanyId,
				className,
				primaryKey,
				ResourceConstants.SCOPE_INDIVIDUAL
		);

		return movieInterest;
	}

	public MovieInterest updateMovieInterest(
			long movieInterestId,
			String favoriteMovie,
			long favoriteGenreId,
			String leastFavoriteMovie,
			String favoriteActor,
			ServiceContext serviceContext) throws PortalException {

		MovieInterest movieInterest = movieInterestPersistence.findByPrimaryKey(movieInterestId);

		movieInterest.setModifiedDate(new Date());
		movieInterest.setFavoriteMovie(favoriteMovie);
		movieInterest.setFavoriteGenreId(favoriteGenreId);
		movieInterest.setLeastFavoriteMovie(leastFavoriteMovie);
		movieInterest.setFavoriteActor(favoriteActor);
		super.updateMovieInterest(movieInterest);

		return movieInterest;
	}



}


