drop table if exists users CASCADE;
drop table if exists articles CASCADE;

create table users (id integer generated by default as identity, age integer, name varchar(255), primary key (id));
create table articles (id integer generated by default as identity, color integer, text varchar(255), user_id integer not null, primary key (id));

INSERT into Users (age, name) values (38, 'Andrii');
INSERT into Users (age, name) values (13, 'Igor');
INSERT into Users (age, name) values (10, 'Petro');
INSERT into Users (age, name) values (42, 'Taras');
INSERT into Users (age, name) values (17, 'Solomia');

INSERT into Articles(Color, text, user_id) values (0, 'Spring by Andrii', 1);
INSERT into Articles(Color, text, user_id) values (2, 'Winter by Andrii', 1);
INSERT into Articles(Color, text, user_id) values (1, 'Summer by Andrii', 1);
INSERT into Articles(Color, text, user_id) values (1, 'Autumn by Andrii', 1);
INSERT into Articles(Color, text, user_id) values (3, 'Spring by Igor', 2);
INSERT into Articles(Color, text, user_id) values (0, 'Summer by Petro', 3);
INSERT into Articles(Color, text, user_id) values (1, 'Summer by Petro', 3);
INSERT into Articles(Color, text, user_id) values (0, 'Something by Taras', 4);
INSERT into Articles(Color, text, user_id) values (3, 'NoOne by Taras', 4);
INSERT into Articles(Color, text, user_id) values (0, 'Text by Solomia', 5);
INSERT into Articles(Color, text, user_id) values (0, 'Another text by Olomia', 5);