CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  user_name TEXT,
  password TEXT,
  date_registration DATE,
  deleted BOOLEAN DEFAULT FALSE,
);

CREATE TABLE children(
  child_id INT AUTO_INCREMENT PRIMARY KEY,
  child_surname VARCHAR(30),
  child_name VARCHAR(30),
  child_patronymic VARCHAR(30),
  user_id INT,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);