drop table user if exists;
drop table p_order if exists;

create table user (
      id bigint auto_increment,
      create_time timestamp,
      update_time timestamp,
      name varchar(255),
      primary key (id)
);

create table p_order (
    id bigint auto_increment,
    order_no varchar(255),
    status varchar(2),
    user_id bigint,
    product_id bigint,
    worksite varchar(255),
    remark varchar(255),
    create_time timestamp,
    update_time timestamp,
    primary key (id)
);