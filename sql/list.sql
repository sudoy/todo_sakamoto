create table list(
	id SERIAL primary key auto_increment not null,
	title varchar(100) not null,
	content varchar(150) not null,
	level varchar(20) not null,
	deadline date
);
	
insert into list values(1,'モックアップ作成', 'HTMLでモックアップを作る', '★★★', '2018/05/29');
insert into list values(2,'DB作成', '指定された内容のDBを作る', '★', '2018/05/30');
insert into list values(3,'テーブル作成', '作ったDB内にテーブルを作る', '★★', '2018/05/30');
insert into list values(4,'修正を頑張る', '作ったDB内のテーブルを修正する', '★★', null);


