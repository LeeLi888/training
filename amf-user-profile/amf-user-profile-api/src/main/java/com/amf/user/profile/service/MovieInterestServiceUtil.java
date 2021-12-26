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

import com.amf.user.profile.model.MovieInterest;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for MovieInterest. This utility wraps
 * <code>com.amf.user.profile.service.impl.MovieInterestServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MovieInterestService
 * @generated
 */
public class MovieInterestServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.user.profile.service.impl.MovieInterestServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MovieInterest addMovieInterest(
			long userId, String favoriteMovie, long favoriteGenreId,
			String leastFavoriteMovie, String favoriteActor,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addMovieInterest(
			userId, favoriteMovie, favoriteGenreId, leastFavoriteMovie,
			favoriteActor, serviceContext);
	}

	public static MovieInterest getMovieInterestByUserId(long userId)
		throws PortalException {

		return getService().getMovieInterestByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MovieInterest updateMovieInterest(
			long movieInterestId, String favoriteMovie, long favoriteGenreId,
			String leastFavoriteMovie, String favoriteActor,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateMovieInterest(
			movieInterestId, favoriteMovie, favoriteGenreId, leastFavoriteMovie,
			favoriteActor, serviceContext);
	}

	public static MovieInterestService getService() {
		return _service;
	}

	private static volatile MovieInterestService _service;

}