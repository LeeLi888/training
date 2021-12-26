create table AmfMember_Member (
	memberId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	zipCode VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	screenName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);