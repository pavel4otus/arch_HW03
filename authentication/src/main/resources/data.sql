-- admin / passw0rd
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, authorities, access_token_validity)
VALUES ('admin', '$2y$12$Aa5ruejFpTeJzAXG7IoxYOtDfepTnXsrlGwsZV9KPfh6OAB4J9bb2', 'read,write', 'password,refresh_token,client_credentials', 'ROLE_CLIENT', 300);



-- The encrypted password is `pass`
-- INSERT INTO users (id, username, password, fio,  phone, enabled) VALUES (1, 'user', '$2y$12$yrWMEf0ewwJ6s1A0VzRI9uDu.SlvEao3/NNQS5q0riTT2rhBREKay', 1);
-- INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');

--
-- пользователи пароль у всех 12345
--
insert into users( id, username, password, fio, phone, enabled) values( 1, 'admin@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Admin',   '+7(921)123-48-11', 1);
INSERT INTO authorities (username, authority) VALUES ('admin@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, enabled) values( 2, 'test2@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Петров',   '+7(921)123-48-12', 1);
INSERT INTO authorities (username, authority) VALUES ('test2@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, enabled) values( 3, 'test3@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Сидоров',  '+7(921)123-48-13', 1);
INSERT INTO authorities (username, authority) VALUES ('test3@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, enabled) values( 4, 'test4@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Кузнецов', '+7(921)123-48-14', 1);
INSERT INTO authorities (username, authority) VALUES ('test4@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, enabled) values( 5, 'test5@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Лавров',   '+7(921)123-48-15', 1);
INSERT INTO authorities (username, authority) VALUES ('test5@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, enabled) values( 6, 'test6@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Козин',    '+7(921)123-48-16', 1);
INSERT INTO authorities (username, authority) VALUES ('test6@mail.ru', 'ROLE_USER');
