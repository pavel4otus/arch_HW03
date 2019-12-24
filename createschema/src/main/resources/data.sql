-- admin / passw0rd
INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, authorities, access_token_validity)
VALUES ('admin', '$2y$12$Aa5ruejFpTeJzAXG7IoxYOtDfepTnXsrlGwsZV9KPfh6OAB4J9bb2', 'read,write', 'password,refresh_token,client_credentials', 'ROLE_CLIENT', 300);



--
-- страны
--
insert into countries( id, code, name) values( 1, '643', 'РОССИЯ');
insert into countries( id, code, name) values( 2, '840', 'США');
insert into countries( id, code, name) values( 3, '276', 'ГЕРМАНИЯ');
insert into countries( id, code, name) values( 4, '250', 'Франция');


--
-- пользователи пароль у всех 12345
--
insert into users( id, username, password, fio, phone, active) values( 1, 'admin@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Admin',   '+7(921)123-48-11', true);
INSERT INTO authorities (username, authority) VALUES ('admin@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, active) values( 2, 'test2@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Петров',   '+7(921)123-48-12', true);
INSERT INTO authorities (username, authority) VALUES ('test2@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, active) values( 3, 'test3@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Сидоров',  '+7(921)123-48-13', true);
INSERT INTO authorities (username, authority) VALUES ('test3@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, active) values( 4, 'test4@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Кузнецов', '+7(921)123-48-14', true);
INSERT INTO authorities (username, authority) VALUES ('test4@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, active) values( 5, 'test5@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Лавров',   '+7(921)123-48-15', true);
INSERT INTO authorities (username, authority) VALUES ('test5@mail.ru', 'ROLE_USER');

insert into users( id, username, password, fio, phone, active) values( 6, 'test6@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Козин',    '+7(921)123-48-16', true);
INSERT INTO authorities (username, authority) VALUES ('test6@mail.ru', 'ROLE_USER');


--
-- города
--
insert into  cities( id, country_id, code, name) values( 1, 1, 'СПБ', 'Санкт-Петербург');
insert into  cities( id, country_id, code, name) values( 2, 1, 'МСК', 'Москва');
insert into  cities( id, country_id, code, name) values( 3, 1, 'ОРЛ', 'Орел');
insert into  cities( id,country_id,  code, name) values( 4, 1, 'ТВР', 'Тверь');

--
-- улицы
--
insert into streets ( id, city_id, name) values ( 1, 1, 'Благодатная');
insert into streets ( id, city_id, name) values ( 2, 1, 'Кирочная');
insert into streets ( id, city_id, name) values ( 3, 2, 'Земляной Вал');
insert into streets ( id, city_id, name) values ( 4, 3, 'Ленина');

--
-- адреса
--
insert into addresses( id, street_id, zip, house, building, flat) values ( 1, 1, '198302', '1а', '1', '' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 2, 2, '198302', '2а', '2', '' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 3, 3, '198302', '3а', '3', '3' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 4, 4, '198302', '4а', '4', '2' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 5, 1, '198302', '5а', '5', '1' );

--
-- склады
--
insert into warehouses( id, name, contacts, schedule, address_id) values ( 1, 'Склад 1', 'sk1@mail.ru',     'с 10.00 до 21.00', 1 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 2, 'Склад 2', '8(495)123-45-67', 'с 11.00 до 22.00', 2 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 3, 'Склад 3', '8(22390)121212',  'с 12.00 до 23.00', 3 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 4, 'Склад 4', '8(1212)121212',   'с 13.00 до 24.00', 4 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 5, 'Склад 5', '8(800)1220292009','с 14.00 до 19.00', 5 );

--
-- бренды
--
insert into brands( id, name, description, country_id) values( 1, 'Bosch', '', 3);
insert into brands( id, name, description, country_id) values( 2, 'Siemens', '', 3);
insert into brands( id, name, description, country_id) values( 3, 'Cadillac', '', 2);
insert into brands( id, name, description, country_id) values( 4, 'ВАЗ', '', 1);

--
-- категории
--
insert into categories( id, code, name) values( 1, 'ELECTR', 'Бытовая электроника');
insert into categories( id, code, name) values( 2, 'PHONES', 'Сотовые телефоны');
insert into categories( id, code, name) values( 3, 'BOOKS', 'Книги');
insert into categories( id, code, name) values( 4, 'DIGITAL', 'Цифровые товары');

--
-- товары
--
insert into goods( id, skud, name, description, smallpictureurl, largepictureurl, category_id, brand_id)
values ( 1, 1, 'Телевизор 1', 'Телевизр', '', '', 1, 1 );
insert into goods( id, skud, name, description, smallpictureurl, largepictureurl, category_id, brand_id)
values ( 2, 1, 'Телевизор 2', 'Телевизр', '', '', 1, 2 );
insert into goods( id, skud, name, description, smallpictureurl, largepictureurl, category_id, brand_id)
values ( 3, 1, 'Телевизор 3', 'Телевизр', '', '', 1, 3 );
insert into goods( id, skud, name, description, smallpictureurl, largepictureurl, category_id, brand_id)
values ( 4, 1, 'Сотовый телефон 1', 'Сотовый телефон', '', '', 2, 2 );
insert into goods( id, skud, name, description, smallpictureurl, largepictureurl, category_id, brand_id)
values ( 5, 1, 'Сотовый телефон 2', 'Сотовый телефон', '', '', 2, 2 );

commit;