-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fkedupl_pwngr
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fkedupl_pwngr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fkedupl_pwngr` DEFAULT CHARACTER SET utf8 ;
USE `fkedupl_pwngr` ;

-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Dni_szkolenia_trenerzy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Dni_szkolenia_trenerzy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dzien` DATE NULL DEFAULT NULL,
  `wolne` TINYINT(4) NULL DEFAULT NULL,
  `szkolenia_id` INT(11) NOT NULL,
  `trenerzy_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Dni_szkolenia_trenerzy_Szkolenia1_idx` (`szkolenia_id` ASC),
  INDEX `fk_Dni_szkolenia_trenerzy_Trenerzy1_idx` (`trenerzy_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 766
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Kat_tematyczne`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Kat_tematyczne` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nazwa` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nazwa_UNIQUE` (`nazwa` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Kat_tematyczne_kursy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Kat_tematyczne_kursy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `kursy_id` INT(11) NOT NULL,
  `kat_tematyczne_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Kat_tematyczne_kursu_Kursy1_idx` (`kursy_id` ASC),
  INDEX `fk_Kat_tematyczne_kursu_Kat_tematyczne1_idx` (`kat_tematyczne_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Kat_tematyczne_trenerzy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Kat_tematyczne_trenerzy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `trenerzy_id` INT(11) NOT NULL,
  `kat_tematyczne_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Kat_tematyczne_trenerzy_Trenerzy1_idx` (`trenerzy_id` ASC),
  INDEX `fk_Kat_tematyczne_trenerzy_Kat_tematyczne1_idx` (`kat_tematyczne_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Kursy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Kursy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nazwa` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `ile_dni` INT(3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nazwa_UNIQUE` (`nazwa` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Swieta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Swieta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `data_UNIQUE` (`data` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 1001
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Szkolenia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Szkolenia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `akronim` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `data_od` DATE NULL DEFAULT NULL,
  `data_do` DATE NULL DEFAULT NULL,
  `typ_szkolen` VARCHAR(1) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `kursy_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `akronim_UNIQUE` (`akronim` ASC),
  INDEX `fk_Szkolenia_Kursy_idx` (`kursy_id` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `fkedupl_pwngr`.`Trenerzy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fkedupl_pwngr`.`Trenerzy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `imie` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `nazwisko` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `inicjaly` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `haslo` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `mentor` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `inicjaly_UNIQUE` (`inicjaly` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

USE `fkedupl_pwngr`;

DELIMITER $$
USE `fkedupl_pwngr`$$
CREATE
DEFINER=`fkedupl_pwn`@`%`
TRIGGER `fkedupl_pwngr`.`Dni_szkolenia_trenerzy_BEFORE_UPDATE`
BEFORE UPDATE ON `fkedupl_pwngr`.`Dni_szkolenia_trenerzy`
FOR EACH ROW
BEGIN
	if new.Trenerzy_id > 0 then
		update Dni_szkolenia_trenerzy set new.wolne=1;
	end if;
End$$

USE `fkedupl_pwngr`$$
CREATE
DEFINER=`fkedupl_pwn`@`%`
TRIGGER `fkedupl_pwngr`.`Szkolenia_BEFORE_INSERT`
BEFORE INSERT ON `fkedupl_pwngr`.`Szkolenia`
FOR EACH ROW
BEGIN
	if new.data_od > new.data_do then
		signal SQLSTATE VALUE '99999' SET MESSAGE_TEXT = 'Data od szkolenia nie może być późniejsza niż data do';
    end if;
    if new.data_do - new.data_od + 1 < (select ile_dni from Kursy where id = new.kursy_id) then
		signal SQLSTATE VALUE '99998' SET MESSAGE_TEXT = 'Pomiędzy datą od i datą do szkolenia muszą się zmieścić wszystkie dni kursu';
    end if;
END$$

USE `fkedupl_pwngr`$$
CREATE
DEFINER=`fkedupl_pwn`@`%`
TRIGGER `fkedupl_pwngr`.`Dni Szkolenia_AFTER_INSERT`
AFTER INSERT ON `fkedupl_pwngr`.`Szkolenia`
FOR EACH ROW
BEGIN
declare x int;
declare dz_szk date;
declare swieto int;
set x=0;
While new.data_od + x <= new.data_do do
	set dz_szk = new.data_od + x;
	if (new.typ_szkolen = 'd' and WEEKDAY(dz_szk) < 5 )
		or (new.typ_szkolen = 'w' and WEEKDAY(dz_szk) > 4 ) then

		set swieto = (select count(1) from Swieta where dz_szk = data);
		insert into Dni_szkolenia_trenerzy(dzien,wolne,Szkolenia_id,Trenerzy_id)
		values(new.data_od+x, swieto, new.id, '0');

    end if;
set x=x+1;
end while;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
