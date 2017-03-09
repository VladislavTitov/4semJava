CREATE TABLE users (
  user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(20) NOT NULL,
  user_password TEXT NOT NULL,
  user_date_reg DATE NOT NULL,
  user_description TEXT
);

CREATE TABLE posts (
  post_id INTEGER AUTO_INCREMENT PRIMARY KEY,
  post_content TEXT NOT NULL,
  user_id INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (user_id)
);