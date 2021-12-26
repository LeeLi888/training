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

package com.amf.event.monitor.service.persistence;

import com.amf.event.monitor.model.Event;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the event service. This utility wraps <code>com.amf.event.monitor.service.persistence.impl.EventPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventPersistence
 * @generated
 */
public class EventUtil {

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
	public static void clearCache(Event event) {
		getPersistence().clearCache(event);
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
	public static Map<Serializable, Event> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Event> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Event> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Event> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Event update(Event event) {
		return getPersistence().update(event);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Event update(Event event, ServiceContext serviceContext) {
		return getPersistence().update(event, serviceContext);
	}

	/**
	 * Returns all the events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching events
	 */
	public static List<Event> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of matching events
	 */
	public static List<Event> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyId_First(
			long companyId, OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyId_First(
		long companyId, OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyId_Last(
			long companyId, OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyId_Last(
		long companyId, OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the events before and after the current event in the ordered set where companyId = &#63;.
	 *
	 * @param eventId the primary key of the current event
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	public static Event[] findByCompanyId_PrevAndNext(
			long eventId, long companyId,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyId_PrevAndNext(
			eventId, companyId, orderByComparator);
	}

	/**
	 * Removes all the events where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching events
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the events where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @return the matching events
	 */
	public static List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType) {

		return getPersistence().findByCompanyIdAndEventType(
			companyId, eventType);
	}

	/**
	 * Returns a range of all the events where companyId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of matching events
	 */
	public static List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType, int start, int end) {

		return getPersistence().findByCompanyIdAndEventType(
			companyId, eventType, start, end);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().findByCompanyIdAndEventType(
			companyId, eventType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyIdAndEventType(
			companyId, eventType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyIdAndEventType_First(
			long companyId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndEventType_First(
			companyId, eventType, orderByComparator);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyIdAndEventType_First(
		long companyId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndEventType_First(
			companyId, eventType, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyIdAndEventType_Last(
			long companyId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndEventType_Last(
			companyId, eventType, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyIdAndEventType_Last(
		long companyId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndEventType_Last(
			companyId, eventType, orderByComparator);
	}

	/**
	 * Returns the events before and after the current event in the ordered set where companyId = &#63; and eventType = &#63;.
	 *
	 * @param eventId the primary key of the current event
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	public static Event[] findByCompanyIdAndEventType_PrevAndNext(
			long eventId, long companyId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndEventType_PrevAndNext(
			eventId, companyId, eventType, orderByComparator);
	}

	/**
	 * Removes all the events where companyId = &#63; and eventType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 */
	public static void removeByCompanyIdAndEventType(
		long companyId, String eventType) {

		getPersistence().removeByCompanyIdAndEventType(companyId, eventType);
	}

	/**
	 * Returns the number of events where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @return the number of matching events
	 */
	public static int countByCompanyIdAndEventType(
		long companyId, String eventType) {

		return getPersistence().countByCompanyIdAndEventType(
			companyId, eventType);
	}

	/**
	 * Returns all the events where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching events
	 */
	public static List<Event> findByCompanyIdAndUserId(
		long companyId, long userId) {

		return getPersistence().findByCompanyIdAndUserId(companyId, userId);
	}

	/**
	 * Returns a range of all the events where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of matching events
	 */
	public static List<Event> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end) {

		return getPersistence().findByCompanyIdAndUserId(
			companyId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().findByCompanyIdAndUserId(
			companyId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyIdAndUserId(
			companyId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyIdAndUserId_First(
			long companyId, long userId,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndUserId_First(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyIdAndUserId_First(
		long companyId, long userId,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndUserId_First(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyIdAndUserId_Last(
			long companyId, long userId,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndUserId_Last(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyIdAndUserId_Last(
		long companyId, long userId,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndUserId_Last(
			companyId, userId, orderByComparator);
	}

	/**
	 * Returns the events before and after the current event in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param eventId the primary key of the current event
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	public static Event[] findByCompanyIdAndUserId_PrevAndNext(
			long eventId, long companyId, long userId,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndUserId_PrevAndNext(
			eventId, companyId, userId, orderByComparator);
	}

	/**
	 * Removes all the events where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	public static void removeByCompanyIdAndUserId(long companyId, long userId) {
		getPersistence().removeByCompanyIdAndUserId(companyId, userId);
	}

	/**
	 * Returns the number of events where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching events
	 */
	public static int countByCompanyIdAndUserId(long companyId, long userId) {
		return getPersistence().countByCompanyIdAndUserId(companyId, userId);
	}

	/**
	 * Returns all the events where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching events
	 */
	public static List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		return getPersistence().findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType);
	}

	/**
	 * Returns a range of all the events where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of matching events
	 */
	public static List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType, int start, int end) {

		return getPersistence().findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, start, end);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the events where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching events
	 */
	public static List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyIdAndUserIdAndEventType_First(
			long companyId, long userId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndUserIdAndEventType_First(
			companyId, userId, eventType, orderByComparator);
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyIdAndUserIdAndEventType_First(
		long companyId, long userId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndUserIdAndEventType_First(
			companyId, userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	public static Event findByCompanyIdAndUserIdAndEventType_Last(
			long companyId, long userId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByCompanyIdAndUserIdAndEventType_Last(
			companyId, userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 */
	public static Event fetchByCompanyIdAndUserIdAndEventType_Last(
		long companyId, long userId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndUserIdAndEventType_Last(
			companyId, userId, eventType, orderByComparator);
	}

	/**
	 * Returns the events before and after the current event in the ordered set where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param eventId the primary key of the current event
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	public static Event[] findByCompanyIdAndUserIdAndEventType_PrevAndNext(
			long eventId, long companyId, long userId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().
			findByCompanyIdAndUserIdAndEventType_PrevAndNext(
				eventId, companyId, userId, eventType, orderByComparator);
	}

	/**
	 * Removes all the events where companyId = &#63; and userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	public static void removeByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		getPersistence().removeByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType);
	}

	/**
	 * Returns the number of events where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching events
	 */
	public static int countByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		return getPersistence().countByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType);
	}

	/**
	 * Caches the event in the entity cache if it is enabled.
	 *
	 * @param event the event
	 */
	public static void cacheResult(Event event) {
		getPersistence().cacheResult(event);
	}

	/**
	 * Caches the events in the entity cache if it is enabled.
	 *
	 * @param events the events
	 */
	public static void cacheResult(List<Event> events) {
		getPersistence().cacheResult(events);
	}

	/**
	 * Creates a new event with the primary key. Does not add the event to the database.
	 *
	 * @param eventId the primary key for the new event
	 * @return the new event
	 */
	public static Event create(long eventId) {
		return getPersistence().create(eventId);
	}

	/**
	 * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the event
	 * @return the event that was removed
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	public static Event remove(long eventId)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().remove(eventId);
	}

	public static Event updateImpl(Event event) {
		return getPersistence().updateImpl(event);
	}

	/**
	 * Returns the event with the primary key or throws a <code>NoSuchEventException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the event
	 * @return the event
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	public static Event findByPrimaryKey(long eventId)
		throws com.amf.event.monitor.exception.NoSuchEventException {

		return getPersistence().findByPrimaryKey(eventId);
	}

	/**
	 * Returns the event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the event
	 * @return the event, or <code>null</code> if a event with the primary key could not be found
	 */
	public static Event fetchByPrimaryKey(long eventId) {
		return getPersistence().fetchByPrimaryKey(eventId);
	}

	/**
	 * Returns all the events.
	 *
	 * @return the events
	 */
	public static List<Event> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @return the range of events
	 */
	public static List<Event> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of events
	 */
	public static List<Event> findAll(
		int start, int end, OrderByComparator<Event> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of events
	 * @param end the upper bound of the range of events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of events
	 */
	public static List<Event> findAll(
		int start, int end, OrderByComparator<Event> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the events from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of events.
	 *
	 * @return the number of events
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EventPersistence _persistence;

}