create index IX_7EBF776C on AmfEventMonitor_Assignment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F256E8EE on AmfEventMonitor_Assignment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_AFDA0CD7 on AmfEventMonitor_Event (companyId, eventType[$COLUMN_LENGTH:75$]);
create index IX_E36E495D on AmfEventMonitor_Event (companyId, userId, eventType[$COLUMN_LENGTH:75$]);