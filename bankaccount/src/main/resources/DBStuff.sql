--Create a user and pasword for the Pokemon Database
CREATE USER admin IDENTIFIED BY admin1;

--Grant privilages to the user
GRANT connect TO admin;
GRANT create any table TO admin;
GRANT create any procedure TO admin;
GRANT create any sequence TO admin;
GRANT create any trigger TO admin;
GRANT insert any table TO admin;
GRANT update any table TO admin;
GRANT delete any table TO admin;
GRANT delete any table TO admin;
GRANT unlimited tablespace TO admin;

--Create bankuser table
CREATE TABLE bankuser (
    accountNumber INTEGER NOT NULL,
    firstName VARCHAR2(20) NOT NULL,
    lastName VARCHAR2(20) NOT NULL,
    isAdmin NUMBER NOT NULL,
    isApproved NUMBER NOT NULL,
    CONSTRAINT PK_BANKUSER PRIMARY KEY (accountNumber)
);

--Create account table
CREATE TABLE account (
    balance NUMBER(9,2) NOT NULL,
    accountNumber INTEGER NOT NULL,
    CONSTRAINT PK_USER_ACCOUNT PRIMARY KEY (balance, accountNumber),
    CONSTRAINT FK_USER_ACCOUNT FOREIGN KEY (accountNumber)
        REFERENCES bankuser(accountNumber)
);

--Create password table
CREATE TABLE p4ssw0rd (
    pass VARCHAR(50) NOT NULL,
    accountNumber INTEGER NOT NULL,
    CONSTRAINT PK_USER_PASS PRIMARY KEY (pass,accountNumber),
    CONSTRAINT FK_USER_PASS FOREIGN KEY (accountNumber) 
        REFERENCES bankuser(accountNumber)
);

--Create a Sequence to generate bankuser PK's
CREATE SEQUENCE accountNum_seq
    START WITH 100010
    INCREMENT BY 1
    MAXVALUE 999999
    MINVALUE 100000
    NOCACHE;

--CREATE an INSERT trigger on bankuserto auto-increment the PK
CREATE OR REPLACE TRIGGER before_insert_bankuser
    BEFORE INSERT ON bankuser
    FOR EACH ROW
    BEGIN
        IF : NEW.accountNumber IS NULL THEN
            SELECT accountNum_seq.nextval INTO : NEW.accountNumber FROM dual;
        END IF;
    END;
    /

--Procedure to return a single user, given the account number and password (WILL NOT USE)
CREATE OR REPLACE PROCEDURE get_user(argAccountNumber IN INTEGER, argPassword IN VARCHAR2, user_cursor
    OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN user_cursor FOR
    SELECT bankuser.accountNumber, firstName, lastName, isAdmin, isApproved, balance FROM
        bankuser INNER JOIN  p4ssw0rd ON bankuser.accountNumber = p4ssw0rd.accountNumber
        INNER JOIN account ON bankuser.accountNumber = account.accountNumber
        WHERE bankuser.accountNumber = argAccountNumber AND p4ssw0rd.pass = argPassword;
    RETURN;
END;
/

--See info of specific account. For ALL info, remove WHERE clause.
SELECT * FROM bankuser INNER JOIN account 
    ON bankuser.accountNumber = account.accountNumber
    INNER JOIN p4ssw0rd 
    ON bankuser.accountNumber = p4ssw0rd.accountNumber;
    --WHERE bankuser.accountNumber = 100017;

--Select last row inserted
SELECT *
FROM (select * from bankuser ORDER BY accountNumber DESC)
WHERE rownum <= 1
ORDER BY rownum DESC;

--Subquery for login (WILL USE THIS)
SELECT bankuser.accountNumber, firstName, lastName, isAdmin, isApproved, balance FROM
        bankuser INNER JOIN  p4ssw0rd ON bankuser.accountNumber = p4ssw0rd.accountNumber
        INNER JOIN account ON bankuser.accountNumber = account.accountNumber
        WHERE bankuser.accountNumber = 100017 AND p4ssw0rd.pass = 'pass1';

--Query to check for users not approved
SELECT bankuser.accountNumber, firstName, lastName, isAdmin, isApproved, balance FROM
        bankuser INNER JOIN  p4ssw0rd ON bankuser.accountNumber = p4ssw0rd.accountNumber
        INNER JOIN account ON bankuser.accountNumber = account.accountNumber
        WHERE isApproved = 0;



    
--SQL queries for testing purposes! ! ! ! ! ! !! !  ! !!
SELECT * FROM account;
SELECT * FROM bankuser;
SELECT * FROM p4ssw0rd;

--Create a new user on the bankuser table
INSERT INTO bankuser(firstName, lastName, isAdmin, isApproved) 
    VALUES ('Admin', 'Master', 1, 1);
--The other two tables also have to be updated with new info (INSERT)
INSERT INTO account(balance, accountNumber) VALUES (2000, 100010);
INSERT INTO p4ssw0rd(pass, accountNumber) VALUES ('pass1', 100010);
 
--Create a new user on the bankuser table   
INSERT INTO bankuser(firstName, lastName, isAdmin, isApproved) 
    VALUES ('Admin', 'Backup', 1, 0);
--The other two tables also have to be updated with new info (INSERT)
INSERT INTO account(balance, accountNumber) VALUES (2000.55, 100011);
INSERT INTO p4ssw0rd(pass, accountNumber) VALUES ('pass2', 100011);

--Approve a new user
UPDATE bankuser set isApproved = 1 WHERE accountNumber = 100011;

--Update balance
UPDATE account set balance = 1500.555 WHERE accountNumber = 100010;

--Testing queries and inserts!!!!
DELETE FROM account WHERE accountNumber = 100017;
DELETE FROM p4ssw0rd WHERE accountNumber = 100017;
DELETE FROM bankuser WHERE lastName = 'Test';

--Create a new user on the bankuser table
INSERT INTO bankuser(firstName, lastName, isAdmin, isApproved) 
    VALUES ('Admin', 'Test', 1, 1);
--The other two tables also have to be updated with new info (INSERT)
INSERT INTO account(balance, accountNumber) VALUES (2000, 100017);
INSERT INTO p4ssw0rd(pass, accountNumber) VALUES ('pass1', 100017);

INSERT INTO bankuser(firstName, lastName, isAdmin, isApproved) 
    VALUES ('Admin', 'Test4', 0, 0);
--The other two tables also have to be updated with new info (INSERT)
INSERT INTO account(balance, accountNumber) VALUES (2000, 100020);
INSERT INTO p4ssw0rd(pass, accountNumber) VALUES ('pass1', 100020);

UPDATE bankuser SET isAdmin = 0 WHERE accountNumber = 100019;
UPDATE bankuser SET isApproved = 0 WHERE accountNumber = 100019;

COMMIT;