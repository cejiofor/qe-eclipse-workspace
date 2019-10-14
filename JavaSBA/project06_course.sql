DROP TABLE IF EXISTS courses;
CREATE TABLE courses (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  description VARCHAR(100)
);
SELECT * FROM courses;

DROP TABLE IF EXISTS events;
CREATE TABLE events (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  description VARCHAR(100),
  eventTime DATE
);

SELECT * FROM events;