create table AmfNewsletter_Article (
	issueNumber INTEGER not null,
	order_ INTEGER not null,
	title TEXT null,
	author VARCHAR(75) null,
	content TEXT null,
	createDate DATE null,
	modifiedDate DATE null,
	journalArticleId VARCHAR(75) null,
	primary key (issueNumber, order_)
);

create table AmfNewsletter_Newsletter (
	issueNumber INTEGER not null primary key,
	title TEXT null,
	description TEXT null,
	issueDate DATE null,
	byline VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	journalArticleId VARCHAR(75) null
);