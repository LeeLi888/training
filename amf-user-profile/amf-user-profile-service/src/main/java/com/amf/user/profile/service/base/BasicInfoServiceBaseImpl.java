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

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.FavoriteGenre;
import com.amf.user.profile.service.*;
import com.amf.user.profile.service.persistence.FavoriteGenrePersistence;
import com.amf.user.profile.service.persistence.GeneralProfilePersistence;
import com.amf.user.profile.service.persistence.MovieInterestPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javax.sql.DataSource;
import java.lang.reflect.Field;

/**
 * Provides the base implementation for the favorite genre remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.amf.user.profile.service.impl.FavoriteGenreServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.amf.user.profile.service.impl.FavoriteGenreServiceImpl
 * @generated
 */
public abstract class BasicInfoServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, BasicInfoService, IdentifiableOSGiService {

	protected BasicInfoService basicInfoService;

	@Reference
	protected BasicInfoLocalService basicInfoLocalService;

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			BasicInfoService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		basicInfoService = (BasicInfoService)aopProxy;

		_setServiceUtilService(basicInfoService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return FavoriteGenreService.class.getName();
	}

	protected Class<?> getModelClass() {
		return BasicInfo.class;
	}

	protected String getModelClassName() {
		return BasicInfo.class.getName();
	}

	private void _setServiceUtilService(
		BasicInfoService basicInfoService) {

		try {
			Field field = BasicInfoServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, basicInfoService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}


}