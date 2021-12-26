create index IX_A0B286FC on AmfUserProfile_GeneralProfile (userId);

create index IX_2CB4DDFF on AmfUserProfile_MovieInterest (userId);

create index IX_C77FD93A on UserProfile_GeneralProfile (companyId, userId);
create index IX_5268CA62 on UserProfile_GeneralProfile (userId);

create index IX_610A0D63 on UserProfile_MovieInterest (companyId, userId);
create index IX_C71595D9 on UserProfile_MovieInterest (userId);