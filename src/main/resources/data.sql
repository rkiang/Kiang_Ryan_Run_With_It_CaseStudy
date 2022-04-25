-- To add Admin role privileges
INSERT INTO user (id, email, first_name, last_name, password)
--Inserted password is "admin"
VALUES (1, "admin@admin.com", "first", "last", "{bcrypt}$2a$10$MpMM/qjPrAJTw2K3jM4PgOMAzKkbTk/FmOy4pT5V.BSJB//ryCTjK");
INSERT INTO role (id, name) VALUES (1, "ROLE_ADMIN");
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);