


DROP USER project0 CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER project0
IDENTIFIED BY password
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to project0;
GRANT resource to project0;
GRANT create session TO project0;
GRANT create view TO project0;
GRANT create any table TO project0;
GRANT insert any table TO project0;
GRANT update any table TO project0;
GRANT delete any table TO project0;
GRANT drop any table TO project0;
GRANT create any procedure TO project0;
GRANT create any sequence TO project0;
GRANT create any trigger TO project0;

conn project0/password
------------------------------------------------------------
CREATE TABLE User_Customer
(
	Customer_Id INTEGER,
	First_Name VARCHAR2 (160),
    Last_Name VARCHAR2 (160),
	User_Name VARCHAR2 (160),
    User_Password VARCHAR2 (160),
	Approval INTEGER DEFAULT 0,
	
    CONSTRAINT Unique_User UNIQUE (User_Name),
	CONSTRAINT PK_User_Customer PRIMARY KEY (Customer_Id)	
);

CREATE TABLE User_Account
(
	Account_Id INTEGER,
	Account_Name VARCHAR2 (160),
	User_Name VARCHAR2 (160),
	Acct_Creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	Balance NUMBER DEFAULT 0,

	CONSTRAINT PK_User_Account PRIMARY KEY (Account_Id),
    CONSTRAINT FK_Customer_User FOREIGN KEY (User_Name)
    REFERENCES User_Customer(User_Name)
);

CREATE TABLE User_Transaction
(
	Transaction_Id INTEGER,
	Account_Id INTEGER,
	Transaction_Amount NUMBER,
	Transaction_Date_Time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT PK_User_Transaction PRIMARY KEY (Transaction_Id),
	CONSTRAINT FK_AccountID FOREIGN KEY (Account_Id)
    REFERENCES User_Account(Account_Id) ON DELETE CASCADE
);

CREATE TABLE User_Admin
(
	Admin_Id INTEGER NOT NULL,
    User_Name VARCHAR2(160),
    Admin_Password VARCHAR2(160),
    First_Name VARCHAR2(160),
    Last_Name VARCHAR2(160),
	Approval INTEGER DEFAULT 0,
	
	CONSTRAINT PK_User_Admin PRIMARY KEY (Admin_Id)
);

------------------------------------------------------------
CREATE SEQUENCE Customer_Increment START WITH 1 INCREMENT BY 1 MINVALUE 1 NOCACHE;
CREATE SEQUENCE Account_Increment START WITH 1 INCREMENT BY 1 MINVALUE 1 NOCACHE;
CREATE SEQUENCE Transaction_Increment START WITH 1 INCREMENT BY 1 MINVALUE 1 NOCACHE;
CREATE SEQUENCE Admin_Increment START WITH 1 INCREMENT BY 1 MINVALUE 1 NOCACHE;

CREATE OR REPLACE TRIGGER add_Customer
BEFORE INSERT ON User_Customer
FOR EACH ROW
BEGIN
    SELECT Customer_Increment.nextval 
    INTO :new.Customer_Id
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER add_Account
BEFORE INSERT ON User_Account
FOR EACH ROW
BEGIN
    SELECT Account_Increment.nextval 
    INTO :new.Account_Id
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER add_Transaction
BEFORE INSERT ON User_Transaction
FOR EACH ROW
BEGIN
    SELECT Transaction_Increment.nextval 
	INTO :new.Transaction_Id
	FROM dual;
END;
/

CREATE OR REPLACE TRIGGER add_Admin
BEFORE INSERT ON User_Admin
FOR EACH ROW
BEGIN
    SELECT Admin_Increment.nextval 
    INTO :new.Admin_Id
    FROM dual;
END;
/

------------------------------------------------------------
CREATE OR REPLACE PROCEDURE insert_Customer(First_Name1 IN VARCHAR2, Last_Name1 IN VARCHAR2, User_Name1 IN VARCHAR2, User_Password1 IN VARCHAR2)
AS
BEGIN
    INSERT INTO User_Customer(First_Name,Last_Name,User_Name,User_Password)
	VALUES(First_Name1,Last_Name1,User_Name1,User_Password1);
    COMMIT;
END;
/	

CREATE OR REPLACE PROCEDURE insert_Account(temp_User_Name IN VARCHAR2, temp_Account_Name IN VARCHAR2)
AS
BEGIN
    INSERT INTO User_Account(User_Name,Account_Name)
	VALUES(temp_User_Name,temp_Account_Name);    
    COMMIT;
END;
/	

CREATE OR REPLACE PROCEDURE insert_Transaction(temp_Account_Id IN VARCHAR2, New_Transaction IN NUMBER)
AS
BEGIN
    INSERT INTO User_Transaction(Account_Id,Transaction_Amount)
	VALUES(temp_Account_Id,New_Transaction);    
    UPDATE User_Account
    SET Balance = Balance + New_Transaction
    WHERE Account_Id = temp_Account_Id;
    COMMIT;
END;
/	

CREATE OR REPLACE PROCEDURE insert_Admin(First_Name1 IN VARCHAR2, Last_Name1 IN VARCHAR2, User_Name1 IN VARCHAR2, User_Password1 IN VARCHAR2)
AS
BEGIN
    INSERT INTO User_Admin(First_Name,Last_Name,User_Name,Admin_Password)
	VALUES(First_Name1,Last_Name1,User_Name1,User_Password1);
    COMMIT;
END;
/	

CREATE OR REPLACE PROCEDURE delete_Account(Dead_Account_Id IN INTEGER)
AS
BEGIN
	DELETE FROM User_Account 
	WHERE Account_Id = Dead_Account_Id;
	COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE approve_Customer(approved_Username IN VARCHAR2)
AS
BEGIN
	UPDATE User_Customer
	SET Approval = 1
	WHERE User_Name = approved_Username;
	COMMIT;
END;
/

