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

package com.amf.search.results.service.impl;

import com.amf.search.results.model.Member;
import com.amf.search.results.service.MemberLocalService;
import com.amf.search.results.service.base.MemberServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=amfmember",
		"json.web.service.context.path=Member"
	},
	service = AopService.class
)
public class MemberServiceImpl extends MemberServiceBaseImpl {

	@Reference
	private MemberLocalService _memberLocalService;

	public List<Member> getMembersByCompanyIdAndZipCode(long companyId, String zipCode, int start, int end) {
		return _memberLocalService.getMembersByCompanyIdAndZipCode(companyId, zipCode, start, end);
	}

	public long getEventsCountByCompanyIdAndZipCode(long companyId, String zipCode) {
		return _memberLocalService.getEventsCountByCompanyIdAndZipCode(companyId, zipCode);
	}

}