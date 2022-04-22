-- To add Admin role privileges
INSERT INTO user (id, email, first_name, last_name, password)
VALUES (1, "admin@email.com", "first", "last", "admin");
INSERT INTO role (id, name) VALUES (1, "ROLE_ADMIN");
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1)