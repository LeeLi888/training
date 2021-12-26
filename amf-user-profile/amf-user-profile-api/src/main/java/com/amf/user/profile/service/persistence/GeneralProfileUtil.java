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

import com.amf.user.profile.model.GeneralProfile;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the general profile service. This utility wraps <code>com.amf.user.profile.service.persistence.impl.GeneralProfilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GeneralProfilePersistence
 * @generated
 */
public class GeneralProfileUtil {

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
	public static void clearCache(GeneralProfile generalProfile) {
		getPersistence().clearCache(generalProfile);
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
	public static Map<Serializable, GeneralProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GeneralProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeneralProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeneralProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GeneralProfile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GeneralProfile update(GeneralProfile generalProfile) {
		return getPersistence().update(generalProfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GeneralProfile update(
		GeneralProfile generalProfile, ServiceContext serviceContext) {

		return getPersistence().update(generalProfile, serviceContext);
	}

	/**
	 * Returns the general profile where userId = &#63; or throws a <code>NoSuchGeneralProfileException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching general profile
	 * @throws NoSuchGeneralProfileException if a matching general profile could not be found
	 */
	public static GeneralProfile findByUserId(long userId)
		throws com.amf.user.profile.exception.NoSuchGeneralProfileException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	 */
	public static GeneralProfile fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	 */
	public static GeneralProfile fetchByUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the general profile where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the general profile that was removed
	 */
	public static GeneralProfile removeByUserId(long userId)
		throws com.amf.user.profile.exception.NoSuchGeneralProfileException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of general profiles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching general profiles
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the general profile in the entity cache if it is enabled.
	 *
	 * @param generalProfile the general profile
	 */
	public static void cacheResult(GeneralProfile generalProfile) {
		getPersistence().cacheResult(generalProfile);
	}

	/**
	 * Caches the general profiles in the entity cache if it is enabled.
	 *
	 * @param generalProfiles the general profiles
	 */
	public static void cacheResult(List<GeneralProfile> generalProfiles) {
		getPersistence().cacheResult(generalProfiles);
	}

	/**
	 * Creates a new general profile with the primary key. Does not add the general profile to the database.
	 *
	 * @param generalProfileId the primary key for the new general profile
	 * @return the new general profile
	 */
	public static GeneralProfile create(long generalProfileId) {
		return getPersistence().create(generalProfileId);
	}

	/**
	 * Removes the general profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile that was removed
	 * @throws NoSuchGeneralProfileException if a general profile with the primary key could not be found
	 */
	public static GeneralProfile remove(long generalProfileId)
		throws com.amf.user.profile.exception.NoSuchGeneralProfileException {

		return getPersistence().remove(generalProfileId);
	}

	public static GeneralProfile updateImpl(GeneralProfile generalProfile) {
		return getPersistence().updateImpl(generalProfile);
	}

	/**
	 * Returns the general profile with the primary key or throws a <code>NoSuchGeneralProfileException</code> if it could not be found.
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile
	 * @throws NoSuchGeneralProfileException if a general profile with the primary key could not be found
	 */
	public static GeneralProfile findByPrimaryKey(long generalProfileId)
		throws com.amf.user.profile.exception.NoSuchGeneralProfileException {

		return getPersistence().findByPrimaryKey(generalProfileId);
	}

	/**
	 * Returns the general profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile, or <code>null</code> if a general profile with the primary key could not be found
	 */
	public static GeneralProfile fetchByPrimaryKey(long generalProfileId) {
		return getPersistence().fetchByPrimaryKey(generalProfileId);
	}

	/**
	 * Returns all the general profiles.
	 *
	 * @return the general profiles
	 */
	public static List<GeneralProfile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the general profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GeneralProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of general profiles
	 * @param end the upper bound of the range of general profiles (not inclusive)
	 * @return the range of general profiles
	 */
	public static List<GeneralProfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the general profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GeneralProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of general profiles
	 * @param end the upper bound of the range of general profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of general profiles
	 */
	public static List<GeneralProfile> findAll(
		int start, int end,
		OrderByComparator<GeneralProfile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the general profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GeneralProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of general profiles
	 * @param end the upper bound of the range of general profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of general profiles
	 */
	public static List<GeneralProfile> findAll(
		int start, int end, OrderByComparator<GeneralProfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the general profiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of general profiles.
	 *
	 * @return the number of general profiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GeneralProfilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile GeneralProfilePersistence _persistence;

}