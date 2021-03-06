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

package com.amf.user.profile.model.impl;

import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.model.MovieInterestModel;
import com.amf.user.profile.model.MovieInterestSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the MovieInterest service. Represents a row in the &quot;AmfUserProfile_MovieInterest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>MovieInterestModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MovieInterestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MovieInterestImpl
 * @generated
 */
@JSON(strict = true)
public class MovieInterestModelImpl
	extends BaseModelImpl<MovieInterest> implements MovieInterestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a movie interest model instance should use the <code>MovieInterest</code> interface instead.
	 */
	public static final String TABLE_NAME = "AmfUserProfile_MovieInterest";

	public static final Object[][] TABLE_COLUMNS = {
		{"movieInterestId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"favoriteMovie", Types.VARCHAR},
		{"favoriteGenreId", Types.BIGINT},
		{"leastFavoriteMovie", Types.VARCHAR}, {"favoriteActor", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("movieInterestId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("favoriteMovie", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("favoriteGenreId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("leastFavoriteMovie", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("favoriteActor", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AmfUserProfile_MovieInterest (movieInterestId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,favoriteMovie VARCHAR(75) null,favoriteGenreId LONG,leastFavoriteMovie VARCHAR(75) null,favoriteActor VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table AmfUserProfile_MovieInterest";

	public static final String ORDER_BY_JPQL =
		" ORDER BY movieInterest.userName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AmfUserProfile_MovieInterest.userName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static MovieInterest toModel(MovieInterestSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MovieInterest model = new MovieInterestImpl();

		model.setMovieInterestId(soapModel.getMovieInterestId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFavoriteMovie(soapModel.getFavoriteMovie());
		model.setFavoriteGenreId(soapModel.getFavoriteGenreId());
		model.setLeastFavoriteMovie(soapModel.getLeastFavoriteMovie());
		model.setFavoriteActor(soapModel.getFavoriteActor());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<MovieInterest> toModels(MovieInterestSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MovieInterest> models = new ArrayList<MovieInterest>(
			soapModels.length);

		for (MovieInterestSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public MovieInterestModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _movieInterestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMovieInterestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _movieInterestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MovieInterest.class;
	}

	@Override
	public String getModelClassName() {
		return MovieInterest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<MovieInterest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<MovieInterest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MovieInterest, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((MovieInterest)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<MovieInterest, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<MovieInterest, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(MovieInterest)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<MovieInterest, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<MovieInterest, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, MovieInterest>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			MovieInterest.class.getClassLoader(), MovieInterest.class,
			ModelWrapper.class);

		try {
			Constructor<MovieInterest> constructor =
				(Constructor<MovieInterest>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<MovieInterest, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<MovieInterest, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<MovieInterest, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<MovieInterest, Object>>();
		Map<String, BiConsumer<MovieInterest, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<MovieInterest, ?>>();

		attributeGetterFunctions.put(
			"movieInterestId", MovieInterest::getMovieInterestId);
		attributeSetterBiConsumers.put(
			"movieInterestId",
			(BiConsumer<MovieInterest, Long>)MovieInterest::setMovieInterestId);
		attributeGetterFunctions.put("groupId", MovieInterest::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<MovieInterest, Long>)MovieInterest::setGroupId);
		attributeGetterFunctions.put("companyId", MovieInterest::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<MovieInterest, Long>)MovieInterest::setCompanyId);
		attributeGetterFunctions.put("userId", MovieInterest::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<MovieInterest, Long>)MovieInterest::setUserId);
		attributeGetterFunctions.put("userName", MovieInterest::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<MovieInterest, String>)MovieInterest::setUserName);
		attributeGetterFunctions.put(
			"createDate", MovieInterest::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<MovieInterest, Date>)MovieInterest::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", MovieInterest::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<MovieInterest, Date>)MovieInterest::setModifiedDate);
		attributeGetterFunctions.put(
			"favoriteMovie", MovieInterest::getFavoriteMovie);
		attributeSetterBiConsumers.put(
			"favoriteMovie",
			(BiConsumer<MovieInterest, String>)MovieInterest::setFavoriteMovie);
		attributeGetterFunctions.put(
			"favoriteGenreId", MovieInterest::getFavoriteGenreId);
		attributeSetterBiConsumers.put(
			"favoriteGenreId",
			(BiConsumer<MovieInterest, Long>)MovieInterest::setFavoriteGenreId);
		attributeGetterFunctions.put(
			"leastFavoriteMovie", MovieInterest::getLeastFavoriteMovie);
		attributeSetterBiConsumers.put(
			"leastFavoriteMovie",
			(BiConsumer<MovieInterest, String>)
				MovieInterest::setLeastFavoriteMovie);
		attributeGetterFunctions.put(
			"favoriteActor", MovieInterest::getFavoriteActor);
		attributeSetterBiConsumers.put(
			"favoriteActor",
			(BiConsumer<MovieInterest, String>)MovieInterest::setFavoriteActor);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMovieInterestId() {
		return _movieInterestId;
	}

	@Override
	public void setMovieInterestId(long movieInterestId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_movieInterestId = movieInterestId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getFavoriteMovie() {
		if (_favoriteMovie == null) {
			return "";
		}
		else {
			return _favoriteMovie;
		}
	}

	@Override
	public void setFavoriteMovie(String favoriteMovie) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_favoriteMovie = favoriteMovie;
	}

	@JSON
	@Override
	public long getFavoriteGenreId() {
		return _favoriteGenreId;
	}

	@Override
	public void setFavoriteGenreId(long favoriteGenreId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_favoriteGenreId = favoriteGenreId;
	}

	@JSON
	@Override
	public String getLeastFavoriteMovie() {
		if (_leastFavoriteMovie == null) {
			return "";
		}
		else {
			return _leastFavoriteMovie;
		}
	}

	@Override
	public void setLeastFavoriteMovie(String leastFavoriteMovie) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_leastFavoriteMovie = leastFavoriteMovie;
	}

	@JSON
	@Override
	public String getFavoriteActor() {
		if (_favoriteActor == null) {
			return "";
		}
		else {
			return _favoriteActor;
		}
	}

	@Override
	public void setFavoriteActor(String favoriteActor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_favoriteActor = favoriteActor;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), MovieInterest.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MovieInterest toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, MovieInterest>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MovieInterestImpl movieInterestImpl = new MovieInterestImpl();

		movieInterestImpl.setMovieInterestId(getMovieInterestId());
		movieInterestImpl.setGroupId(getGroupId());
		movieInterestImpl.setCompanyId(getCompanyId());
		movieInterestImpl.setUserId(getUserId());
		movieInterestImpl.setUserName(getUserName());
		movieInterestImpl.setCreateDate(getCreateDate());
		movieInterestImpl.setModifiedDate(getModifiedDate());
		movieInterestImpl.setFavoriteMovie(getFavoriteMovie());
		movieInterestImpl.setFavoriteGenreId(getFavoriteGenreId());
		movieInterestImpl.setLeastFavoriteMovie(getLeastFavoriteMovie());
		movieInterestImpl.setFavoriteActor(getFavoriteActor());

		movieInterestImpl.resetOriginalValues();

		return movieInterestImpl;
	}

	@Override
	public MovieInterest cloneWithOriginalValues() {
		MovieInterestImpl movieInterestImpl = new MovieInterestImpl();

		movieInterestImpl.setMovieInterestId(
			this.<Long>getColumnOriginalValue("movieInterestId"));
		movieInterestImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		movieInterestImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		movieInterestImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		movieInterestImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		movieInterestImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		movieInterestImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		movieInterestImpl.setFavoriteMovie(
			this.<String>getColumnOriginalValue("favoriteMovie"));
		movieInterestImpl.setFavoriteGenreId(
			this.<Long>getColumnOriginalValue("favoriteGenreId"));
		movieInterestImpl.setLeastFavoriteMovie(
			this.<String>getColumnOriginalValue("leastFavoriteMovie"));
		movieInterestImpl.setFavoriteActor(
			this.<String>getColumnOriginalValue("favoriteActor"));

		return movieInterestImpl;
	}

	@Override
	public int compareTo(MovieInterest movieInterest) {
		int value = 0;

		value = getUserName().compareTo(movieInterest.getUserName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MovieInterest)) {
			return false;
		}

		MovieInterest movieInterest = (MovieInterest)object;

		long primaryKey = movieInterest.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<MovieInterest> toCacheModel() {
		MovieInterestCacheModel movieInterestCacheModel =
			new MovieInterestCacheModel();

		movieInterestCacheModel.movieInterestId = getMovieInterestId();

		movieInterestCacheModel.groupId = getGroupId();

		movieInterestCacheModel.companyId = getCompanyId();

		movieInterestCacheModel.userId = getUserId();

		movieInterestCacheModel.userName = getUserName();

		String userName = movieInterestCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			movieInterestCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			movieInterestCacheModel.createDate = createDate.getTime();
		}
		else {
			movieInterestCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			movieInterestCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			movieInterestCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		movieInterestCacheModel.favoriteMovie = getFavoriteMovie();

		String favoriteMovie = movieInterestCacheModel.favoriteMovie;

		if ((favoriteMovie != null) && (favoriteMovie.length() == 0)) {
			movieInterestCacheModel.favoriteMovie = null;
		}

		movieInterestCacheModel.favoriteGenreId = getFavoriteGenreId();

		movieInterestCacheModel.leastFavoriteMovie = getLeastFavoriteMovie();

		String leastFavoriteMovie = movieInterestCacheModel.leastFavoriteMovie;

		if ((leastFavoriteMovie != null) &&
			(leastFavoriteMovie.length() == 0)) {

			movieInterestCacheModel.leastFavoriteMovie = null;
		}

		movieInterestCacheModel.favoriteActor = getFavoriteActor();

		String favoriteActor = movieInterestCacheModel.favoriteActor;

		if ((favoriteActor != null) && (favoriteActor.length() == 0)) {
			movieInterestCacheModel.favoriteActor = null;
		}

		return movieInterestCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<MovieInterest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<MovieInterest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MovieInterest, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((MovieInterest)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<MovieInterest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<MovieInterest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<MovieInterest, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((MovieInterest)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, MovieInterest>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _movieInterestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _favoriteMovie;
	private long _favoriteGenreId;
	private String _leastFavoriteMovie;
	private String _favoriteActor;

	public <T> T getColumnValue(String columnName) {
		Function<MovieInterest, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((MovieInterest)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("movieInterestId", _movieInterestId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("favoriteMovie", _favoriteMovie);
		_columnOriginalValues.put("favoriteGenreId", _favoriteGenreId);
		_columnOriginalValues.put("leastFavoriteMovie", _leastFavoriteMovie);
		_columnOriginalValues.put("favoriteActor", _favoriteActor);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("movieInterestId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("favoriteMovie", 128L);

		columnBitmasks.put("favoriteGenreId", 256L);

		columnBitmasks.put("leastFavoriteMovie", 512L);

		columnBitmasks.put("favoriteActor", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private MovieInterest _escapedModel;

}