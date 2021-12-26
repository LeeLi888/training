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

import com.amf.user.profile.exception.NoSuchFavoriteGenreException;
import com.amf.user.profile.model.FavoriteGenre;
import com.amf.user.profile.model.FavoriteGenreTable;
import com.amf.user.profile.model.impl.FavoriteGenreImpl;
import com.amf.user.profile.model.impl.FavoriteGenreModelImpl;
import com.amf.user.profile.service.persistence.FavoriteGenrePersistence;
import com.amf.user.profile.service.persistence.FavoriteGenreUtil;
import com.amf.user.profile.service.persistence.impl.constants.AmfUserProfilePersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the favorite genre service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FavoriteGenrePersistence.class, BasePersistence.class})
public class FavoriteGenrePersistenceImpl
	extends BasePersistenceImpl<FavoriteGenre>
	implements FavoriteGenrePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FavoriteGenreUtil</code> to access the favorite genre persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FavoriteGenreImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FavoriteGenrePersistenceImpl() {
		setModelClass(FavoriteGenre.class);

		setModelImplClass(FavoriteGenreImpl.class);
		setModelPKClass(long.class);

		setTable(FavoriteGenreTable.INSTANCE);
	}

	/**
	 * Caches the favorite genre in the entity cache if it is enabled.
	 *
	 * @param favoriteGenre the favorite genre
	 */
	@Override
	public void cacheResult(FavoriteGenre favoriteGenre) {
		entityCache.putResult(
			FavoriteGenreImpl.class, favoriteGenre.getPrimaryKey(),
			favoriteGenre);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the favorite genres in the entity cache if it is enabled.
	 *
	 * @param favoriteGenres the favorite genres
	 */
	@Override
	public void cacheResult(List<FavoriteGenre> favoriteGenres) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (favoriteGenres.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FavoriteGenre favoriteGenre : favoriteGenres) {
			if (entityCache.getResult(
					FavoriteGenreImpl.class, favoriteGenre.getPrimaryKey()) ==
						null) {

				cacheResult(favoriteGenre);
			}
		}
	}

	/**
	 * Clears the cache for all favorite genres.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FavoriteGenreImpl.class);

		finderCache.clearCache(FavoriteGenreImpl.class);
	}

	/**
	 * Clears the cache for the favorite genre.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FavoriteGenre favoriteGenre) {
		entityCache.removeResult(FavoriteGenreImpl.class, favoriteGenre);
	}

	@Override
	public void clearCache(List<FavoriteGenre> favoriteGenres) {
		for (FavoriteGenre favoriteGenre : favoriteGenres) {
			entityCache.removeResult(FavoriteGenreImpl.class, favoriteGenre);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FavoriteGenreImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FavoriteGenreImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new favorite genre with the primary key. Does not add the favorite genre to the database.
	 *
	 * @param favoriteGenreId the primary key for the new favorite genre
	 * @return the new favorite genre
	 */
	@Override
	public FavoriteGenre create(long favoriteGenreId) {
		FavoriteGenre favoriteGenre = new FavoriteGenreImpl();

		favoriteGenre.setNew(true);
		favoriteGenre.setPrimaryKey(favoriteGenreId);

		return favoriteGenre;
	}

	/**
	 * Removes the favorite genre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre that was removed
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	@Override
	public FavoriteGenre remove(long favoriteGenreId)
		throws NoSuchFavoriteGenreException {

		return remove((Serializable)favoriteGenreId);
	}

	/**
	 * Removes the favorite genre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the favorite genre
	 * @return the favorite genre that was removed
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	@Override
	public FavoriteGenre remove(Serializable primaryKey)
		throws NoSuchFavoriteGenreException {

		Session session = null;

		try {
			session = openSession();

			FavoriteGenre favoriteGenre = (FavoriteGenre)session.get(
				FavoriteGenreImpl.class, primaryKey);

			if (favoriteGenre == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFavoriteGenreException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(favoriteGenre);
		}
		catch (NoSuchFavoriteGenreException noSuchEntityException) {
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
	protected FavoriteGenre removeImpl(FavoriteGenre favoriteGenre) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(favoriteGenre)) {
				favoriteGenre = (FavoriteGenre)session.get(
					FavoriteGenreImpl.class, favoriteGenre.getPrimaryKeyObj());
			}

			if (favoriteGenre != null) {
				session.delete(favoriteGenre);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (favoriteGenre != null) {
			clearCache(favoriteGenre);
		}

		return favoriteGenre;
	}

	@Override
	public FavoriteGenre updateImpl(FavoriteGenre favoriteGenre) {
		boolean isNew = favoriteGenre.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(favoriteGenre);
			}
			else {
				favoriteGenre = (FavoriteGenre)session.merge(favoriteGenre);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FavoriteGenreImpl.class, favoriteGenre, false, true);

		if (isNew) {
			favoriteGenre.setNew(false);
		}

		favoriteGenre.resetOriginalValues();

		return favoriteGenre;
	}

	/**
	 * Returns the favorite genre with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the favorite genre
	 * @return the favorite genre
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	@Override
	public FavoriteGenre findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFavoriteGenreException {

		FavoriteGenre favoriteGenre = fetchByPrimaryKey(primaryKey);

		if (favoriteGenre == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFavoriteGenreException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return favoriteGenre;
	}

	/**
	 * Returns the favorite genre with the primary key or throws a <code>NoSuchFavoriteGenreException</code> if it could not be found.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre
	 * @throws NoSuchFavoriteGenreException if a favorite genre with the primary key could not be found
	 */
	@Override
	public FavoriteGenre findByPrimaryKey(long favoriteGenreId)
		throws NoSuchFavoriteGenreException {

		return findByPrimaryKey((Serializable)favoriteGenreId);
	}

	/**
	 * Returns the favorite genre with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param favoriteGenreId the primary key of the favorite genre
	 * @return the favorite genre, or <code>null</code> if a favorite genre with the primary key could not be found
	 */
	@Override
	public FavoriteGenre fetchByPrimaryKey(long favoriteGenreId) {
		return fetchByPrimaryKey((Serializable)favoriteGenreId);
	}

	/**
	 * Returns all the favorite genres.
	 *
	 * @return the favorite genres
	 */
	@Override
	public List<FavoriteGenre> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the favorite genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorite genres
	 * @param end the upper bound of the range of favorite genres (not inclusive)
	 * @return the range of favorite genres
	 */
	@Override
	public List<FavoriteGenre> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the favorite genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorite genres
	 * @param end the upper bound of the range of favorite genres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of favorite genres
	 */
	@Override
	public List<FavoriteGenre> findAll(
		int start, int end,
		OrderByComparator<FavoriteGenre> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the favorite genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteGenreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorite genres
	 * @param end the upper bound of the range of favorite genres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of favorite genres
	 */
	@Override
	public List<FavoriteGenre> findAll(
		int start, int end, OrderByComparator<FavoriteGenre> orderByComparator,
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

		List<FavoriteGenre> list = null;

		if (useFinderCache) {
			list = (List<FavoriteGenre>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAVORITEGENRE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAVORITEGENRE;

				sql = sql.concat(FavoriteGenreModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FavoriteGenre>)QueryUtil.list(
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
	 * Removes all the favorite genres from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FavoriteGenre favoriteGenre : findAll()) {
			remove(favoriteGenre);
		}
	}

	/**
	 * Returns the number of favorite genres.
	 *
	 * @return the number of favorite genres
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FAVORITEGENRE);

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
		return "favoriteGenreId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAVORITEGENRE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FavoriteGenreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the favorite genre persistence.
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

		_setFavoriteGenreUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFavoriteGenreUtilPersistence(null);

		entityCache.removeCache(FavoriteGenreImpl.class.getName());
	}

	private void _setFavoriteGenreUtilPersistence(
		FavoriteGenrePersistence favoriteGenrePersistence) {

		try {
			Field field = FavoriteGenreUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, favoriteGenrePersistence);
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

	private static final String _SQL_SELECT_FAVORITEGENRE =
		"SELECT favoriteGenre FROM FavoriteGenre favoriteGenre";

	private static final String _SQL_COUNT_FAVORITEGENRE =
		"SELECT COUNT(favoriteGenre) FROM FavoriteGenre favoriteGenre";

	private static final String _ORDER_BY_ENTITY_ALIAS = "favoriteGenre.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FavoriteGenre exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FavoriteGenrePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private FavoriteGenreModelArgumentsResolver
		_favoriteGenreModelArgumentsResolver;

}