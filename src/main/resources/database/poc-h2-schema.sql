/*
ADMIN
*/
CREATE TABLE ADMIN_USER (
    ID BIGINT IDENTITY not null,
	NAME varchar (100)  NULL  DEFAULT '',
	PASSWORD varchar (100)  DEFAULT '',
	FULL_NAME varchar (255)  NULL  DEFAULT '',
	USER_TYPE varchar (64)  NULL  DEFAULT '',
	FORBIDDEN BOOLEAN NULL  DEFAULT FALSE,
	LOCKED BOOLEAN NULL DEFAULT FALSE,
	CREATED_TIME TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	LOGON_TIME TIMESTAMP NULL ,
	LOGOUT_TIME TIMESTAMP NULL ,
	TRIED_TIMES int NOT NULL DEFAULT 0,
	IS_ADMIN BOOLEAN NOT NULL DEFAULT FALSE,
	primary key (ID)	
);

create table ADMIN_ROLE (
    ID BIGINT IDENTITY not null,
    Name varchar(100) NOT null DEFAULT '',
    DESCRIPTION varchar(256) NOT null DEFAULT '',
    SORT_ORDER int not null DEFAULT 0,
    primary key (ID)
);

create table ADMIN_SYSTEM_CATEGORY (
    ID BIGINT IDENTITY not null,
    Name varchar(100) NOT null DEFAULT '',
    DESCRIPTION varchar(256) NOT null DEFAULT '',
    SORT_ORDER int not null DEFAULT 0,
    primary key (ID)
);

create table ADMIN_SYSTEM (
    ID BIGINT IDENTITY not null,
    Name varchar(100) NOT null DEFAULT '',
    DESCRIPTION varchar(256) NOT null DEFAULT '',
    ICON varchar(256) NOT null DEFAULT '',
    URL varchar(256) NOT null DEFAULT '',
    CATEGORY_ID BIGINT not null DEFAULT 0,
    SORT_ORDER int not null DEFAULT 0,
    primary key (ID)
);

ALTER TABLE ADMIN_SYSTEM ADD CONSTRAINT
	FK_ADMIN_SYSTEM_CATEGORY_ID FOREIGN KEY (CATEGORY_ID)
	REFERENCES ADMIN_SYSTEM_CATEGORY (ID)
	ON UPDATE RESTRICT ON DELETE CASCADE;


CREATE TABLE ADMIN_USER_ROLE (
	USER_ID BIGINT NOT NULL ,
	ROLE_ID BIGINT NOT NULL,
	primary key (USER_ID,ROLE_ID)	
); 

CREATE INDEX I_ADMIN_USER_ROLE_USER_ID ON ADMIN_USER_ROLE(USER_ID);
CREATE INDEX I_ADMIN_USER_ROLE_ROLE_ID ON ADMIN_USER_ROLE(ROLE_ID);

CREATE TABLE ADMIN_SYSTEM_ROLE (
	SYSTEM_ID BIGINT NOT NULL ,
	ROLE_ID BIGINT NOT NULL,
	primary key (SYSTEM_ID,ROLE_ID)	
);
CREATE INDEX I_ADMIN_SYSTEM_ROLE_SYSTEM_ID ON ADMIN_SYSTEM_ROLE(SYSTEM_ID);
CREATE INDEX I_ADMIN_SYSTEM_ROLE_ROLE_ID ON ADMIN_SYSTEM_ROLE(ROLE_ID);


create table Users (
    UserId int not null,
    UserName varchar(80) null,
    Gender varchar(1) not null,
    Dob date not null,
    constraint pk_Users primary key (UserId)
);

create table Orders (
    orderNo int IDENTITY not null,
    productName varchar(80) null,
    price decimal(10,2) not null,
    qty int not null
);





CREATE TABLE dbo.GEN_CODES (
	CODE_ID decimal(18, 0) NOT NULL ,
	CODE_NAME varchar (100)  NULL ,
	REMARK varchar (2000)  NULL 
) ON PRIMARY
GO

CREATE TABLE dbo.GEN_CODE_CHOICES (
	CHOICE_ID decimal(18, 0) NOT NULL ,
	CODE_ID decimal(18, 0) NULL ,
	CHOICE_CODE varchar (255)  NULL ,
	ECHOICE varchar (255)  NULL ,
	CCHOICE varchar (255)  NULL ,
	SORTORDER int NULL ,
	REMARK varchar (2000)  NULL 
) ON PRIMARY
GO

CREATE TABLE dbo.GEN_CODE_CHOICES2 (
	CHOICE2_ID decimal(18, 0) NOT NULL ,
	CHOICE_ID decimal(18, 0) NULL ,
	CHOICE2_CODE varchar (255)  NULL ,
	ECHOICE2 varchar (255)  NULL ,
	CCHOICE2 varchar (255)  NULL ,
	SORTORDER int NOT NULL 
) ON PRIMARY
GO



CREATE TABLE sequence
(
    name               varchar(30)  not null,
    nextid             int          not null,
    constraint pk_sequence primary key (name)
);
