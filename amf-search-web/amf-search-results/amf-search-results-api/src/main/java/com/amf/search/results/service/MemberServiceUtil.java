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

package com.amf.search.results.service;

import com.amf.search.results.model.Member;

import java.util.List;

/**
 * Provides the remote service utility for Member. This utility wraps
 * <code>com.amf.search.results.service.impl.MemberServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MemberService
 * @generated
 */
public class MemberServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.search.results.service.impl.MemberServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static long getEventsCountByCompanyIdAndZipCode(
		long companyId, String zipCode) {

		return getService().getEventsCountByCompanyIdAndZipCode(
			companyId, zipCode);
	}

	public static List<Member> getMembersByCompanyIdAndZipCode(
		long companyId, String zipCode, int start, int end) {

		return getService().getMembersByCompanyIdAndZipCode(
			companyId, zipCode, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MemberService getService() {
		return _service;
	}

	private static volatile MemberService _service;

}