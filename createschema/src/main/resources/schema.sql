--CREATE DATABASE eshop
--WITH
--  OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'Russian_Russia.1251'
--    LC_CTYPE = 'Russian_Russia.1251'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1;

--
-- clients клиенты сервера авторизации
--
DROP TABLE if exists public.oauth_access_token cascade ;
DROP TABLE if exists public.oauth_client_details cascade ;
DROP TABLE if exists public.oauth_client_token cascade ;
DROP TABLE if exists public.oauth_code cascade ;
DROP TABLE if exists public.oauth_refresh_token cascade ;


DROP TABLE if exists public.authorities cascade ;
DROP TABLE if exists public.users cascade ;

DROP TABLE if exists public.goods cascade ;
DROP TABLE if exists public.brands cascade ;
DROP TABLE if exists public.categories cascade ;
DROP TABLE if exists public.streets cascade ;
DROP TABLE if exists public.cities cascade ;
DROP TABLE if exists public.addresses cascade ;


DROP TABLE if exists public.pricelist cascade ;
DROP TABLE if exists public.typeprice cascade ;

drop table if exists public.countries cascade ;
drop table if exists public.goods_on_warehouses cascade ;

DROP TABLE if exists public.order_items cascade ;
DROP TABLE if exists public.orders cascade ;
DROP TABLE if exists public.payment_method cascade ;
DROP TABLE if exists public.status_history cascade ;
DROP TABLE if exists public.delivery_method cascade ;
DROP TABLE if exists public.warehouses cascade ;



CREATE TABLE IF NOT EXISTS oauth_client_details (
                                                    client_id VARCHAR(256) PRIMARY KEY,
                                                    resource_ids VARCHAR(256),
                                                    client_secret VARCHAR(256) NOT NULL,
                                                    scope VARCHAR(256),
                                                    authorized_grant_types VARCHAR(256),
                                                    web_server_redirect_uri VARCHAR(256),
                                                    authorities VARCHAR(256),
                                                    access_token_validity INTEGER,
                                                    refresh_token_validity INTEGER,
                                                    additional_information VARCHAR(4000),
                                                    autoapprove VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_client_token (
                                                  token_id VARCHAR(256),
                                                  token bytea,
                                                  authentication_id VARCHAR(256) PRIMARY KEY,
                                                  user_name VARCHAR(256),
                                                  client_id VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
                                                  token_id VARCHAR(256),
                                                  token bytea,
                                                  authentication_id VARCHAR(256),
                                                  user_name VARCHAR(256),
                                                  client_id VARCHAR(256),
                                                  authentication bytea,
                                                  refresh_token VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
                                                   token_id VARCHAR(256),
                                                   token bytea,
                                                   authentication bytea
);

CREATE TABLE IF NOT EXISTS oauth_code (
                                          code VARCHAR(256), authentication bytea
);



CREATE TABLE IF NOT EXISTS authorities (
                                           username VARCHAR(256) NOT NULL,
                                           authority VARCHAR(256) NOT NULL,
                                           PRIMARY KEY(username, authority)
);

create table addresses (id  bigserial not null, building varchar(255), flat varchar(255), house varchar(255), zip varchar(255), street_id int8, primary key (id));
  create table brands (id  bigserial not null, description varchar(255), logo varchar(255), name varchar(255), country_id int8, primary key (id));
  create table categories (id  bigserial not null, code varchar(255), name varchar(255), primary key (id));
  create table cities (id  bigserial not null, code varchar(255), name varchar(255), country_id int8, primary key (id));
  create table countries (id  bigserial not null, code varchar(255), name varchar(255), primary key (id));
  create table delivery_method (id  bigserial not null, code varchar(255), name varchar(255), primary key (id));
  create table goods (id  bigserial not null, description varchar(255), largepictureurl varchar(255), name varchar(255), skud int8, smallpictureurl varchar(255), brand_id int8, category_id int8, primary key (id));
  create table goods_on_warehouses (id int8 not null, good_id  bigserial not null, qnty int8, warehouse_id int8 not null, primary key (good_id, warehouse_id));
  create table order_items (id  bigserial not null, price float8, quantity int4, good_id int8, order_id int8, primary key (id));
  create table orders (id  bigserial not null, delivery_address_id int8, delivery_method_id int8, payment_method_id int8, user_id int8, primary key (id));
  create table payment_method (id  bigserial not null, code varchar(255), name varchar(255), payment_url varchar(255), primary key (id));
  create table pricelist (id  bigserial not null, datefrom date, date_to date, price float8, good_id int8, typeprice_id int8, ware_house_id int8, primary key (id));
  create table status_history (id  bigserial not null, date_from timestamp, date_to timestamp, address_id int8, order_id int8, primary key (id));
  create table streets (id  bigserial not null, name varchar(255), city_id int8, primary key (id));
  create table typeprice (id  bigserial not null, name varchar(255), primary key (id));
  create table users (id  bigserial not null, active boolean, username varchar(255), fio varchar(255), password varchar(255), phone varchar(255), role varchar(255), primary key (id));
  create table warehouses (id  bigserial not null, contacts varchar(255), name varchar(255), schedule varchar(255), address_id int8, primary key (id));
  alter table addresses add constraint FK1os4rpeeaugj76t9ak612wtj8 foreign key (street_id) references streets;
  alter table brands add constraint FK3b8m95t9tmnpw4du5krk9bpol foreign key (country_id) references countries;
  alter table cities add constraint FK6gatmv9dwedve82icy8wrkdmk foreign key (country_id) references countries;
  alter table goods add constraint FKq0mwjy71tw44tcqnj2hb056hm foreign key (brand_id) references brands;
  alter table goods add constraint FKm164hdre8y3lew7lvtu0sneqe foreign key (category_id) references categories;
  alter table goods_on_warehouses add constraint FK4knv1caau2vyslmfoyrj8kj4m foreign key (warehouse_id) references warehouses;
  alter table goods_on_warehouses add constraint FK6k4lwrcgo8ukesbhfpbwr4o5i foreign key (good_id) references goods;
  alter table order_items add constraint FKmvm09ockbbse56dmhmlnj5rri foreign key (good_id) references goods;
  alter table order_items add constraint FKbioxgbv59vetrxe0ejfubep1w foreign key (order_id) references orders;
  alter table orders add constraint FK3s2t83m5ddty3rgomn94d4ht6 foreign key (delivery_address_id) references addresses;
  alter table orders add constraint FKq2m2xkvrir0eftwpixx46v9l5 foreign key (delivery_method_id) references delivery_method;
  alter table orders add constraint FKgeqwl6x0iadp9e2459uh3o8fv foreign key (payment_method_id) references payment_method;
  alter table orders add constraint FK32ql8ubntj5uh44ph9659tiih foreign key (user_id) references users;
  alter table pricelist add constraint FKa8ick0q1tg7wfadh5h3ri1drw foreign key (good_id) references goods;
  alter table pricelist add constraint FK4kmsdbifq9lvgt0jk2t0tlg9s foreign key (typeprice_id) references typeprice;
  alter table pricelist add constraint FKmtoaefqjcsoms58i34y0x9jgc foreign key (ware_house_id) references warehouses;
  alter table status_history add constraint FK9lcmdeo5a1775njff5bj7fmh7 foreign key (address_id) references addresses;
  alter table status_history add constraint FKov2onvtb867gv4uumrwu623vp foreign key (order_id) references orders;
  alter table streets add constraint FKefsv8gxpfki4pn4x1nfp7cv4h foreign key (city_id) references cities;
  alter table warehouses add constraint FK4e4lvoo6ncfomibepxlmok94l foreign key (address_id) references addresses;
