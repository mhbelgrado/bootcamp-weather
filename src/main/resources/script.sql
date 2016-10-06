-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BOOTCAMP_WEATHER
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BOOTCAMP_WEATHER` ;

-- -----------------------------------------------------
-- Schema BOOTCAMP_WEATHER
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BOOTCAMP_WEATHER` DEFAULT CHARACTER SET utf8 ;
USE `BOOTCAMP_WEATHER` ;

-- -----------------------------------------------------
-- Table `BOOTCAMP_WEATHER`.`CURRENT_DAY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BOOTCAMP_WEATHER`.`CURRENT_DAY` ;

CREATE TABLE IF NOT EXISTS `BOOTCAMP_WEATHER`.`CURRENT_DAY` (
  `DATE` DATE NOT NULL,
  `TEMPERATURE` FLOAT NOT NULL,
  `DESCRIPTION` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`DATE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOOTCAMP_WEATHER`.`WIND`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BOOTCAMP_WEATHER`.`WIND` ;

CREATE TABLE IF NOT EXISTS `BOOTCAMP_WEATHER`.`WIND` (
  `ID_WIND` INT NOT NULL AUTO_INCREMENT,
  `SPEED` INT NOT NULL,
  `DIRECTION` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`ID_WIND`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOOTCAMP_WEATHER`.`ATMOSPHERE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BOOTCAMP_WEATHER`.`ATMOSPHERE` ;

CREATE TABLE IF NOT EXISTS `BOOTCAMP_WEATHER`.`ATMOSPHERE` (
  `ID_ATMOSPHERE` INT NOT NULL AUTO_INCREMENT,
  `HUMIDITY` INT NOT NULL,
  `PRESSURE` FLOAT NOT NULL,
  `VISIBILITY` FLOAT NOT NULL,
  `RISING` FLOAT NOT NULL,
  PRIMARY KEY (`ID_ATMOSPHERE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOOTCAMP_WEATHER`.`LOCATION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BOOTCAMP_WEATHER`.`LOCATION` ;

CREATE TABLE IF NOT EXISTS `BOOTCAMP_WEATHER`.`LOCATION` (
  `ID_LOCATION` INT NOT NULL AUTO_INCREMENT,
  `CITY` VARCHAR(45) NOT NULL,
  `COUNTRY` VARCHAR(45) NOT NULL,
  `REGION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_LOCATION`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOOTCAMP_WEATHER`.`FORECAST`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BOOTCAMP_WEATHER`.`FORECAST` ;

CREATE TABLE IF NOT EXISTS `BOOTCAMP_WEATHER`.`FORECAST` (
  `ID_FORECAST` INT NOT NULL AUTO_INCREMENT,
  `WIND_ID` INT NOT NULL,
  `LOCATION_ID` INT NOT NULL,
  `CURRENT_DAY_ID` DATE NOT NULL,
  `ATMOSPHERE_ID` INT NOT NULL,
  PRIMARY KEY (`ID_FORECAST`),
  CONSTRAINT `WIND_FK`
    FOREIGN KEY (`WIND_ID`)
    REFERENCES `BOOTCAMP_WEATHER`.`WIND` (`ID_WIND`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ATMOSPHERE_FK`
    FOREIGN KEY (`ATMOSPHERE_ID`)
    REFERENCES `BOOTCAMP_WEATHER`.`ATMOSPHERE` (`ID_ATMOSPHERE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `LOCATION_FK`
    FOREIGN KEY (`LOCATION_ID`)
    REFERENCES `BOOTCAMP_WEATHER`.`LOCATION` (`ID_LOCATION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CURRENT_DAY_ID`
    FOREIGN KEY (`CURRENT_DAY_ID`)
    REFERENCES `BOOTCAMP_WEATHER`.`CURRENT_DAY` (`DATE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `WIND_FK_idx` ON `BOOTCAMP_WEATHER`.`FORECAST` (`WIND_ID` ASC);

CREATE INDEX `ATMOSPHERE_FK_idx` ON `BOOTCAMP_WEATHER`.`FORECAST` (`ATMOSPHERE_ID` ASC);

CREATE INDEX `LOCATION_FK_idx` ON `BOOTCAMP_WEATHER`.`FORECAST` (`LOCATION_ID` ASC);

CREATE INDEX `CURRENT_DAY_ID_idx` ON `BOOTCAMP_WEATHER`.`FORECAST` (`CURRENT_DAY_ID` ASC);


-- -----------------------------------------------------
-- Table `BOOTCAMP_WEATHER`.`EXTENDED_FORECAST`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BOOTCAMP_WEATHER`.`EXTENDED_FORECAST` ;

CREATE TABLE IF NOT EXISTS `BOOTCAMP_WEATHER`.`EXTENDED_FORECAST` (
  `ID_EXTENDED_FORECAST` INT NOT NULL AUTO_INCREMENT,
  `DATE` DATE NOT NULL,
  `DAY_OF_WEEK` VARCHAR(45) NOT NULL,
  `MAXIMUM_TEMP` INT NOT NULL,
  `MINIMUM_TEMP` INT NOT NULL,
  `DESCRIPTION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_EXTENDED_FORECAST`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOOTCAMP_WEATHER`.`FORECAST_EXTENDEDFORECAST`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BOOTCAMP_WEATHER`.`FORECAST_EXTENDEDFORECAST` ;

CREATE TABLE IF NOT EXISTS `BOOTCAMP_WEATHER`.`FORECAST_EXTENDEDFORECAST` (
  `ID_FORECAST_EXTENDEDFORCAST` INT NOT NULL AUTO_INCREMENT,
  `FORECAST_ID` INT NOT NULL,
  `EXTENDEDFORCAST_ID` INT NOT NULL,
  PRIMARY KEY (`ID_FORECAST_EXTENDEDFORCAST`),
  CONSTRAINT `EXTENDEDFORECAST_FK`
    FOREIGN KEY (`EXTENDEDFORCAST_ID`)
    REFERENCES `BOOTCAMP_WEATHER`.`EXTENDED_FORECAST` (`ID_EXTENDED_FORECAST`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FORECAST_FK`
    FOREIGN KEY (`FORECAST_ID`)
    REFERENCES `BOOTCAMP_WEATHER`.`FORECAST` (`ID_FORECAST`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `EXTENDEDFORECAST_FK_idx` ON `BOOTCAMP_WEATHER`.`FORECAST_EXTENDEDFORECAST` (`EXTENDEDFORCAST_ID` ASC);

CREATE INDEX `FORECAST_FK_idx` ON `BOOTCAMP_WEATHER`.`FORECAST_EXTENDEDFORECAST` (`FORECAST_ID` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
