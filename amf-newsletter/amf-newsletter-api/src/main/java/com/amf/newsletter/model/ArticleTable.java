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
 * The table class for the &quot;AmfNewsletter_Article&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @generated
 */
public class ArticleTable extends BaseTable<ArticleTable> {

	public static final ArticleTable INSTANCE = new ArticleTable();

	public final Column<ArticleTable, Integer> issueNumber = createColumn(
		"issueNumber", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<ArticleTable, Integer> order = createColumn(
		"order_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<ArticleTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, String> author = createColumn(
		"author", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, String> content = createColumn(
		"content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, String> journalArticleId = createColumn(
		"journalArticleId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ArticleTable() {
		super("AmfNewsletter_Article", ArticleTable::new);
	}

}