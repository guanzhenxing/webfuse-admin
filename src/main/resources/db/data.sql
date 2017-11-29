INSERT INTO "USER" ("ID","USERNAME","PASSWORD","ACCOUNT_NON_EXPIRED","ACCOUNT_NON_LOCKED","CREDENTIALS_NON_EXPIRED","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219031937024','admin','admin',1,1,1, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);
INSERT INTO "USER" ("ID","USERNAME","PASSWORD","ACCOUNT_NON_EXPIRED","ACCOUNT_NON_LOCKED","CREDENTIALS_NON_EXPIRED","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219032854528','test','test',1,1,1, CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);


INSERT INTO "ROLE"("ID","NAME","DISPLAY_NAME","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219032068096','ADMINISTRATOR','管理员',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);
INSERT INTO "ROLE"("ID","NAME","DISPLAY_NAME","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219032199168','NORMAL_USER','普通用户',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);

INSERT INTO "PERMISSION"("ID","NAME","DISPLAY_NAME","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219032330240','USER_MANAGER','用户管理',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);
INSERT INTO "PERMISSION"("ID","NAME","DISPLAY_NAME","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219032461312','ROLE_MANAGER','角色管理',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);
INSERT INTO "PERMISSION"("ID","NAME","DISPLAY_NAME","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219032592384','SYS_LOG_MANAGE','系统日志管理',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);
INSERT INTO "PERMISSION"("ID","NAME","DISPLAY_NAME","CREATE_TIME","UPDATE_TIME","ENABLED")
VALUES('929726219032723456','VIEW_NEWS','查看新闻',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(),1);

INSERT INTO "USER_ROLE"("USER_ID","ROLE_ID")
VALUES('929726219031937024','929726219032068096');
INSERT INTO "USER_ROLE"("USER_ID","ROLE_ID")
VALUES('929726219032854528','929726219032199168');

INSERT INTO "ROLE_PERMISSION"("ROLE_ID","PERMISSION_ID")
VALUES('929726219032068096','929726219032330240');
INSERT INTO "ROLE_PERMISSION"("ROLE_ID","PERMISSION_ID")
VALUES('929726219032068096','929726219032461312');
INSERT INTO "ROLE_PERMISSION"("ROLE_ID","PERMISSION_ID")
VALUES('929726219032068096','929726219032592384');
INSERT INTO "ROLE_PERMISSION"("ROLE_ID","PERMISSION_ID")
VALUES('929726219032068096','929726219032723456');
INSERT INTO "ROLE_PERMISSION"("ROLE_ID","PERMISSION_ID")
VALUES('929726219032199168','929726219032592384');
INSERT INTO "ROLE_PERMISSION"("ROLE_ID","PERMISSION_ID")
VALUES('929726219032199168','929726219032723456');


