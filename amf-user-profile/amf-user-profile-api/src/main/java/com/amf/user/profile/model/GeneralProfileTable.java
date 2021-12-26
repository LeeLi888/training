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
 * The table class for the &quot;AmfUserProfile_GeneralProfile&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see GeneralProfile
 * @generated
 */
public class GeneralProfileTable extends BaseTable<GeneralProfileTable> {

	public static final GeneralProfileTable INSTANCE =
		new GeneralProfileTable();

	public final Column<GeneralProfileTable, Long> generalProfileId =
		createColumn(
			"generalProfileId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<GeneralProfileTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GeneralProfileTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GeneralProfileTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GeneralProfileTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GeneralProfileTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GeneralProfileTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GeneralProfileTable, String> aboutMe = createColumn(
		"aboutMe", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GeneralProfileTable, String> favoriteQuotes =
		createColumn(
			"favoriteQuotes", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private GeneralProfileTable() {
		super("AmfUserProfile_GeneralProfile", GeneralProfileTable::new);
	}

}