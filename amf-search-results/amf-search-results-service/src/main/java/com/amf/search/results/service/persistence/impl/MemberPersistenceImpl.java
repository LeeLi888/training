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

package com.amf.search.results.service.persistence.impl;

import com.amf.search.results.exception.NoSuchMemberException;
import com.amf.search.results.model.Member;
import com.amf.search.results.model.MemberTable;
import com.amf.search.results.model.impl.MemberImpl;
import com.amf.search.results.model.impl.MemberModelImpl;
import com.amf.search.results.service.persistence.MemberPersistence;
import com.amf.search.results.service.persistence.MemberUtil;
import com.amf.search.results.service.persistence.impl.constants.AmfMemberPersistenceConstants;

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
 * The persistence implementation for the member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {MemberPersistence.class, BasePersistence.class})
public class MemberPersistenceImpl
	extends BasePersistenceImpl<Member> implements MemberPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MemberUtil</code> to access the member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MemberImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCompanyIdAndZipCode;
	private FinderPath _finderPathWithoutPaginationFindByCompanyIdAndZipCode;
	private FinderPath _finderPathCountByCompanyIdAndZipCode;

	/**
	 * Returns all the members where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @return the matching members
	 */
	@Override
	public List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode) {

		return findByCompanyIdAndZipCode(
			companyId, zipCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members where companyId = &#63; and zipCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	@Override
	public List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end) {

		return findByCompanyIdAndZipCode(companyId, zipCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the members where companyId = &#63; and zipCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	@Override
	public List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end,
		OrderByComparator<Member> orderByComparator) {

		return findByCompanyIdAndZipCode(
			companyId, zipCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the members where companyId = &#63; and zipCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	@Override
	public List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end,
		OrderByComparator<Member> orderByComparator, boolean useFinderCache) {

		zipCode = Objects.toString(zipCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCompanyIdAndZipCode;
				finderArgs = new Object[] {companyId, zipCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyIdAndZipCode;
			finderArgs = new Object[] {
				companyId, zipCode, start, end, orderByComparator
			};
		}

		List<Member> list = null;

		if (useFinderCache) {
			list = (List<Member>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Member member : list) {
					if ((companyId != member.getCompanyId()) ||
						!zipCode.equals(member.getZipCode())) {

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

			sb.append(_SQL_SELECT_MEMBER__WHERE);

			sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_COMPANYID_2);

			boolean bindZipCode = false;

			if (zipCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_3);
			}
			else {
				bindZipCode = true;

				sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MemberModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindZipCode) {
					queryPos.add(zipCode);
				}

				list = (List<Member>)QueryUtil.list(
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
	 * Returns the first member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchMemberException if a matching member could not be found
	 */
	@Override
	public Member findByCompanyIdAndZipCode_First(
			long companyId, String zipCode,
			OrderByComparator<Member> orderByComparator)
		throws NoSuchMemberException {

		Member member = fetchByCompanyIdAndZipCode_First(
			companyId, zipCode, orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", zipCode=");
		sb.append(zipCode);

		sb.append("}");

		throw new NoSuchMemberException(sb.toString());
	}

	/**
	 * Returns the first member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	@Override
	public Member fetchByCompanyIdAndZipCode_First(
		long companyId, String zipCode,
		OrderByComparator<Member> orderByComparator) {

		List<Member> list = findByCompanyIdAndZipCode(
			companyId, zipCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchMemberException if a matching member could not be found
	 */
	@Override
	public Member findByCompanyIdAndZipCode_Last(
			long companyId, String zipCode,
			OrderByComparator<Member> orderByComparator)
		throws NoSuchMemberException {

		Member member = fetchByCompanyIdAndZipCode_Last(
			companyId, zipCode, orderByComparator);

		if (member != null) {
			return member;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", zipCode=");
		sb.append(zipCode);

		sb.append("}");

		throw new NoSuchMemberException(sb.toString());
	}

	/**
	 * Returns the last member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	@Override
	public Member fetchByCompanyIdAndZipCode_Last(
		long companyId, String zipCode,
		OrderByComparator<Member> orderByComparator) {

		int count = countByCompanyIdAndZipCode(companyId, zipCode);

		if (count == 0) {
			return null;
		}

		List<Member> list = findByCompanyIdAndZipCode(
			companyId, zipCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the members before and after the current member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member[] findByCompanyIdAndZipCode_PrevAndNext(
			long memberId, long companyId, String zipCode,
			OrderByComparator<Member> orderByComparator)
		throws NoSuchMemberException {

		zipCode = Objects.toString(zipCode, "");

		Member member = findByPrimaryKey(memberId);

		Session session = null;

		try {
			session = openSession();

			Member[] array = new MemberImpl[3];

			array[0] = getByCompanyIdAndZipCode_PrevAndNext(
				session, member, companyId, zipCode, orderByComparator, true);

			array[1] = member;

			array[2] = getByCompanyIdAndZipCode_PrevAndNext(
				session, member, companyId, zipCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Member getByCompanyIdAndZipCode_PrevAndNext(
		Session session, Member member, long companyId, String zipCode,
		OrderByComparator<Member> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MEMBER__WHERE);

		sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_COMPANYID_2);

		boolean bindZipCode = false;

		if (zipCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_3);
		}
		else {
			bindZipCode = true;

			sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_2);
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
			sb.append(MemberModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (bindZipCode) {
			queryPos.add(zipCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(member)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Member> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the members where companyId = &#63; and zipCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 */
	@Override
	public void removeByCompanyIdAndZipCode(long companyId, String zipCode) {
		for (Member member :
				findByCompanyIdAndZipCode(
					companyId, zipCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(member);
		}
	}

	/**
	 * Returns the number of members where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @return the number of matching members
	 */
	@Override
	public int countByCompanyIdAndZipCode(long companyId, String zipCode) {
		zipCode = Objects.toString(zipCode, "");

		FinderPath finderPath = _finderPathCountByCompanyIdAndZipCode;

		Object[] finderArgs = new Object[] {companyId, zipCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MEMBER__WHERE);

			sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_COMPANYID_2);

			boolean bindZipCode = false;

			if (zipCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_3);
			}
			else {
				bindZipCode = true;

				sb.append(_FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindZipCode) {
					queryPos.add(zipCode);
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

	private static final String _FINDER_COLUMN_COMPANYIDANDZIPCODE_COMPANYID_2 =
		"member_.companyId = ? AND ";

	private static final String _FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_2 =
		"member_.zipCode = ?";

	private static final String _FINDER_COLUMN_COMPANYIDANDZIPCODE_ZIPCODE_3 =
		"(member_.zipCode IS NULL OR member_.zipCode = '')";

	public MemberPersistenceImpl() {
		setModelClass(Member.class);

		setModelImplClass(MemberImpl.class);
		setModelPKClass(long.class);

		setTable(MemberTable.INSTANCE);
	}

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	@Override
	public void cacheResult(Member member) {
		entityCache.putResult(MemberImpl.class, member.getPrimaryKey(), member);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	@Override
	public void cacheResult(List<Member> members) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (members.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Member member : members) {
			if (entityCache.getResult(
					MemberImpl.class, member.getPrimaryKey()) == null) {

				cacheResult(member);
			}
		}
	}

	/**
	 * Clears the cache for all members.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MemberImpl.class);

		finderCache.clearCache(MemberImpl.class);
	}

	/**
	 * Clears the cache for the member.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Member member) {
		entityCache.removeResult(MemberImpl.class, member);
	}

	@Override
	public void clearCache(List<Member> members) {
		for (Member member : members) {
			entityCache.removeResult(MemberImpl.class, member);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MemberImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MemberImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	@Override
	public Member create(long memberId) {
		Member member = new MemberImpl();

		member.setNew(true);
		member.setPrimaryKey(memberId);

		member.setCompanyId(CompanyThreadLocal.getCompanyId());

		return member;
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member remove(long memberId) throws NoSuchMemberException {
		return remove((Serializable)memberId);
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member remove(Serializable primaryKey) throws NoSuchMemberException {
		Session session = null;

		try {
			session = openSession();

			Member member = (Member)session.get(MemberImpl.class, primaryKey);

			if (member == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemberException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(member);
		}
		catch (NoSuchMemberException noSuchEntityException) {
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
	protected Member removeImpl(Member member) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(member)) {
				member = (Member)session.get(
					MemberImpl.class, member.getPrimaryKeyObj());
			}

			if (member != null) {
				session.delete(member);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (member != null) {
			clearCache(member);
		}

		return member;
	}

	@Override
	public Member updateImpl(Member member) {
		boolean isNew = member.isNew();

		if (!(member instanceof MemberModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(member.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(member);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in member proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Member implementation " +
					member.getClass());
		}

		MemberModelImpl memberModelImpl = (MemberModelImpl)member;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (member.getCreateDate() == null)) {
			if (serviceContext == null) {
				member.setCreateDate(date);
			}
			else {
				member.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!memberModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				member.setModifiedDate(date);
			}
			else {
				member.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(member);
			}
			else {
				member = (Member)session.merge(member);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MemberImpl.class, memberModelImpl, false, true);

		if (isNew) {
			member.setNew(false);
		}

		member.resetOriginalValues();

		return member;
	}

	/**
	 * Returns the member with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMemberException {

		Member member = fetchByPrimaryKey(primaryKey);

		if (member == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMemberException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return member;
	}

	/**
	 * Returns the member with the primary key or throws a <code>NoSuchMemberException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	@Override
	public Member findByPrimaryKey(long memberId) throws NoSuchMemberException {
		return findByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 */
	@Override
	public Member fetchByPrimaryKey(long memberId) {
		return fetchByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 */
	@Override
	public List<Member> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of members
	 */
	@Override
	public List<Member> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of members
	 */
	@Override
	public List<Member> findAll(
		int start, int end, OrderByComparator<Member> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MemberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of members
	 */
	@Override
	public List<Member> findAll(
		int start, int end, OrderByComparator<Member> orderByComparator,
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

		List<Member> list = null;

		if (useFinderCache) {
			list = (List<Member>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MEMBER_);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBER_;

				sql = sql.concat(MemberModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Member>)QueryUtil.list(
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
	 * Removes all the members from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Member member : findAll()) {
			remove(member);
		}
	}

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MEMBER_);

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
		return "memberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MEMBER_;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MemberModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the member persistence.
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

		_finderPathWithPaginationFindByCompanyIdAndZipCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyIdAndZipCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "zipCode"}, true);

		_finderPathWithoutPaginationFindByCompanyIdAndZipCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndZipCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "zipCode"}, true);

		_finderPathCountByCompanyIdAndZipCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndZipCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "zipCode"}, false);

		_setMemberUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMemberUtilPersistence(null);

		entityCache.removeCache(MemberImpl.class.getName());
	}

	private void _setMemberUtilPersistence(
		MemberPersistence memberPersistence) {

		try {
			Field field = MemberUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, memberPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AmfMemberPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AmfMemberPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfMemberPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MEMBER_ =
		"SELECT member_ FROM Member member_";

	private static final String _SQL_SELECT_MEMBER__WHERE =
		"SELECT member_ FROM Member member_ WHERE ";

	private static final String _SQL_COUNT_MEMBER_ =
		"SELECT COUNT(member_) FROM Member member_";

	private static final String _SQL_COUNT_MEMBER__WHERE =
		"SELECT COUNT(member_) FROM Member member_ WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "member_.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Member exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Member exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MemberPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MemberModelArgumentsResolver _memberModelArgumentsResolver;

}