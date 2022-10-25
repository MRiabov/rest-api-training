CREATE DATABASE userDB;

USE userDB;

CREATE TABLE user
(
    id           BIGINT       NOT NULL,
    email        VARCHAR(255) NULL,
    first_name   VARCHAR(255) NULL,
    last_name    VARCHAR(255) NULL,
    birth_date   datetime     NULL,
    address      VARCHAR(255) NULL,
    phone_number VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);