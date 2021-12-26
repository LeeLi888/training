create table AmfUserProfile_FavoriteGenre (
	favoriteGenreId LONG not null primary key,
	favoriteGenreName VARCHAR(75) null
);

create table AmfUserProfile_GeneralProfile (
	generalProfileId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	aboutMe VARCHAR(75) null,
	favoriteQuotes VARCHAR(75) null
);

create table AmfUserProfile_MovieInterest (
	movieInterestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	favoriteMovie VARCHAR(75) null,
	favoriteGenreId LONG,
	leastFavoriteMovie VARCHAR(75) null,
	favoriteActor VARCHAR(75) null
);

create table UserProfile_FavoriteGenre (
	favoriteGenreId LONG not null primary key,
	favoriteGenreName VARCHAR(75) null
);

create table UserProfile_GeneralProfile (
	generalProfileId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	aboutMe VARCHAR(75) null,
	favoriteQuotes VARCHAR(75) null
);

create table UserProfile_MovieInterest (
	movieInterestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	favoriteMovie VARCHAR(75) null,
	favoriteGenreId LONG,
	leastFavoriteMovie VARCHAR(75) null,
	favoriteActor VARCHAR(75) null
);