CREATE SCHEMA `weather_bootcamp` ;

CREATE TABLE `weather_bootcamp`.`location` (
  `id_location` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `region` VARCHAR(45) NULL,
  PRIMARY KEY (`id_location`));

