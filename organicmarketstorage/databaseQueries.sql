CREATE table category (

	id IDENTITY,
	name VARCHAR(255),
	discription VARCHAR(255),
	imageURL VARCHAR(50),
	is_active BOOLEAN,

	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

CREATE TABLE user_details (
	id IDENTITY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR (100),
	contactnumber VARCHAR(15),
	
	CONSTRAINT pk_user_id PRIMARY KEY (id)


);

CREATE TABLE product (

	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	discrpition VARCHAR(255),
	unitprice DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_details(id),

);







   -------------------------------------------------------------- MySql Data Query --1-----------------




CREATE table category (

	id INT,
	name VARCHAR(255),
	discription VARCHAR(255),
	imageURL VARCHAR(50),
	is_active BOOLEAN,

	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

CREATE TABLE user_details (
	id INT,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR (100),
	contactnumber VARCHAR(15),
	
	CONSTRAINT pk_user_id PRIMARY KEY (id)


);

CREATE TABLE product (

	id INT,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	discrpition VARCHAR(255),
	unitprice DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_details(id)

);


















