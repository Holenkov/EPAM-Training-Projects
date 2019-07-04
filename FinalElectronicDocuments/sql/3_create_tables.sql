USE `epam_documents`;

CREATE TABLE `employeePosition` (
  `positionID` TINYINT(2) NOT NULL,
  `position` VARCHAR(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userRoles` (
  `roleID` TINYINT(2) NOT NULL,
  `role` VARCHAR(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employeeStatus` (
  `emplStatusID` TINYINT(2) NOT NULL,
  `emplStatus` VARCHAR(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
  `employeeID` INT(5) NOT NULL,
  `pic` blob NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `firstName` VARCHAR(32) NOT NULL,
  `lastName` VARCHAR(32) NOT NULL,
  `position` TINYINT(2) DEFAULT NULL,
  `role` TINYINT(2) DEFAULT NULL,
  `employeeStatus` TINYINT(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `documentType` (
  `docTypeID` TINYINT(2) NOT NULL,
  `docType` VARCHAR(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `documentStatus` (
  `docStatusID` TINYINT(2) NOT NULL,
  `docStatus` VARCHAR(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `document` (
  `docID` INT(8) NOT NULL,
  `authorID` INT(5) NOT NULL,
  `docType` TINYINT(2) NOT NULL,
  `keywords` VARCHAR(64) NOT NULL,
  `textBody` VARCHAR(1000) NOT NULL,
  `dateUpdated` TIMESTAMP NOT NULL,
  `dateToExecute` TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `subordination` (
  `id` INT(8) NOT NULL,
  `senderID` INT(5) NOT NULL,
  `docTypeID` TINYINT(2) NOT NULL,
  `receiverID` INT(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `documentHistory` (
  `id` INT(5) NOT NULL,
  `docID` INT(8) NOT NULL,
  `fromID` INT(5) NOT NULL,
  `toID` INT(5) NOT NULL,
  `dateExecuted` TIMESTAMP NULL DEFAULT NULL,
  `docStatus` TINYINT(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




ALTER TABLE `employeePosition`
  ADD PRIMARY KEY (`positionID`),
   MODIFY `positionID` TINYINT(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
 COMMIT;

ALTER TABLE `userRoles`
  ADD PRIMARY KEY (`roleID`),
  MODIFY `roleID` TINYINT(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

ALTER TABLE `employeeStatus`
  ADD PRIMARY KEY (`emplStatusID`),
  MODIFY `emplStatusID` TINYINT(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `employeeStatus` (`employeeStatus`),
  ADD KEY `position` (`position`),
  ADD KEY `role` (`role`),
  MODIFY `employeeID` INT(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38,
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`employeeStatus`) REFERENCES `employeeStatus` (`emplStatusID`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`position`) REFERENCES `employeePosition` (`positionID`),
  ADD CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`role`) REFERENCES `userRoles` (`roleID`);
COMMIT;

ALTER TABLE `documentType`
  ADD PRIMARY KEY (`docTypeID`),
  MODIFY `docTypeID` TINYINT(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;
  
  ALTER TABLE `documentStatus`
  ADD PRIMARY KEY (`docStatusID`),
  MODIFY `docStatusID` TINYINT(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;
  
ALTER TABLE `document`
  ADD PRIMARY KEY (`docID`),
  ADD KEY `docType` (`docType`),
  ADD KEY `authorID` (`authorID`),
  MODIFY `docID` INT(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21,
  ADD CONSTRAINT `document_ibfk_1` FOREIGN KEY (`docType`) REFERENCES `documentType` (`docTypeID`),
  ADD CONSTRAINT `document_ibfk_2` FOREIGN KEY (`authorID`) REFERENCES `employee` (`employeeID`);
COMMIT;

ALTER TABLE `subordination`
  ADD PRIMARY KEY (`id`),
  ADD KEY `docTypeID` (`docTypeID`),
  ADD KEY `receiverID` (`receiverID`),
  ADD KEY `senderID` (`senderID`),
  MODIFY `id` INT(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59,
  ADD CONSTRAINT `subordination_ibfk_1` FOREIGN KEY (`docTypeID`) REFERENCES `documentType` (`docTypeID`),
  ADD CONSTRAINT `subordination_ibfk_2` FOREIGN KEY (`receiverID`) REFERENCES `employee` (`employeeID`),
  ADD CONSTRAINT `subordination_ibfk_3` FOREIGN KEY (`senderID`) REFERENCES `employee` (`employeeID`);
COMMIT;

ALTER TABLE `documentHistory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `docID` (`docID`),
  ADD KEY `employeeID` (`fromID`),
  ADD KEY `toID` (`toID`),
  ADD KEY `docStatus` (`docStatus`),
  MODIFY `id` INT(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21,
  ADD CONSTRAINT `documenthistory_ibfk_1` FOREIGN KEY (`docID`) REFERENCES `document` (`docID`),
  ADD CONSTRAINT `documenthistory_ibfk_2` FOREIGN KEY (`fromID`) REFERENCES `employee` (`employeeID`),
  ADD CONSTRAINT `documenthistory_ibfk_3` FOREIGN KEY (`toID`) REFERENCES `employee` (`employeeID`),
  ADD CONSTRAINT `documenthistory_ibfk_4` FOREIGN KEY (`docStatus`) REFERENCES `documentStatus` (`docStatusID`);
COMMIT;






