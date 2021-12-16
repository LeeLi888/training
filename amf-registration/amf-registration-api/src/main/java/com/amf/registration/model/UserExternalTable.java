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

package com.amf.registration.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AmfRegistration_UserExternal&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserExternal
 * @generated
 */
public class UserExternalTable extends BaseTable<UserExternalTable> {

	public static final UserExternalTable INSTANCE = new UserExternalTable();

	public final Column<UserExternalTable, Long> userExternalId = createColumn(
		"userExternalId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserExternalTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserExternalTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserExternalTable, Integer> male = createColumn(
		"male", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<UserExternalTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserExternalTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private UserExternalTable() {
		super("AmfRegistration_UserExternal", UserExternalTable::new);
	}

}