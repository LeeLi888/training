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
 * Provides a wrapper for {@link FavoriteGenreLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenreLocalService
 * @generated
 */
public class FavoriteGenreLocalServiceWrapper
	implements FavoriteGenreLocalService,
			   ServiceWrapper<FavoriteGenreLocalService> {

	public FavoriteGenreLocalServiceWrapper(
		FavoriteGenreLocalService favoriteGenreLocalService) {

		_favoriteGenreLocalService = favoriteGenreLocalService;
	}

	/**
	 * Adds the favorite genre to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteGenreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favoriteGenre the favorite genre
	 * @return the favorite genre that was added
	 */
	@Override
	public com.amf.user.profile.model.FavoriteGenre addFavoriteGenre(
		com.amf.user.profile.model.FavoriteGenre favoriteGenre) {

		return _favoriteGenreLocalService.addFavoriteGenre(favoriteGenre);
	}

	/**
	 * Creates a new favorite genre with the primary key. Does not add the favorite genre to the database.
	 *
	 * @param favoriteGenreId the primary key for the new favorite genre
	 * @return the new favorite genre
	 */
	@Override
	public com.amf.user.profile.model.FavoriteGenre createFavoriteGenre(
		long favoriteGenreId) {

		return _favoriteGenreLocalService.createFavoriteGenre(favoriteGenreId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteGenreLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the favorite genre from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteGenreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favoriteGenre the favorite genre
	 * @return the favorite genre that was removed
	 */
	@Override
	public com.amf.user.profile.model.FavoriteGenre deleteFavoriteGenre(
		com.amf.user.profile.model.FavoriteGenre favoriteGenre) {

		return _favoriteGenreLocalService.deleteFavoriteGenre(favoriteGenre);
	}

	/**
	 * Deletes the favorite genre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteGenreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre that was removed
	 * @throws PortalException if a favorite genre with the primary key could not be found
	 */
	@Override
	public com.amf.user.profile.model.FavoriteGenre deleteFavoriteGenre(
			long favoriteGenreId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteGenreLocalService.deleteFavoriteGenre(favoriteGenreId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteGenreLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _favoriteGenreLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _favoriteGenreLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _favoriteGenreLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _favoriteGenreLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.user.profile.model.impl.FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _favoriteGenreLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.user.profile.model.impl.FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _favoriteGenreLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _favoriteGenreLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _favoriteGenreLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.amf.user.profile.model.FavoriteGenre fetchFavoriteGenre(
		long favoriteGenreId) {

		return _favoriteGenreLocalService.fetchFavoriteGenre(favoriteGenreId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _favoriteGenreLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the favorite genre with the primary key.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre
	 * @throws PortalException if a favorite genre with the primary key could not be found
	 */
	@Override
	public com.amf.user.profile.model.FavoriteGenre getFavoriteGenre(
			long favoriteGenreId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteGenreLocalService.getFavoriteGenre(favoriteGenreId);
	}

	@Override
	public java.util.List<com.amf.user.profile.model.FavoriteGenre>
		getFavoriteGenres() {

		return _favoriteGenreLocalService.getFavoriteGenres();
	}

	/**
	 * Returns a range of all the favorite genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.user.profile.model.impl.FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorite genres
	 * @param end the upper bound of the range of favorite genres (not inclusive)
	 * @return the range of favorite genres
	 */
	@Override
	public java.util.List<com.amf.user.profile.model.FavoriteGenre>
		getFavoriteGenres(int start, int end) {

		return _favoriteGenreLocalService.getFavoriteGenres(start, end);
	}

	/**
	 * Returns the number of favorite genres.
	 *
	 * @return the number of favorite genres
	 */
	@Override
	public int getFavoriteGenresCount() {
		return _favoriteGenreLocalService.getFavoriteGenresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _favoriteGenreLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _favoriteGenreLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _favoriteGenreLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the favorite genre in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FavoriteGenreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param favoriteGenre the favorite genre
	 * @return the favorite genre that was updated
	 */
	@Override
	public com.amf.user.profile.model.FavoriteGenre updateFavoriteGenre(
		com.amf.user.profile.model.FavoriteGenre favoriteGenre) {

		return _favoriteGenreLocalService.updateFavoriteGenre(favoriteGenre);
	}

	@Override
	public FavoriteGenreLocalService getWrappedService() {
		return _favoriteGenreLocalService;
	}

	@Override
	public void setWrappedService(
		FavoriteGenreLocalService favoriteGenreLocalService) {

		_favoriteGenreLocalService = favoriteGenreLocalService;
	}

	private FavoriteGenreLocalService _favoriteGenreLocalService;

}