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

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeneralProfileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GeneralProfileLocalService
 * @generated
 */
public class GeneralProfileLocalServiceWrapper
	implements GeneralProfileLocalService,
			   ServiceWrapper<GeneralProfileLocalService> {

	public GeneralProfileLocalServiceWrapper(
		GeneralProfileLocalService generalProfileLocalService) {

		_generalProfileLocalService = generalProfileLocalService;
	}

	/**
	 * Adds the general profile to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GeneralProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param generalProfile the general profile
	 * @return the general profile that was added
	 */
	@Override
	public com.amf.user.profile.model.GeneralProfile addGeneralProfile(
		com.amf.user.profile.model.GeneralProfile generalProfile) {

		return _generalProfileLocalService.addGeneralProfile(generalProfile);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile addGeneralProfile(
			long userId, String aboutMe, String favoriteQuotes,
			ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.addGeneralProfile(
			userId, aboutMe, favoriteQuotes, serviceContext);
	}

	/**
	 * Creates a new general profile with the primary key. Does not add the general profile to the database.
	 *
	 * @param generalProfileId the primary key for the new general profile
	 * @return the new general profile
	 */
	@Override
	public com.amf.user.profile.model.GeneralProfile createGeneralProfile(
		long generalProfileId) {

		return _generalProfileLocalService.createGeneralProfile(
			generalProfileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the general profile from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GeneralProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param generalProfile the general profile
	 * @return the general profile that was removed
	 */
	@Override
	public com.amf.user.profile.model.GeneralProfile deleteGeneralProfile(
		com.amf.user.profile.model.GeneralProfile generalProfile) {

		return _generalProfileLocalService.deleteGeneralProfile(generalProfile);
	}

	/**
	 * Deletes the general profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GeneralProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile that was removed
	 * @throws PortalException if a general profile with the primary key could not be found
	 */
	@Override
	public com.amf.user.profile.model.GeneralProfile deleteGeneralProfile(
			long generalProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.deleteGeneralProfile(
			generalProfileId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _generalProfileLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _generalProfileLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _generalProfileLocalService.dynamicQuery();
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

		return _generalProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.user.profile.model.impl.GeneralProfileModelImpl</code>.
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

		return _generalProfileLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.user.profile.model.impl.GeneralProfileModelImpl</code>.
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

		return _generalProfileLocalService.dynamicQuery(
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

		return _generalProfileLocalService.dynamicQueryCount(dynamicQuery);
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

		return _generalProfileLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile fetchGeneralProfile(
		long generalProfileId) {

		return _generalProfileLocalService.fetchGeneralProfile(
			generalProfileId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _generalProfileLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the general profile with the primary key.
	 *
	 * @param generalProfileId the primary key of the general profile
	 * @return the general profile
	 * @throws PortalException if a general profile with the primary key could not be found
	 */
	@Override
	public com.amf.user.profile.model.GeneralProfile getGeneralProfile(
			long generalProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.getGeneralProfile(generalProfileId);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile getGeneralProfileByUserId(
			long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.getGeneralProfileByUserId(userId);
	}

	/**
	 * Returns a range of all the general profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.user.profile.model.impl.GeneralProfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of general profiles
	 * @param end the upper bound of the range of general profiles (not inclusive)
	 * @return the range of general profiles
	 */
	@Override
	public java.util.List<com.amf.user.profile.model.GeneralProfile>
		getGeneralProfiles(int start, int end) {

		return _generalProfileLocalService.getGeneralProfiles(start, end);
	}

	/**
	 * Returns the number of general profiles.
	 *
	 * @return the number of general profiles
	 */
	@Override
	public int getGeneralProfilesCount() {
		return _generalProfileLocalService.getGeneralProfilesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _generalProfileLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _generalProfileLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the general profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GeneralProfileLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param generalProfile the general profile
	 * @return the general profile that was updated
	 */
	@Override
	public com.amf.user.profile.model.GeneralProfile updateGeneralProfile(
		com.amf.user.profile.model.GeneralProfile generalProfile) {

		return _generalProfileLocalService.updateGeneralProfile(generalProfile);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile updateGeneralProfile(
			long generalProfileId, String aboutMe, String favoriteQuotes,
			ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _generalProfileLocalService.updateGeneralProfile(
			generalProfileId, aboutMe, favoriteQuotes, serviceContext);
	}

	@Override
	public GeneralProfileLocalService getWrappedService() {
		return _generalProfileLocalService;
	}

	@Override
	public void setWrappedService(
		GeneralProfileLocalService generalProfileLocalService) {

		_generalProfileLocalService = generalProfileLocalService;
	}

	private GeneralProfileLocalService _generalProfileLocalService;

}