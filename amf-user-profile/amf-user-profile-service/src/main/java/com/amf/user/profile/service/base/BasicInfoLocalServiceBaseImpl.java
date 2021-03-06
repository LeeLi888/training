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

package com.amf.user.profile.service.base;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.service.*;
import com.amf.user.profile.service.persistence.FavoriteGenrePersistence;
import com.amf.user.profile.service.persistence.GeneralProfilePersistence;
import com.amf.user.profile.service.persistence.MovieInterestPersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ContactPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Provides the base implementation for the general profile local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.amf.user.profile.service.impl.GeneralProfileLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.amf.user.profile.service.impl.GeneralProfileLocalServiceImpl
 * @generated
 */
public abstract class BasicInfoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, BasicInfoLocalService, IdentifiableOSGiService {

	@Reference
	protected UserLocalService userLocalService;

	@Reference
	protected ContactLocalService contactLocalService;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;


	@Override
	public String getOSGiServiceIdentifier() {
		return BasicInfoLocalService.class.getName();
	}

	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel) throws PortalException {
		throw new PortalException("Unsupport method - deletePersistedModel.");
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		throw new RuntimeException("Unsupport method - dslQuery.");
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		throw new RuntimeException("Unsupport method - dslQueryCount.");
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj) throws PortalException {
		throw new PortalException("Unsupport method - getPersistedModel.");
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
				BasicInfoLocalService.class, IdentifiableOSGiService.class,
				PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		basicInfoLocalService = (BasicInfoLocalService)aopProxy;

		_setLocalServiceUtilService(basicInfoLocalService);
	}

	private void _setLocalServiceUtilService(
			BasicInfoLocalService basicInfoLocalService) {

		try {
			Field field = BasicInfoLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, basicInfoLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected BasicInfoLocalService basicInfoLocalService;

}