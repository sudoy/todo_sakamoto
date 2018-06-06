create table users(
	id int primary key auto_increment,
	email varchar(100) not null,
	password varchar(100) not null,
	name varchar(100) not null default''
);

insert into users values(1,'sakamoto@tsd', MD5('sakamoto@tsd'), '阪本真由');
insert into users values(2,'wonderland@wl', MD5('wonder@land@wl'), 'User1');
insert into users values(3,'yuichi.sudo@ssie.jp', MD5('yuichi.sudo@ssie.jp'), '須藤雄一');



