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

package com.amf.newsletter.service.persistence;

import com.amf.newsletter.exception.NoSuchNewsletterException;
import com.amf.newsletter.model.Newsletter;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterUtil
 * @generated
 */
@ProviderType
public interface NewsletterPersistence extends BasePersistence<Newsletter> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the newsletter where issueNumber = &#63; or throws a <code>NoSuchNewsletterException</code> if it could not be found.
	 *
	 * @param issueNumber the issue number
	 * @return the matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public Newsletter findByIssueNumber(long issueNumber)
		throws NoSuchNewsletterException;

	/**
	 * Returns the newsletter where issueNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public Newsletter fetchByIssueNumber(long issueNumber);

	/**
	 * Returns the newsletter where issueNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public Newsletter fetchByIssueNumber(
		long issueNumber, boolean useFinderCache);

	/**
	 * Removes the newsletter where issueNumber = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 * @return the newsletter that was removed
	 */
	public Newsletter removeByIssueNumber(long issueNumber)
		throws NoSuchNewsletterException;

	/**
	 * Returns the number of newsletters where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the number of matching newsletters
	 */
	public int countByIssueNumber(long issueNumber);

	/**
	 * Caches the newsletter in the entity cache if it is enabled.
	 *
	 * @param newsletter the newsletter
	 */
	public void cacheResult(Newsletter newsletter);

	/**
	 * Caches the newsletters in the entity cache if it is enabled.
	 *
	 * @param newsletters the newsletters
	 */
	public void cacheResult(java.util.List<Newsletter> newsletters);

	/**
	 * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	 *
	 * @param issueNumber the primary key for the new newsletter
	 * @return the new newsletter
	 */
	public Newsletter create(long issueNumber);

	/**
	 * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueNumber the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	public Newsletter remove(long issueNumber) throws NoSuchNewsletterException;

	public Newsletter updateImpl(Newsletter newsletter);

	/**
	 * Returns the newsletter with the primary key or throws a <code>NoSuchNewsletterException</code> if it could not be found.
	 *
	 * @param issueNumber the primary key of the newsletter
	 * @return the newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	public Newsletter findByPrimaryKey(long issueNumber)
		throws NoSuchNewsletterException;

	/**
	 * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueNumber the primary key of the newsletter
	 * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	 */
	public Newsletter fetchByPrimaryKey(long issueNumber);

	/**
	 * Returns all the newsletters.
	 *
	 * @return the newsletters
	 */
	public java.util.List<Newsletter> findAll();

	/**
	 * Returns a range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of newsletters
	 */
	public java.util.List<Newsletter> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletters
	 */
	public java.util.List<Newsletter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter>
			orderByComparator);

	/**
	 * Returns an ordered range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of newsletters
	 */
	public java.util.List<Newsletter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the newsletters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of newsletters.
	 *
	 * @return the number of newsletters
	 */
	public int countAll();

}