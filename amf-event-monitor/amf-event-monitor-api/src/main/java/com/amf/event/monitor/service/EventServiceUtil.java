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

package com.amf.event.monitor.service;

import com.amf.event.monitor.model.Event;

import java.util.List;

/**
 * Provides the remote service utility for Event. This utility wraps
 * <code>com.amf.event.monitor.service.impl.EventServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EventService
 * @generated
 */
public class EventServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.event.monitor.service.impl.EventServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<Event> getEventsByCompanyId(
		long companyId, int start, int end) {

		return getService().getEventsByCompanyId(companyId, start, end);
	}

	public static List<Event> getEventsByCompanyIdAndEventType(
		long companyId, String eventType, int start, int end) {

		return getService().getEventsByCompanyIdAndEventType(
			companyId, eventType, start, end);
	}

	public static List<Event> getEventsByCompanyIdAndUserId(
		long companyId, long userId, int start, int end) {

		return getService().getEventsByCompanyIdAndUserId(
			companyId, userId, start, end);
	}

	public static List<Event> getEventsByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType, int start, int end) {

		return getService().getEventsByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, start, end);
	}

	public static int getEventsCountByCompanyId(long companyId) {
		return getService().getEventsCountByCompanyId(companyId);
	}

	public static long getEventsCountByCompanyIdAndEventType(
		long companyId, String eventType) {

		return getService().getEventsCountByCompanyIdAndEventType(
			companyId, eventType);
	}

	public static int getEventsCountByCompanyIdAndUserId(
		long companyId, long userId) {

		return getService().getEventsCountByCompanyIdAndUserId(
			companyId, userId);
	}

	public static long getEventsCountByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		return getService().getEventsCountByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static EventService getService() {
		return _service;
	}

	private static volatile EventService _service;

}