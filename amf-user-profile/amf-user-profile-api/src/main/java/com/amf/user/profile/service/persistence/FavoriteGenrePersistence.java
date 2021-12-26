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

import com.amf.user.profile.exception.NoSuchFavoriteGenreException;
import com.amf.user.profile.model.FavoriteGenre;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the favorite genre service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenreUtil
 * @generated
 */
@ProviderType
public interface FavoriteGenrePersistence
	extends BasePersistence<FavoriteGenre> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FavoriteGenreUtil} to access the favorite genre persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the favorite genre in the entity cache if it is enabled.
	 *
	 * @param favoriteGenre the favorite genre
	 */
	public void cacheResult(FavoriteGenre favoriteGenre);

	/**
	 * Caches the favorite genres in the entity cache if it is enabled.
	 *
	 * @param favoriteGenres the favorite genres
	 */
	public void cacheResult(java.util.List<FavoriteGenre> favoriteGenres);

	/**
	 * Creates a new favorite genre with the primary key. Does not add the favorite genre to the database.
	 *
	 * @param favoriteGenreId the primary key for the new favorite genre
	 * @return the new favorite genre
	 */
	public FavoriteGenre create(long favoriteGenreId);

	/**
	 * Removes the favorite genre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre that was removed
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	public FavoriteGenre remove(long favoriteGenreId)
		throws NoSuchFavoriteGenreException;

	public FavoriteGenre updateImpl(FavoriteGenre favoriteGenre);

	/**
	 * Returns the favorite genre with the primary key or throws a <code>NoSuchFavoriteGenreException</code> if it could not be found.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	public FavoriteGenre findByPrimaryKey(long favoriteGenreId)
		throws NoSuchFavoriteGenreException;

	/**
	 * Returns the favorite genre with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre, or <code>null</code> if a favorite genre with the primary key could not be found
	 */
	public FavoriteGenre fetchByPrimaryKey(long favoriteGenreId);

	/**
	 * Returns all the favorite genres.
	 *
	 * @return the favorite genres
	 */
	public java.util.List<FavoriteGenre> findAll();

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
	public java.util.List<FavoriteGenre> findAll(int start, int end);

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
	public java.util.List<FavoriteGenre> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FavoriteGenre>
			orderByComparator);

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
	public java.util.List<FavoriteGenre> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FavoriteGenre>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the favorite genres from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of favorite genres.
	 *
	 * @return the number of favorite genres
	 */
	public int countAll();

}