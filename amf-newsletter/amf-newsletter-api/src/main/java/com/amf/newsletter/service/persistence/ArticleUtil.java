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

import com.amf.newsletter.model.Article;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the article service. This utility wraps <code>com.amf.newsletter.service.persistence.impl.ArticlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticlePersistence
 * @generated
 */
public class ArticleUtil {

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
	public static void clearCache(Article article) {
		getPersistence().clearCache(article);
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
	public static Map<Serializable, Article> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Article update(Article article) {
		return getPersistence().update(article);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Article update(
		Article article, ServiceContext serviceContext) {

		return getPersistence().update(article, serviceContext);
	}

	/**
	 * Returns all the articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the matching articles
	 */
	public static List<Article> findByIssueNumber(int issueNumber) {
		return getPersistence().findByIssueNumber(issueNumber);
	}

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
	public static List<Article> findByIssueNumber(
		int issueNumber, int start, int end) {

		return getPersistence().findByIssueNumber(issueNumber, start, end);
	}

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
	public static List<Article> findByIssueNumber(
		int issueNumber, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().findByIssueNumber(
			issueNumber, start, end, orderByComparator);
	}

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
	public static List<Article> findByIssueNumber(
		int issueNumber, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByIssueNumber(
			issueNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByIssueNumber_First(
			int issueNumber, OrderByComparator<Article> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().findByIssueNumber_First(
			issueNumber, orderByComparator);
	}

	/**
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByIssueNumber_First(
		int issueNumber, OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByIssueNumber_First(
			issueNumber, orderByComparator);
	}

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByIssueNumber_Last(
			int issueNumber, OrderByComparator<Article> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().findByIssueNumber_Last(
			issueNumber, orderByComparator);
	}

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByIssueNumber_Last(
		int issueNumber, OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByIssueNumber_Last(
			issueNumber, orderByComparator);
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where issueNumber = &#63;.
	 *
	 * @param articlePK the primary key of the current article
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public static Article[] findByIssueNumber_PrevAndNext(
			ArticlePK articlePK, int issueNumber,
			OrderByComparator<Article> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().findByIssueNumber_PrevAndNext(
			articlePK, issueNumber, orderByComparator);
	}

	/**
	 * Removes all the articles where issueNumber = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 */
	public static void removeByIssueNumber(int issueNumber) {
		getPersistence().removeByIssueNumber(issueNumber);
	}

	/**
	 * Returns the number of articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the number of matching articles
	 */
	public static int countByIssueNumber(int issueNumber) {
		return getPersistence().countByIssueNumber(issueNumber);
	}

	/**
	 * Returns the article where journalArticleId = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByJournalArticleId(String journalArticleId)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().findByJournalArticleId(journalArticleId);
	}

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByJournalArticleId(String journalArticleId) {
		return getPersistence().fetchByJournalArticleId(journalArticleId);
	}

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByJournalArticleId(
		String journalArticleId, boolean useFinderCache) {

		return getPersistence().fetchByJournalArticleId(
			journalArticleId, useFinderCache);
	}

	/**
	 * Removes the article where journalArticleId = &#63; from the database.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the article that was removed
	 */
	public static Article removeByJournalArticleId(String journalArticleId)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().removeByJournalArticleId(journalArticleId);
	}

	/**
	 * Returns the number of articles where journalArticleId = &#63;.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the number of matching articles
	 */
	public static int countByJournalArticleId(String journalArticleId) {
		return getPersistence().countByJournalArticleId(journalArticleId);
	}

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByIssueNumberAndOrder(int issueNumber, int order)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().findByIssueNumberAndOrder(issueNumber, order);
	}

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByIssueNumberAndOrder(
		int issueNumber, int order) {

		return getPersistence().fetchByIssueNumberAndOrder(issueNumber, order);
	}

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByIssueNumberAndOrder(
		int issueNumber, int order, boolean useFinderCache) {

		return getPersistence().fetchByIssueNumberAndOrder(
			issueNumber, order, useFinderCache);
	}

	/**
	 * Removes the article where issueNumber = &#63; and order = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the article that was removed
	 */
	public static Article removeByIssueNumberAndOrder(
			int issueNumber, int order)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().removeByIssueNumberAndOrder(issueNumber, order);
	}

	/**
	 * Returns the number of articles where issueNumber = &#63; and order = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the number of matching articles
	 */
	public static int countByIssueNumberAndOrder(int issueNumber, int order) {
		return getPersistence().countByIssueNumberAndOrder(issueNumber, order);
	}

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	public static void cacheResult(Article article) {
		getPersistence().cacheResult(article);
	}

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	public static void cacheResult(List<Article> articles) {
		getPersistence().cacheResult(articles);
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articlePK the primary key for the new article
	 * @return the new article
	 */
	public static Article create(ArticlePK articlePK) {
		return getPersistence().create(articlePK);
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articlePK the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public static Article remove(ArticlePK articlePK)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().remove(articlePK);
	}

	public static Article updateImpl(Article article) {
		return getPersistence().updateImpl(article);
	}

	/**
	 * Returns the article with the primary key or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param articlePK the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public static Article findByPrimaryKey(ArticlePK articlePK)
		throws com.amf.newsletter.exception.NoSuchArticleException {

		return getPersistence().findByPrimaryKey(articlePK);
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articlePK the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 */
	public static Article fetchByPrimaryKey(ArticlePK articlePK) {
		return getPersistence().fetchByPrimaryKey(articlePK);
	}

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 */
	public static List<Article> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Article> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the articles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ArticlePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ArticlePersistence _persistence;

}