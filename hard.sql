CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS attendance (
    id VARCHAR(20),
    subject VARCHAR(50),
    percentage INT
);
