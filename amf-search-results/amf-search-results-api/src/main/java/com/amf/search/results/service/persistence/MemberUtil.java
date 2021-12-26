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

package com.amf.search.results.service.persistence;

import com.amf.search.results.model.Member;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the member service. This utility wraps <code>com.amf.search.results.service.persistence.impl.MemberPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberPersistence
 * @generated
 */
public class MemberUtil {

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
	public static void clearCache(Member member) {
		getPersistence().clearCache(member);
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
	public static Map<Serializable, Member> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Member> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Member> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Member> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Member> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Member update(Member member) {
		return getPersistence().update(member);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Member update(Member member, ServiceContext serviceContext) {
		return getPersistence().update(member, serviceContext);
	}

	/**
	 * Returns all the members where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @return the matching members
	 */
	public static List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode) {

		return getPersistence().findByCompanyIdAndZipCode(companyId, zipCode);
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
	public static List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end) {

		return getPersistence().findByCompanyIdAndZipCode(
			companyId, zipCode, start, end);
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
	public static List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end,
		OrderByComparator<Member> orderByComparator) {

		return getPersistence().findByCompanyIdAndZipCode(
			companyId, zipCode, start, end, orderByComparator);
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
	public static List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end,
		OrderByComparator<Member> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCompanyIdAndZipCode(
			companyId, zipCode, start, end, orderByComparator, useFinderCache);
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
	public static Member findByCompanyIdAndZipCode_First(
			long companyId, String zipCode,
			OrderByComparator<Member> orderByComparator)
		throws com.amf.search.results.exception.NoSuchMemberException {

		return getPersistence().findByCompanyIdAndZipCode_First(
			companyId, zipCode, orderByComparator);
	}

	/**
	 * Returns the first member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public static Member fetchByCompanyIdAndZipCode_First(
		long companyId, String zipCode,
		OrderByComparator<Member> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndZipCode_First(
			companyId, zipCode, orderByComparator);
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
	public static Member findByCompanyIdAndZipCode_Last(
			long companyId, String zipCode,
			OrderByComparator<Member> orderByComparator)
		throws com.amf.search.results.exception.NoSuchMemberException {

		return getPersistence().findByCompanyIdAndZipCode_Last(
			companyId, zipCode, orderByComparator);
	}

	/**
	 * Returns the last member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public static Member fetchByCompanyIdAndZipCode_Last(
		long companyId, String zipCode,
		OrderByComparator<Member> orderByComparator) {

		return getPersistence().fetchByCompanyIdAndZipCode_Last(
			companyId, zipCode, orderByComparator);
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
	public static Member[] findByCompanyIdAndZipCode_PrevAndNext(
			long memberId, long companyId, String zipCode,
			OrderByComparator<Member> orderByComparator)
		throws com.amf.search.results.exception.NoSuchMemberException {

		return getPersistence().findByCompanyIdAndZipCode_PrevAndNext(
			memberId, companyId, zipCode, orderByComparator);
	}

	/**
	 * Removes all the members where companyId = &#63; and zipCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 */
	public static void removeByCompanyIdAndZipCode(
		long companyId, String zipCode) {

		getPersistence().removeByCompanyIdAndZipCode(companyId, zipCode);
	}

	/**
	 * Returns the number of members where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @return the number of matching members
	 */
	public static int countByCompanyIdAndZipCode(
		long companyId, String zipCode) {

		return getPersistence().countByCompanyIdAndZipCode(companyId, zipCode);
	}

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	public static void cacheResult(Member member) {
		getPersistence().cacheResult(member);
	}

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	public static void cacheResult(List<Member> members) {
		getPersistence().cacheResult(members);
	}

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	public static Member create(long memberId) {
		return getPersistence().create(memberId);
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	public static Member remove(long memberId)
		throws com.amf.search.results.exception.NoSuchMemberException {

		return getPersistence().remove(memberId);
	}

	public static Member updateImpl(Member member) {
		return getPersistence().updateImpl(member);
	}

	/**
	 * Returns the member with the primary key or throws a <code>NoSuchMemberException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	public static Member findByPrimaryKey(long memberId)
		throws com.amf.search.results.exception.NoSuchMemberException {

		return getPersistence().findByPrimaryKey(memberId);
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 */
	public static Member fetchByPrimaryKey(long memberId) {
		return getPersistence().fetchByPrimaryKey(memberId);
	}

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 */
	public static List<Member> findAll() {
		return getPersistence().findAll();
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
	public static List<Member> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Member> findAll(
		int start, int end, OrderByComparator<Member> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Member> findAll(
		int start, int end, OrderByComparator<Member> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the members from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MemberPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MemberPersistence _persistence;

}