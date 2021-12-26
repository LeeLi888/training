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

import com.amf.registration.model.UserExternal;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user external service. This utility wraps <code>com.amf.registration.service.persistence.impl.UserExternalPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserExternalPersistence
 * @generated
 */
public class UserExternalUtil {

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
	public static void clearCache(UserExternal userExternal) {
		getPersistence().clearCache(userExternal);
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
	public static Map<Serializable, UserExternal> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserExternal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserExternal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserExternal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserExternal> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserExternal update(UserExternal userExternal) {
		return getPersistence().update(userExternal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserExternal update(
		UserExternal userExternal, ServiceContext serviceContext) {

		return getPersistence().update(userExternal, serviceContext);
	}

	/**
	 * Caches the user external in the entity cache if it is enabled.
	 *
	 * @param userExternal the user external
	 */
	public static void cacheResult(UserExternal userExternal) {
		getPersistence().cacheResult(userExternal);
	}

	/**
	 * Caches the user externals in the entity cache if it is enabled.
	 *
	 * @param userExternals the user externals
	 */
	public static void cacheResult(List<UserExternal> userExternals) {
		getPersistence().cacheResult(userExternals);
	}

	/**
	 * Creates a new user external with the primary key. Does not add the user external to the database.
	 *
	 * @param userExternalId the primary key for the new user external
	 * @return the new user external
	 */
	public static UserExternal create(long userExternalId) {
		return getPersistence().create(userExternalId);
	}

	/**
	 * Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external that was removed
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	public static UserExternal remove(long userExternalId)
		throws com.amf.registration.exception.NoSuchUserExternalException {

		return getPersistence().remove(userExternalId);
	}

	public static UserExternal updateImpl(UserExternal userExternal) {
		return getPersistence().updateImpl(userExternal);
	}

	/**
	 * Returns the user external with the primary key or throws a <code>NoSuchUserExternalException</code> if it could not be found.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	public static UserExternal findByPrimaryKey(long userExternalId)
		throws com.amf.registration.exception.NoSuchUserExternalException {

		return getPersistence().findByPrimaryKey(userExternalId);
	}

	/**
	 * Returns the user external with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external, or <code>null</code> if a user external with the primary key could not be found
	 */
	public static UserExternal fetchByPrimaryKey(long userExternalId) {
		return getPersistence().fetchByPrimaryKey(userExternalId);
	}

	/**
	 * Returns all the user externals.
	 *
	 * @return the user externals
	 */
	public static List<UserExternal> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserExternal> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserExternal> findAll(
		int start, int end, OrderByComparator<UserExternal> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserExternal> findAll(
		int start, int end, OrderByComparator<UserExternal> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user externals from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user externals.
	 *
	 * @return the number of user externals
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserExternalPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserExternalPersistence _persistence;

}