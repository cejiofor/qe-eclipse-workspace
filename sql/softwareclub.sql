DROP TABLE IF EXISTS members;
CREATE TABLE members (
	member_id INT AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(100),
	password VARCHAR(100),
	favorite_language VARCHAR(100),
	PRIMARY KEY (member_id)
);


SELECT * FROM members;

DROP TABLE IF EXISTS events;
CREATE TABLE events (
	event_id INT AUTO_INCREMENT,
	title VARCHAR(100),
	description VARCHAR(100),
	location VARCHAR(100),
	event_time DATE,
	member_id INT,
	PRIMARY KEY (event_id),
	FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE
);

SELECT * FROM events;