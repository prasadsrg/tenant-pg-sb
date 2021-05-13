
CREATE TABLE  public.tbl_tenant_master (
	id int NOT NULL,
	db_name varchar(50) NOT NULL,
	url varchar(100) NOT NULL,
	user_name varchar(50) NOT NULL,
	password varchar(100) NOT NULL,
	driver_class varchar(100) NOT NULL,
	status varchar(10) NOT NULL,
	PRIMARY KEY (id)
);

insert into tbl_tenant_master values (1, 'tenant1', 'jdbc:postgresql://pg.rndpro.in:5432/tenant_db?currentSchema=tenant1', 'tenant_user', 'Tenant1234', 'org.postgresql.Driver', 'Active');
insert into tbl_tenant_master values (1, 'tenant2', 'jdbc:postgresql://pg.rndpro.in:5432/tenant_db?currentSchema=tenant2', 'tenant_user', 'Tenant1234', 'org.postgresql.Driver', 'Active');


create schema if not exists tenant1;
create schema if not exists tenant2;



CREATE TABLE  tbl_user (
    user_id int NOT NULL,
    full_name varchar(100) NOT NULL,
    gender varchar(10) NOT NULL,
    user_name varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    status varchar(10) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE  tbl_product (
    product_id int NOT NULL,
    product_name varchar(50) NOT NULL,
    quantity int NOT NULL DEFAULT '0',
    size varchar(3) NOT NULL,
    PRIMARY KEY (product_id)
);


INSERT INTO tenant1.tbl_user (user_id, full_name, gender, user_name, "password", status)
    VALUES(1, 'Test User 1', 'M', 'user1', 'Test1234', 'Active');


INSERT INTO tenant2.tbl_user (user_id, full_name, gender, user_name, "password", status)
    VALUES(1, 'Test User 1', 'M', 'user2', 'Test1234', 'Active');
