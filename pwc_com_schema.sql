CREATE SCHEMA `company`;
use company;
drop table if exists employee;
drop table if exists department;
drop table if exists project;

CREATE TABLE `employee`
(
    `employeeID` BIGINT  NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45) NOT NULL,
    `Email`       VARCHAR(45) NOT NULL,
    `Role`       VARCHAR(45) DEFAULT NULL,
    `MangerID`   BIGINT DEFAULT NULL,
    `departmentID`   INT DEFAULT NULL,
    PRIMARY KEY (`employeeID`),
    UNIQUE (`employeeID`),
    UNIQUE (`Email`)

) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = LATIN1;


CREATE TABLE `department`
(
    `departmentID` INT         NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(45) NOT NULL,
    PRIMARY KEY (`DepartmentID`),
    UNIQUE (`DepartmentID`)
) ENGINE = INNODB

  DEFAULT CHARSET = LATIN1;

CREATE TABLE `project`
(
    `ProjectID`   BIGINT NOT NULL,
    `ProjectName` INT NOT NULL,
    `DepartmentID` INT NOT NULL,
    PRIMARY KEY (`ProjectID`),
    UNIQUE (`ProjectID`)

) ENGINE = INNODB
  DEFAULT CHARSET = LATIN1;



ALTER TABLE employee
    add constraint FOREIGN KEY (departmentID) REFERENCES department (departmentID);
ALTER TABLE project
    add constraint FOREIGN KEY (DepartmentID) REFERENCES department (DepartmentID);





