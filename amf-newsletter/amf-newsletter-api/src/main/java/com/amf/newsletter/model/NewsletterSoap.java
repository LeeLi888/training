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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.newsletter.service.http.NewsletterServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class NewsletterSoap implements Serializable {

	public static NewsletterSoap toSoapModel(Newsletter model) {
		NewsletterSoap soapModel = new NewsletterSoap();

		soapModel.setIssueNumber(model.getIssueNumber());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setByline(model.getByline());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setJournalArticleId(model.getJournalArticleId());

		return soapModel;
	}

	public static NewsletterSoap[] toSoapModels(Newsletter[] models) {
		NewsletterSoap[] soapModels = new NewsletterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsletterSoap[][] toSoapModels(Newsletter[][] models) {
		NewsletterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NewsletterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsletterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsletterSoap[] toSoapModels(List<Newsletter> models) {
		List<NewsletterSoap> soapModels = new ArrayList<NewsletterSoap>(
			models.size());

		for (Newsletter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsletterSoap[soapModels.size()]);
	}

	public NewsletterSoap() {
	}

	public long getPrimaryKey() {
		return _issueNumber;
	}

	public void setPrimaryKey(long pk) {
		setIssueNumber(pk);
	}

	public long getIssueNumber() {
		return _issueNumber;
	}

	public void setIssueNumber(long issueNumber) {
		_issueNumber = issueNumber;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public String getByline() {
		return _byline;
	}

	public void setByline(String byline) {
		_byline = byline;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getJournalArticleId() {
		return _journalArticleId;
	}

	public void setJournalArticleId(String journalArticleId) {
		_journalArticleId = journalArticleId;
	}

	private long _issueNumber;
	private long _companyId;
	private String _title;
	private String _description;
	private Date _issueDate;
	private String _byline;
	private Date _createDate;
	private Date _modifiedDate;
	private String _journalArticleId;

}