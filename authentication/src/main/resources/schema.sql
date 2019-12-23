--
-- clients клиенты сервера авторизации
--
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

--
-- users клиенты магазина
--
CREATE TABLE IF NOT EXISTS users (
                                     id INT  PRIMARY KEY,
                                     username VARCHAR(256) NOT NULL constraint unique_username unique,
                                     password VARCHAR(256) NOT NULL,
                                     fio      varchar(256) not null,
                                     phone    varchar(256) not null,
                                     enabled smallint
);





CREATE TABLE IF NOT EXISTS authorities (
                                           username VARCHAR(256) NOT NULL,
                                           authority VARCHAR(256) NOT NULL,
                                           PRIMARY KEY(username, authority)
);
