DROP TABLE IF EXISTS users;
CREATE TABLE users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  password VARCHAR(100),
  javaScore double,
  sqlScore double
);
SELECT * FROM users;