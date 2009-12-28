insert into ROLE (NAME, DESCRIPTION) value('ROLE_ADMIN','ROLE_ADMIN');
insert into ROLE (NAME, DESCRIPTION) value('ROLE_USER','ROLE_USER');
insert into MEMBER (NAME,WORK_ID,LOGIN_ID,PASSWORD, EMAIL, ALI_TALK_ID, GMT_CREATE,GMT_MODIFIED, ENABLE, LOCATION, EXT)
values('admin', '0000','admin','9a1996efc97181f0aee18321aa3b3b12','yonglin.fanyl@alibaba-inc.com','',NOW(),NOW(),1,'','');
insert into MEMBER_ROLE (MEMBER_ID, ROLE_ID) values(1, 1);
insert into MEMBER_ROLE (MEMBER_ID, ROLE_ID) values(1, 2);