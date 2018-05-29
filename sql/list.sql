(create database todolist_sakamoto;)

create table list(
	id SERIAL primary key auto_increment,
	title varchar(100),
	content varchar(150),
	level varchar(20),
	deadline date
);
	
insert into list values(1,'モックアップ作成', 'HTMLでモックアップを作る', '★★★', '2018/05/29');
insert into list values(2,'DB作成', '指定された内容のDBを作る', '★', '2018/05/30');
insert into list values(3,'テーブル作成', '作ったDB内にテーブルを作る', '★★', '2018/05/30');

