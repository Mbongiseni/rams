-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rams_oltp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rams_oltp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rams_oltp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `rams_oltp` ;

-- -----------------------------------------------------
-- Table `rams_oltp`.`app_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`app_user` (
                                                      `app_user_id` INT NOT NULL AUTO_INCREMENT,
                                                      `user_name` VARCHAR(45) NOT NULL,
    `pass_word` VARCHAR(45) NOT NULL,
    `captured` TIMESTAMP NULL DEFAULT NULL,
    `last_updated` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`app_user_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 18
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`home_owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`home_owner` (
                                                        `home_owner_id` INT NOT NULL AUTO_INCREMENT,
                                                        `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `primary_phone_number` VARCHAR(45) NULL DEFAULT NULL,
    `secondary_phone_number` VARCHAR(45) NULL DEFAULT NULL,
    `email_address` VARCHAR(45) NULL DEFAULT NULL,
    `captured` TIMESTAMP NULL DEFAULT NULL,
    `last_updated` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`home_owner_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`asso_app_user_home_owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`asso_app_user_home_owner` (
                                                                      `asso_app_user_home_owner_id` INT NOT NULL AUTO_INCREMENT,
                                                                      `app_user_id` INT NOT NULL,
                                                                      `home_owner_id` INT NOT NULL,
                                                                      `captured` TIMESTAMP NULL DEFAULT NULL,
                                                                      `last_updated` TIMESTAMP NULL DEFAULT NULL,
                                                                      PRIMARY KEY (`asso_app_user_home_owner_id`),
    INDEX `fk_asso_app_user_home_owner_app_user1_idx` (`app_user_id` ASC),
    INDEX `fk_asso_app_user_home_owner_home_owner1_idx` (`home_owner_id` ASC),
    CONSTRAINT `fk_asso_app_user_home_owner_app_user1`
    FOREIGN KEY (`app_user_id`)
    REFERENCES `rams_oltp`.`app_user` (`app_user_id`),
    CONSTRAINT `fk_asso_app_user_home_owner_home_owner1`
    FOREIGN KEY (`home_owner_id`)
    REFERENCES `rams_oltp`.`home_owner` (`home_owner_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`role` (
                                                  `role_id` INT NOT NULL AUTO_INCREMENT,
                                                  `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NOT NULL,
    `captured` TIMESTAMP NULL DEFAULT NULL,
    `last_updated` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`role_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`asso_app_user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`asso_app_user_role` (
                                                                `asso_app_user_role_id` INT NOT NULL AUTO_INCREMENT,
                                                                `role_id` INT NOT NULL,
                                                                `app_user_id` INT NOT NULL,
                                                                `captured` TIMESTAMP NULL DEFAULT NULL,
                                                                `last_updated` TIMESTAMP NULL DEFAULT NULL,
                                                                PRIMARY KEY (`asso_app_user_role_id`),
    INDEX `fk_home_owner_role_role1_idx` (`role_id` ASC),
    INDEX `fk_asso_app_user_role_app_user1_idx` (`app_user_id` ASC),
    CONSTRAINT `fk_asso_app_user_role_app_user1`
    FOREIGN KEY (`app_user_id`)
    REFERENCES `rams_oltp`.`app_user` (`app_user_id`),
    CONSTRAINT `fk_home_owner_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `rams_oltp`.`role` (`role_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`house`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`house` (
                                                   `house_id` INT NOT NULL AUTO_INCREMENT,
                                                   `street_name` VARCHAR(45) NOT NULL,
    `number` VARCHAR(45) NOT NULL,
    `location` VARCHAR(45) NOT NULL,
    `town` VARCHAR(45) NULL DEFAULT NULL,
    `captured` TIMESTAMP NULL DEFAULT NULL,
    `last_updated` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`house_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`asso_home_owner_house`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`asso_home_owner_house` (
                                                                   `asso_home_owner_house_id` INT NOT NULL AUTO_INCREMENT,
                                                                   `home_owner_home_owner_id` INT NOT NULL,
                                                                   `house_house_id` INT NOT NULL,
                                                                   `captured` TIMESTAMP NULL DEFAULT NULL,
                                                                   `last_updated` TIMESTAMP NULL DEFAULT NULL,
                                                                   PRIMARY KEY (`asso_home_owner_house_id`),
    INDEX `fk_asso_home_owner_house_home_owner1_idx` (`home_owner_home_owner_id` ASC),
    INDEX `fk_asso_home_owner_house_house1_idx` (`house_house_id` ASC),
    CONSTRAINT `fk_asso_home_owner_house_home_owner1`
    FOREIGN KEY (`home_owner_home_owner_id`)
    REFERENCES `rams_oltp`.`home_owner` (`home_owner_id`),
    CONSTRAINT `fk_asso_home_owner_house_house1`
    FOREIGN KEY (`house_house_id`)
    REFERENCES `rams_oltp`.`house` (`house_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`payment` (
                                                     `payment_id` INT NOT NULL AUTO_INCREMENT,
                                                     `date_payed` TIMESTAMP NOT NULL,
                                                     `amount_payed` VARCHAR(45) NOT NULL,
    `captured` TIMESTAMP NULL DEFAULT NULL,
    `last_updated` TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (`payment_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rams_oltp`.`asso_home_owner_payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rams_oltp`.`asso_home_owner_payment` (
                                                                     `asso_home_owner_payment_id` INT NOT NULL AUTO_INCREMENT,
                                                                     `home_owner_id` INT NOT NULL,
                                                                     `payment_payment_id` INT NOT NULL,
                                                                     `captured` TIMESTAMP NULL DEFAULT NULL,
                                                                     `last_updated` TIMESTAMP NULL DEFAULT NULL,
                                                                     PRIMARY KEY (`asso_home_owner_payment_id`),
    INDEX `fk_asso_home_owner_payment_home_owner1_idx` (`home_owner_id` ASC),
    INDEX `fk_asso_home_owner_payment_payment1_idx` (`payment_payment_id` ASC),
    CONSTRAINT `fk_asso_home_owner_payment_home_owner1`
    FOREIGN KEY (`home_owner_id`)
    REFERENCES `rams_oltp`.`home_owner` (`home_owner_id`),
    CONSTRAINT `fk_asso_home_owner_payment_payment1`
    FOREIGN KEY (`payment_payment_id`)
    REFERENCES `rams_oltp`.`payment` (`payment_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
