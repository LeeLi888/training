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

package com.amf.registration.service.persistence.impl;

import com.amf.registration.exception.NoSuchUserExternalException;
import com.amf.registration.model.UserExternal;
import com.amf.registration.model.UserExternalTable;
import com.amf.registration.model.impl.UserExternalImpl;
import com.amf.registration.model.impl.UserExternalModelImpl;
import com.amf.registration.service.persistence.UserExternalPersistence;
import com.amf.registration.service.persistence.UserExternalUtil;
import com.amf.registration.service.persistence.impl.constants.AmfRegistrationPersistenceConstants;

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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user external service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {UserExternalPersistence.class, BasePersistence.class})
public class UserExternalPersistenceImpl
	extends BasePersistenceImpl<UserExternal>
	implements UserExternalPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserExternalUtil</code> to access the user external persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserExternalImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public UserExternalPersistenceImpl() {
		setModelClass(UserExternal.class);

		setModelImplClass(UserExternalImpl.class);
		setModelPKClass(long.class);

		setTable(UserExternalTable.INSTANCE);
	}

	/**
	 * Caches the user external in the entity cache if it is enabled.
	 *
	 * @param userExternal the user external
	 */
	@Override
	public void cacheResult(UserExternal userExternal) {
		entityCache.putResult(
			UserExternalImpl.class, userExternal.getPrimaryKey(), userExternal);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user externals in the entity cache if it is enabled.
	 *
	 * @param userExternals the user externals
	 */
	@Override
	public void cacheResult(List<UserExternal> userExternals) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userExternals.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserExternal userExternal : userExternals) {
			if (entityCache.getResult(
					UserExternalImpl.class, userExternal.getPrimaryKey()) ==
						null) {

				cacheResult(userExternal);
			}
		}
	}

	/**
	 * Clears the cache for all user externals.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserExternalImpl.class);

		finderCache.clearCache(UserExternalImpl.class);
	}

	/**
	 * Clears the cache for the user external.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserExternal userExternal) {
		entityCache.removeResult(UserExternalImpl.class, userExternal);
	}

	@Override
	public void clearCache(List<UserExternal> userExternals) {
		for (UserExternal userExternal : userExternals) {
			entityCache.removeResult(UserExternalImpl.class, userExternal);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserExternalImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserExternalImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user external with the primary key. Does not add the user external to the database.
	 *
	 * @param userExternalId the primary key for the new user external
	 * @return the new user external
	 */
	@Override
	public UserExternal create(long userExternalId) {
		UserExternal userExternal = new UserExternalImpl();

		userExternal.setNew(true);
		userExternal.setPrimaryKey(userExternalId);

		userExternal.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userExternal;
	}

	/**
	 * Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external that was removed
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal remove(long userExternalId)
		throws NoSuchUserExternalException {

		return remove((Serializable)userExternalId);
	}

	/**
	 * Removes the user external with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user external
	 * @return the user external that was removed
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal remove(Serializable primaryKey)
		throws NoSuchUserExternalException {

		Session session = null;

		try {
			session = openSession();

			UserExternal userExternal = (UserExternal)session.get(
				UserExternalImpl.class, primaryKey);

			if (userExternal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserExternalException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userExternal);
		}
		catch (NoSuchUserExternalException noSuchEntityException) {
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
	protected UserExternal removeImpl(UserExternal userExternal) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userExternal)) {
				userExternal = (UserExternal)session.get(
					UserExternalImpl.class, userExternal.getPrimaryKeyObj());
			}

			if (userExternal != null) {
				session.delete(userExternal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userExternal != null) {
			clearCache(userExternal);
		}

		return userExternal;
	}

	@Override
	public UserExternal updateImpl(UserExternal userExternal) {
		boolean isNew = userExternal.isNew();

		if (!(userExternal instanceof UserExternalModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userExternal.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userExternal);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userExternal proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserExternal implementation " +
					userExternal.getClass());
		}

		UserExternalModelImpl userExternalModelImpl =
			(UserExternalModelImpl)userExternal;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userExternal.getCreateDate() == null)) {
			if (serviceContext == null) {
				userExternal.setCreateDate(date);
			}
			else {
				userExternal.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!userExternalModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userExternal.setModifiedDate(date);
			}
			else {
				userExternal.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userExternal);
			}
			else {
				userExternal = (UserExternal)session.merge(userExternal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserExternalImpl.class, userExternal, false, true);

		if (isNew) {
			userExternal.setNew(false);
		}

		userExternal.resetOriginalValues();

		return userExternal;
	}

	/**
	 * Returns the user external with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user external
	 * @return the user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserExternalException {

		UserExternal userExternal = fetchByPrimaryKey(primaryKey);

		if (userExternal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserExternalException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userExternal;
	}

	/**
	 * Returns the user external with the primary key or throws a <code>NoSuchUserExternalException</code> if it could not be found.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external
	 * @throws NoSuchUserExternalException if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal findByPrimaryKey(long userExternalId)
		throws NoSuchUserExternalException {

		return findByPrimaryKey((Serializable)userExternalId);
	}

	/**
	 * Returns the user external with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userExternalId the primary key of the user external
	 * @return the user external, or <code>null</code> if a user external with the primary key could not be found
	 */
	@Override
	public UserExternal fetchByPrimaryKey(long userExternalId) {
		return fetchByPrimaryKey((Serializable)userExternalId);
	}

	/**
	 * Returns all the user externals.
	 *
	 * @return the user externals
	 */
	@Override
	public List<UserExternal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserExternalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @return the range of user externals
	 */
	@Override
	public List<UserExternal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserExternalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user externals
	 */
	@Override
	public List<UserExternal> findAll(
		int start, int end, OrderByComparator<UserExternal> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user externals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserExternalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user externals
	 * @param end the upper bound of the range of user externals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user externals
	 */
	@Override
	public List<UserExternal> findAll(
		int start, int end, OrderByComparator<UserExternal> orderByComparator,
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

		List<UserExternal> list = null;

		if (useFinderCache) {
			list = (List<UserExternal>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USEREXTERNAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USEREXTERNAL;

				sql = sql.concat(UserExternalModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserExternal>)QueryUtil.list(
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
	 * Removes all the user externals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserExternal userExternal : findAll()) {
			remove(userExternal);
		}
	}

	/**
	 * Returns the number of user externals.
	 *
	 * @return the number of user externals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USEREXTERNAL);

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
		return "userExternalId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USEREXTERNAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserExternalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user external persistence.
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

		_setUserExternalUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserExternalUtilPersistence(null);

		entityCache.removeCache(UserExternalImpl.class.getName());
	}

	private void _setUserExternalUtilPersistence(
		UserExternalPersistence userExternalPersistence) {

		try {
			Field field = UserExternalUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userExternalPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AmfRegistrationPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AmfRegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfRegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USEREXTERNAL =
		"SELECT userExternal FROM UserExternal userExternal";

	private static final String _SQL_COUNT_USEREXTERNAL =
		"SELECT COUNT(userExternal) FROM UserExternal userExternal";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userExternal.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserExternal exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		UserExternalPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private UserExternalModelArgumentsResolver
		_userExternalModelArgumentsResolver;

}