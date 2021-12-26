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

package com.amf.search.results.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AmfMember_Member&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Member
 * @generated
 */
public class MemberTable extends BaseTable<MemberTable> {

	public static final MemberTable INSTANCE = new MemberTable();

	public final Column<MemberTable, Long> memberId = createColumn(
		"memberId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MemberTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MemberTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MemberTable, String> zipCode = createColumn(
		"zipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemberTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemberTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemberTable, String> screenName = createColumn(
		"screenName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemberTable, String> emailAddress = createColumn(
		"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MemberTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MemberTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private MemberTable() {
		super("AmfMember_Member", MemberTable::new);
	}

}