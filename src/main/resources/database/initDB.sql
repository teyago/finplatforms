CREATE TABLE IF NOT EXISTS student
(
    id         bigserial
        constraint student_pk
            primary key,
    name       VARCHAR(30) not null,
    surname    VARCHAR(30) not null,
    patronymic VARCHAR(30) not null,
    "group"    VARCHAR(30) not null,
    birthday   DATE
);