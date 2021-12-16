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

package com.amf.registration.service.persistence;

import com.amf.registration.exception.NoSuchUserExternalException;
import com.amf.registration.model.UserExternal;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user external service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalUtil
 * @generated
 */
@ProviderType
public interface UserExternalPersistence extends BasePersistence<UserExternal> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserExternalUtil} to access the user external persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the user external in the entity cache if it is enabled.
	 *
	 * @param userExternal the user external
	 */
	public void cacheResult(UserExternal userExternal);

	/**
	 * Caches the user externals in the entity cache if it is enabled.
	 *
	 * @param userExternals the user externals
	 */
	public void cacheResult(java.util.List<UserExternal> userExternals);

	/**
	 * Creates a new user external with the primary key. Does not add the user external to the database.
	 *
	 * @param userExternalId the primary key for the new user external
	 * @return the new user external
	 */
	public UserExternal create(long userExternalId);

	/**
	 * Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external that was removed
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	public UserExternal remove(long userExternalId)
		throws NoSuchUserExternalException;

	public UserExternal updateImpl(UserExternal userExternal);

	/**
	 * Returns the user external with the primary key or throws a <code>NoSuchUserExternalException</code> if it could not be found.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	public UserExternal findByPrimaryKey(long userExternalId)
		throws NoSuchUserExternalException;

	/**
	 * Returns the user external with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external, or <code>null</code> if a user external with the primary key could not be found
	 */
	public UserExternal fetchByPrimaryKey(long userExternalId);

	/**
	 * Returns all the user externals.
	 *
	 * @return the user externals
	 */
	public java.util.List<UserExternal> findAll();

	/**
	 * Returns a range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserExternalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @return the range of user externals
	 */
	public java.util.List<UserExternal> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserExternalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user externals
	 */
	public java.util.List<UserExternal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserExternalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user externals
	 */
	public java.util.List<UserExternal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserExternal>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user externals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user externals.
	 *
	 * @return the number of user externals
	 */
	public int countAll();

}