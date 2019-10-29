-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema messageTreeDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `messageTreeDB` ;

-- -----------------------------------------------------
-- Schema messageTreeDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `messageTreeDB` DEFAULT CHARACTER SET latin1 ;
USE `messageTreeDB` ;

-- -----------------------------------------------------
-- Table `message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message` ;

CREATE TABLE IF NOT EXISTS `message` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NOT NULL,
  `parentID` INT(11) NULL DEFAULT NULL,
  `likes` INT(11) NULL DEFAULT '0',
  `timestamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO user;
 DROP USER user;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'user' IDENTIFIED BY 'userpw';

GRANT ALL ON * TO 'user';
GRANT ALL ON * TO 'user';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `messageTreeDB`.`message`
-- -----------------------------------------------------
START TRANSACTION;
USE `messageTreeDB`;
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (1, 'This is a message', NULL, 2, DEFAULT);
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (2, 'This is a comment', 1, 3, DEFAULT);
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (3, 'This is a comment on a comment', 2, -3, DEFAULT);
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (4, 'This is another comment on a comment', 2, -2, DEFAULT);
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (5, 'Yet another comment on a comment', 2, -1, DEFAULT);
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (6, 'This is a new message', , 3, DEFAULT);
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (7, 'This is a commet on the new message', 6, 10, DEFAULT);
INSERT INTO `messageTreeDB`.`message` (`id`, `content`, `parentID`, `likes`, `timestamp`) VALUES (8, 'Another comment on that new message', 6, -9, DEFAULT);

COMMIT;
