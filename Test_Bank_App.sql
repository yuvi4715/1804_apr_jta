--Create a user and password for the Bank Database
CREATE USER Bank_Admin IDENTIFIED BY MONEY;

--Grant privileges to the user
GRANT connect TO Bank_Admin;
GRANT create any table TO Bank_Admin;
GRANT create any procedure TO Bank_Admin;
GRANT create any sequence TO Bank_Admin;
GRANT create any trigger TO Bank_Admin;
GRANT insert any table TO Bank_Admin;
GRANT update any table TO Bank_Admin;
GRANT delete any table TO Bank_Admin;
GRANT drop any table TO Bank_Admin;
GRANT resource TO Bank_Admin;
GRANT unlimited tablespace TO Bank_Admin;



--Create the User Table
CREATE TABLE bank_user(
user_id INTEGER,
first_name VARCHAR2(20),
Last_name VARCHAR2(20),
username VARCHAR2(30) UNIQUE NOT NULL,
password VARCHAR2(30) NOT NULL,
is_approved INTEGER DEFAULT 0, --If you do not provide a value for is_approved it is assigned 0 for false 
is_admin INTEGER DEFAULT 0,    --If you do not provide a value for is_admin it is assigned 0 for false 
CONSTRAINT PK_USER PRIMARY KEY (user_id)
);


--Create the Account Table
CREATE TABLE account(
user_id INTEGER,
account_id INTEGER,
account_name VARCHAR2(15),
balance INTEGER DEFAULT 500,-- Minimum vaule for a new account    
CONSTRAINT PK_Account PRIMARY KEY (account_id),
CONSTRAINT FK_USER_ENTRY FOREIGN KEY (user_id) REFERENCES bank_user(user_id) ON DELETE CASCADE 
);

	
--Create a Sequence to generate the value for the Account PK's
CREATE SEQUENCE account_id_sequence
    START WITH 6789 
    INCREMENT BY 1
    MAXVALUE 2147483646
    MINVALUE -1
    NOCACHE;


--Create an INSERT trigger on account to auto-increment the PK
CREATE OR REPLACE TRIGGER before_account
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
    IF :NEW.account_id IS NULL THEN 
        SELECT account_id_sequence.nextval INTO :NEW.account_id FROM dual;
    END IF;
END;
/

--Create a Sequence to generate the value for the Bank User PK's
CREATE SEQUENCE user_id_sequence
    START WITH 12345 
    INCREMENT BY 1
    MAXVALUE 2147483646
    MINVALUE -1
    NOCACHE;


--Create an INSERT trigger on bank_user to auto-increment the PK
CREATE OR REPLACE TRIGGER before_bank_user
BEFORE INSERT ON bank_user
FOR EACH ROW
BEGIN
    IF :NEW.user_id IS NULL THEN 
        SELECT user_id_sequence.nextval INTO :NEW.user_id FROM dual;
    END IF;
END;
/


--Create a Stored Procedure to INSERT a new bank_user
CREATE OR REPLACE PROCEDURE insert_bank_user(first_name IN VARCHAR2, last_name IN VARCHAR2, 
				username IN VARCHAR2, password IN VARCHAR2)
AS
BEGIN   
    INSERT INTO bank_user VALUES(null,first_name,last_name,username, password, null,null);
    COMMIT;
END;
/

--Test 
BEGIN 
    insert_bank_user(12345, 'Bob', 'Smith', 'WhatAboutBob', 'password');
END;
/

select * from BANK_USER;


--Create a Stored Procedure to INSERT a new account
CREATE OR REPLACE PROCEDURE insert_account(user_id IN INTEGER, account_name IN VARCHAR, balance IN INTEGER)
AS
BEGIN
    INSERT INTO account VALUES(user_id,null,account_name,balance);
    COMMIT;
END;
/

--Test 
BEGIN 
    insert_account(12345, 'SAVINGS',900);
END;
/

select * from ACCOUNT;



--Procedure to Update a bank_user as approved
CREATE OR REPLACE PROCEDURE update_user_approved(new_status IN INTEGER, new_user_id IN INTEGER)
AS
BEGIN
    
    UPDATE bank_user SET is_approved = new_status
    WHERE user_id = new_user_id;
    COMMIT;
END;
/


BEGIN
    update_user_approved(1,12345);
END;
/



--Procedure to Update a bank_user as admin
CREATE OR REPLACE PROCEDURE update_admin(new_status IN INTEGER, new_user_id IN INTEGER)
AS
BEGIN
    
    UPDATE bank_user SET is_admin = new_status
    WHERE user_id = new_user_id;
    COMMIT;
END;
/

BEGIN
    update_admin(1,12345);
END;
/



--Procedure to Update a account a with a new balance
CREATE OR REPLACE PROCEDURE update_account(new_user_id IN INTEGER,new_account_id IN INTEGER,new_balance IN INTEGER )
AS
BEGIN
    
    UPDATE account SET balance = new_balance
    WHERE user_id = new_user_id AND   account_id = new_account_id;
    COMMIT;
END;
/ 


BEGIN
    update_account(12346,6792,300);
END;
/

--This procedure deletes a bank user based on their user id
CREATE OR REPLACE PROCEDURE delete_bank_user(new_user_id IN INTEGER)
AS
BEGIN
    DELETE FROM bank_user WHERE user_id = new_user_id;
    COMMIT;
END;
/ 


exec delete_bank_user(12345);


--This procedure deletes a bank user based on their account id
CREATE OR REPLACE PROCEDURE delete_account(new_account_id IN INTEGER)
AS
BEGIN
    DELETE FROM account WHERE account_id = new_account_id;
    COMMIT;
END;
/ 


exec delete_account(6793);
