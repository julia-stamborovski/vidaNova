CREATE TABLE Streak (
    id BIGINT NOT NULL AUTO_INCREMENT,
    start DATE,
    current INT,
    longest INT,
    sober BIT,
    feeling VARCHAR(255),
    daily_commitment VARCHAR(255),
    user_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);
