if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_GEN_CODE_CHOICES_GEN_CODES]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[GEN_CODE_CHOICES] DROP CONSTRAINT FK_GEN_CODE_CHOICES_GEN_CODES
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_GEN_CODE_CHOICES2_GEN_CODE_CHOICES]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[GEN_CODE_CHOICES2] DROP CONSTRAINT FK_GEN_CODE_CHOICES2_GEN_CODE_CHOICES
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_LOGS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_LOGS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_ROLES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_ROLES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_SYSTEMS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_SYSTEMS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_SYSTEM_PAGES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_SYSTEM_PAGES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_SYSTEM_ROLE]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_SYSTEM_ROLE]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_SYSTEM_TYPES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_SYSTEM_TYPES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_USERS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_USERS]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ADMIN_USER_ROLE]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ADMIN_USER_ROLE]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[GEN_CODES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[GEN_CODES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[GEN_CODE_CHOICES]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[GEN_CODE_CHOICES]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[GEN_CODE_CHOICES2]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[GEN_CODE_CHOICES2]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PK]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PK]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[SYS_PARAS]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[SYS_PARAS]
GO

CREATE TABLE [dbo].[ADMIN_LOGS] (
	[USER_ID] [decimal](18, 0) NULL ,
	[IS_SUCCESS] [bit] NULL ,
	[LOGON_TIME] [datetime] NULL ,
	[LOGOUT_TIME] [datetime] NULL ,
	[VISITED_URL] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ADMIN_ROLES] (
	[ROLE_ID] [decimal](18, 0) NOT NULL ,
	[ROLE_NAME] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ADMIN_SYSTEMS] (
	[SYSTEM_ID] [decimal](18, 0) NOT NULL ,
	[TYPE_ID] [decimal](18, 0) NULL ,
	[SYSTEM_NAME] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[SYSTEM_FULLNAME] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[ENTRY_PAGE] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[ACCESS_ROLES] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[SORT_ORDER] [int] NULL ,
	[IMAGE_PATH] [varchar] (128) COLLATE Chinese_PRC_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ADMIN_SYSTEM_PAGES] (
	[PAGE_ID] [decimal](18, 0) NOT NULL ,
	[SYSTEM_ID] [decimal](18, 0) NULL ,
	[PAGE_URL] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[BROWSE_ROLES] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[ADD_ROLES] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[UPDATE_ROLES] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[DELETE_ROLES] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[FULL_ACCESS_ROLES] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ADMIN_SYSTEM_ROLE] (
	[SYSTEM_ID] [decimal](18, 0) NOT NULL ,
	[ROLE_ID] [decimal](18, 0) NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ADMIN_SYSTEM_TYPES] (
	[TYPE_ID] [decimal](18, 0) NOT NULL ,
	[TYPE_NAME] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[SORT_ORDER] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ADMIN_USERS] (
	[USER_ID] [decimal](18, 0) NOT NULL ,
	[USER_NAME] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[FULL_NAME] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[PASSWORD] [int] NULL ,
	[USER_TYPE] [varchar] (64) COLLATE Chinese_PRC_CI_AS NULL ,
	[ROLES] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL ,
	[FORBID] [bit] NULL ,
	[LOCKED] [bit] NULL ,
	[CREATE_TIME] [datetime] NULL ,
	[LOGON_TIME] [datetime] NULL ,
	[LOGOUT_TIME] [datetime] NULL ,
	[TRY_TIMES] [decimal](2, 0) NULL ,
	[IS_ADMIN] [bit] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ADMIN_USER_ROLE] (
	[USER_ID] [decimal](18, 0) NOT NULL ,
	[ROLE_ID] [decimal](18, 0) NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[GEN_CODES] (
	[CODE_ID] [decimal](18, 0) NOT NULL ,
	[CODE_NAME] [varchar] (100) COLLATE Chinese_PRC_CI_AS NULL ,
	[REMARK] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[GEN_CODE_CHOICES] (
	[CHOICE_ID] [decimal](18, 0) NOT NULL ,
	[CODE_ID] [decimal](18, 0) NULL ,
	[CHOICE_CODE] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[ECHOICE] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[CCHOICE] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[SORTORDER] [int] NULL ,
	[REMARK] [varchar] (2000) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[GEN_CODE_CHOICES2] (
	[CHOICE2_ID] [decimal](18, 0) NOT NULL ,
	[CHOICE_ID] [decimal](18, 0) NULL ,
	[CHOICE2_CODE] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[ECHOICE2] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[CCHOICE2] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[SORTORDER] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PK] (
	[PK] [decimal](18, 0) NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[SYS_PARAS] (
	[PARA_ID] [decimal](18, 0) NOT NULL ,
	[NAME] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL ,
	[VALUE] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ADMIN_ROLES] WITH NOCHECK ADD 
	CONSTRAINT [PK_ADMIN_ROLES] PRIMARY KEY  CLUSTERED 
	(
		[ROLE_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[ADMIN_SYSTEM_PAGES] WITH NOCHECK ADD 
	CONSTRAINT [PK_ADMIN_SYSTEM_PAGES] PRIMARY KEY  CLUSTERED 
	(
		[PAGE_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[ADMIN_SYSTEM_TYPES] WITH NOCHECK ADD 
	CONSTRAINT [PK_ADMIN_SYSTEM_TYPES] PRIMARY KEY  CLUSTERED 
	(
		[TYPE_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[ADMIN_USERS] WITH NOCHECK ADD 
	CONSTRAINT [PK_ADMIN_USERS] PRIMARY KEY  CLUSTERED 
	(
		[USER_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[GEN_CODES] WITH NOCHECK ADD 
	CONSTRAINT [PK_GEN_CODES] PRIMARY KEY  CLUSTERED 
	(
		[CODE_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[GEN_CODE_CHOICES] WITH NOCHECK ADD 
	CONSTRAINT [PK_GEN_CODE_CHOICES] PRIMARY KEY  CLUSTERED 
	(
		[CHOICE_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[GEN_CODE_CHOICES2] WITH NOCHECK ADD 
	CONSTRAINT [PK_GEN_CODE_CHOICES2] PRIMARY KEY  CLUSTERED 
	(
		[CHOICE2_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[SYS_PARAS] WITH NOCHECK ADD 
	CONSTRAINT [PK_SYS_PARAS] PRIMARY KEY  CLUSTERED 
	(
		[PARA_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[ADMIN_SYSTEMS] ADD 
	CONSTRAINT [DF__ADMIN_SYS__TYPE___01142BA1] DEFAULT (1) FOR [TYPE_ID],
	CONSTRAINT [DF__ADMIN_SYS__ACCES__02084FDA] DEFAULT ('-1') FOR [ACCESS_ROLES],
	CONSTRAINT [DF__ADMIN_SYS__SORT___02FC7413] DEFAULT (0) FOR [SORT_ORDER],
	CONSTRAINT [DF_ADMIN_SYSTEMS_IMAGE_PATH] DEFAULT ('folder.gif') FOR [IMAGE_PATH],
	CONSTRAINT [PK_ADMIN_SYSTEMS] PRIMARY KEY  NONCLUSTERED 
	(
		[SYSTEM_ID]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[ADMIN_SYSTEM_PAGES] ADD 
	CONSTRAINT [DF__ADMIN_SYS__BROWS__04E4BC85] DEFAULT ('0') FOR [BROWSE_ROLES],
	CONSTRAINT [DF__ADMIN_SYS__UPDAT__05D8E0BE] DEFAULT ('0') FOR [UPDATE_ROLES],
	CONSTRAINT [DF__ADMIN_SYS__DELET__06CD04F7] DEFAULT ('0') FOR [DELETE_ROLES],
	CONSTRAINT [DF__ADMIN_SYS__FULL___07C12930] DEFAULT ('0') FOR [FULL_ACCESS_ROLES]
GO

ALTER TABLE [dbo].[ADMIN_SYSTEM_TYPES] ADD 
	CONSTRAINT [DF__ADMIN_SYS__SORT___0B91BA14] DEFAULT (0) FOR [SORT_ORDER]
GO

ALTER TABLE [dbo].[ADMIN_USERS] ADD 
	CONSTRAINT [DF__ADMIN_USE__CREAT__0CBAE877] DEFAULT (getdate()) FOR [CREATE_TIME]
GO

ALTER TABLE [dbo].[GEN_CODES] ADD 
	CONSTRAINT [DF__GEN_CODES__CODE___114A936A] DEFAULT (0) FOR [CODE_ID]
GO

ALTER TABLE [dbo].[GEN_CODE_CHOICES] ADD 
	CONSTRAINT [DF__GEN_CODE___CHOIC__1332DBDC] DEFAULT (0) FOR [CHOICE_ID],
	CONSTRAINT [DF__GEN_CODE___CODE___14270015] DEFAULT (0) FOR [CODE_ID],
	CONSTRAINT [DF__GEN_CODE___SORTO__151B244E] DEFAULT (0) FOR [SORTORDER]
GO

ALTER TABLE [dbo].[GEN_CODE_CHOICES2] ADD 
	CONSTRAINT [DF__GEN_CODE___CHOIC__17036CC0] DEFAULT (0) FOR [CHOICE2_ID],
	CONSTRAINT [DF__GEN_CODE___CHOIC__17F790F9] DEFAULT (0) FOR [CHOICE_ID],
	CONSTRAINT [DF__GEN_CODE___ECHOI__18EBB532] DEFAULT ('') FOR [ECHOICE2],
	CONSTRAINT [DF__GEN_CODE___SORTO__19DFD96B] DEFAULT (0) FOR [SORTORDER]
GO

ALTER TABLE [dbo].[SYS_PARAS] ADD 
	CONSTRAINT [DF__SYS_PARAS__PARA___12149A71] DEFAULT (0) FOR [PARA_ID]
GO

ALTER TABLE [dbo].[GEN_CODE_CHOICES] ADD 
	CONSTRAINT [FK_GEN_CODE_CHOICES_GEN_CODES] FOREIGN KEY 
	(
		[CODE_ID]
	) REFERENCES [dbo].[GEN_CODES] (
		[CODE_ID]
	) NOT FOR REPLICATION 
GO

alter table [dbo].[GEN_CODE_CHOICES] nocheck constraint [FK_GEN_CODE_CHOICES_GEN_CODES]
GO

ALTER TABLE [dbo].[GEN_CODE_CHOICES2] ADD 
	CONSTRAINT [FK_GEN_CODE_CHOICES2_GEN_CODE_CHOICES] FOREIGN KEY 
	(
		[CHOICE_ID]
	) REFERENCES [dbo].[GEN_CODE_CHOICES] (
		[CHOICE_ID]
	) NOT FOR REPLICATION 
GO

alter table [dbo].[GEN_CODE_CHOICES2] nocheck constraint [FK_GEN_CODE_CHOICES2_GEN_CODE_CHOICES]
GO

