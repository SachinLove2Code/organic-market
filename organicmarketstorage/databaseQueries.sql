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


///////////////////////////////////////////////////

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema organicdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema organicdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `organicdb` DEFAULT CHARACTER SET utf8 ;
USE `organicdb` ;

-- -----------------------------------------------------
-- Table `organicdb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organicdb`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `imageURL` VARCHAR(50) NULL,
  `is_active` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organicdb`.`user_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organicdb`.`user_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `role` VARCHAR(50) NULL,
  `enabled` TINYINT NULL,
  `password` VARCHAR(60) NULL,
  `email` VARCHAR(100) NULL,
  `contact_number` VARCHAR(15) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organicdb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organicdb`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(30) NULL,
  `name` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `unitprice` DECIMAL(10,2) NULL,
  `is_active` TINYINT NULL,
  `purchases` INT NULL DEFAULT 0,
  `views` INT NULL DEFAULT 0,
  `category_id` INT NOT NULL,
  `supplier_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_category_idx` (`category_id` ASC),
  INDEX `fk_product_user_details1_idx` (`supplier_id` ASC),
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `organicdb`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_user_details1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `organicdb`.`user_details` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
















