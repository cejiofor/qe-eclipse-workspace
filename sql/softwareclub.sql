SET FOREIGN_KEY_CHECKS=0;

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

SELECT * FROM EVENTS;

drop table if exists signups;
CREATE TABLE signups (
   signups_member_id INT NOT NULL,
   signups_event_id INT NOT NULL,
   PRIMARY KEY (signups_member_id , signups_event_id),
   CONSTRAINT l_fk_eventId FOREIGN KEY (signups_event_id)
       REFERENCES events (event_id)
       ON UPDATE CASCADE ON DELETE CASCADE,
   CONSTRAINT l_fk_memberId FOREIGN KEY (signups_member_id)
       REFERENCES members (member_id)
       ON UPDATE CASCADE ON DELETE CASCADE
)  DEFAULT CHARSET=UTF8;

SELECT * FROM signups;
