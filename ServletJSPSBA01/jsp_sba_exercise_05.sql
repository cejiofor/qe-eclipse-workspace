SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
	userId INT AUTO_INCREMENT,
	firstName VARCHAR(50),
	lastName VARCHAR(50),
	userEmail VARCHAR(50),
	userPassword VARCHAR(50),
	userDOB DATE,
	PRIMARY KEY (userId)
);

DROP TABLE IF EXISTS homes;
CREATE TABLE homes (
	homeId INT AUTO_INCREMENT,
	userId INT,
	address1 VARCHAR(255),
	address2 VARCHAR(50),
	city VARCHAR(25),
	state VARCHAR(2),
	zip INT(5),
	yearBuilt INT(4),
	homeValue DOUBLE,
	PRIMARY KEY (homeId),
	FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE
);

DROP TABLE IF EXISTS quotes;
CREATE TABLE quotes (
	quoteId INT AUTO_INCREMENT,
	homeId INT,
	yearlyPremium DOUBLE,
	startDate DATE,
	expiration DATE,
	active BOOLEAN,
	PRIMARY KEY (quoteId),
	FOREIGN KEY (homeId) REFERENCES homes(homeId) ON DELETE CASCADE
);


drop table if exists homequotes;
CREATE TABLE homequotes AS 
  (SELECT homes.*,
  			quotes.quoteId,
  			quotes.yearlyPremium,
			quotes.active
   FROM  quotes 
         INNER JOIN homes 
         ON quotes.homeId = homes.homeId);
                  
CREATE TABLE homequotes (
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