CREATE TABLE resources (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255),
  content TEXT,
  category VARCHAR(255),
  helped BIT,
  createDate DATE,
  PRIMARY KEY (id)
);
