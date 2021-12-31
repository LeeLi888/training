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
 * This class is a wrapper for {@link Newsletter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
public class NewsletterWrapper
	extends BaseModelWrapper<Newsletter>
	implements ModelWrapper<Newsletter>, Newsletter {

	public NewsletterWrapper(Newsletter newsletter) {
		super(newsletter);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("issueNumber", getIssueNumber());
		attributes.put("companyId", getCompanyId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("issueDate", getIssueDate());
		attributes.put("byline", getByline());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("journalArticleId", getJournalArticleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long issueNumber = (Long)attributes.get("issueNumber");

		if (issueNumber != null) {
			setIssueNumber(issueNumber);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		String byline = (String)attributes.get("byline");

		if (byline != null) {
			setByline(byline);
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
	public Newsletter cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the byline of this newsletter.
	 *
	 * @return the byline of this newsletter
	 */
	@Override
	public String getByline() {
		return model.getByline();
	}

	/**
	 * Returns the company ID of this newsletter.
	 *
	 * @return the company ID of this newsletter
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this newsletter.
	 *
	 * @return the create date of this newsletter
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this newsletter.
	 *
	 * @return the description of this newsletter
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the issue date of this newsletter.
	 *
	 * @return the issue date of this newsletter
	 */
	@Override
	public Date getIssueDate() {
		return model.getIssueDate();
	}

	/**
	 * Returns the issue number of this newsletter.
	 *
	 * @return the issue number of this newsletter
	 */
	@Override
	public long getIssueNumber() {
		return model.getIssueNumber();
	}

	/**
	 * Returns the journal article ID of this newsletter.
	 *
	 * @return the journal article ID of this newsletter
	 */
	@Override
	public String getJournalArticleId() {
		return model.getJournalArticleId();
	}

	/**
	 * Returns the modified date of this newsletter.
	 *
	 * @return the modified date of this newsletter
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this newsletter.
	 *
	 * @return the primary key of this newsletter
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this newsletter.
	 *
	 * @return the title of this newsletter
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
	 * Sets the byline of this newsletter.
	 *
	 * @param byline the byline of this newsletter
	 */
	@Override
	public void setByline(String byline) {
		model.setByline(byline);
	}

	/**
	 * Sets the company ID of this newsletter.
	 *
	 * @param companyId the company ID of this newsletter
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this newsletter.
	 *
	 * @param createDate the create date of this newsletter
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this newsletter.
	 *
	 * @param description the description of this newsletter
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the issue date of this newsletter.
	 *
	 * @param issueDate the issue date of this newsletter
	 */
	@Override
	public void setIssueDate(Date issueDate) {
		model.setIssueDate(issueDate);
	}

	/**
	 * Sets the issue number of this newsletter.
	 *
	 * @param issueNumber the issue number of this newsletter
	 */
	@Override
	public void setIssueNumber(long issueNumber) {
		model.setIssueNumber(issueNumber);
	}

	/**
	 * Sets the journal article ID of this newsletter.
	 *
	 * @param journalArticleId the journal article ID of this newsletter
	 */
	@Override
	public void setJournalArticleId(String journalArticleId) {
		model.setJournalArticleId(journalArticleId);
	}

	/**
	 * Sets the modified date of this newsletter.
	 *
	 * @param modifiedDate the modified date of this newsletter
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this newsletter.
	 *
	 * @param primaryKey the primary key of this newsletter
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this newsletter.
	 *
	 * @param title the title of this newsletter
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	protected NewsletterWrapper wrap(Newsletter newsletter) {
		return new NewsletterWrapper(newsletter);
	}

}