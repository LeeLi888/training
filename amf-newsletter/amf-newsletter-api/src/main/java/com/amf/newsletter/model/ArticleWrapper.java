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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Article}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @generated
 */
public class ArticleWrapper
	extends BaseModelWrapper<Article>
	implements Article, ModelWrapper<Article> {

	public ArticleWrapper(Article article) {
		super(article);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("articleId", getArticleId());
		attributes.put("issueNumber", getIssueNumber());
		attributes.put("order", getOrder());
		attributes.put("companyId", getCompanyId());
		attributes.put("title", getTitle());
		attributes.put("author", getAuthor());
		attributes.put("content", getContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("journalArticleId", getJournalArticleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long issueNumber = (Long)attributes.get("issueNumber");

		if (issueNumber != null) {
			setIssueNumber(issueNumber);
		}

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String journalArticleId = (String)attributes.get("journalArticleId");

		if (journalArticleId != null) {
			setJournalArticleId(journalArticleId);
		}
	}

	@Override
	public Article cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the article ID of this article.
	 *
	 * @return the article ID of this article
	 */
	@Override
	public long getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the author of this article.
	 *
	 * @return the author of this article
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the company ID of this article.
	 *
	 * @return the company ID of this article
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this article.
	 *
	 * @return the content of this article
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this article.
	 *
	 * @return the create date of this article
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the issue number of this article.
	 *
	 * @return the issue number of this article
	 */
	@Override
	public long getIssueNumber() {
		return model.getIssueNumber();
	}

	/**
	 * Returns the journal article ID of this article.
	 *
	 * @return the journal article ID of this article
	 */
	@Override
	public String getJournalArticleId() {
		return model.getJournalArticleId();
	}

	/**
	 * Returns the modified date of this article.
	 *
	 * @return the modified date of this article
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the order of this article.
	 *
	 * @return the order of this article
	 */
	@Override
	public long getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this article.
	 *
	 * @return the primary key of this article
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this article.
	 *
	 * @return the title of this article
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the article ID of this article.
	 *
	 * @param articleId the article ID of this article
	 */
	@Override
	public void setArticleId(long articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the author of this article.
	 *
	 * @param author the author of this article
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	/**
	 * Sets the company ID of this article.
	 *
	 * @param companyId the company ID of this article
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this article.
	 *
	 * @param content the content of this article
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this article.
	 *
	 * @param createDate the create date of this article
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the issue number of this article.
	 *
	 * @param issueNumber the issue number of this article
	 */
	@Override
	public void setIssueNumber(long issueNumber) {
		model.setIssueNumber(issueNumber);
	}

	/**
	 * Sets the journal article ID of this article.
	 *
	 * @param journalArticleId the journal article ID of this article
	 */
	@Override
	public void setJournalArticleId(String journalArticleId) {
		model.setJournalArticleId(journalArticleId);
	}

	/**
	 * Sets the modified date of this article.
	 *
	 * @param modifiedDate the modified date of this article
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the order of this article.
	 *
	 * @param order the order of this article
	 */
	@Override
	public void setOrder(long order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this article.
	 *
	 * @param primaryKey the primary key of this article
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this article.
	 *
	 * @param title the title of this article
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	protected ArticleWrapper wrap(Article article) {
		return new ArticleWrapper(article);
	}

}