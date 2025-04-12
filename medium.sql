CREATE DATABASE IF NOT EXISTS test;
USE test;

CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50)
);

INSERT INTO employees (id, name, department) VALUES
(1, 'Alice Johnson', 'HR'),
(2, 'Bob Smith', 'Finance'),
(3, 'Charlie Davis', 'IT');
