use shoppingweb;

create table items(
                      item_id int(11) AUTO_INCREMENT primary key,
                      item_name varchar(500),
                      item_price float(20)
) engine=InnoDB default charset=utf8;

