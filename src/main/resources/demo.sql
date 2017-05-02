-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pool_ref
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `recovery_demo` DEFAULT CHARACTER SET utf8 ;
USE `recovery_demo` ;

-- -----------------------------------------------------
-- Table `recovery_demo`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `recovery_demo`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `forename` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `hashed_password` VARCHAR(80) NOT NULL,
  `securtity_question_id` INT(11) NULL
  `securtity_question_answer` VARCHAR(80) NULL
  PRIMARY KEY (`id`),
  UNIQUE INDEX `Id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `recovery_demo`.`security_question` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

INSERT INTO `recovery_demo`.`security_question` (id, question)
VALUES ('1', "What is your mother's maiden name?"), ('2', "In what city were you born?"), ('3', "What secondary school did you attend?"), ('4', "What street did you grow up on?"), ('5', "What was the make of your first car?"), ('6', "Which is your favorite web browser?"), ('7', "What is the name of your favorite pet?");

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
