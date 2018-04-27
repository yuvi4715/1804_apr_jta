CREATE USER receiptManager IDENTIFIED BY Weblog1;
REVOKE DBA FROM receiptManager;
GRANT CONNECT TO receiptManager;
GRANT CREATE ANY TABLE TO receiptManager;
GRANT SELECT ANY TABLE TO receiptManager;
GRANT INSERT ANY TABLE TO receiptManager;
GRANT UPDATE ANY TABLE TO receiptManager;
GRANT CREATE ANY SEQUENCE TO receiptManager;
GRANT CREATE ANY TRIGGER TO receiptManager;
GRANT UNLIMITED TABLESPACE TO receiptManager;
GRANT create any procedure TO receiptManager;

DROP TABLE reinbursementrequest;
DROP TABLE employee;
DROP TABLE manager;
DROP SEQUENCE rr_seq;

CREATE TABLE employee(
    fname VARCHAR2(35),
    password VARCHAR2(35),
    lname VARCHAR2(35),
    isDeleted NUMBER(1),
    email VARCHAR2(200),
    CONSTRAINT PK_EMPLOYEE PRIMARY KEY(email)
);

CREATE TABLE manager(
    fname VARCHAR2(35),
    password VARCHAR2(35),
    lname VARCHAR2(35),
    isDeleted NUMBER(1),
    email VARCHAR2(200),
    CONSTRAINT PK_MANAGER PRIMARY KEY(email)
);

CREATE TABLE reinbursementrequest(
    RRId NUMBER(32),
    image VARCHAR2(200),
    handledBy VARCHAR2(200),
    owner VARCHAR2(200), 
    description VARCHAR2(1000),
    amount FLOAT(32),
    isDeleted NUMBER(1),
    status NUMBER(2), 
    CONSTRAINT PK_RR PRIMARY KEY(RRId),
    CONSTRAINT FK_E_RR FOREIGN KEY (owner) REFERENCES employee(email)
);

CREATE SEQUENCE rr_seq START WITH 1;

CREATE OR REPLACE TRIGGER rr_increment 
BEFORE INSERT ON reinbursementrequest 
FOR EACH ROW
BEGIN
  SELECT rr_seq.NEXTVAL
  INTO   :NEW.RRId
  FROM   dual;
END;
/
-- employee
INSERT INTO employee VALUES ('Antonio','Weblog1','Tapia',0,'antonio.tapia.maldonado@gmail.com');
-- manager
INSERT INTO manager VALUES ('Antonio','Weblog1','Tapia',0,'antonio.tapia@upr.edu');

-- RR inserts
INSERT INTO reinbursementrequest (image,handledBy,owner,description,amount,isDeleted,status) 
            VALUES ('image1.jpeg','antonio.tapia@upr.edu','antonio.tapia.maldonado@gmail.com','Receipt for client lunch',100,0,0);

CREATE OR REPLACE PROCEDURE insertEmployee(
	   p_fname IN employee.fname%TYPE,
	   p_password IN employee.password%TYPE,
	   p_lname IN employee.lname%TYPE,
       p_isDeleted IN employee.isDeleted%TYPE,
	   p_email IN employee.email%TYPE)
IS
BEGIN
  INSERT INTO employee (fname, password, lname, isDeleted, email) 
  VALUES (p_fname, p_password,p_lname, p_isDeleted,p_email);
  COMMIT;
END;
/

begin
    insertEmployee('Pedro','password','Tapua',0,'jose@gmail.com');
end;
/
CREATE OR REPLACE PROCEDURE updateEmployee(
	   p_fname IN employee.fname%TYPE,
	   p_lname IN employee.lname%TYPE,
       p_isDeleted IN employee.isDeleted%TYPE,
	   p_email IN employee.email%TYPE,
       p_newEmail IN VARCHAR2)
IS
BEGIN
  UPDATE employee SET fname=p_fname,lname=p_lname,
       isDeleted=p_isDeleted,email=p_newEmail where email = p_email;
  COMMIT;
END;
/
BEGIN
   updateEmployee('Maria','Rodriguez',0,'jose@gmail.com','email@yahoo.com');
END;
/


CREATE OR REPLACE PROCEDURE insertManager(
	   p_fname IN manager.fname%TYPE,
	   p_password IN manager.password%TYPE,
	   p_lname IN manager.lname%TYPE,
       p_isDeleted IN manager.isDeleted%TYPE,
	   p_email IN manager.email%TYPE)
IS
BEGIN
  INSERT INTO manager (fname, password, lname, isDeleted, email) 
  VALUES (p_fname, p_password,p_lname, p_isDeleted,p_email);
  COMMIT;
END;
/

begin
    insertManager('Pero','password','Tapua',0,'joe@gmail.com');
end;
/

CREATE OR REPLACE PROCEDURE updateManager(
	   p_fname IN manager.fname%TYPE,
	   p_lname IN manager.lname%TYPE,
       p_isDeleted IN manager.isDeleted%TYPE,
	   p_email IN manager.email%TYPE,
       p_newEmail IN VARCHAR2)
IS
BEGIN
  UPDATE manager SET fname=p_fname,lname=p_lname,
       isDeleted=p_isDeleted,email=p_newEmail where email = p_email;
  COMMIT;
END;
/
BEGIN
   updateManager('Maria','Rodriguez',0,'joe@gmail.com','email@yahoo.com');
END;
/
CREATE OR REPLACE PROCEDURE insertReinbursementRequest(
	   p_RRId IN reinbursementrequest.RRId%TYPE,
	   p_image IN reinbursementrequest.image%TYPE,
	   p_handledBy IN reinbursementrequest.handledBy%TYPE,
       p_owner IN reinbursementrequest.owner%TYPE,
	   p_description IN reinbursementrequest.description%TYPE,
	   p_amount IN reinbursementrequest.amount%TYPE,
	   p_isDeleted IN reinbursementrequest.isDeleted%TYPE,
	   p_status IN reinbursementrequest.status%TYPE)
IS
BEGIN
  INSERT INTO reinbursementrequest (RRId, image, handledBy, owner, description,amount,isDeleted,status) 
  VALUES (p_RRId,p_image,p_handledBy,p_owner,p_description,p_amount,p_isDeleted,p_status);
  COMMIT;
END;
/

begin
    insertReinbursementRequest(0,'pedro.jpeg','antonio.tapia@upr.edu','antonio.tapia.maldonado@gmail.com','Suchi bar with client',100,0,0);
end;
/
CREATE OR REPLACE PROCEDURE updateReinbursementRequest(
	   p_RRId IN reinbursementrequest.RRId%TYPE,
	   p_image IN reinbursementrequest.image%TYPE,
	   p_handledBy IN reinbursementrequest.handledBy%TYPE,
       p_owner IN reinbursementrequest.owner%TYPE,
	   p_description IN reinbursementrequest.description%TYPE,
	   p_amount IN reinbursementrequest.amount%TYPE,
	   p_isDeleted IN reinbursementrequest.isDeleted%TYPE,
	   p_status IN reinbursementrequest.status%TYPE)
IS
BEGIN
  UPDATE reinbursementrequest SET image=p_image,handledBy=p_handledBy,
  owner=p_owner,description=p_description,amount=p_amount,isDeleted=p_isDeleted,
  status=p_status where  RRId = p_RRId;
  COMMIT;
END;
/
BEGIN
   updateReinbursementRequest(1,'Maria.jpeg','email@yahoo.com','antonio.tapia.maldonado@gmail.com','Receipt for travel',40,0,0);
END;
/

COMMIT;