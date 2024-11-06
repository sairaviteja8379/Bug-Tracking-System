CREATE DATABASE BugTrackingDB;
USE BugTrackingDB;

CREATE TABLE Bug (
    bug_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT,
    status VARCHAR(50),
    created_by INT,
    assigned_to INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE BugHistory (
    history_id INT PRIMARY KEY AUTO_INCREMENT,
    bug_id INT,
    status VARCHAR(50),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (bug_id) REFERENCES Bug(bug_id)
);

CREATE TABLE Solution (
    solution_id INT PRIMARY KEY AUTO_INCREMENT,
    bug_id INT,
    solution_description TEXT,
    solved_by INT,
    solved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (bug_id) REFERENCES Bug(bug_id)
);

CREATE TABLE EmployeePerformance (
    employee_id INT PRIMARY KEY,
    bugs_solved INT DEFAULT 0,
    bugs_reported INT DEFAULT 0
);
