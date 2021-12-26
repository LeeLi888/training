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

package com.amf.event.monitor.service.http;

import com.amf.event.monitor.service.EventServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>EventServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.amf.event.monitor.model.EventSoap</code>. If the method in the
 * service utility returns a
 * <code>com.amf.event.monitor.model.Event</code>, that is translated to a
 * <code>com.amf.event.monitor.model.EventSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EventServiceSoap {

	public static com.amf.event.monitor.model.EventSoap[] getEventsByCompanyId(
			long companyId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.amf.event.monitor.model.Event> returnValue =
				EventServiceUtil.getEventsByCompanyId(companyId, start, end);

			return com.amf.event.monitor.model.EventSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.amf.event.monitor.model.EventSoap[]
			getEventsByCompanyIdAndUserId(
				long companyId, long userId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.amf.event.monitor.model.Event> returnValue =
				EventServiceUtil.getEventsByCompanyIdAndUserId(
					companyId, userId, start, end);

			return com.amf.event.monitor.model.EventSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getEventsCountByCompanyId(long companyId)
		throws RemoteException {

		try {
			int returnValue = EventServiceUtil.getEventsCountByCompanyId(
				companyId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getEventsCountByCompanyIdAndUserId(
			long companyId, long userId)
		throws RemoteException {

		try {
			int returnValue =
				EventServiceUtil.getEventsCountByCompanyIdAndUserId(
					companyId, userId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.amf.event.monitor.model.EventSoap[]
			getEventsByCompanyIdAndEventType(
				long companyId, String eventType, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.amf.event.monitor.model.Event> returnValue =
				EventServiceUtil.getEventsByCompanyIdAndEventType(
					companyId, eventType, start, end);

			return com.amf.event.monitor.model.EventSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long getEventsCountByCompanyIdAndEventType(
			long companyId, String eventType)
		throws RemoteException {

		try {
			long returnValue =
				EventServiceUtil.getEventsCountByCompanyIdAndEventType(
					companyId, eventType);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.amf.event.monitor.model.EventSoap[]
			getEventsByCompanyIdAndUserIdAndEventType(
				long companyId, long userId, String eventType, int start,
				int end)
		throws RemoteException {

		try {
			java.util.List<com.amf.event.monitor.model.Event> returnValue =
				EventServiceUtil.getEventsByCompanyIdAndUserIdAndEventType(
					companyId, userId, eventType, start, end);

			return com.amf.event.monitor.model.EventSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long getEventsCountByCompanyIdAndUserIdAndEventType(
			long companyId, long userId, String eventType)
		throws RemoteException {

		try {
			long returnValue =
				EventServiceUtil.getEventsCountByCompanyIdAndUserIdAndEventType(
					companyId, userId, eventType);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EventServiceSoap.class);

}