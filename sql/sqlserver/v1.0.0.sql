

GO
DROP TABLE IF EXISTS `t_b_user`;

CREATE TABLE `t_b_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `auth` varchar(255) default NULL,
  `isbn` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `orgid` bigint(20) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_b_user` */

GO
insert  into `t_b_user`(`id`,`auth`,`isbn`,`name`,`orgid`,`password`) values (3,NULL,NULL,'961',NULL,'771665'),(4,NULL,NULL,'419',NULL,'954047'),(5,NULL,NULL,'126',NULL,'984132');

GO
DROP TABLE IF EXISTS `BASE_REGION`;
GO
CREATE TABLE [dbo].[BASE_REGION](
	[id] [char](32) NOT NULL,
	[code] [nvarchar](100) NULL,
	[name] [nvarchar](100) NULL,
	[parentId] [char](32) NULL,
	[createTimeStamp] [datetime] NULL,
	[lastChangeTimeStamp] [datetime] NULL,
	[parent_id] [bigint] NULL,
 CONSTRAINT [PK_BASE_ REGION] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e4774d7e989c014d7e9dc44e0001', N'10001', N'东区', NULL, CAST(0x0000A4A100ADD9B1 AS DateTime), CAST(0x0000A4A100ADD9B1 AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e4774d7e989c014d7e9e20fc0002', N'10002', N'西区', NULL, CAST(0x0000A4A100ADF57F AS DateTime), CAST(0x0000A4A100ADF57F AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e4774d7e989c014d7e9e73ff0003', N'10003', N'微电子', NULL, CAST(0x0000A4A100AE0E66 AS DateTime), CAST(0x0000A4A100AE0E66 AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e4774d7e989c014d7e9ec9cb0004', N'10004', N'化工区', NULL, CAST(0x0000A4A100AE2823 AS DateTime), CAST(0x0000A4A100AE2823 AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e4774d7e989c014d7e9f2e730005', N'10005', N'逸仙园', NULL, CAST(0x0000A4A100AE4656 AS DateTime), CAST(0x0000A54100A53FE5 AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e477509410cd01509f6a93e90001', N'10006', N'南港', NULL, CAST(0x0000A53C0173952E AS DateTime), CAST(0x0000A53C0173952E AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e477509410cd01509f6b30640002', N'10007', N'中区', NULL, CAST(0x0000A53C0173C41E AS DateTime), CAST(0x0000A53C0173C41E AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e477509410cd01509f6ba1d50003', N'10008', N'南部新兴产业区', NULL, CAST(0x0000A53C0173E626 AS DateTime), CAST(0x0000A53C0173E626 AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e477509410cd01509f6bed260004', N'10009', N'慧谷', NULL, CAST(0x0000A53C0173FCBF AS DateTime), CAST(0x0000A53C0173FCBF AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e477509410cd01509f6c85970005', N'10010', N'宁河未来科技城', NULL, CAST(0x0000A53C01742A7A AS DateTime), CAST(0x0000A53C01742A7A AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'4028e4775ad04844015afa3a8f0c0351', N'10011', N'其它', NULL, CAST(0x0000A73F010B741D AS DateTime), CAST(0x0000A73F010B741D AS DateTime), NULL)
INSERT [dbo].[BASE_REGION] ([id], [code], [name], [parentId], [createTimeStamp], [lastChangeTimeStamp], [parent_id]) VALUES (N'8a8e80e164b11ac90164b13cafc10002', N'10012', N'中心商务区', NULL, CAST(0x0000A92200EF6B20 AS DateTime), CAST(0x0000A92200EF6B20 AS DateTime), NULL)


