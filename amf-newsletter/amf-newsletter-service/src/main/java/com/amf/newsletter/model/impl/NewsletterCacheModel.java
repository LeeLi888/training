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

package com.amf.newsletter.model.impl;

import com.amf.newsletter.model.Newsletter;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Newsletter in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NewsletterCacheModel
	implements CacheModel<Newsletter>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NewsletterCacheModel)) {
			return false;
		}

		NewsletterCacheModel newsletterCacheModel =
			(NewsletterCacheModel)object;

		if (issueNumber == newsletterCacheModel.issueNumber) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, issueNumber);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{issueNumber=");
		sb.append(issueNumber);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", byline=");
		sb.append(byline);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", journalArticleId=");
		sb.append(journalArticleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Newsletter toEntityModel() {
		NewsletterImpl newsletterImpl = new NewsletterImpl();

		newsletterImpl.setIssueNumber(issueNumber);

		if (title == null) {
			newsletterImpl.setTitle("");
		}
		else {
			newsletterImpl.setTitle(title);
		}

		if (description == null) {
			newsletterImpl.setDescription("");
		}
		else {
			newsletterImpl.setDescription(description);
		}

		if (issueDate == Long.MIN_VALUE) {
			newsletterImpl.setIssueDate(null);
		}
		else {
			newsletterImpl.setIssueDate(new Date(issueDate));
		}

		if (byline == null) {
			newsletterImpl.setByline("");
		}
		else {
			newsletterImpl.setByline(byline);
		}

		if (createDate == Long.MIN_VALUE) {
			newsletterImpl.setCreateDate(null);
		}
		else {
			newsletterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			newsletterImpl.setModifiedDate(null);
		}
		else {
			newsletterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (journalArticleId == null) {
			newsletterImpl.setJournalArticleId("");
		}
		else {
			newsletterImpl.setJournalArticleId(journalArticleId);
		}

		newsletterImpl.resetOriginalValues();

		return newsletterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		issueNumber = objectInput.readInt();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		issueDate = objectInput.readLong();
		byline = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		journalArticleId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(issueNumber);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(issueDate);

		if (byline == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(byline);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (journalArticleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(journalArticleId);
		}
	}

	public int issueNumber;
	public String title;
	public String description;
	public long issueDate;
	public String byline;
	public long createDate;
	public long modifiedDate;
	public String journalArticleId;

}