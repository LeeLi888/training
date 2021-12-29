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

package com.amf.newsletter.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ArticlePK implements Comparable<ArticlePK>, Serializable {

	public int issueNumber;
	public int order;

	public ArticlePK() {
	}

	public ArticlePK(int issueNumber, int order) {
		this.issueNumber = issueNumber;
		this.order = order;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int compareTo(ArticlePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (issueNumber < pk.issueNumber) {
			value = -1;
		}
		else if (issueNumber > pk.issueNumber) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (order < pk.order) {
			value = -1;
		}
		else if (order > pk.order) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ArticlePK)) {
			return false;
		}

		ArticlePK pk = (ArticlePK)object;

		if ((issueNumber == pk.issueNumber) && (order == pk.order)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, issueNumber);
		hashCode = HashUtil.hash(hashCode, order);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("issueNumber=");

		sb.append(issueNumber);
		sb.append(", order=");

		sb.append(order);

		sb.append("}");

		return sb.toString();
	}

}