
insert into ADMIN_USER ( NAME, PASSWORD, FULL_NAME, USER_TYPE, FORBIDDEN, LOCKED, IS_ADMIN ) values ('jason', 'hello', 'Jason Gu', 'Admin', false, false, true );

insert into ADMIN_ROLE (NAME, DESCRIPTION, SORT_ORDER ) values ('Admin', 'Admin Role', 1);
insert into ADMIN_ROLE (NAME, DESCRIPTION, SORT_ORDER ) values ('User', 'User Role', 2);


insert into ADMIN_SYSTEM_CATEGORY (NAME, DESCRIPTION, SORT_ORDER ) values ('Admin', 'Admin Category', 1);
insert into ADMIN_SYSTEM_CATEGORY (NAME, DESCRIPTION, SORT_ORDER ) values ('Setting', 'System Settings', 2);
insert into ADMIN_SYSTEM_CATEGORY (NAME, DESCRIPTION, SORT_ORDER ) values ('Profile', 'Profile', 99);


insert into ADMIN_SYSTEM (NAME, DESCRIPTION, ICON, URL, CATEGORY_ID, SORT_ORDER ) values ('User', 'User Description', 'ui-icon-search', '/admin/adminUser.xhtml', 1, 1);
insert into ADMIN_SYSTEM (NAME, DESCRIPTION, ICON, URL, CATEGORY_ID, SORT_ORDER ) values ('System', 'System maintenance', 'ui-icon-search', '/admin/adminSystem.xhtml', 1, 1);
insert into ADMIN_SYSTEM (NAME, DESCRIPTION, ICON, URL, CATEGORY_ID, SORT_ORDER ) values ('System Category', 'User Description', 'ui-icon-search', '//admin/adminSystemCategoryAIO.xhtml', 1, 1);
insert into ADMIN_SYSTEM (NAME, DESCRIPTION, ICON, URL, CATEGORY_ID, SORT_ORDER ) values ('Role', 'Role maintenance', 'ui-icon-search', '/admin/adminRoleAIO.xhtml', 1, 1);


INSERT INTO sequence VALUES('UserId', 1000);

INSERT INTO Users VALUES (1,'Jason Gu','M','1972-1-1');
INSERT INTO Users VALUES (2,'Tim Salzman','M','1973-2-2');
INSERT INTO Users VALUES (3,'Steven Brener','M','1974-3-3');

INSERT INTO Orders(productName,price,qty) VALUES ('Laptop',786.50,2);
INSERT INTO Orders(productName,price,qty) VALUES ('Dell Latitude Laptop',1786.50, 3);
INSERT INTO Orders(productName,price,qty) VALUES ('Dell Monitor',123.45,1);



