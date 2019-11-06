-- DROP TABLE IF EXISTS members;
CREATE TABLE members (
	member_id INT AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(100),
	password VARCHAR(100),
	favorite_language VARCHAR(100),
	PRIMARY KEY (member_id)
);


SELECT * FROM members;
-- DROP TABLE IF EXISTS events;
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

SELECT * FROM EVENTS;


SELECT members.member_id, events.event_id FROM 
	members
	JOIN events
	ON members.member_id = EVENTS.member_id
	AS signups;
	
SELECT * FROM signups;

-- signups_member_id, signups_event_id
-- JOIN members.member_id, EVENTS.event_id WHERE members.member_id = EVENT.member_id AS sugnups;