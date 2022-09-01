create database ShoppingWeb;

create table users(
                      id int(11) AUTO_INCREMENT primary key,
                      name varchar(50),
                      password varchar(20),
                      email varchar(20)
) engine=InnoDB default charset=utf8;

create table items(
                      id int(11) AUTO_INCREMENT primary key,
                      item_name varchar(50),
                      item_price long,
                      item_type enum('GOLD_613','GOLD_10K','GOLD_ITALI')
) engine=InnoDB default charset=utf8;

insert into items(item_name,item_price,item_type)
values
    ('Vang Phuc Loc Tho',3000000,'GOLD_613'),
    ('Vang Mickey',4000000,'GOLD_10K'),
    ('Day Chuyen',1500000,'GOLD_ITALI'),
    ('Nhan Nam',2500000,'GOLD_613'),
    ('Nhan Nu',5000000,'GOLD_ITALI')