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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventService
 * @generated
 */
public class EventServiceWrapper
	implements EventService, ServiceWrapper<EventService> {

	public EventServiceWrapper(EventService eventService) {
		_eventService = eventService;
	}

	@Override
	public java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyId(long companyId, int start, int end) {

		return _eventService.getEventsByCompanyId(companyId, start, end);
	}

	@Override
	public java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyIdAndEventType(
			long companyId, String eventType, int start, int end) {

		return _eventService.getEventsByCompanyIdAndEventType(
			companyId, eventType, start, end);
	}

	@Override
	public java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyIdAndUserId(
			long companyId, long userId, int start, int end) {

		return _eventService.getEventsByCompanyIdAndUserId(
			companyId, userId, start, end);
	}

	@Override
	public java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyIdAndUserIdAndEventType(
			long companyId, long userId, String eventType, int start, int end) {

		return _eventService.getEventsByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, start, end);
	}

	@Override
	public int getEventsCountByCompanyId(long companyId) {
		return _eventService.getEventsCountByCompanyId(companyId);
	}

	@Override
	public long getEventsCountByCompanyIdAndEventType(
		long companyId, String eventType) {

		return _eventService.getEventsCountByCompanyIdAndEventType(
			companyId, eventType);
	}

	@Override
	public int getEventsCountByCompanyIdAndUserId(long companyId, long userId) {
		return _eventService.getEventsCountByCompanyIdAndUserId(
			companyId, userId);
	}

	@Override
	public long getEventsCountByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		return _eventService.getEventsCountByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventService.getOSGiServiceIdentifier();
	}

	@Override
	public EventService getWrappedService() {
		return _eventService;
	}

	@Override
	public void setWrappedService(EventService eventService) {
		_eventService = eventService;
	}

	private EventService _eventService;

}