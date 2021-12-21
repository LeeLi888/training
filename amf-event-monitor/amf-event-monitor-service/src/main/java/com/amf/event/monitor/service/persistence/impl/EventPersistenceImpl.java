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

package com.amf.event.monitor.service.persistence.impl;

import com.amf.event.monitor.exception.NoSuchEventException;
import com.amf.event.monitor.model.Event;
import com.amf.event.monitor.model.EventTable;
import com.amf.event.monitor.model.impl.EventImpl;
import com.amf.event.monitor.model.impl.EventModelImpl;
import com.amf.event.monitor.service.persistence.EventPersistence;
import com.amf.event.monitor.service.persistence.EventUtil;
import com.amf.event.monitor.service.persistence.impl.constants.AmfEventMonitorPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {EventPersistence.class, BasePersistence.class})
public class EventPersistenceImpl
	extends BasePersistenceImpl<Event> implements EventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EventUtil</code> to access the event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EventImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching events
	 */
	@Override
	public List<Event> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Event> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<Event> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Event> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<Event> list = null;

		if (useFinderCache) {
			list = (List<Event>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Event event : list) {
					if (companyId != event.getCompanyId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Event>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	@Override
	public Event findByCompanyId_First(
			long companyId, OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyId_First(companyId, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 */
	@Override
	public Event fetchByCompanyId_First(
		long companyId, OrderByComparator<Event> orderByComparator) {

		List<Event> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event
	 * @throws NoSuchEventException if a matching event could not be found
	 */
	@Override
	public Event findByCompanyId_Last(
			long companyId, OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyId_Last(companyId, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 */
	@Override
	public Event fetchByCompanyId_Last(
		long companyId, OrderByComparator<Event> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Event> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Event[] findByCompanyId_PrevAndNext(
			long eventId, long companyId,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Event[] array = new EventImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, event, companyId, orderByComparator, true);

			array[1] = event;

			array[2] = getByCompanyId_PrevAndNext(
				session, event, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Event getByCompanyId_PrevAndNext(
		Session session, Event event, long companyId,
		OrderByComparator<Event> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENT_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(event)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Event> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the events where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (Event event :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(event);
		}
	}

	/**
	 * Returns the number of events where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching events
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"event.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyIdAndEventType;
	private FinderPath _finderPathWithoutPaginationFindByCompanyIdAndEventType;
	private FinderPath _finderPathCountByCompanyIdAndEventType;

	/**
	 * Returns all the events where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @return the matching events
	 */
	@Override
	public List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType) {

		return findByCompanyIdAndEventType(
			companyId, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType, int start, int end) {

		return findByCompanyIdAndEventType(
			companyId, eventType, start, end, null);
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
	@Override
	public List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return findByCompanyIdAndEventType(
			companyId, eventType, start, end, orderByComparator, true);
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
	@Override
	public List<Event> findByCompanyIdAndEventType(
		long companyId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCompanyIdAndEventType;
				finderArgs = new Object[] {companyId, eventType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyIdAndEventType;
			finderArgs = new Object[] {
				companyId, eventType, start, end, orderByComparator
			};
		}

		List<Event> list = null;

		if (useFinderCache) {
			list = (List<Event>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Event event : list) {
					if ((companyId != event.getCompanyId()) ||
						!eventType.equals(event.getEventType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_COMPANYID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				list = (List<Event>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Event findByCompanyIdAndEventType_First(
			long companyId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyIdAndEventType_First(
			companyId, eventType, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 */
	@Override
	public Event fetchByCompanyIdAndEventType_First(
		long companyId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		List<Event> list = findByCompanyIdAndEventType(
			companyId, eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Event findByCompanyIdAndEventType_Last(
			long companyId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyIdAndEventType_Last(
			companyId, eventType, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 */
	@Override
	public Event fetchByCompanyIdAndEventType_Last(
		long companyId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		int count = countByCompanyIdAndEventType(companyId, eventType);

		if (count == 0) {
			return null;
		}

		List<Event> list = findByCompanyIdAndEventType(
			companyId, eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Event[] findByCompanyIdAndEventType_PrevAndNext(
			long eventId, long companyId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		eventType = Objects.toString(eventType, "");

		Event event = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Event[] array = new EventImpl[3];

			array[0] = getByCompanyIdAndEventType_PrevAndNext(
				session, event, companyId, eventType, orderByComparator, true);

			array[1] = event;

			array[2] = getByCompanyIdAndEventType_PrevAndNext(
				session, event, companyId, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Event getByCompanyIdAndEventType_PrevAndNext(
		Session session, Event event, long companyId, String eventType,
		OrderByComparator<Event> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EVENT_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_COMPANYID_2);

		boolean bindEventType = false;

		if (eventType.isEmpty()) {
			sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (bindEventType) {
			queryPos.add(eventType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(event)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Event> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the events where companyId = &#63; and eventType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 */
	@Override
	public void removeByCompanyIdAndEventType(
		long companyId, String eventType) {

		for (Event event :
				findByCompanyIdAndEventType(
					companyId, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(event);
		}
	}

	/**
	 * Returns the number of events where companyId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param eventType the event type
	 * @return the number of matching events
	 */
	@Override
	public int countByCompanyIdAndEventType(long companyId, String eventType) {
		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = _finderPathCountByCompanyIdAndEventType;

		Object[] finderArgs = new Object[] {companyId, eventType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_COMPANYID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_COMPANYID_2 =
			"event.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_2 =
			"event.eventType = ?";

	private static final String
		_FINDER_COLUMN_COMPANYIDANDEVENTTYPE_EVENTTYPE_3 =
			"(event.eventType IS NULL OR event.eventType = '')";

	private FinderPath _finderPathWithPaginationFindByCompanyIdAndUserId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyIdAndUserId;
	private FinderPath _finderPathCountByCompanyIdAndUserId;

	/**
	 * Returns all the events where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching events
	 */
	@Override
	public List<Event> findByCompanyIdAndUserId(long companyId, long userId) {
		return findByCompanyIdAndUserId(
			companyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Event> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end) {

		return findByCompanyIdAndUserId(companyId, userId, start, end, null);
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
	@Override
	public List<Event> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return findByCompanyIdAndUserId(
			companyId, userId, start, end, orderByComparator, true);
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
	@Override
	public List<Event> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCompanyIdAndUserId;
				finderArgs = new Object[] {companyId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyIdAndUserId;
			finderArgs = new Object[] {
				companyId, userId, start, end, orderByComparator
			};
		}

		List<Event> list = null;

		if (useFinderCache) {
			list = (List<Event>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Event event : list) {
					if ((companyId != event.getCompanyId()) ||
						(userId != event.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				list = (List<Event>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Event findByCompanyIdAndUserId_First(
			long companyId, long userId,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyIdAndUserId_First(
			companyId, userId, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
	}

	/**
	 * Returns the first event in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event, or <code>null</code> if a matching event could not be found
	 */
	@Override
	public Event fetchByCompanyIdAndUserId_First(
		long companyId, long userId,
		OrderByComparator<Event> orderByComparator) {

		List<Event> list = findByCompanyIdAndUserId(
			companyId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Event findByCompanyIdAndUserId_Last(
			long companyId, long userId,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyIdAndUserId_Last(
			companyId, userId, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
	}

	/**
	 * Returns the last event in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event, or <code>null</code> if a matching event could not be found
	 */
	@Override
	public Event fetchByCompanyIdAndUserId_Last(
		long companyId, long userId,
		OrderByComparator<Event> orderByComparator) {

		int count = countByCompanyIdAndUserId(companyId, userId);

		if (count == 0) {
			return null;
		}

		List<Event> list = findByCompanyIdAndUserId(
			companyId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Event[] findByCompanyIdAndUserId_PrevAndNext(
			long eventId, long companyId, long userId,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Event[] array = new EventImpl[3];

			array[0] = getByCompanyIdAndUserId_PrevAndNext(
				session, event, companyId, userId, orderByComparator, true);

			array[1] = event;

			array[2] = getByCompanyIdAndUserId_PrevAndNext(
				session, event, companyId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Event getByCompanyIdAndUserId_PrevAndNext(
		Session session, Event event, long companyId, long userId,
		OrderByComparator<Event> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EVENT_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

		sb.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(event)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Event> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the events where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByCompanyIdAndUserId(long companyId, long userId) {
		for (Event event :
				findByCompanyIdAndUserId(
					companyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(event);
		}
	}

	/**
	 * Returns the number of events where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching events
	 */
	@Override
	public int countByCompanyIdAndUserId(long companyId, long userId) {
		FinderPath finderPath = _finderPathCountByCompanyIdAndUserId;

		Object[] finderArgs = new Object[] {companyId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EVENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2 =
		"event.companyId = ? AND ";

	private static final String _FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2 =
		"event.userId = ?";

	private FinderPath
		_finderPathWithPaginationFindByCompanyIdAndUserIdAndEventType;
	private FinderPath
		_finderPathWithoutPaginationFindByCompanyIdAndUserIdAndEventType;
	private FinderPath _finderPathCountByCompanyIdAndUserIdAndEventType;

	/**
	 * Returns all the events where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching events
	 */
	@Override
	public List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		return findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType, int start, int end) {

		return findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, start, end, null);
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
	@Override
	public List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator) {

		return findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, start, end, orderByComparator, true);
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
	@Override
	public List<Event> findByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean useFinderCache) {

		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCompanyIdAndUserIdAndEventType;
				finderArgs = new Object[] {companyId, userId, eventType};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByCompanyIdAndUserIdAndEventType;
			finderArgs = new Object[] {
				companyId, userId, eventType, start, end, orderByComparator
			};
		}

		List<Event> list = null;

		if (useFinderCache) {
			list = (List<Event>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Event event : list) {
					if ((companyId != event.getCompanyId()) ||
						(userId != event.getUserId()) ||
						!eventType.equals(event.getEventType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_EVENT_WHERE);

			sb.append(
				_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_USERID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(
					_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				list = (List<Event>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Event findByCompanyIdAndUserIdAndEventType_First(
			long companyId, long userId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyIdAndUserIdAndEventType_First(
			companyId, userId, eventType, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
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
	@Override
	public Event fetchByCompanyIdAndUserIdAndEventType_First(
		long companyId, long userId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		List<Event> list = findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Event findByCompanyIdAndUserIdAndEventType_Last(
			long companyId, long userId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		Event event = fetchByCompanyIdAndUserIdAndEventType_Last(
			companyId, userId, eventType, orderByComparator);

		if (event != null) {
			return event;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append(", eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchEventException(sb.toString());
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
	@Override
	public Event fetchByCompanyIdAndUserIdAndEventType_Last(
		long companyId, long userId, String eventType,
		OrderByComparator<Event> orderByComparator) {

		int count = countByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType);

		if (count == 0) {
			return null;
		}

		List<Event> list = findByCompanyIdAndUserIdAndEventType(
			companyId, userId, eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Event[] findByCompanyIdAndUserIdAndEventType_PrevAndNext(
			long eventId, long companyId, long userId, String eventType,
			OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException {

		eventType = Objects.toString(eventType, "");

		Event event = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Event[] array = new EventImpl[3];

			array[0] = getByCompanyIdAndUserIdAndEventType_PrevAndNext(
				session, event, companyId, userId, eventType, orderByComparator,
				true);

			array[1] = event;

			array[2] = getByCompanyIdAndUserIdAndEventType_PrevAndNext(
				session, event, companyId, userId, eventType, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Event getByCompanyIdAndUserIdAndEventType_PrevAndNext(
		Session session, Event event, long companyId, long userId,
		String eventType, OrderByComparator<Event> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_EVENT_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_COMPANYID_2);

		sb.append(_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_USERID_2);

		boolean bindEventType = false;

		if (eventType.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			sb.append(
				_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(userId);

		if (bindEventType) {
			queryPos.add(eventType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(event)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Event> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the events where companyId = &#63; and userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	@Override
	public void removeByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		for (Event event :
				findByCompanyIdAndUserIdAndEventType(
					companyId, userId, eventType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(event);
		}
	}

	/**
	 * Returns the number of events where companyId = &#63; and userId = &#63; and eventType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching events
	 */
	@Override
	public int countByCompanyIdAndUserIdAndEventType(
		long companyId, long userId, String eventType) {

		eventType = Objects.toString(eventType, "");

		FinderPath finderPath =
			_finderPathCountByCompanyIdAndUserIdAndEventType;

		Object[] finderArgs = new Object[] {companyId, userId, eventType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_EVENT_WHERE);

			sb.append(
				_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_COMPANYID_2);

			sb.append(_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_USERID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(
					_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_COMPANYID_2 =
			"event.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_USERID_2 =
			"event.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_2 =
			"event.eventType = ?";

	private static final String
		_FINDER_COLUMN_COMPANYIDANDUSERIDANDEVENTTYPE_EVENTTYPE_3 =
			"(event.eventType IS NULL OR event.eventType = '')";

	public EventPersistenceImpl() {
		setModelClass(Event.class);

		setModelImplClass(EventImpl.class);
		setModelPKClass(long.class);

		setTable(EventTable.INSTANCE);
	}

	/**
	 * Caches the event in the entity cache if it is enabled.
	 *
	 * @param event the event
	 */
	@Override
	public void cacheResult(Event event) {
		entityCache.putResult(EventImpl.class, event.getPrimaryKey(), event);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the events in the entity cache if it is enabled.
	 *
	 * @param events the events
	 */
	@Override
	public void cacheResult(List<Event> events) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (events.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Event event : events) {
			if (entityCache.getResult(EventImpl.class, event.getPrimaryKey()) ==
					null) {

				cacheResult(event);
			}
		}
	}

	/**
	 * Clears the cache for all events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EventImpl.class);

		finderCache.clearCache(EventImpl.class);
	}

	/**
	 * Clears the cache for the event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Event event) {
		entityCache.removeResult(EventImpl.class, event);
	}

	@Override
	public void clearCache(List<Event> events) {
		for (Event event : events) {
			entityCache.removeResult(EventImpl.class, event);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EventImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EventImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new event with the primary key. Does not add the event to the database.
	 *
	 * @param eventId the primary key for the new event
	 * @return the new event
	 */
	@Override
	public Event create(long eventId) {
		Event event = new EventImpl();

		event.setNew(true);
		event.setPrimaryKey(eventId);

		event.setCompanyId(CompanyThreadLocal.getCompanyId());

		return event;
	}

	/**
	 * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the event
	 * @return the event that was removed
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	@Override
	public Event remove(long eventId) throws NoSuchEventException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event
	 * @return the event that was removed
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	@Override
	public Event remove(Serializable primaryKey) throws NoSuchEventException {
		Session session = null;

		try {
			session = openSession();

			Event event = (Event)session.get(EventImpl.class, primaryKey);

			if (event == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(event);
		}
		catch (NoSuchEventException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Event removeImpl(Event event) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(event)) {
				event = (Event)session.get(
					EventImpl.class, event.getPrimaryKeyObj());
			}

			if (event != null) {
				session.delete(event);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (event != null) {
			clearCache(event);
		}

		return event;
	}

	@Override
	public Event updateImpl(Event event) {
		boolean isNew = event.isNew();

		if (!(event instanceof EventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(event.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(event);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in event proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Event implementation " +
					event.getClass());
		}

		EventModelImpl eventModelImpl = (EventModelImpl)event;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (event.getCreateDate() == null)) {
			if (serviceContext == null) {
				event.setCreateDate(date);
			}
			else {
				event.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!eventModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				event.setModifiedDate(date);
			}
			else {
				event.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(event);
			}
			else {
				event = (Event)session.merge(event);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(EventImpl.class, eventModelImpl, false, true);

		if (isNew) {
			event.setNew(false);
		}

		event.resetOriginalValues();

		return event;
	}

	/**
	 * Returns the event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event
	 * @return the event
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	@Override
	public Event findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventException {

		Event event = fetchByPrimaryKey(primaryKey);

		if (event == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return event;
	}

	/**
	 * Returns the event with the primary key or throws a <code>NoSuchEventException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the event
	 * @return the event
	 * @throws NoSuchEventException if a event with the primary key could not be found
	 */
	@Override
	public Event findByPrimaryKey(long eventId) throws NoSuchEventException {
		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the event
	 * @return the event, or <code>null</code> if a event with the primary key could not be found
	 */
	@Override
	public Event fetchByPrimaryKey(long eventId) {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the events.
	 *
	 * @return the events
	 */
	@Override
	public List<Event> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Event> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Event> findAll(
		int start, int end, OrderByComparator<Event> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Event> findAll(
		int start, int end, OrderByComparator<Event> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Event> list = null;

		if (useFinderCache) {
			list = (List<Event>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EVENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EVENT;

				sql = sql.concat(EventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Event>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Event event : findAll()) {
			remove(event);
		}
	}

	/**
	 * Returns the number of events.
	 *
	 * @return the number of events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EVENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "eventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the event persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId"}, true);

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			true);

		_finderPathCountByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			false);

		_finderPathWithPaginationFindByCompanyIdAndEventType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyIdAndEventType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "eventType"}, true);

		_finderPathWithoutPaginationFindByCompanyIdAndEventType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCompanyIdAndEventType",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"companyId", "eventType"}, true);

		_finderPathCountByCompanyIdAndEventType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndEventType",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "eventType"}, false);

		_finderPathWithPaginationFindByCompanyIdAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyIdAndUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "userId"}, true);

		_finderPathWithoutPaginationFindByCompanyIdAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, true);

		_finderPathCountByCompanyIdAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, false);

		_finderPathWithPaginationFindByCompanyIdAndUserIdAndEventType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCompanyIdAndUserIdAndEventType",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"companyId", "userId", "eventType"}, true);

		_finderPathWithoutPaginationFindByCompanyIdAndUserIdAndEventType =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCompanyIdAndUserIdAndEventType",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName()
				},
				new String[] {"companyId", "userId", "eventType"}, true);

		_finderPathCountByCompanyIdAndUserIdAndEventType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndUserIdAndEventType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			new String[] {"companyId", "userId", "eventType"}, false);

		_setEventUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEventUtilPersistence(null);

		entityCache.removeCache(EventImpl.class.getName());
	}

	private void _setEventUtilPersistence(EventPersistence eventPersistence) {
		try {
			Field field = EventUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, eventPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AmfEventMonitorPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AmfEventMonitorPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfEventMonitorPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EVENT =
		"SELECT event FROM Event event";

	private static final String _SQL_SELECT_EVENT_WHERE =
		"SELECT event FROM Event event WHERE ";

	private static final String _SQL_COUNT_EVENT =
		"SELECT COUNT(event) FROM Event event";

	private static final String _SQL_COUNT_EVENT_WHERE =
		"SELECT COUNT(event) FROM Event event WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "event.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Event exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Event exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EventPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private EventModelArgumentsResolver _eventModelArgumentsResolver;

}