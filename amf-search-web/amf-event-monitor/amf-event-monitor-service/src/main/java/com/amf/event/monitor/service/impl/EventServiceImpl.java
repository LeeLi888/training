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

import com.amf.event.monitor.service.EventLocalService;
import com.amf.event.monitor.service.base.EventServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import com.amf.event.monitor.model.Event;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=amfeventmonitor",
		"json.web.service.context.path=Event"
	},
	service = AopService.class
)
public class EventServiceImpl extends EventServiceBaseImpl {

	@Reference
	private EventLocalService _eventLocalService;

	public List<Event> getEventsByCompanyId(long companyId, int start, int end) {
		return _eventLocalService.getEventsByCompanyId(companyId, start, end);
	}

	public List<Event> getEventsByCompanyIdAndUserId(long companyId, long userId, int start, int end) {
		return _eventLocalService.getEventsByCompanyIdAndUserId(companyId, userId, start, end);
	}

	public int getEventsCountByCompanyId(long companyId) {
		return _eventLocalService.getEventsCountByCompanyId(companyId);
	}

	public int getEventsCountByCompanyIdAndUserId(long companyId, long userId) {
		return _eventLocalService.getEventsCountByCompanyIdAndUserId(companyId, userId);
	}

	public List<Event> getEventsByCompanyIdAndEventType(long companyId, String eventType, int start, int end) {
		return _eventLocalService.getEventsByCompanyIdAndEventType(companyId, eventType, start, end);
	}

	public long getEventsCountByCompanyIdAndEventType(long companyId, String eventType) {
		return _eventLocalService.getEventsCountByCompanyIdAndEventType(companyId, eventType);
	}

	public List<Event> getEventsByCompanyIdAndUserIdAndEventType(long companyId, long userId, String eventType, int start, int end) {
		return _eventLocalService.getEventsByCompanyIdAndUserIdAndEventType(companyId, userId, eventType, start, end);
	}

	public long getEventsCountByCompanyIdAndUserIdAndEventType(long companyId, long userId, String eventType) {
		return _eventLocalService.getEventsCountByCompanyIdAndUserIdAndEventType(companyId, userId, eventType);
	}

}