/*
DROP TABLE account_transaction;
DROP TABLE bank_account;
DROP TABLE account_holder;
DROP TABLE bank_admin;
DROP SEQUENCE holder_seq;
DROP SEQUENCE admin_seq;
DROP SEQUENCE transaction_seq;
*/

--Create Control Sequences
CREATE SEQUENCE holder_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  NOCACHE;
  
CREATE SEQUENCE admin_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  NOCACHE;
  
CREATE SEQUENCE transaction_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  NOCACHE;

--Create Tables
CREATE TABLE account_holder (
    USERID INT DEFAULT holder_seq.NEXTVAL,
    FIRSTNAME NVARCHAR2(128),
    LASTNAME NVARCHAR2(128),
    MEMBERSINCE DATE DEFAULT CURRENT_TIMESTAMP,
    PASSPHRASE NVARCHAR2(128),
    STATUSFLAG INT DEFAULT 0,
    CHECK (USERID > 0),
    CHECK (STATUSFLAG >= 0),
    CHECK (STATUSFLAG <= 3),
    PRIMARY KEY (USERID)
    
);

CREATE TABLE bank_admin (
    ADMINID INT DEFAULT admin_seq.NEXTVAL,
    USERNAME NVARCHAR2(128),
    PASSPHRASE NVARCHAR2(128),
    CHECK (ADMINID > 0),
    PRIMARY KEY (ADMINID)
);

CREATE TABLE bank_account (
    ACCOUNTTYPE NUMBER(2),
    HOLDER INT,
    BALANCE FLOAT,
    CONSTRAINT FK_HOLDER FOREIGN KEY (HOLDER)
        REFERENCES account_holder (USERID),
    CONSTRAINT PK_HOLDER_TYPE PRIMARY KEY (HOLDER, ACCOUNTTYPE)
);

CREATE TABLE account_transaction (
    TRANSID INT DEFAULT transaction_seq.NEXTVAL,
    ACTNUM INT,
    ACTTYPE NUMBER(2),
    INIT FLOAT,
    ADJUST FLOAT,
    ENDING FLOAT,
    TDATE DATE DEFAULT CURRENT_TIMESTAMP,
    NOTE VARCHAR2(1024),
    CONSTRAINT FK_ACCOUNT_TYPE FOREIGN KEY(ACTNUM, ACTTYPE)
        REFERENCES bank_account(HOLDER, ACCOUNTTYPE),
    PRIMARY KEY (TRANSID)
);

--Creating Stored procedures
--update account holder info. Can only chance first, last or pass
CREATE OR REPLACE PROCEDURE  update_account_holder (
    FNAME in NVARCHAR2,
    LNAME in NVARCHAR2,
    PPHRASE in NVARCHAR2,
    IDENT in INT)
AS
BEGIN
    UPDATE account_holder SET FIRSTNAME = FNAME, LASTNAME = LNAME, PASSPHRASE = PPHRASE 
    WHERE USERID = IDENT;
    COMMIT;
END;
/

--insert new holder
create or replace PROCEDURE insert_account_holder (
    FNAME in NVARCHAR2,
    LNAME in  NVARCHAR2,
    PPHRASE in NVARCHAR2)
AS
BEGIN
    INSERT INTO account_holder (FIRSTNAME, LASTNAME, PASSPHRASE) 
        VALUES(FNAME, LNAME, PPHRASE);
    COMMIT;
END;

--Update account holder status. Used to update an account holder's status, such as set them to inactive.
CREATE OR REPLACE PROCEDURE update_account_holder_status (
    IDENT in INT,
    STATUS in INT)
AS
BEGIN
    UPDATE account_holder SET STATUSFLAG = STATUS
    WHERE USERID = IDENT;
    
    COMMIT;
END;
/


--Read account holder record and return 
CREATE OR REPLACE PROCEDURE read_account_holder (
    IDENT in INT,
    holder_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN holder_cursor FOR
    SELECT FIRSTNAME, LASTNAME, MEMBERSINCE, PASSPHRASE, STATUSFLAG
    FROM account_holder
    WHERE USERID = IDENT;
END;
/

--Create new account for existing user
CREATE OR REPLACE PROCEDURE insert_bank_account(
    HOLDERID in INT,
    ATYPE in INT,
    INITIALBALANCE in FLOAT)
AS
BEGIN
    INSERT INTO bank_account (ACCOUNTTYPE, HOLDER, BALANCE)
        VALUES (ATYPE, HOLDERID, INITIALBALANCE);
        
    COMMIT;
END;
/

--Modify balance of existing account
CREATE OR REPLACE PROCEDURE deposit_or_withdrawl (
    IDENT in INT,
    ATYPE in INT,
    AMT in FLOAT,
    CURBALANCE in FLOAT,
    COMMENTS in NVARCHAR2)
AS
BEGIN
    UPDATE bank_account SET BALANCE = (CURBALANCE + AMT) 
        WHERE HOLDER = IDENT AND ACCOUNTTYPE = ATYPE;
    INSERT INTO account_transaction (ACTNUM, ACTTYPE, INIT, ADJUST, ENDING, NOTE) 
        VALUES (IDENT, ATYPE, CURBALANCE, AMT, (CURBALANCE+AMT), COMMENTS); 
    COMMIT;
END;
/




--Some initial records
INSERT INTO bank_admin (USERNAME, PASSPHRASE) 
    VALUES ('DefaultAdmin', 'password');

INSERT INTO account_holder (FIRSTNAME, LASTNAME, PASSPHRASE) 
    VALUES ('Aaron', 'Rutledge', 'password');

exec insert_account_holder('Lesley', 'Byrn', 'qwerty');

--Testing some stored Procedures
BEGIN
    update_account_holder (2, 'Melody', 'Shipp', 'qwerty');
END;
/


BEGIN update_account_holder_status(2, 1); END;/

--testing read explcitly
DECLARE
    my_cursor SYS_REFCURSOR;
    idnum INTEGER;
    fn NVARCHAR2 (128);
    ln NVARCHAR2 (128);
    joindate DATE;
    pass NVARCHAR2 (128);
    sf INTEGER;
BEGIN
    read_account_holder(2, my_cursor);
    LOOP
        FETCH my_cursor INTO fn, ln, joindate, pass, sf;
        EXIT WHEN my_cursor%notfound;
        dbms_output.put_line(fn || ' ' || ln || ', member since: ' || joindate);
    END LOOP;
    CLOSE my_cursor;
END;
/

--make an account
exec insert_bank_Account(1, 1, 50.0);

--Deduct three-fifty
--DEPRECIATED!
--exec deposit_or_withdrawl(1, 1, -3.5, 50.0);

--add it back with updated transactions.
exec deposit_or_withdrawl(1, 1, 3.5, 50.0, 'N/A');

SELECT * FROM account_transaction


