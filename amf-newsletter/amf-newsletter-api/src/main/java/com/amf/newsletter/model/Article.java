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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Article service. Represents a row in the &quot;AmfNewsletter_Article&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleModel
 * @generated
 */
@ImplementationClassName("com.amf.newsletter.model.impl.ArticleImpl")
@ProviderType
public interface Article extends ArticleModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.amf.newsletter.model.impl.ArticleImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Article, Integer> ISSUE_NUMBER_ACCESSOR =
		new Accessor<Article, Integer>() {

			@Override
			public Integer get(Article article) {
				return article.getIssueNumber();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<Article> getTypeClass() {
				return Article.class;
			}

		};
	public static final Accessor<Article, Integer> ORDER_ACCESSOR =
		new Accessor<Article, Integer>() {

			@Override
			public Integer get(Article article) {
				return article.getOrder();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<Article> getTypeClass() {
				return Article.class;
			}

		};

}