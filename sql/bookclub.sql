DROP TABLE IF EXISTS members;
CREATE TABLE members (
	member_id INT AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(100),
	password VARCHAR(100),
	favorite_genre VARCHAR(100),
	PRIMARY KEY (member_id)
);


SELECT * FROM members;

DROP TABLE IF EXISTS books;
CREATE TABLE books (
	book_id INT AUTO_INCREMENT,
	title VARCHAR(100),
	synopsis VARCHAR(100),
	author VARCHAR(100),
	pub_date DATE,
	member_id INT,
	PRIMARY KEY (book_id),
	FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE
);

SELECT * FROM books;