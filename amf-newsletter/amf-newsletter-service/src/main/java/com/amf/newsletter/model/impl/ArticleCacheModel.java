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

import com.amf.newsletter.model.Article;
import com.amf.newsletter.service.persistence.ArticlePK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Article in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ArticleCacheModel implements CacheModel<Article>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ArticleCacheModel)) {
			return false;
		}

		ArticleCacheModel articleCacheModel = (ArticleCacheModel)object;

		if (articlePK.equals(articleCacheModel.articlePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, articlePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{issueNumber=");
		sb.append(issueNumber);
		sb.append(", order=");
		sb.append(order);
		sb.append(", title=");
		sb.append(title);
		sb.append(", author=");
		sb.append(author);
		sb.append(", content=");
		sb.append(content);
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
	public Article toEntityModel() {
		ArticleImpl articleImpl = new ArticleImpl();

		articleImpl.setIssueNumber(issueNumber);
		articleImpl.setOrder(order);

		if (title == null) {
			articleImpl.setTitle("");
		}
		else {
			articleImpl.setTitle(title);
		}

		if (author == null) {
			articleImpl.setAuthor("");
		}
		else {
			articleImpl.setAuthor(author);
		}

		if (content == null) {
			articleImpl.setContent("");
		}
		else {
			articleImpl.setContent(content);
		}

		if (createDate == Long.MIN_VALUE) {
			articleImpl.setCreateDate(null);
		}
		else {
			articleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			articleImpl.setModifiedDate(null);
		}
		else {
			articleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (journalArticleId == null) {
			articleImpl.setJournalArticleId("");
		}
		else {
			articleImpl.setJournalArticleId(journalArticleId);
		}

		articleImpl.resetOriginalValues();

		return articleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		issueNumber = objectInput.readInt();

		order = objectInput.readInt();
		title = objectInput.readUTF();
		author = objectInput.readUTF();
		content = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		journalArticleId = objectInput.readUTF();

		articlePK = new ArticlePK(issueNumber, order);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(issueNumber);

		objectOutput.writeInt(order);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
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
	public int order;
	public String title;
	public String author;
	public String content;
	public long createDate;
	public long modifiedDate;
	public String journalArticleId;
	public transient ArticlePK articlePK;

}