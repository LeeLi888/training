create table AmfEventMonitor_Assignment (
	uuid_ VARCHAR(75) null,
	assignmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	description STRING null,
	dueDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table AmfEventMonitor_Event (
	eventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	eventType VARCHAR(75) null,
	clientIp VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);