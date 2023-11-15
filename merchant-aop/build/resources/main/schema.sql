drop table if exists hibernate_sequence
drop table if exists merchant
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table merchant (id integer not null, created_on datetime(6) not null, merchant_id varchar(255) not null, name varchar(255) not null, updated_on datetime(6) not null, primary key (id)) engine=InnoDB
alter table merchant add constraint UK_nwmfix3x27256p9mwjjcpo27u unique (merchant_id)
