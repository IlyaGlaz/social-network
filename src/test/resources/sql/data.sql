ALTER TABLE users AUTO_INCREMENT = 6;

INSERT INTO users (id, birth_date, firstname, lastname, user_type, username)
VALUES (1, '1990-01-10', 'Ivan', 'Ivanov', 'ADMIN', 'ivan@gmail.com'),
       (2, '1995-10-19', 'Petr', 'Petrov', 'USER', 'petr@gmail.com'),
       (3, '2001-12-23', 'Sveta', 'Svetikova', 'USER', 'sveta@gmail.com'),
       (4, '1984-03-14', 'Vlad', 'Vladikov', 'USER', 'vlad@gmail.com'),
       (5, '1984-03-14', 'Kate', 'Smith', 'ADMIN', 'kate@gmail.com');