/*
3 Tables for admins, approved user, and unapproved user
each table has account number, account balance, accountName, accounttype
FLOAT(32)
*/
CREATE USER master_user IDENTIFIED BY p4ssw0rd; --user= master_user password=p4ssw0rd

GRANT connect TO master_user;
GRANT create any table To master_user;
GRANT create any procedure To master_user;
GRANT create any sequence To master_user;
GRANT create any trigger To master_user;
GRANT insert any table To master_user;
GRANT update any table To master_user;
GRANT delete any table To master_user;
GRANT drop any table To master_user;
GRANT resource TO master_user;
--GRANT dba TO master_user;--
--REVOKE dba FROM master_user;--
GRANT unlimited tablespace TO master_user;


drop Table user_info;
drop table bank;

CREATE TABLE user_info
(
    user_id INTEGER,
    username VARCHAR2(20) UNIQUE,
    password VARCHAR2(20),
    firstname VARCHAR2(20),
    lastname VARCHAR2(20),
    approved INTEGER,
    admin INTEGER,
    CONSTRAINT PK_USER_ID PRIMARY KEY  (user_id),
    CONSTRAINT UK_USERNAME UNIQUE (username)
    
);

CREATE TABLE bank
(
    user_id INTEGER,
    username VARCHAR2(20) UNIQUE,
    accountnumber VARCHAR2(9) NOT NULL UNIQUE,
    accountbalance NUMBER(10,2) NOT NULL,
    accounttype VARCHAR2(1),
    CONSTRAINT FK_USER_ID FOREIGN KEY (user_id) REFERENCES  user_info(user_id),
    CONSTRAINT FK_USERNAME FOREIGN KEY (username) REFERENCES  user_info(username)
    ON DELETE CASCADE
);

SELECT * FROM user_info;
SELECT * FROM bank;

--CREATE
INSERT INTO user_info VALUES(1, 'master', 'password', 'John', 'Doe', 1, 0);
INSERT INTO bank  VALUES(1, 'master', 123456789, 100000, 's');


--READ
SELECT * FROM user_info WHERE username = 'master';

--UPDATE
UPDATE user_info
SET password = 'new_pass'
WHERE username = 'master';


--DELETE
DELETE FROM user_info WHERE username ='master';

















----------------------------------------------------------------------------------------------------------------------------------
--Create a Sequence to generate User PK's
CREATE SEQUENCE user_sequence
    START WITH 1
    INCREMENT BY 1
    --no max value
    --MINVALUE -1 --since we start with 1, it doesnt get used
    NOCACHE; -- if we used cache, ex CACHE 10, this is commented out because we don't need it

--Create an INSERT trigger on User to auto-increment the PK
CREATE OR REPLACE TRIGGER before_insert_user
BEFORE INSERT ON user_info
FOR EACH ROW
BEGIN
    IF :NEW.USER_ID IS NULL THEN
        SELECT user_sequence.nextval INTO : NEW.USER_ID FROM dual;
    END IF;
END;
/


-------------------------------------------------------------------------------------------------------------------------------------
--Create a Stored Procedure to INSERT a new User
CREATE OR REPLACE PROCEDURE insert_user(un IN VARCHAR2,
                password in VARCHAR2, firstname IN VARCHAR2, lastname IN VARCHAR2,
                approved IN INTEGER, admin IN INTEGER, 
                accountnumber IN NUMBER, accountbalance IN Number, accounttype IN VARCHAR2)--changed balance from int to number
AS
BEGIN
    INSERT INTO user_info VALUES(null, un, password, firstname, lastname, approved, admin);
    INSERT INTO bank  VALUES((SELECT user_id FROM user_info WHERE username = un ), un, accountnumber, accountbalance, accounttype);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE approve_user(un IN VARCHAR2)--approve entered user
AS
BEGIN
    UPDATE user_info
    SET APPROVED = 1
    Where username = un;
commit;
    COMMIT;
END;
/


--Create a Stored Procedure to DELETE a new User 
CREATE OR REPLACE PROCEDURE delete_user(un IN VARCHAR2)
AS
BEGIN
    
    DELETE FROM user_info WHERE username = un;
    COMMIT;
END;
/


--Create a Stored Procedure to deposit money 
CREATE OR REPLACE PROCEDURE deposit(un IN VARCHAR2, amount IN  NUMBER)
AS
BEGIN
    
    UPDATE bank 
    SET accountbalance = accountbalance + amount
    Where username =un;
    COMMIT;
END;
/

--Create a Stored Procedure to deposit money 
CREATE OR REPLACE PROCEDURE withdraw(un IN VARCHAR2, amount IN  NUMBER)
AS
BEGIN
    
    UPDATE bank 
    SET accountbalance = accountbalance - amount
    Where username =un;
    COMMIT;
END;
/



SELECT * FROM user_info;
SELECT * FROM bank;




--------------------------------------------------------------------------------------------------------------------------------
UPDATE user_info
SET APPROVED = 1
Where username = 'k';
commit;

SELECT approved
FROM user_info WHERE username = 'k';

SELECT firstname, lastname, approved, admin
FROM user_info WHERE username = 'master' AND password = 'password';

SELECT accountnumber, accountbalance, accounttype
FROM bank WHERE username = 'l';

SELECT accountbalance FROM bank_info WHERE username = 'k';


--procedure to search for user, return user info

SELECT * FROM user_info;
SELECT * FROM bank;

--Test
BEGIN
    insert_user('master2', 'password', 'Jane', 'Doe', 1, 1, 12345678, 1000, 'c' );
END;
/

--Test
BEGIN
    withdraw('master', 500 );
END;
/

