# create table lesson.users(
#                             `id` INT not null  AUTO_INCREMENT,
#                             PRIMARY KEY (`id`),
#                             username varchar(50) not null ,
#                             lastName varchar(50) not null,
#                             password  varchar(50) not null,
#                             age int
# );
# create table lesson.roles(
#                             `id` INT not NULL AUTO_INCREMENT,
#                             PRIMARY KEY (`id`),
#                             role varchar(50) not null
#
# );
# create table lesson.users_roles(
#                                  user_id int, roles_id int
# );