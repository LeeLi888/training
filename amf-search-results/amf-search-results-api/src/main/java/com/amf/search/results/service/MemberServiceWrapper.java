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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MemberService}.
 *
 * @author Brian Wing Shun Chan
 * @see MemberService
 * @generated
 */
public class MemberServiceWrapper
	implements MemberService, ServiceWrapper<MemberService> {

	public MemberServiceWrapper(MemberService memberService) {
		_memberService = memberService;
	}

	@Override
	public long getEventsCountByCompanyIdAndZipCode(
		long companyId, String zipCode) {

		return _memberService.getEventsCountByCompanyIdAndZipCode(
			companyId, zipCode);
	}

	@Override
	public java.util.List<com.amf.search.results.model.Member>
		getMembersByCompanyIdAndZipCode(
			long companyId, String zipCode, int start, int end) {

		return _memberService.getMembersByCompanyIdAndZipCode(
			companyId, zipCode, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _memberService.getOSGiServiceIdentifier();
	}

	@Override
	public MemberService getWrappedService() {
		return _memberService;
	}

	@Override
	public void setWrappedService(MemberService memberService) {
		_memberService = memberService;
	}

	private MemberService _memberService;

}