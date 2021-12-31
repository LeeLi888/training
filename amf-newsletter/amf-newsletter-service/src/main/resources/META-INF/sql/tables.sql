create table AmfNewsletter_Article (
	articleId LONG not null primary key,
	issueNumber LONG,
	order_ LONG,
	companyId LONG,
	title TEXT null,
	author VARCHAR(75) null,
	content TEXT null,
	createDate DATE null,
	modifiedDate DATE null,
	journalArticleId VARCHAR(75) null
);

create table AmfNewsletter_Newsletter (
	issueNumber LONG not null primary key,
	companyId LONG,
	title TEXT null,
	description TEXT null,
	issueDate DATE null,
	byline VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	journalArticleId VARCHAR(75) null
);