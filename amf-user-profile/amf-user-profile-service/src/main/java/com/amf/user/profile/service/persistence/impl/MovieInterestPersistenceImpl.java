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

package com.amf.user.profile.service.persistence.impl;

import com.amf.user.profile.exception.NoSuchMovieInterestException;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.model.MovieInterestTable;
import com.amf.user.profile.model.impl.MovieInterestImpl;
import com.amf.user.profile.model.impl.MovieInterestModelImpl;
import com.amf.user.profile.service.persistence.MovieInterestPersistence;
import com.amf.user.profile.service.persistence.MovieInterestUtil;
import com.amf.user.profile.service.persistence.impl.constants.AmfUserProfilePersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the movie interest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {MovieInterestPersistence.class, BasePersistence.class})
public class MovieInterestPersistenceImpl
	extends BasePersistenceImpl<MovieInterest>
	implements MovieInterestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MovieInterestUtil</code> to access the movie interest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MovieInterestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the movie interest where userId = &#63; or throws a <code>NoSuchMovieInterestException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching movie interest
	 * @throws NoSuchMovieInterestException if a matching movie interest could not be found
	 */
	@Override
	public MovieInterest findByUserId(long userId)
		throws NoSuchMovieInterestException {

		MovieInterest movieInterest = fetchByUserId(userId);

		if (movieInterest == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMovieInterestException(sb.toString());
		}

		return movieInterest;
	}

	/**
	 * Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	 */
	@Override
	public MovieInterest fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	 */
	@Override
	public MovieInterest fetchByUserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs);
		}

		if (result instanceof MovieInterest) {
			MovieInterest movieInterest = (MovieInterest)result;

			if (userId != movieInterest.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MOVIEINTEREST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<MovieInterest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"MovieInterestPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MovieInterest movieInterest = list.get(0);

					result = movieInterest;

					cacheResult(movieInterest);
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
			return (MovieInterest)result;
		}
	}

	/**
	 * Removes the movie interest where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the movie interest that was removed
	 */
	@Override
	public MovieInterest removeByUserId(long userId)
		throws NoSuchMovieInterestException {

		MovieInterest movieInterest = findByUserId(userId);

		return remove(movieInterest);
	}

	/**
	 * Returns the number of movie interests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching movie interests
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOVIEINTEREST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"movieInterest.userId = ?";

	public MovieInterestPersistenceImpl() {
		setModelClass(MovieInterest.class);

		setModelImplClass(MovieInterestImpl.class);
		setModelPKClass(long.class);

		setTable(MovieInterestTable.INSTANCE);
	}

	/**
	 * Caches the movie interest in the entity cache if it is enabled.
	 *
	 * @param movieInterest the movie interest
	 */
	@Override
	public void cacheResult(MovieInterest movieInterest) {
		entityCache.putResult(
			MovieInterestImpl.class, movieInterest.getPrimaryKey(),
			movieInterest);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {movieInterest.getUserId()},
			movieInterest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the movie interests in the entity cache if it is enabled.
	 *
	 * @param movieInterests the movie interests
	 */
	@Override
	public void cacheResult(List<MovieInterest> movieInterests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (movieInterests.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MovieInterest movieInterest : movieInterests) {
			if (entityCache.getResult(
					MovieInterestImpl.class, movieInterest.getPrimaryKey()) ==
						null) {

				cacheResult(movieInterest);
			}
		}
	}

	/**
	 * Clears the cache for all movie interests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MovieInterestImpl.class);

		finderCache.clearCache(MovieInterestImpl.class);
	}

	/**
	 * Clears the cache for the movie interest.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MovieInterest movieInterest) {
		entityCache.removeResult(MovieInterestImpl.class, movieInterest);
	}

	@Override
	public void clearCache(List<MovieInterest> movieInterests) {
		for (MovieInterest movieInterest : movieInterests) {
			entityCache.removeResult(MovieInterestImpl.class, movieInterest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MovieInterestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MovieInterestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MovieInterestModelImpl movieInterestModelImpl) {

		Object[] args = new Object[] {movieInterestModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUserId, args, movieInterestModelImpl);
	}

	/**
	 * Creates a new movie interest with the primary key. Does not add the movie interest to the database.
	 *
	 * @param movieInterestId the primary key for the new movie interest
	 * @return the new movie interest
	 */
	@Override
	public MovieInterest create(long movieInterestId) {
		MovieInterest movieInterest = new MovieInterestImpl();

		movieInterest.setNew(true);
		movieInterest.setPrimaryKey(movieInterestId);

		movieInterest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return movieInterest;
	}

	/**
	 * Removes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param movieInterestId the primary key of the movie interest
	 * @return the movie interest that was removed
	 * @throws NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 */
	@Override
	public MovieInterest remove(long movieInterestId)
		throws NoSuchMovieInterestException {

		return remove((Serializable)movieInterestId);
	}

	/**
	 * Removes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the movie interest
	 * @return the movie interest that was removed
	 * @throws NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 */
	@Override
	public MovieInterest remove(Serializable primaryKey)
		throws NoSuchMovieInterestException {

		Session session = null;

		try {
			session = openSession();

			MovieInterest movieInterest = (MovieInterest)session.get(
				MovieInterestImpl.class, primaryKey);

			if (movieInterest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMovieInterestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(movieInterest);
		}
		catch (NoSuchMovieInterestException noSuchEntityException) {
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
	protected MovieInterest removeImpl(MovieInterest movieInterest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(movieInterest)) {
				movieInterest = (MovieInterest)session.get(
					MovieInterestImpl.class, movieInterest.getPrimaryKeyObj());
			}

			if (movieInterest != null) {
				session.delete(movieInterest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (movieInterest != null) {
			clearCache(movieInterest);
		}

		return movieInterest;
	}

	@Override
	public MovieInterest updateImpl(MovieInterest movieInterest) {
		boolean isNew = movieInterest.isNew();

		if (!(movieInterest instanceof MovieInterestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(movieInterest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					movieInterest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in movieInterest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MovieInterest implementation " +
					movieInterest.getClass());
		}

		MovieInterestModelImpl movieInterestModelImpl =
			(MovieInterestModelImpl)movieInterest;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (movieInterest.getCreateDate() == null)) {
			if (serviceContext == null) {
				movieInterest.setCreateDate(date);
			}
			else {
				movieInterest.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!movieInterestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				movieInterest.setModifiedDate(date);
			}
			else {
				movieInterest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(movieInterest);
			}
			else {
				movieInterest = (MovieInterest)session.merge(movieInterest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MovieInterestImpl.class, movieInterestModelImpl, false, true);

		cacheUniqueFindersCache(movieInterestModelImpl);

		if (isNew) {
			movieInterest.setNew(false);
		}

		movieInterest.resetOriginalValues();

		return movieInterest;
	}

	/**
	 * Returns the movie interest with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the movie interest
	 * @return the movie interest
	 * @throws NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 */
	@Override
	public MovieInterest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMovieInterestException {

		MovieInterest movieInterest = fetchByPrimaryKey(primaryKey);

		if (movieInterest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMovieInterestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return movieInterest;
	}

	/**
	 * Returns the movie interest with the primary key or throws a <code>NoSuchMovieInterestException</code> if it could not be found.
	 *
	 * @param movieInterestId the primary key of the movie interest
	 * @return the movie interest
	 * @throws NoSuchMovieInterestException if a movie interest with the primary key could not be found
	 */
	@Override
	public MovieInterest findByPrimaryKey(long movieInterestId)
		throws NoSuchMovieInterestException {

		return findByPrimaryKey((Serializable)movieInterestId);
	}

	/**
	 * Returns the movie interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param movieInterestId the primary key of the movie interest
	 * @return the movie interest, or <code>null</code> if a movie interest with the primary key could not be found
	 */
	@Override
	public MovieInterest fetchByPrimaryKey(long movieInterestId) {
		return fetchByPrimaryKey((Serializable)movieInterestId);
	}

	/**
	 * Returns all the movie interests.
	 *
	 * @return the movie interests
	 */
	@Override
	public List<MovieInterest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the movie interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovieInterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movie interests
	 * @param end the upper bound of the range of movie interests (not inclusive)
	 * @return the range of movie interests
	 */
	@Override
	public List<MovieInterest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the movie interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovieInterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movie interests
	 * @param end the upper bound of the range of movie interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of movie interests
	 */
	@Override
	public List<MovieInterest> findAll(
		int start, int end,
		OrderByComparator<MovieInterest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the movie interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MovieInterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of movie interests
	 * @param end the upper bound of the range of movie interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of movie interests
	 */
	@Override
	public List<MovieInterest> findAll(
		int start, int end, OrderByComparator<MovieInterest> orderByComparator,
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

		List<MovieInterest> list = null;

		if (useFinderCache) {
			list = (List<MovieInterest>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MOVIEINTEREST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MOVIEINTEREST;

				sql = sql.concat(MovieInterestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MovieInterest>)QueryUtil.list(
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
	 * Removes all the movie interests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MovieInterest movieInterest : findAll()) {
			remove(movieInterest);
		}
	}

	/**
	 * Returns the number of movie interests.
	 *
	 * @return the number of movie interests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MOVIEINTEREST);

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
		return "movieInterestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MOVIEINTEREST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MovieInterestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the movie interest persistence.
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

		_finderPathFetchByUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setMovieInterestUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMovieInterestUtilPersistence(null);

		entityCache.removeCache(MovieInterestImpl.class.getName());
	}

	private void _setMovieInterestUtilPersistence(
		MovieInterestPersistence movieInterestPersistence) {

		try {
			Field field = MovieInterestUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, movieInterestPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AmfUserProfilePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AmfUserProfilePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfUserProfilePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MOVIEINTEREST =
		"SELECT movieInterest FROM MovieInterest movieInterest";

	private static final String _SQL_SELECT_MOVIEINTEREST_WHERE =
		"SELECT movieInterest FROM MovieInterest movieInterest WHERE ";

	private static final String _SQL_COUNT_MOVIEINTEREST =
		"SELECT COUNT(movieInterest) FROM MovieInterest movieInterest";

	private static final String _SQL_COUNT_MOVIEINTEREST_WHERE =
		"SELECT COUNT(movieInterest) FROM MovieInterest movieInterest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "movieInterest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MovieInterest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MovieInterest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MovieInterestPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MovieInterestModelArgumentsResolver
		_movieInterestModelArgumentsResolver;

}