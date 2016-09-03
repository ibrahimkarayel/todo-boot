# SpringBootTodo

##Spring Boot Thymeleaf to-do Project

The application demonstrates simple login page, which compares the given username and password to the ones in MySQL database 'tododb'.
You can create new task edit or move to trash also delete these to-do list
## Create the database:


The passwords have been created by using the PassEncodingTest, which is included with the project.


CREATE TABLE todo
(
    id INT(11) PRIMARY KEY NOT NULL,
    category VARCHAR(255),
    content VARCHAR(255),
    created_date DATE,
    description VARCHAR(255),
    status VARCHAR(255),
    todo_name VARCHAR(255),
    user_id INT(11)
);
CREATE TABLE users
(
    id INT(11) PRIMARY KEY NOT NULL,
    email VARCHAR(255),
    password VARCHAR(255),
    role INT(11),
    username VARCHAR(255)
);

## test username=ibrahim password = ibrahim

INSERT INTO tododb.users (id, email, password, role, username)
VALUES (1, 'ibrahim.karayel@gmail.com', '$2a$10$CKFXs6U1nOz9yMLuzPog6eKDjq6eNcDvxYd05F2P58Usl/3psEu9K', 2, 'ibrahim');
