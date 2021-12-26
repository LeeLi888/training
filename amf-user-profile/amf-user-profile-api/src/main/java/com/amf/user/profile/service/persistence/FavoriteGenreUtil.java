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

package com.amf.user.profile.service.persistence;

import com.amf.user.profile.model.FavoriteGenre;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the favorite genre service. This utility wraps <code>com.amf.user.profile.service.persistence.impl.FavoriteGenrePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenrePersistence
 * @generated
 */
public class FavoriteGenreUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FavoriteGenre favoriteGenre) {
		getPersistence().clearCache(favoriteGenre);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, FavoriteGenre> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FavoriteGenre> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FavoriteGenre> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FavoriteGenre> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FavoriteGenre> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FavoriteGenre update(FavoriteGenre favoriteGenre) {
		return getPersistence().update(favoriteGenre);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FavoriteGenre update(
		FavoriteGenre favoriteGenre, ServiceContext serviceContext) {

		return getPersistence().update(favoriteGenre, serviceContext);
	}

	/**
	 * Caches the favorite genre in the entity cache if it is enabled.
	 *
	 * @param favoriteGenre the favorite genre
	 */
	public static void cacheResult(FavoriteGenre favoriteGenre) {
		getPersistence().cacheResult(favoriteGenre);
	}

	/**
	 * Caches the favorite genres in the entity cache if it is enabled.
	 *
	 * @param favoriteGenres the favorite genres
	 */
	public static void cacheResult(List<FavoriteGenre> favoriteGenres) {
		getPersistence().cacheResult(favoriteGenres);
	}

	/**
	 * Creates a new favorite genre with the primary key. Does not add the favorite genre to the database.
	 *
	 * @param favoriteGenreId the primary key for the new favorite genre
	 * @return the new favorite genre
	 */
	public static FavoriteGenre create(long favoriteGenreId) {
		return getPersistence().create(favoriteGenreId);
	}

	/**
	 * Removes the favorite genre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre that was removed
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	public static FavoriteGenre remove(long favoriteGenreId)
		throws com.amf.user.profile.exception.NoSuchFavoriteGenreException {

		return getPersistence().remove(favoriteGenreId);
	}

	public static FavoriteGenre updateImpl(FavoriteGenre favoriteGenre) {
		return getPersistence().updateImpl(favoriteGenre);
	}

	/**
	 * Returns the favorite genre with the primary key or throws a <code>NoSuchFavoriteGenreException</code> if it could not be found.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	public static FavoriteGenre findByPrimaryKey(long favoriteGenreId)
		throws com.amf.user.profile.exception.NoSuchFavoriteGenreException {

		return getPersistence().findByPrimaryKey(favoriteGenreId);
	}

	/**
	 * Returns the favorite genre with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre, or <code>null</code> if a favorite genre with the primary key could not be found
	 */
	public static FavoriteGenre fetchByPrimaryKey(long favoriteGenreId) {
		return getPersistence().fetchByPrimaryKey(favoriteGenreId);
	}

	/**
	 * Returns all the favorite genres.
	 *
	 * @return the favorite genres
	 */
	public static List<FavoriteGenre> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the favorite genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorite genres
	 * @param end the upper bound of the range of favorite genres (not inclusive)
	 * @return the range of favorite genres
	 */
	public static List<FavoriteGenre> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the favorite genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorite genres
	 * @param end the upper bound of the range of favorite genres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of favorite genres
	 */
	public static List<FavoriteGenre> findAll(
		int start, int end,
		OrderByComparator<FavoriteGenre> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the favorite genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorite genres
	 * @param end the upper bound of the range of favorite genres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of favorite genres
	 */
	public static List<FavoriteGenre> findAll(
		int start, int end, OrderByComparator<FavoriteGenre> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the favorite genres from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of favorite genres.
	 *
	 * @return the number of favorite genres
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FavoriteGenrePersistence getPersistence() {
		return _persistence;
	}

	private static volatile FavoriteGenrePersistence _persistence;

}