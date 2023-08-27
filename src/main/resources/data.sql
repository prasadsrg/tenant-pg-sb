CREATE USER tenant_user WITH PASSWORD 'Tenant1234';
CREATE DATABASE tenant_db;
\c tenant_db;
CREATE SCHEMA if not exists tenant1;
CREATE SCHEMA if not exists tenant2;
CREATE SCHEMA if not exists tenant3;

GRANT USAGE ON SCHEMA tenant1 TO tenant_user;
GRANT USAGE ON SCHEMA tenant2 TO tenant_user;
GRANT USAGE ON SCHEMA tenant3 TO tenant_user;

ALTER DEFAULT PRIVILEGES FOR USER tenant_user IN SCHEMA public GRANT ALL ON TABLES TO tenant_user;

ALTER ROLE tenant_user SET search_path = tenant1, tenant2, tenant3, public;

GRANT CONNECT ON DATABASE tenant_db TO tenant_user;



CREATE TABLE  public.tenant_master (
	id varchar(68) NOT NULL,
	db_name varchar(68) NOT NULL,
	url varchar(1000) NOT NULL,
	user_name varchar(50) NOT NULL,
	password varchar(100) NOT NULL,
	driver_class varchar(100) NOT NULL,
	status varchar(10) NOT NULL,
	PRIMARY KEY (id)
);

insert into tenant_master values ('tenant1', 'tenant1', 'jdbc:postgresql://node.dfftech.com:5432/tenant_db?currentSchema=tenant1', 'tenant_user', 'Tenant1234', 'org.postgresql.Driver', 'Active');
insert into tenant_master values ('tenant2', 'tenant2', 'jdbc:postgresql://node.dfftech.com:5432/tenant_db?currentSchema=tenant2', 'tenant_user', 'Tenant1234', 'org.postgresql.Driver', 'Active');
insert into tenant_master values ('tenant3', 'tenant3', 'jdbc:postgresql://node.dfftech.com:5432/tenant_db?currentSchema=tenant3', 'tenant_user', 'Tenant1234', 'org.postgresql.Driver', 'Active');


CREATE TABLE  profile (
    id int NOT NULL,
    full_name varchar(100) NOT NULL,
    gender varchar(10) NOT NULL,
    user_name varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    status varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE  product (
    product_id int NOT NULL,
    product_name varchar(50) NOT NULL,
    quantity int NOT NULL DEFAULT '0',
    size varchar(3) NOT NULL,
    PRIMARY KEY (product_id)
);

--password:Test1234

INSERT INTO tenant1.profile (id, full_name, gender, user_name, "password", status)
    VALUES(1, 'Test User 1', 'M', 'user1', '$2a$10$HsSuvrUfnkLTcLUuERJFCuHmlrC5AS.ByvODSdvIRCcT5921sg.6m', 'Active');


INSERT INTO tenant2.profile (id, full_name, gender, user_name, "password", status)
    VALUES(1, 'Test User 1', 'M', 'user2', '$2a$10$HsSuvrUfnkLTcLUuERJFCuHmlrC5AS.ByvODSdvIRCcT5921sg.6m', 'Active');

INSERT INTO tenant3.profile (id, full_name, gender, user_name, "password", status)
    VALUES(1, 'Test User 1', 'M', 'user2', '$2a$10$HsSuvrUfnkLTcLUuERJFCuHmlrC5AS.ByvODSdvIRCcT5921sg.6m', 'Active');


insert into tenant1.product values (1, 't1-p1', 10, '10');
insert into tenant1.product values (2, 't1-p3', 10, '10');
insert into tenant1.product values (3, 't1-p3', 10, '10');

insert into tenant2.product values (1, 't2-p1', 10, '10');
insert into tenant2.product values (2, 't2-p3', 10, '10');
insert into tenant2.product values (3, 't2-p3', 10, '10');

insert into tenant3.product values (1, 't3-p1', 10, '10');
insert into tenant3.product values (2, 't3-p3', 10, '10');
insert into tenant3.product values (3, 't3-p3', 10, '10');