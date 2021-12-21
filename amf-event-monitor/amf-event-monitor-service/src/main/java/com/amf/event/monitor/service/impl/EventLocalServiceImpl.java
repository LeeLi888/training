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

package com.amf.event.monitor.service.impl;

import com.amf.event.monitor.service.base.EventLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

import com.amf.event.monitor.model.Event;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.amf.event.monitor.model.Event",
	service = AopService.class
)
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {

	public List<Event> getEventsByCompanyId(long companyId, int start, int end) {
		return eventPersistence.findByCompanyId(companyId, start, end);
	}

	public List<Event> getEventsByCompanyIdAndUserId(long companyId, long userId, int start, int end) {
		return eventPersistence.findByCompanyIdAndUserId(companyId, userId, start, end);
	}

	public int getEventsCountByCompanyId(long companyId) {
		return eventPersistence.countByCompanyId(companyId);
	}

	public int getEventsCountByCompanyIdAndUserId(long companyId, long userId) {
		return eventPersistence.countByCompanyIdAndUserId(companyId, userId);
	}

	public List<Event> getEventsByCompanyIdAndEventType(long companyId, String eventType, int start, int end) {
		return eventPersistence.findByCompanyIdAndEventType(companyId, eventType, start, end);
	}

	public List<Event> getEventsByCompanyIdAndUserIdAndEventType(long companyId, long userId, String eventType, int start, int end) {
		return eventPersistence.findByCompanyIdAndUserIdAndEventType(companyId, userId, eventType, start, end);
	}

	public long getEventsCountByCompanyIdAndEventType(long companyId, String eventType) {
		return eventPersistence.countByCompanyIdAndEventType(companyId, eventType);
	}

	public long getEventsCountByCompanyIdAndUserIdAndEventType(long companyId, long userId, String eventType) {
		return eventPersistence.countByCompanyIdAndUserIdAndEventType(companyId, userId, eventType);
	}

}