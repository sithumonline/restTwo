DROP DATABASE IF EXISTS productDB;

CREATE DATABASE productDB;
USE productDB;

SET @@SESSION.auto_increment_increment=1;


CREATE TABLE category(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(256) NOT NULL,

	CONSTRAINT pk_category PRIMARY KEY(id)
);

INSERT INTO category(name,description)
VALUES
("category 1", "description 1"),
("category 2", "description 2"),
("category 3", "description 3"),
("category 4", "description 4"),
("category 5", "description 5");
