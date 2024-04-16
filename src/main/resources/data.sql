insert into lesson.users (username,lastName,age, password) values('user','igor', '1', 'user');
insert into lesson.users (username,lastName,age, password) values('admin','inna', '2', 'admin');
insert into lesson.roles (role) values('ROLE_ADMIN');
insert into lesson.roles (role) values('ROLE_USER');
insert into lesson.users_roles (user_id, roles_id) values('1','2');
insert into lesson.users_roles (user_id, roles_id) values('2','1');