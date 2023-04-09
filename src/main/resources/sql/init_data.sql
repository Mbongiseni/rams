USE rams_oltp;

INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Baba', 'Baba', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bebe', 'Bebe', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bibi', 'Bibi', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bobo', 'Bobo', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bubu', 'Bubu', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Dada', 'Dada', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO role(name, description, captured, last_updated) VALUES('ADMIN','Administrator', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO role(name, description, captured, last_updated) VALUES('RESIDENT','Resident', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

