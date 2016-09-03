# SpringBootTodo

The application demonstrates simple login page, which compares the given username and password to the ones in MySQL database 'tododb'.

## Create the database:


The passwords have been created by using the PassEncodingTest, which is included with the project.

## test username=ibrahim password = ibrahim
INSERT INTO tododb.users (id, email, password, role, username)
VALUES (1, 'ibrahim.karayel@gmail.com', '$2a$10$CKFXs6U1nOz9yMLuzPog6eKDjq6eNcDvxYd05F2P58Usl/3psEu9K', 2, 'ibrahim');
