USE rams_oltp;

INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Baba', 'Baba', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bebe', 'Bebe', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bibi', 'Bibi', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bobo', 'Bobo', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Bubu', 'Bubu', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO app_user(user_name, pass_word, captured, last_updated)VALUES('Dada', 'Dada', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO role(name, description, captured, last_updated) VALUES('ADMIN','Administrator', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO role(name, description, captured, last_updated) VALUES('RESIDENT','Resident', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO home_owner(first_name,last_name, primary_phone_number, secondary_phone_number, email_address, captured, last_updated)
VALUES('Baba','Baba','011 123 1234','011 123 1234','baba@gmail.com',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO home_owner(first_name,last_name, primary_phone_number, secondary_phone_number, email_address, captured, last_updated)
VALUES('Bebe','Bebe','011 123 1235','011 123 1235','bebe@gmail.com',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO home_owner(first_name,last_name, primary_phone_number, secondary_phone_number, email_address, captured, last_updated)
VALUES('Bibi','Bibi','011 123 1236','011 123 1236','bibi@gmail.com',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO home_owner(first_name,last_name, primary_phone_number, secondary_phone_number, email_address, captured, last_updated)
VALUES('Bobo','Bobo','011 123 1237','011 123 1237','bobo@gmail.com',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO home_owner(first_name,last_name, primary_phone_number, secondary_phone_number, email_address, captured, last_updated)
VALUES('Bubu','Bubu','011 123 1238','011 123 1238','bubu@gmail.com',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());


INSERT INTO house(street_name, number, location, town, captured, last_updated) VALUES('Colonel', '4274', 'Witpoortjie Estate', 'Roodepoort', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO house(street_name, number, location, town, captured, last_updated) VALUES('Colonel', '4275', 'Witpoortjie Estate', 'Roodepoort', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO house(street_name, number, location, town, captured, last_updated) VALUES('Colonel', '4276', 'Witpoortjie Estate', 'Roodepoort', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO house(street_name, number, location, town, captured, last_updated) VALUES('Colonel', '4277', 'Witpoortjie Estate', 'Roodepoort', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO house(street_name, number, location, town, captured, last_updated) VALUES('Colonel', '4278', 'Witpoortjie Estate', 'Roodepoort', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());


