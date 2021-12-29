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

package com.amf.newsletter.service.persistence.impl;

import com.amf.newsletter.exception.NoSuchArticleException;
import com.amf.newsletter.model.Article;
import com.amf.newsletter.model.ArticleTable;
import com.amf.newsletter.model.impl.ArticleImpl;
import com.amf.newsletter.model.impl.ArticleModelImpl;
import com.amf.newsletter.service.persistence.ArticlePK;
import com.amf.newsletter.service.persistence.ArticlePersistence;
import com.amf.newsletter.service.persistence.ArticleUtil;
import com.amf.newsletter.service.persistence.impl.constants.AmfNewsletterPersistenceConstants;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ArticlePersistence.class, BasePersistence.class})
public class ArticlePersistenceImpl
	extends BasePersistenceImpl<Article> implements ArticlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ArticleUtil</code> to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ArticleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByIssueNumber;
	private FinderPath _finderPathWithoutPaginationFindByIssueNumber;
	private FinderPath _finderPathCountByIssueNumber;

	/**
	 * Returns all the articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the matching articles
	 */
	@Override
	public List<Article> findByIssueNumber(int issueNumber) {
		return findByIssueNumber(
			issueNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Article> findByIssueNumber(
		int issueNumber, int start, int end) {

		return findByIssueNumber(issueNumber, start, end, null);
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
	@Override
	public List<Article> findByIssueNumber(
		int issueNumber, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return findByIssueNumber(
			issueNumber, start, end, orderByComparator, true);
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
	@Override
	public List<Article> findByIssueNumber(
		int issueNumber, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIssueNumber;
				finderArgs = new Object[] {issueNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIssueNumber;
			finderArgs = new Object[] {
				issueNumber, start, end, orderByComparator
			};
		}

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Article article : list) {
					if (issueNumber != article.getIssueNumber()) {
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

			sb.append(_SQL_SELECT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueNumber);

				list = (List<Article>)QueryUtil.list(
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
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByIssueNumber_First(
			int issueNumber, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByIssueNumber_First(
			issueNumber, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueNumber=");
		sb.append(issueNumber);

		sb.append("}");

		throw new NoSuchArticleException(sb.toString());
	}

	/**
	 * Returns the first article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByIssueNumber_First(
		int issueNumber, OrderByComparator<Article> orderByComparator) {

		List<Article> list = findByIssueNumber(
			issueNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByIssueNumber_Last(
			int issueNumber, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByIssueNumber_Last(
			issueNumber, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueNumber=");
		sb.append(issueNumber);

		sb.append("}");

		throw new NoSuchArticleException(sb.toString());
	}

	/**
	 * Returns the last article in the ordered set where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByIssueNumber_Last(
		int issueNumber, OrderByComparator<Article> orderByComparator) {

		int count = countByIssueNumber(issueNumber);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByIssueNumber(
			issueNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Article[] findByIssueNumber_PrevAndNext(
			ArticlePK articlePK, int issueNumber,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = findByPrimaryKey(articlePK);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByIssueNumber_PrevAndNext(
				session, article, issueNumber, orderByComparator, true);

			array[1] = article;

			array[2] = getByIssueNumber_PrevAndNext(
				session, article, issueNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByIssueNumber_PrevAndNext(
		Session session, Article article, int issueNumber,
		OrderByComparator<Article> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ARTICLE_WHERE);

		sb.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

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
			sb.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(issueNumber);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(article)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Article> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where issueNumber = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 */
	@Override
	public void removeByIssueNumber(int issueNumber) {
		for (Article article :
				findByIssueNumber(
					issueNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(article);
		}
	}

	/**
	 * Returns the number of articles where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the number of matching articles
	 */
	@Override
	public int countByIssueNumber(int issueNumber) {
		FinderPath finderPath = _finderPathCountByIssueNumber;

		Object[] finderArgs = new Object[] {issueNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueNumber);

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

	private static final String _FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2 =
		"article.id.issueNumber = ?";

	private FinderPath _finderPathFetchByJournalArticleId;
	private FinderPath _finderPathCountByJournalArticleId;

	/**
	 * Returns the article where journalArticleId = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByJournalArticleId(String journalArticleId)
		throws NoSuchArticleException {

		Article article = fetchByJournalArticleId(journalArticleId);

		if (article == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("journalArticleId=");
			sb.append(journalArticleId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchArticleException(sb.toString());
		}

		return article;
	}

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByJournalArticleId(String journalArticleId) {
		return fetchByJournalArticleId(journalArticleId, true);
	}

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByJournalArticleId(
		String journalArticleId, boolean useFinderCache) {

		journalArticleId = Objects.toString(journalArticleId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {journalArticleId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByJournalArticleId, finderArgs);
		}

		if (result instanceof Article) {
			Article article = (Article)result;

			if (!Objects.equals(
					journalArticleId, article.getJournalArticleId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ARTICLE_WHERE);

			boolean bindJournalArticleId = false;

			if (journalArticleId.isEmpty()) {
				sb.append(_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_3);
			}
			else {
				bindJournalArticleId = true;

				sb.append(_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindJournalArticleId) {
					queryPos.add(journalArticleId);
				}

				List<Article> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByJournalArticleId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {journalArticleId};
							}

							_log.warn(
								"ArticlePersistenceImpl.fetchByJournalArticleId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Article article = list.get(0);

					result = article;

					cacheResult(article);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Article)result;
		}
	}

	/**
	 * Removes the article where journalArticleId = &#63; from the database.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the article that was removed
	 */
	@Override
	public Article removeByJournalArticleId(String journalArticleId)
		throws NoSuchArticleException {

		Article article = findByJournalArticleId(journalArticleId);

		return remove(article);
	}

	/**
	 * Returns the number of articles where journalArticleId = &#63;.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the number of matching articles
	 */
	@Override
	public int countByJournalArticleId(String journalArticleId) {
		journalArticleId = Objects.toString(journalArticleId, "");

		FinderPath finderPath = _finderPathCountByJournalArticleId;

		Object[] finderArgs = new Object[] {journalArticleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ARTICLE_WHERE);

			boolean bindJournalArticleId = false;

			if (journalArticleId.isEmpty()) {
				sb.append(_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_3);
			}
			else {
				bindJournalArticleId = true;

				sb.append(_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindJournalArticleId) {
					queryPos.add(journalArticleId);
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
		_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_2 =
			"article.journalArticleId = ?";

	private static final String
		_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_3 =
			"(article.journalArticleId IS NULL OR article.journalArticleId = '')";

	private FinderPath _finderPathFetchByIssueNumberAndOrder;
	private FinderPath _finderPathCountByIssueNumberAndOrder;

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByIssueNumberAndOrder(int issueNumber, int order)
		throws NoSuchArticleException {

		Article article = fetchByIssueNumberAndOrder(issueNumber, order);

		if (article == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("issueNumber=");
			sb.append(issueNumber);

			sb.append(", order=");
			sb.append(order);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchArticleException(sb.toString());
		}

		return article;
	}

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByIssueNumberAndOrder(int issueNumber, int order) {
		return fetchByIssueNumberAndOrder(issueNumber, order, true);
	}

	/**
	 * Returns the article where issueNumber = &#63; and order = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByIssueNumberAndOrder(
		int issueNumber, int order, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {issueNumber, order};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByIssueNumberAndOrder, finderArgs);
		}

		if (result instanceof Article) {
			Article article = (Article)result;

			if ((issueNumber != article.getIssueNumber()) ||
				(order != article.getOrder())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ISSUENUMBERANDORDER_ISSUENUMBER_2);

			sb.append(_FINDER_COLUMN_ISSUENUMBERANDORDER_ORDER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueNumber);

				queryPos.add(order);

				List<Article> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByIssueNumberAndOrder, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {issueNumber, order};
							}

							_log.warn(
								"ArticlePersistenceImpl.fetchByIssueNumberAndOrder(int, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Article article = list.get(0);

					result = article;

					cacheResult(article);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Article)result;
		}
	}

	/**
	 * Removes the article where issueNumber = &#63; and order = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the article that was removed
	 */
	@Override
	public Article removeByIssueNumberAndOrder(int issueNumber, int order)
		throws NoSuchArticleException {

		Article article = findByIssueNumberAndOrder(issueNumber, order);

		return remove(article);
	}

	/**
	 * Returns the number of articles where issueNumber = &#63; and order = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param order the order
	 * @return the number of matching articles
	 */
	@Override
	public int countByIssueNumberAndOrder(int issueNumber, int order) {
		FinderPath finderPath = _finderPathCountByIssueNumberAndOrder;

		Object[] finderArgs = new Object[] {issueNumber, order};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ISSUENUMBERANDORDER_ISSUENUMBER_2);

			sb.append(_FINDER_COLUMN_ISSUENUMBERANDORDER_ORDER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(issueNumber);

				queryPos.add(order);

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
		_FINDER_COLUMN_ISSUENUMBERANDORDER_ISSUENUMBER_2 =
			"article.id.issueNumber = ? AND ";

	private static final String _FINDER_COLUMN_ISSUENUMBERANDORDER_ORDER_2 =
		"article.id.order = ?";

	public ArticlePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Article.class);

		setModelImplClass(ArticleImpl.class);
		setModelPKClass(ArticlePK.class);

		setTable(ArticleTable.INSTANCE);
	}

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	@Override
	public void cacheResult(Article article) {
		entityCache.putResult(
			ArticleImpl.class, article.getPrimaryKey(), article);

		finderCache.putResult(
			_finderPathFetchByJournalArticleId,
			new Object[] {article.getJournalArticleId()}, article);

		finderCache.putResult(
			_finderPathFetchByIssueNumberAndOrder,
			new Object[] {article.getIssueNumber(), article.getOrder()},
			article);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	@Override
	public void cacheResult(List<Article> articles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (articles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Article article : articles) {
			if (entityCache.getResult(
					ArticleImpl.class, article.getPrimaryKey()) == null) {

				cacheResult(article);
			}
		}
	}

	/**
	 * Clears the cache for all articles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ArticleImpl.class);

		finderCache.clearCache(ArticleImpl.class);
	}

	/**
	 * Clears the cache for the article.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Article article) {
		entityCache.removeResult(ArticleImpl.class, article);
	}

	@Override
	public void clearCache(List<Article> articles) {
		for (Article article : articles) {
			entityCache.removeResult(ArticleImpl.class, article);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ArticleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ArticleImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ArticleModelImpl articleModelImpl) {
		Object[] args = new Object[] {articleModelImpl.getJournalArticleId()};

		finderCache.putResult(
			_finderPathCountByJournalArticleId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByJournalArticleId, args, articleModelImpl);

		args = new Object[] {
			articleModelImpl.getIssueNumber(), articleModelImpl.getOrder()
		};

		finderCache.putResult(
			_finderPathCountByIssueNumberAndOrder, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByIssueNumberAndOrder, args, articleModelImpl);
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articlePK the primary key for the new article
	 * @return the new article
	 */
	@Override
	public Article create(ArticlePK articlePK) {
		Article article = new ArticleImpl();

		article.setNew(true);
		article.setPrimaryKey(articlePK);

		return article;
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articlePK the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article remove(ArticlePK articlePK) throws NoSuchArticleException {
		return remove((Serializable)articlePK);
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article remove(Serializable primaryKey)
		throws NoSuchArticleException {

		Session session = null;

		try {
			session = openSession();

			Article article = (Article)session.get(
				ArticleImpl.class, primaryKey);

			if (article == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(article);
		}
		catch (NoSuchArticleException noSuchEntityException) {
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
	protected Article removeImpl(Article article) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(article)) {
				article = (Article)session.get(
					ArticleImpl.class, article.getPrimaryKeyObj());
			}

			if (article != null) {
				session.delete(article);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (article != null) {
			clearCache(article);
		}

		return article;
	}

	@Override
	public Article updateImpl(Article article) {
		boolean isNew = article.isNew();

		if (!(article instanceof ArticleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(article.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(article);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in article proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Article implementation " +
					article.getClass());
		}

		ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (article.getCreateDate() == null)) {
			if (serviceContext == null) {
				article.setCreateDate(date);
			}
			else {
				article.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!articleModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				article.setModifiedDate(date);
			}
			else {
				article.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(article);
			}
			else {
				article = (Article)session.merge(article);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ArticleImpl.class, articleModelImpl, false, true);

		cacheUniqueFindersCache(articleModelImpl);

		if (isNew) {
			article.setNew(false);
		}

		article.resetOriginalValues();

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleException {

		Article article = fetchByPrimaryKey(primaryKey);

		if (article == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param articlePK the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article findByPrimaryKey(ArticlePK articlePK)
		throws NoSuchArticleException {

		return findByPrimaryKey((Serializable)articlePK);
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articlePK the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 */
	@Override
	public Article fetchByPrimaryKey(ArticlePK articlePK) {
		return fetchByPrimaryKey((Serializable)articlePK);
	}

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 */
	@Override
	public List<Article> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Article> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator,
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

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ARTICLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLE;

				sql = sql.concat(ArticleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Article>)QueryUtil.list(
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
	 * Removes all the articles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Article article : findAll()) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ARTICLE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "articlePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ARTICLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ArticleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the article persistence.
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

		_finderPathWithPaginationFindByIssueNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssueNumber",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"issueNumber"}, true);

		_finderPathWithoutPaginationFindByIssueNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssueNumber",
			new String[] {Integer.class.getName()},
			new String[] {"issueNumber"}, true);

		_finderPathCountByIssueNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueNumber",
			new String[] {Integer.class.getName()},
			new String[] {"issueNumber"}, false);

		_finderPathFetchByJournalArticleId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByJournalArticleId",
			new String[] {String.class.getName()},
			new String[] {"journalArticleId"}, true);

		_finderPathCountByJournalArticleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJournalArticleId", new String[] {String.class.getName()},
			new String[] {"journalArticleId"}, false);

		_finderPathFetchByIssueNumberAndOrder = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByIssueNumberAndOrder",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			new String[] {"issueNumber", "order_"}, true);

		_finderPathCountByIssueNumberAndOrder = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIssueNumberAndOrder",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			new String[] {"issueNumber", "order_"}, false);

		_setArticleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setArticleUtilPersistence(null);

		entityCache.removeCache(ArticleImpl.class.getName());
	}

	private void _setArticleUtilPersistence(
		ArticlePersistence articlePersistence) {

		try {
			Field field = ArticleUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, articlePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AmfNewsletterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AmfNewsletterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfNewsletterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ARTICLE =
		"SELECT article FROM Article article";

	private static final String _SQL_SELECT_ARTICLE_WHERE =
		"SELECT article FROM Article article WHERE ";

	private static final String _SQL_COUNT_ARTICLE =
		"SELECT COUNT(article) FROM Article article";

	private static final String _SQL_COUNT_ARTICLE_WHERE =
		"SELECT COUNT(article) FROM Article article WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "article.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Article exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Article exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ArticlePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"issueNumber", "order"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ArticleModelArgumentsResolver _articleModelArgumentsResolver;

}