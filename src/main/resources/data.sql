
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


create schema if not exists tenant1;
create schema if not exists tenant2;



CREATE TABLE  tbl_user (
    user_id int NOT NULL AUTO_INCREMENT,
    full_name varchar(100) NOT NULL,
    gender varchar(10) NOT NULL,
    user_name varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    status varchar(10) NOT NULL,
    PRIMARY KEY (user_id)
)

CREATE TABLE  tbl_product (
    product_id int NOT NULL AUTO_INCREMENT,
    product_name varchar(50) NOT NULL,
    quantity int NOT NULL DEFAULT '0',
    size varchar(3) NOT NULL,
    PRIMARY KEY (product_id)
)