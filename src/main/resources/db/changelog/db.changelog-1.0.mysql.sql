-- liquibase formatted sql

-- changeset Ilia:1
CREATE TABLE IF NOT EXISTS users
(
    id                  BIGINT PRIMARY KEY AUTO_INCREMENT,
    status              VARCHAR(32),
    about               VARCHAR(255),
    city                VARCHAR(64),
    country             VARCHAR(64),
    birth_date          date,
    confirmation_code   VARCHAR(64),
    username            VARCHAR(64) NOT NULL UNIQUE,
    firstname           VARCHAR(64) NOT NULL,
    is_approved         TINYINT(1),
    deleted             TINYINT(1)   DEFAULT 0,
    lastname            VARCHAR(64) NOT NULL,
    last_online_time    datetime,
    messages_permission VARCHAR(32),
    password            VARCHAR(255) DEFAULT '{noop}123',
    phone               VARCHAR(32),
    photo               VARCHAR(255),
    user_type           VARCHAR(32),
    reg_date            datetime,
    is_blocked          TINYINT(1)
);

-- changeset Ilia:2
CREATE TABLE IF NOT EXISTS post
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    is_blocked TINYINT(1),
    post_text  VARCHAR(255),
    time       datetime,
    title      VARCHAR(64),
    author_id  BIGINT,
    FOREIGN KEY (author_id) REFERENCES users (id)
);


-- changeset Ilia:3
CREATE TABLE IF NOT EXISTS file
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    `path`  VARCHAR(255),
    post_id BIGINT,
    FOREIGN KEY (post_id) REFERENCES post (id)
);

-- changeset Ilia:4
CREATE TABLE IF NOT EXISTS friendship
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    status      VARCHAR(32),
    time        datetime,
    dst_user_id BIGINT,
    src_user_id BIGINT,
    FOREIGN KEY (dst_user_id) REFERENCES users (id),
    FOREIGN KEY (src_user_id) REFERENCES users (id)
);

-- changeset Ilia:5
CREATE TABLE IF NOT EXISTS likes
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    time    datetime,
    post_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (post_id) REFERENCES post (id)
);

-- changeset Ilia:6
CREATE TABLE IF NOT EXISTS message
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    message_text VARCHAR(255),
    read_status  INT,
    time         datetime,
    sender_id    BIGINT,
    receiver_id  BIGINT,
    FOREIGN KEY (sender_id) REFERENCES users (id),
    FOREIGN KEY (receiver_id) REFERENCES users (id)
);

-- changeset Ilia:7
CREATE TABLE IF NOT EXISTS notification
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    notification_type VARCHAR(32),
    sent_time         datetime,
    user_id           BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- changeset Ilia:8
CREATE TABLE IF NOT EXISTS comment
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    comment_text      VARCHAR(255),
    is_blocked        TINYINT(1),
    parent_comment_id BIGINT,
    time              datetime,
    author_id         BIGINT,
    post_id           BIGINT,
    FOREIGN KEY (author_id) REFERENCES users (id),
    FOREIGN KEY (parent_comment_id) REFERENCES comment (id),
    FOREIGN KEY (post_id) REFERENCES post (id)
);

-- changeset Ilia:9
CREATE TABLE IF NOT EXISTS tag
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL
);

-- changeset Ilia:10
CREATE TABLE IF NOT EXISTS posts_tag
(
    post_id BIGINT,
    tag_id  BIGINT,
    FOREIGN KEY (post_id) REFERENCES post (id),
    FOREIGN KEY (tag_id) REFERENCES tag (id)
);

-- changeset Ilia:11
CREATE TABLE IF NOT EXISTS users_message
(
    user_id    BIGINT NOT NULL,
    message_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (message_id) REFERENCES message (id)
);

-- changeset Ilia:12
CREATE TABLE IF NOT EXISTS block_history
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    action  VARCHAR(32),
    time    datetime,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- changeset Ilia:13
CREATE TABLE IF NOT EXISTS users_friendships
(
    user_id        BIGINT NOT NULL,
    friendships_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (friendships_id) REFERENCES friendship (id)
);