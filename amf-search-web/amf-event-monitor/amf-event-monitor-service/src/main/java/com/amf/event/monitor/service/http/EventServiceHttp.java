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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>EventServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventServiceSoap
 * @generated
 */
public class EventServiceHttp {

	public static java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyId(
			HttpPrincipal httpPrincipal, long companyId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class, "getEventsByCompanyId",
				_getEventsByCompanyIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.amf.event.monitor.model.Event>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyIdAndUserId(
			HttpPrincipal httpPrincipal, long companyId, long userId, int start,
			int end) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class, "getEventsByCompanyIdAndUserId",
				_getEventsByCompanyIdAndUserIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, userId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.amf.event.monitor.model.Event>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getEventsCountByCompanyId(
		HttpPrincipal httpPrincipal, long companyId) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class, "getEventsCountByCompanyId",
				_getEventsCountByCompanyIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getEventsCountByCompanyIdAndUserId(
		HttpPrincipal httpPrincipal, long companyId, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class, "getEventsCountByCompanyIdAndUserId",
				_getEventsCountByCompanyIdAndUserIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyIdAndEventType(
			HttpPrincipal httpPrincipal, long companyId, String eventType,
			int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class, "getEventsByCompanyIdAndEventType",
				_getEventsByCompanyIdAndEventTypeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, eventType, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.amf.event.monitor.model.Event>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getEventsCountByCompanyIdAndEventType(
		HttpPrincipal httpPrincipal, long companyId, String eventType) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class, "getEventsCountByCompanyIdAndEventType",
				_getEventsCountByCompanyIdAndEventTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, eventType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.amf.event.monitor.model.Event>
		getEventsByCompanyIdAndUserIdAndEventType(
			HttpPrincipal httpPrincipal, long companyId, long userId,
			String eventType, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class,
				"getEventsByCompanyIdAndUserIdAndEventType",
				_getEventsByCompanyIdAndUserIdAndEventTypeParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, userId, eventType, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.amf.event.monitor.model.Event>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getEventsCountByCompanyIdAndUserIdAndEventType(
		HttpPrincipal httpPrincipal, long companyId, long userId,
		String eventType) {

		try {
			MethodKey methodKey = new MethodKey(
				EventServiceUtil.class,
				"getEventsCountByCompanyIdAndUserIdAndEventType",
				_getEventsCountByCompanyIdAndUserIdAndEventTypeParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, userId, eventType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EventServiceHttp.class);

	private static final Class<?>[] _getEventsByCompanyIdParameterTypes0 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[]
		_getEventsByCompanyIdAndUserIdParameterTypes1 = new Class[] {
			long.class, long.class, int.class, int.class
		};
	private static final Class<?>[] _getEventsCountByCompanyIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getEventsCountByCompanyIdAndUserIdParameterTypes3 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[]
		_getEventsByCompanyIdAndEventTypeParameterTypes4 = new Class[] {
			long.class, String.class, int.class, int.class
		};
	private static final Class<?>[]
		_getEventsCountByCompanyIdAndEventTypeParameterTypes5 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[]
		_getEventsByCompanyIdAndUserIdAndEventTypeParameterTypes6 =
			new Class[] {
				long.class, long.class, String.class, int.class, int.class
			};
	private static final Class<?>[]
		_getEventsCountByCompanyIdAndUserIdAndEventTypeParameterTypes7 =
			new Class[] {long.class, long.class, String.class};

}