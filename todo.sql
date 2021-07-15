CREATE SEQUENCE TODO_ID_SEQ
  START WITH 1
  INCREMENT BY 1
;

CREATE TABLE todo(
id int PRIMARY KEY,
priority int not null,
content varchar not null,
date date not null,
userName varchar not null
);