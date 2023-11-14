drop table if exists hibernate_sequence
drop table if exists product
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 4 )
create table product (id integer not null, brand_name varchar(100) not null, created_on datetime, in_stock integer default 0 not null, manufacturer varchar(255) default 'Not Available' not null, price double precision not null, product_category varchar(50) not null, product_code varchar(10) not null, product_description varchar(500) default 'Not Available' not null, supplier_information varchar(500) default 'Not Available', updated_on datetime, primary key (id)) engine=InnoDB
alter table product add constraint UK_hcpr86kgtroqvxu1mxoyx4ahm unique (product_code)
