use collect;
create table tag(
	t_id int primary key auto_increment,
	t_name varchar(100),
	t_count int
)


insert into tag(t_name,t_count) values('java',2);
insert into tag(t_name,t_count) values('strtua',1);
insert into tag(t_name,t_count) values('oracle',1);
create table favorite(
	f_id int primary key auto_increment,
	f_label varchar(1000),
	f_url varchar(300),
	f_tags varchar(1000),
	f_desc varchar(1000)
)
insert into favorite(f_label,f_url,f_tags,f_desc) values('apache Strtua','http://www.apache.org/strtus/','java,Strtus','strtus官方站点');
insert into favorite(f_label,f_url,f_tags,f_desc) values('oracle','http://www.oracle.com','java,oracle','oracle官方站点');








