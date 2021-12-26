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

package com.amf.user.profile.service;

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.FavoriteGenre;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Provides the local service utility for FavoriteGenre. This utility wraps
 * <code>com.amf.user.profile.service.impl.FavoriteGenreLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FavoriteGenreLocalService
 * @generated
 */
public class BasicInfoLocalServiceUtil {

	public static BasicInfo getBasicInfo(long userId) throws PortalException {
		return getService().getBasicInfo(userId);
	}

	public static BasicInfo updateBasicInfo(
			long userId,
			String firstName,
			String lastName,
			boolean male,
			Date birthDay,
			ServiceContext serviceContext
	) throws PortalException {
		return getService().updateBasicInfo(userId, firstName, lastName, male, birthDay, serviceContext);
	}

	public static BasicInfoLocalService getService() {
		return _service;
	}

	private static volatile BasicInfoLocalService _service;

}