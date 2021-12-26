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
 * Provides a wrapper for {@link FavoriteGenreService}.
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenreService
 * @generated
 */
public class FavoriteGenreServiceWrapper
	implements FavoriteGenreService, ServiceWrapper<FavoriteGenreService> {

	public FavoriteGenreServiceWrapper(
		FavoriteGenreService favoriteGenreService) {

		_favoriteGenreService = favoriteGenreService;
	}

	@Override
	public java.util.List<com.amf.user.profile.model.FavoriteGenre>
		getFavoriteGenres() {

		return _favoriteGenreService.getFavoriteGenres();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _favoriteGenreService.getOSGiServiceIdentifier();
	}

	@Override
	public FavoriteGenreService getWrappedService() {
		return _favoriteGenreService;
	}

	@Override
	public void setWrappedService(FavoriteGenreService favoriteGenreService) {
		_favoriteGenreService = favoriteGenreService;
	}

	private FavoriteGenreService _favoriteGenreService;

}