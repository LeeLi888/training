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

package com.amf.user.profile.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AmfUserProfile_MovieInterest&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MovieInterest
 * @generated
 */
public class MovieInterestTable extends BaseTable<MovieInterestTable> {

	public static final MovieInterestTable INSTANCE = new MovieInterestTable();

	public final Column<MovieInterestTable, Long> movieInterestId =
		createColumn(
			"movieInterestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MovieInterestTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, String> favoriteMovie =
		createColumn(
			"favoriteMovie", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, Long> favoriteGenreId =
		createColumn(
			"favoriteGenreId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, String> leastFavoriteMovie =
		createColumn(
			"leastFavoriteMovie", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<MovieInterestTable, String> favoriteActor =
		createColumn(
			"favoriteActor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private MovieInterestTable() {
		super("AmfUserProfile_MovieInterest", MovieInterestTable::new);
	}

}