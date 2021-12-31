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

import com.amf.newsletter.exception.NoSuchArticleException;
import com.amf.newsletter.model.Article;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticleUtil
 * @generated
 */
@ProviderType
public interface ArticlePersistence extends BasePersistence<Article> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleUtil} to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the matching articles
	 */
	public java.util.List<Article> findByIssueNumber(long issueNumber);

	/**
	 * Returns a range of all the articles where issueNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	public java.util.List<Article> findByIssueNumber(
		long issueNumber, int start, int end);

	/**
	 * Returns an ordered range of all the articles where issueNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByIssueNumber(
		long issueNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articles where issueNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByIssueNumber(
		long issueNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByIssueNumber_First(
			long issueNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByIssueNumber_First(
		long issueNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByIssueNumber_Last(
			long issueNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByIssueNumber_Last(
		long issueNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the articles before and after the current article in the ordered set where issueNumber = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article[] findByIssueNumber_PrevAndNext(
			long articleId, long issueNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Removes all the articles where issueNumber = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 */
	public void removeByIssueNumber(long issueNumber);

	/**
	 * Returns the number of articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the number of matching articles
	 */
	public int countByIssueNumber(long issueNumber);

	/**
	 * Returns the article where journalArticleId = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByJournalArticleId(String journalArticleId)
		throws NoSuchArticleException;

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByJournalArticleId(String journalArticleId);

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByJournalArticleId(
		String journalArticleId, boolean useFinderCache);

	/**
	 * Removes the article where journalArticleId = &#63; from the database.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the article that was removed
	 */
	public Article removeByJournalArticleId(String journalArticleId)
		throws NoSuchArticleException;

	/**
	 * Returns the number of articles where journalArticleId = &#63;.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the number of matching articles
	 */
	public int countByJournalArticleId(String journalArticleId);

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByIssueNumberAndOrder(long issueNumber, long order)
		throws NoSuchArticleException;

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByIssueNumberAndOrder(long issueNumber, long order);

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByIssueNumberAndOrder(
		long issueNumber, long order, boolean useFinderCache);

	/**
	 * Removes the article where issueNumber = &#63; and order = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the article that was removed
	 */
	public Article removeByIssueNumberAndOrder(long issueNumber, long order)
		throws NoSuchArticleException;

	/**
	 * Returns the number of articles where issueNumber = &#63; and order = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the number of matching articles
	 */
	public int countByIssueNumberAndOrder(long issueNumber, long order);

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	public void cacheResult(Article article);

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	public void cacheResult(java.util.List<Article> articles);

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	public Article create(long articleId);

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article remove(long articleId) throws NoSuchArticleException;

	public Article updateImpl(Article article);

	/**
	 * Returns the article with the primary key or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article findByPrimaryKey(long articleId)
		throws NoSuchArticleException;

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 */
	public Article fetchByPrimaryKey(long articleId);

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 */
	public java.util.List<Article> findAll();

	/**
	 * Returns a range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of articles
	 */
	public java.util.List<Article> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of articles
	 */
	public java.util.List<Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of articles
	 */
	public java.util.List<Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the articles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	public int countAll();

}