drop table user if exists;

create table user (
      id bigint auto_increment,
      create_time timestamp,
      update_time timestamp,
      name varchar(255),
      code varchar(32),
      bg_name varchar(255),
      credit_line decimal(15, 2),
      available_loan_quota decimal(15, 2),
      loan_amount_last_month decimal(20, 2),
      primary key(id)
);