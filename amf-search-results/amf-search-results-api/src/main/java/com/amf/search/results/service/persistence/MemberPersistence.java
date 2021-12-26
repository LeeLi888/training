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

import com.amf.search.results.exception.NoSuchMemberException;
import com.amf.search.results.model.Member;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberUtil
 * @generated
 */
@ProviderType
public interface MemberPersistence extends BasePersistence<Member> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemberUtil} to access the member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the members where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @return the matching members
	 */
	public java.util.List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode);

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
	public java.util.List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end);

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
	public java.util.List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Member>
			orderByComparator);

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
	public java.util.List<Member> findByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Member>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchMemberException if a matching member could not be found
	 */
	public Member findByCompanyIdAndZipCode_First(
			long companyId, String zipCode,
			com.liferay.portal.kernel.util.OrderByComparator<Member>
				orderByComparator)
		throws NoSuchMemberException;

	/**
	 * Returns the first member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public Member fetchByCompanyIdAndZipCode_First(
		long companyId, String zipCode,
		com.liferay.portal.kernel.util.OrderByComparator<Member>
			orderByComparator);

	/**
	 * Returns the last member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchMemberException if a matching member could not be found
	 */
	public Member findByCompanyIdAndZipCode_Last(
			long companyId, String zipCode,
			com.liferay.portal.kernel.util.OrderByComparator<Member>
				orderByComparator)
		throws NoSuchMemberException;

	/**
	 * Returns the last member in the ordered set where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public Member fetchByCompanyIdAndZipCode_Last(
		long companyId, String zipCode,
		com.liferay.portal.kernel.util.OrderByComparator<Member>
			orderByComparator);

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
	public Member[] findByCompanyIdAndZipCode_PrevAndNext(
			long memberId, long companyId, String zipCode,
			com.liferay.portal.kernel.util.OrderByComparator<Member>
				orderByComparator)
		throws NoSuchMemberException;

	/**
	 * Removes all the members where companyId = &#63; and zipCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 */
	public void removeByCompanyIdAndZipCode(long companyId, String zipCode);

	/**
	 * Returns the number of members where companyId = &#63; and zipCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param zipCode the zip code
	 * @return the number of matching members
	 */
	public int countByCompanyIdAndZipCode(long companyId, String zipCode);

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	public void cacheResult(Member member);

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	public void cacheResult(java.util.List<Member> members);

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	public Member create(long memberId);

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	public Member remove(long memberId) throws NoSuchMemberException;

	public Member updateImpl(Member member);

	/**
	 * Returns the member with the primary key or throws a <code>NoSuchMemberException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws NoSuchMemberException if a member with the primary key could not be found
	 */
	public Member findByPrimaryKey(long memberId) throws NoSuchMemberException;

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 */
	public Member fetchByPrimaryKey(long memberId);

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 */
	public java.util.List<Member> findAll();

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
	public java.util.List<Member> findAll(int start, int end);

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
	public java.util.List<Member> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Member>
			orderByComparator);

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
	public java.util.List<Member> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Member>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the members from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 */
	public int countAll();

}