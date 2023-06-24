use `grupo-17-oo2-2023`;

insert into `grupo-17-oo2-2023`.user(enabled, password, username)
values(1, '$2a$10$KxUoFBacvSbyUjq86seGxe2pO6B9cuoBfeKyur1VLKZ9YSZH4CciG', 'admin');

insert into `grupo-17-oo2-2023`.user_role(role, user_id) values('ROLE_ADMIN', 1);

insert into `grupo-17-oo2-2023`.user(enabled, password, username)
values(1, '$2a$10$HJJGX.i64hIvs6zcKuUzV.IKVBZaO4QSwdzH9SrB4qDU1YidaVrGu', 'auditor');

insert into `grupo-17-oo2-2023`.user_role(role, user_id) values('ROLE_AUDITOR', 2);