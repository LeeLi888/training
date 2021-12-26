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

import com.amf.user.profile.model.FavoriteGenre;
import com.amf.user.profile.model.FavoriteGenreModel;
import com.amf.user.profile.model.FavoriteGenreSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the FavoriteGenre service. Represents a row in the &quot;AmfUserProfile_FavoriteGenre&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FavoriteGenreModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FavoriteGenreImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenreImpl
 * @generated
 */
@JSON(strict = true)
public class FavoriteGenreModelImpl
	extends BaseModelImpl<FavoriteGenre> implements FavoriteGenreModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a favorite genre model instance should use the <code>FavoriteGenre</code> interface instead.
	 */
	public static final String TABLE_NAME = "AmfUserProfile_FavoriteGenre";

	public static final Object[][] TABLE_COLUMNS = {
		{"favoriteGenreId", Types.BIGINT}, {"favoriteGenreName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("favoriteGenreId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("favoriteGenreName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AmfUserProfile_FavoriteGenre (favoriteGenreId LONG not null primary key,favoriteGenreName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table AmfUserProfile_FavoriteGenre";

	public static final String ORDER_BY_JPQL =
		" ORDER BY favoriteGenre.favoriteGenreName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AmfUserProfile_FavoriteGenre.favoriteGenreName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FAVORITEGENRENAME_COLUMN_BITMASK = 1L;

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
	public static FavoriteGenre toModel(FavoriteGenreSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FavoriteGenre model = new FavoriteGenreImpl();

		model.setFavoriteGenreId(soapModel.getFavoriteGenreId());
		model.setFavoriteGenreName(soapModel.getFavoriteGenreName());

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
	public static List<FavoriteGenre> toModels(FavoriteGenreSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FavoriteGenre> models = new ArrayList<FavoriteGenre>(
			soapModels.length);

		for (FavoriteGenreSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public FavoriteGenreModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _favoriteGenreId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFavoriteGenreId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _favoriteGenreId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FavoriteGenre.class;
	}

	@Override
	public String getModelClassName() {
		return FavoriteGenre.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FavoriteGenre, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FavoriteGenre, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FavoriteGenre, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FavoriteGenre)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FavoriteGenre, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FavoriteGenre, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FavoriteGenre)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FavoriteGenre, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FavoriteGenre, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, FavoriteGenre>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			FavoriteGenre.class.getClassLoader(), FavoriteGenre.class,
			ModelWrapper.class);

		try {
			Constructor<FavoriteGenre> constructor =
				(Constructor<FavoriteGenre>)proxyClass.getConstructor(
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

	private static final Map<String, Function<FavoriteGenre, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FavoriteGenre, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FavoriteGenre, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<FavoriteGenre, Object>>();
		Map<String, BiConsumer<FavoriteGenre, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<FavoriteGenre, ?>>();

		attributeGetterFunctions.put(
			"favoriteGenreId", FavoriteGenre::getFavoriteGenreId);
		attributeSetterBiConsumers.put(
			"favoriteGenreId",
			(BiConsumer<FavoriteGenre, Long>)FavoriteGenre::setFavoriteGenreId);
		attributeGetterFunctions.put(
			"favoriteGenreName", FavoriteGenre::getFavoriteGenreName);
		attributeSetterBiConsumers.put(
			"favoriteGenreName",
			(BiConsumer<FavoriteGenre, String>)
				FavoriteGenre::setFavoriteGenreName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public String getFavoriteGenreName() {
		if (_favoriteGenreName == null) {
			return "";
		}
		else {
			return _favoriteGenreName;
		}
	}

	@Override
	public void setFavoriteGenreName(String favoriteGenreName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_favoriteGenreName = favoriteGenreName;
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
			0, FavoriteGenre.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FavoriteGenre toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FavoriteGenre>
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
		FavoriteGenreImpl favoriteGenreImpl = new FavoriteGenreImpl();

		favoriteGenreImpl.setFavoriteGenreId(getFavoriteGenreId());
		favoriteGenreImpl.setFavoriteGenreName(getFavoriteGenreName());

		favoriteGenreImpl.resetOriginalValues();

		return favoriteGenreImpl;
	}

	@Override
	public FavoriteGenre cloneWithOriginalValues() {
		FavoriteGenreImpl favoriteGenreImpl = new FavoriteGenreImpl();

		favoriteGenreImpl.setFavoriteGenreId(
			this.<Long>getColumnOriginalValue("favoriteGenreId"));
		favoriteGenreImpl.setFavoriteGenreName(
			this.<String>getColumnOriginalValue("favoriteGenreName"));

		return favoriteGenreImpl;
	}

	@Override
	public int compareTo(FavoriteGenre favoriteGenre) {
		int value = 0;

		value = getFavoriteGenreName().compareTo(
			favoriteGenre.getFavoriteGenreName());

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

		if (!(object instanceof FavoriteGenre)) {
			return false;
		}

		FavoriteGenre favoriteGenre = (FavoriteGenre)object;

		long primaryKey = favoriteGenre.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<FavoriteGenre> toCacheModel() {
		FavoriteGenreCacheModel favoriteGenreCacheModel =
			new FavoriteGenreCacheModel();

		favoriteGenreCacheModel.favoriteGenreId = getFavoriteGenreId();

		favoriteGenreCacheModel.favoriteGenreName = getFavoriteGenreName();

		String favoriteGenreName = favoriteGenreCacheModel.favoriteGenreName;

		if ((favoriteGenreName != null) && (favoriteGenreName.length() == 0)) {
			favoriteGenreCacheModel.favoriteGenreName = null;
		}

		return favoriteGenreCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FavoriteGenre, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FavoriteGenre, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FavoriteGenre, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((FavoriteGenre)this);

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
		Map<String, Function<FavoriteGenre, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FavoriteGenre, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FavoriteGenre, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((FavoriteGenre)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FavoriteGenre>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _favoriteGenreId;
	private String _favoriteGenreName;

	public <T> T getColumnValue(String columnName) {
		Function<FavoriteGenre, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FavoriteGenre)this);
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

		_columnOriginalValues.put("favoriteGenreId", _favoriteGenreId);
		_columnOriginalValues.put("favoriteGenreName", _favoriteGenreName);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("favoriteGenreId", 1L);

		columnBitmasks.put("favoriteGenreName", 2L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FavoriteGenre _escapedModel;

}