--
-- пользователи пароль у всех 12345
--
insert into users( id, email, password, fio, phone, active, role) values( 1, 'admin@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Admin',   '+7(921)123-48-11', true, 'ROLE_ADMIN');
insert into users( id, email, password, fio, phone, active, role) values( 2, 'test2@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Петров',   '+7(921)123-48-12', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 3, 'test3@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Сидоров',  '+7(921)123-48-13', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 4, 'test4@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Кузнецов', '+7(921)123-48-14', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 5, 'test5@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Лавров',   '+7(921)123-48-15', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 6, 'test6@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Козин',    '+7(921)123-48-16', true, 'ROLE_USER');
