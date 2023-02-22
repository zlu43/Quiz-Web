DROP DATABASE IF EXISTS quiz_database;
CREATE DATABASE quiz_database;
USE quiz_database;

# User
DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    user_password VARCHAR(255),
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255),
    address VARCHAR(255),
    is_admin BOOL,
    is_active BOOL
);
INSERT INTO User(
    user_name, user_password,
    firstname, lastname,
    phone, email, address,
    is_admin, is_active
) VALUES
    ('admin', '123', 'AD', 'MIN', '1234567890', 'admin@gmail.com', 'admin address', TRUE, TRUE),
    ('steven', '123', 'Steven', 'Lu', '1111111111', 'steven@gmail.com', 'steven address', FALSE, TRUE),
    ('david', '123', 'David', 'Ge', '2222222222', 'david@gmail.com', 'david address', FALSE, TRUE),
    ('jason', '123', '', '', '', '', '', FALSE, FALSE);



# Category
DROP TABLE IF EXISTS Category;
CREATE TABLE IF NOT EXISTS Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO Category (name)
VALUES
    ('Math1'),
    ('Math2'),
    ('Math3');


# Question
DROP TABLE IF EXISTS Question;
CREATE TABLE IF NOT EXISTS Question (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT,
    question_content VARCHAR(255),
    is_active BOOL,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);
INSERT INTO Question(
    category_id, question_content, is_active
) VALUES
    (1, '1 + 1 = ?', TRUE),
    (1, '1 + 2 = ?', TRUE),
    (1, '1 + 3 = ?', TRUE),
    (1, '1 + 4 = ?', TRUE),
    (1, '1 + 5 = ?', TRUE),
    (1, '1 + 6 = ?', TRUE),
    (1, '1 + 7 = ?', TRUE),
    (1, '1 + 8 = ?', TRUE),
    (1, '1 + 9 = ?', TRUE),
    (1, '1 + 10 = ?', TRUE),

    (2, '2 + 1 = ?', TRUE),
    (2, '2 + 2 = ?', TRUE),
    (2, '2 + 3 = ?', TRUE),
    (2, '2 + 4 = ?', TRUE),
    (2, '2 + 5 = ?', TRUE),
    (2, '2 + 6 = ?', TRUE),
    (2, '2 + 7 = ?', TRUE),
    (2, '2 + 8 = ?', TRUE),
    (2, '2 + 9 = ?', TRUE),
    (2, '2 + 10 = ?', TRUE),

    (3, '3 + 1 = ?', TRUE),
    (3, '3 + 2 = ?', TRUE),
    (3, '3 + 3 = ?', TRUE),
    (3, '3 + 4 = ?', TRUE),
    (3, '3 + 5 = ?', TRUE),
    (3, '3 + 6 = ?', TRUE),
    (3, '3 + 7 = ?', TRUE),
    (3, '3 + 8 = ?', TRUE),
    (3, '3 + 9 = ?', TRUE),
    (3, '3 + 10 = ?', TRUE);


# Choice
DROP TABLE IF EXISTS Choice;
CREATE TABLE IF NOT EXISTS Choice (
    choice_id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT,
    choice_content VARCHAR(255),
    is_answer BOOL,
    FOREIGN KEY (question_id) REFERENCES Question(question_id)
);
INSERT INTO Choice (question_id, choice_content, is_answer)
VALUES
    (1, 'right', TRUE), (1, 'wrong1', FALSE), (1, 'wrong2', FALSE), (1, 'wrong3', FALSE),
    (2, 'right', TRUE), (2, 'wrong1', FALSE), (2, 'wrong2', FALSE), (2, 'wrong3', FALSE),
    (3, 'right', TRUE), (3, 'wrong1', FALSE), (3, 'wrong2', FALSE), (3, 'wrong3', FALSE),
    (4, 'right', TRUE), (4, 'wrong1', FALSE), (4, 'wrong2', FALSE), (4, 'wrong3', FALSE),
    (5, 'right', TRUE), (5, 'wrong1', FALSE), (5, 'wrong2', FALSE), (5, 'wrong3', FALSE),
    (6, 'right', TRUE), (6, 'wrong1', FALSE), (6, 'wrong2', FALSE), (6, 'wrong3', FALSE),
    (7, 'right', TRUE), (7, 'wrong1', FALSE), (7, 'wrong2', FALSE), (7, 'wrong3', FALSE),
    (8, 'right', TRUE), (8, 'wrong1', FALSE), (8, 'wrong2', FALSE), (8, 'wrong3', FALSE),
    (9, 'right', TRUE), (9, 'wrong1', FALSE), (9, 'wrong2', FALSE), (9, 'wrong3', FALSE),
    (10, 'right', TRUE), (10, 'wrong1', FALSE), (10, 'wrong2', FALSE), (10, 'wrong3', FALSE),

    (11, 'right', TRUE), (11, 'wrong1', FALSE), (11, 'wrong2', FALSE), (11, 'wrong3', FALSE),
    (12, 'right', TRUE), (12, 'wrong1', FALSE), (12, 'wrong2', FALSE), (12, 'wrong3', FALSE),
    (13, 'right', TRUE), (13, 'wrong1', FALSE), (13, 'wrong2', FALSE), (13, 'wrong3', FALSE),
    (14, 'right', TRUE), (14, 'wrong1', FALSE), (14, 'wrong2', FALSE), (14, 'wrong3', FALSE),
    (15, 'right', TRUE), (15, 'wrong1', FALSE), (15, 'wrong2', FALSE), (15, 'wrong3', FALSE),
    (16, 'right', TRUE), (16, 'wrong1', FALSE), (16, 'wrong2', FALSE), (16, 'wrong3', FALSE),
    (17, 'right', TRUE), (17, 'wrong1', FALSE), (17, 'wrong2', FALSE), (17, 'wrong3', FALSE),
    (18, 'right', TRUE), (18, 'wrong1', FALSE), (18, 'wrong2', FALSE), (18, 'wrong3', FALSE),
    (19, 'right', TRUE), (19, 'wrong1', FALSE), (19, 'wrong2', FALSE), (19, 'wrong3', FALSE),
    (20, 'right', TRUE), (20, 'wrong1', FALSE), (20, 'wrong2', FALSE), (20, 'wrong3', FALSE),

    (21, 'right', TRUE), (21, 'wrong1', FALSE), (21, 'wrong2', FALSE), (21, 'wrong3', FALSE),
    (22, 'right', TRUE), (22, 'wrong1', FALSE), (22, 'wrong2', FALSE), (22, 'wrong3', FALSE),
    (23, 'right', TRUE), (23, 'wrong1', FALSE), (23, 'wrong2', FALSE), (23, 'wrong3', FALSE),
    (24, 'right', TRUE), (24, 'wrong1', FALSE), (24, 'wrong2', FALSE), (24, 'wrong3', FALSE),
    (25, 'right', TRUE), (25, 'wrong1', FALSE), (25, 'wrong2', FALSE), (25, 'wrong3', FALSE),
    (26, 'right', TRUE), (26, 'wrong1', FALSE), (26, 'wrong2', FALSE), (26, 'wrong3', FALSE),
    (27, 'right', TRUE), (27, 'wrong1', FALSE), (27, 'wrong2', FALSE), (27, 'wrong3', FALSE),
    (28, 'right', TRUE), (28, 'wrong1', FALSE), (28, 'wrong2', FALSE), (28, 'wrong3', FALSE),
    (29, 'right', TRUE), (29, 'wrong1', FALSE), (29, 'wrong2', FALSE), (29, 'wrong3', FALSE),
    (30, 'right', TRUE), (30, 'wrong1', FALSE), (30, 'wrong2', FALSE), (30, 'wrong3', FALSE);


# Quiz
DROP TABLE IF EXISTS QuizInfo;
CREATE TABLE IF NOT EXISTS QuizInfo (
    quiz_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    category_id INT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);


# Result
DROP TABLE IF EXISTS Result;
CREATE TABLE IF NOT EXISTS Result (
    result_id INT AUTO_INCREMENT PRIMARY KEY,
    quiz_id INT,
    question_id INT,
    user_choice_id INT,
    FOREIGN KEY (quiz_id) REFERENCES QuizInfo(quiz_id),
    FOREIGN KEY (question_id) REFERENCES Question(question_id),
    FOREIGN KEY (user_choice_id) REFERENCES Choice(choice_id)
);


# Feedback
DROP TABLE IF EXISTS Feedback;
CREATE TABLE IF NOT EXISTS Feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    rating INT,
    feedback VARCHAR(5000)
);


# Content
DROP TABLE IF EXISTS Message;
CREATE TABLE IF NOT EXISTS Message (
    contact_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    message VARCHAR(5000)
);