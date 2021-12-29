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

package com.amf.newsletter.service.impl;

import com.amf.newsletter.model.Newsletter;
import com.amf.newsletter.service.base.NewsletterLocalServiceBaseImpl;

import com.amf.newsletter.util.AmfDateUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.*;
import org.osgi.service.component.annotations.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.amf.newsletter.model.Newsletter",
	service = AopService.class
)
public class NewsletterLocalServiceImpl extends NewsletterLocalServiceBaseImpl {

	public List<Newsletter> getNewslettersByYearmonth(int year, int month) {
		Date start = AmfDateUtil.getStartDay(year, month);
		Date end = AmfDateUtil.getEndDay(year, month);

		DynamicQuery query = newsletterLocalService.dynamicQuery();
		query.add(RestrictionsFactoryUtil.between("issueDate", start, end));
		query.addOrder(OrderFactoryUtil.desc("issueDate"));

		List<Newsletter> list = newsletterLocalService.dynamicQuery(query);

		return list;
	}

}