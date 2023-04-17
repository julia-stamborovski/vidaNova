CREATE TABLE new_begginers_item (
    id BIGINT NOT NULL AUTO_INCREMENT,
    completed BOOLEAN DEFAULT FALSE,
    description TEXT NOT NULL,
    new_begginers_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (new_begginers_id) REFERENCES new_begginers (id)
);