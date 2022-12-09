insert into
    users(email, password)
values
    ('admin@example.com', '{noop}adminpass'),
    ('user@example.com', '{noop}userpass'),
    ('editor@example.com', '{noop}editorpass');

insert into
    user_role(name, description)
values
    ('ADMIN', 'pełen dostęp'),
    ('USER', 'podstawowe uprawnienia, możliwość oddawania głosów'),
    ('EDITOR','możliwość zarządzania treścia');

insert into
    user_roles (user_id, role_id)
values
    (1, 1),
    (2, 2),
    (3, 3);