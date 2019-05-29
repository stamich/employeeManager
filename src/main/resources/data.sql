DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    grade INT NOT NULL,
    salary INT NOT NULL
);

INSERT INTO employees (first_name, last_name, grade, salary) VALUES
    ('Albert', 'Einstein', 100, 5000),
    ('Ada', 'Lovelace', 110, 5000),
    ('Charles', 'Babbage', 120, 5000),
    ('Stefan', 'Banach', 100, 4500);