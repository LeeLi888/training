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

package com.amf.user.profile.service.impl;

import com.amf.user.profile.constants.AmfActionKeys;
import com.amf.user.profile.constants.UserProfileConstants;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.model.impl.GeneralProfileImpl;
import com.amf.user.profile.service.base.MovieInterestServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.NoSuchResourcePermissionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=userprofile",
		"json.web.service.context.path=MovieInterest"
	},
	service = AopService.class
)
public class MovieInterestServiceImpl extends MovieInterestServiceBaseImpl {

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(model.class.name=com.amf.user.profile.model.MovieInterest)"
	)
	private volatile ModelResourcePermission<MovieInterest> modelResourcePermission;

	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(resource.name=" + UserProfileConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission portletResourcePermission;

	public MovieInterest getMovieInterestByUserId(
			long userId) throws PortalException {

		MovieInterest movieInterest = movieInterestLocalService.getMovieInterestByUserId(userId);

//		if (movieInterest != null) {
//			modelResourcePermission.check(
//					getPermissionChecker(), movieInterest, AmfActionKeys.VIEW_MOVIE_INTEREST);
//		}

		return movieInterest;
	}

	public MovieInterest addMovieInterest(
			long userId,
			String favoriteMovie,
			long favoriteGenreId,
			String leastFavoriteMovie,
			String favoriteActor,
			ServiceContext serviceContext) throws PortalException {

//		portletResourcePermission.check(
//				getPermissionChecker(), serviceContext.getScopeGroupId(),
//				ActionKeys.ADD_ENTRY);

		MovieInterest movieInterest = movieInterestLocalService.addMovieInterest(userId, favoriteMovie, favoriteGenreId, leastFavoriteMovie, favoriteActor, serviceContext);

		return movieInterest;
	}

	public MovieInterest updateMovieInterest(
			long movieInterestId,
			String favoriteMovie,
			long favoriteGenreId,
			String leastFavoriteMovie,
			String favoriteActor,
			ServiceContext serviceContext) throws PortalException {

//		modelResourcePermission.check(
//				getPermissionChecker(), movieInterestId, ActionKeys.UPDATE);

		MovieInterest movieInterest = movieInterestLocalService.updateMovieInterest(movieInterestId, favoriteMovie, favoriteGenreId, leastFavoriteMovie, favoriteActor, serviceContext);

		return movieInterest;
	}


}