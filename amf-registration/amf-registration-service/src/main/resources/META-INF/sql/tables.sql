create table AmfRegistration_UserExternal (
	userExternalId LONG not null primary key,
	companyId LONG,
	userId LONG,
	male INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);