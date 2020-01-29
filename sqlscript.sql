CREATE DATABASE candidates;
CREATE TABLE `candidates`.`candidate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `contact_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
  USE candidates;
  SELECT * FROM candidate;
  
  INSERT INTO `candidates`.`candidate` (`full_name`, `date_of_birth`, `contact_number`, `email`) VALUES ('Bill Gates', '15.8.1997', '069583352', 'bill.gates@gmail.com');
  INSERT INTO `candidates`.`candidate` (`full_name`, `date_of_birth`, `contact_number`, `email`) VALUES ('John Snow', '4.3.1997', '069583352', 'john.snow@gmail.com');
  INSERT INTO `candidates`.`candidate` (`full_name`, `date_of_birth`, `contact_number`, `email`) VALUES ('Steve Jobs', '25.11.1997', '069583352', 'steve.jobs@gmail.com');

  SELECT * FROM candidate;
