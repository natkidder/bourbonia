CREATE TABLE IF NOT EXISTS Contacts (
  ContactID SMALLINT AUTO_INCREMENT PRIMARY KEY,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  Dear VARCHAR(50),
  Address VARCHAR(100),
  City VARCHAR(50),
  stateOrProvince VARCHAR(2),
  PostalCode VARCHAR(10),
  Region VARCHAR(50),
  Country VARCHAR(50),
  Company VARCHAR(50),
  Title VARCHAR(50),
  WorkPhone VARCHAR(30),
  WorkExt VARCHAR(10),
  MobilePhone VARCHAR(30),
  HomePhone VARCHAR(30),
  FaxNumber VARCHAR(30),
  EmailName VARCHAR(70),
  IM_Name VARCHAR(70),
  LastMeetingDate DATE,
  ContactTypeID TINYINT,
  ReferredBy VARCHAR(50),
  RelationshipToNat VARCHAR(50),
  Importance TINYINT,
  LastUpdated TIMESTAMP(14),
  Notes MEDIUMTEXT,
  MiscInfo VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ContactTypes (
  ContactTypeID TINYINT PRIMARY KEY,
  ContactType VARCHAR(50)
); 

CREATE TABLE IF NOT EXISTS ContactTransactions (
  ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ContactID SMALLINT UNSIGNED,
  TransactDt DATE,
  TransactDesc VARCHAR(200)
);
