CREATE USER bankprogram IDENTIFIED BY Weblog1;
REVOKE DBA FROM bankprogram;
GRANT CONNECT TO bankprogram;
GRANT CREATE ANY TABLE TO bankprogram;
GRANT SELECT ANY TABLE TO bankprogram;
GRANT INSERT ANY TABLE TO bankprogram;
GRANT UPDATE ANY TABLE TO bankprogram;
GRANT CREATE ANY SEQUENCE TO bankprogram;
GRANT CREATE ANY TRIGGER TO bankprogram;
GRANT UNLIMITED TABLESPACE TO bankprogram;
GRANT create any procedure TO bankprogram;

DROP TABLE account;
DROP TABLE bankuser;
DROP TABLE banktransaction;
DROP SEQUENCE acc_seq;
DROP SEQUENCE tran_seq;
CREATE TABLE bankuser(
    id NUMBER(6),
    fname VARCHAR2(35),
    password VARCHAR2(35),
    lname VARCHAR2(35),
    isAdmin NUMBER(1),
    isActive NUMBER(1),
    isDeleted NUMBER(1),
    username VARCHAR2(20),
    CONSTRAINT PK_BANK_USER PRIMARY KEY(username)
);

CREATE TABLE account(
    id NUMBER(32),
    owner VARCHAR2(20),
    balance FLOAT(32),
    isDeleted NUMBER(1),
    type VARCHAR2(100),
    CONSTRAINT PK_ACCOUNT PRIMARY KEY(id),
    CONSTRAINT FK_USER FOREIGN KEY (owner) REFERENCES bankuser(username)
);

CREATE TABLE banktransaction(
    id NUMBER(32),
    account_id NUMBER(32),
    amount FLOAT(32),
    is_deposit NUMBER(1),
    is_deleted NUMBER(1),
    tran_timestamp TIMESTAMP WITH TIME ZONE,
    CONSTRAINT PK_TRANS PRIMARY KEY(id),
    CONSTRAINT FK_TRANS FOREIGN KEY (account_id) REFERENCES account(id)
);

CREATE SEQUENCE acc_seq START WITH 1;
CREATE SEQUENCE tran_seq START WITH 1;

CREATE OR REPLACE TRIGGER account_increment 
BEFORE INSERT ON account 
FOR EACH ROW
BEGIN
  SELECT acc_seq.NEXTVAL
  INTO   :NEW.id
  FROM   dual;
END;
/
CREATE OR REPLACE TRIGGER trans_increment 
BEFORE INSERT ON banktransaction
FOR EACH ROW
BEGIN
  SELECT tran_seq.NEXTVAL
  INTO   :NEW.id
  FROM   dual;
END;
/

CREATE OR REPLACE TRIGGER tran_date BEFORE INSERT ON banktransaction 
FOR EACH ROW
BEGIN
 :NEW.tran_timestamp := SYSDATE;
END;
/
CREATE OR REPLACE PROCEDURE insert_banktransaction(account_id IN NUMBER,amount IN FLOAT,is_deposit IN NUMBER,is_deleted IN NUMBER)
AS
BEGIN
    INSERT INTO banktransaction VALUES (account_id,amount,is_deposit,is_deleted) ;
    COMMIT;
END;
/

BEGIN 
    insert_banktransaction(1,20,0,0);
END;
/

--Users
INSERT INTO bankuser VALUES(0,'Pedro','Weblog1!','Rodriguez',1,1,0,'Apo45ty');
INSERT INTO bankuser VALUES(1,'Juan','Password','Tapia',0,1,0,'Ipsum');
INSERT INTO bankuser VALUES(2,'Maria','marialopez','Lopez',0,0,0,'MLopez');
--Accounts
INSERT INTO account (id,owner,balance,isDeleted,type) VALUES(0,'Apo45ty',1000.31415,0,'checkings04092018');
INSERT INTO account VALUES(0,'Apo45ty',2000.31415,0,'checkings04092018');
INSERT INTO account (owner,balance,isDeleted,type) VALUES('Apo45ty',100.31415,0,'checkings04092018');
--transaction
INSERT INTO banktransaction (account_id,amount,is_deposit,is_deleted) VALUES(1,20.2,0,0);

SELECT *  FROM  banktransaction ba WHERE ba.account_id=? AND ba.is_deleted=0 ORDER BY ba.account_id OFFSET 0 ROWS FETCH NEXT 25 ROWS ONLY;

COMMIT;