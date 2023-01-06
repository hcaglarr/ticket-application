INSERT INTO postgres.public.authorities
    (id, create_at, create_by, permission)
VALUES
    (1,now() ,'SUPER_ADMIN','CREATE'),
    (2,now() ,'SUPER_ADMIN','READ'),
    (3,now() ,'SUPER_ADMIN','UPDATE'),
    (4,now() ,'SUPER_ADMIN','DELETE');

INSERT INTO postgres.public.roles
    (id, create_at, create_by, name)
VALUES
    (1,now() ,'SUPER_ADMIN','ADMIN'),
    (2,now() ,'SUPER_ADMIN','USER');

INSERT INTO postgres.public.users
    (id, create_at, create_by, account_non_expired, account_non_locked,
    credentials_non_expired, email, enabled, password, username)
VALUES
    ('dab167cb-2087-4012-9a13-a584bea97afd', now(), 'SUPER_ADMIN', TRUE, TRUE, TRUE, 'admin@admin.com', TRUE, '$2a$10$ylPKTjv5aVRumJJkwpcDqeyye7zwKli22C/sAWMVmrkvCXdqx9aIC', 'ADMIN'),
    ('aea3a712-e5c0-428a-9dd0-c251685a3734', now(), 'SUPER_ADMIN', TRUE, TRUE, TRUE, 'user@user.com', TRUE, '$2a$10$liMfxKK6rBU4fgmPwyOW7.SN.vvDz7wt8QkgbbAWc2Eynj8acjuh.', 'USER');

INSERT INTO postgres.public.roles_authorities
    (role_id, authority_id)
VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (2,1),
    (2,2),
    (2,3);

INSERT INTO postgres.public.user_role
    (user_id, role_id)
VALUES
    ('dab167cb-2087-4012-9a13-a584bea97afd',1),
    ('aea3a712-e5c0-428a-9dd0-c251685a3734',2);

