DROP TABLE if EXISTS users;
CREATE TABLE users (
	user_id INT AUTO_INCREMENT,
	name VARCHAR(45),
	password VARCHAR(45),
	PRIMARY KEY (user_id)
	);
	
DROP TABLE IF EXISTS adds;
CREATE TABLE adds(
	add_id INT(11) AUTO_INCREMENT,
	item VARCHAR(45),
	price DOUBLE,
	available BOOL,
	PRIMARY KEY (id)
);