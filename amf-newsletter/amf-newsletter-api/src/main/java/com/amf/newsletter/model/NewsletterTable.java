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

package com.amf.newsletter.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AmfNewsletter_Newsletter&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
public class NewsletterTable extends BaseTable<NewsletterTable> {

	public static final NewsletterTable INSTANCE = new NewsletterTable();

	public final Column<NewsletterTable, Long> issueNumber = createColumn(
		"issueNumber", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NewsletterTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NewsletterTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NewsletterTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NewsletterTable, Date> issueDate = createColumn(
		"issueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NewsletterTable, String> byline = createColumn(
		"byline", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NewsletterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NewsletterTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NewsletterTable, String> journalArticleId =
		createColumn(
			"journalArticleId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private NewsletterTable() {
		super("AmfNewsletter_Newsletter", NewsletterTable::new);
	}

}