CREATE TABLE USER
(
    ID         INT auto_increment,
    ACCOUNT_ID VARCHAR(100),
    NAME       VARCHAR(50),
    TOKEN      VARCHAR(50),
    GMT_CREATE BIGINT,
    GMT_MODIFY BIGINT,
    BIO        VARCHAR(256),
    AVATAR_URL VARCHAR(100),
    constraint USER_PK
        primary key (ID)
);


