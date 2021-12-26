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

package com.amf.user.profile.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MovieInterestService}.
 *
 * @author Brian Wing Shun Chan
 * @see MovieInterestService
 * @generated
 */
public class MovieInterestServiceWrapper
	implements MovieInterestService, ServiceWrapper<MovieInterestService> {

	public MovieInterestServiceWrapper(
		MovieInterestService movieInterestService) {

		_movieInterestService = movieInterestService;
	}

	@Override
	public com.amf.user.profile.model.MovieInterest addMovieInterest(
			long userId, String favoriteMovie, long favoriteGenreId,
			String leastFavoriteMovie, String favoriteActor,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieInterestService.addMovieInterest(
			userId, favoriteMovie, favoriteGenreId, leastFavoriteMovie,
			favoriteActor, serviceContext);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest getMovieInterestByUserId(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieInterestService.getMovieInterestByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _movieInterestService.getOSGiServiceIdentifier();
	}

	@Override
	public com.amf.user.profile.model.MovieInterest updateMovieInterest(
			long movieInterestId, String favoriteMovie, long favoriteGenreId,
			String leastFavoriteMovie, String favoriteActor,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _movieInterestService.updateMovieInterest(
			movieInterestId, favoriteMovie, favoriteGenreId, leastFavoriteMovie,
			favoriteActor, serviceContext);
	}

	@Override
	public MovieInterestService getWrappedService() {
		return _movieInterestService;
	}

	@Override
	public void setWrappedService(MovieInterestService movieInterestService) {
		_movieInterestService = movieInterestService;
	}

	private MovieInterestService _movieInterestService;

}