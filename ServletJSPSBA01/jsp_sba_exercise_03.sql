SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
	user_id INT AUTO_INCREMENT,
	user_name VARCHAR(100),
	password VARCHAR(100),
	PRIMARY KEY (user_id)
);

INSERT INTO users VALUES (1, 'monkey', 'monkey123');
INSERT INTO users VALUES (2, 'letters', 'abcd123');
INSERT INTO users VALUES (3, 'numbers', '123456');
INSERT INTO users VALUES (4, 'barrack', 'obama');