--Create a user and pasword for the Pokemon Database
CREATE USER ERS IDENTIFIED BY ERS1;

--Grant privilages to the user
GRANT connect TO ERS;
GRANT create any table TO ERS;
GRANT create any procedure TO ERS;
GRANT create any sequence TO ERS;
GRANT create any trigger TO ERS;
GRANT insert any table TO ERS;
GRANT update any table TO ERS;
GRANT delete any table TO ERS;
GRANT delete any table TO ERS;
GRANT unlimited tablespace TO ERS;

--Create ERS user table
DROP TABLE ERS_User;
CREATE TABLE ERS_User (
    user_id INTEGER NOT NULL,
    email VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(20) NOT NULL,
    firstName VARCHAR2(20),
    lastName VARCHAR2(20),
    isManager INTEGER NOT NULL, -- 1 = True, 0 = False

    CONSTRAINT PK_ERS_USER PRIMARY KEY (user_id),
    CONSTRAINT UK_EMAIL UNIQUE (email)
);

--Create Requests table
DROP TABLE Request;
CREATE TABLE Request(
    request_id INTEGER NOT NULL,
    img BLOB,
    req_amount NUMBER(9,2) NOT NULL,
    requester INTEGER NOT NULL,
    reviewer INTEGER,
    purpose VARCHAR2(500),
    status VARCHAR2(10) DEFAULT 'PENDING',
    request_date DATE NOT NULL,
    review_date DATE,

    CONSTRAINT PK_REQUEST PRIMARY KEY (request_id),
    CONSTRAINT FK_EMPLOYEE_REQUEST FOREIGN KEY (requester)
        REFERENCES ERS_User(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_MANAGER_REQUEST FOREIGN KEY (reviewer)
        REFERENCES ERS_User(user_id) ON DELETE CASCADE
);

--//////////////////// S E Q U E N C E S ///////////////////////////////////////
--Create sequence for request_id
DROP SEQUENCE request_id_seq;
CREATE SEQUENCE request_id_seq
    START WITH 100
    INCREMENT BY 1
    MAXVALUE 100000
    MINVALUE 1
    NOCACHE;

--Create sequence for user_id
DROP SEQUENCE user_id_seq;
CREATE SEQUENCE user_id_seq
    START WITH 100
    INCREMENT BY 1
    MAXVALUE 100000
    MINVALUE 1
    NOCACHE;

--//////////////////// P R O C E D U R E S /////////////////////////////////////
--Create procedure to create (insert) requests
CREATE OR REPLACE PROCEDURE insert_request(req_amount IN NUMBER, requester IN INTEGER,
            purpose IN VARCHAR)
AS
BEGIN
    --SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    INSERT INTO Request(request_id, req_amount, requester, purpose) 
        VALUES(null, req_amount, requester, purpose);
    COMMIT;
END;
/

--Create procedure to create (insert) employee account
CREATE OR REPLACE PROCEDURE insert_user(email IN VARCHAR2, passwd IN VARCHAR2, 
    firstName IN VARCHAR2, lastName IN VARCHAR2, isManager IN INTEGER)
AS
BEGIN
    --SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    INSERT INTO ERS_User VALUES(null, email, passwd, firstName, lastName, isManager);
    COMMIT;
END;
/

--Create procedure to approve a request
CREATE OR REPLACE PROCEDURE modify_request(a_request_id IN INTEGER, new_status IN VARCHAR2, a_reviewer IN INTEGER)
AS
BEGIN
    UPDATE Request SET status = new_status, review_date = TO_DATE(CURRENT_DATE, 'DD-MON-YY'), reviewer = a_reviewer WHERE request_id = a_request_id;
    COMMIT;
END;
/

--Create procedure to modify user info
CREATE OR REPLACE PROCEDURE modify_user(new_firstName IN VARCHAR2, new_lastName IN VARCHAR2,
    new_email IN VARCHAR2, new_passwd IN VARCHAR2, a_user_id IN INTEGER)
AS
BEGIN
    UPDATE ERS_User SET firstName = new_firstName, lastName = new_lastName, 
    email = new_email, passwd = new_passwd WHERE user_id = a_user_id;
END;
/

--//////////////////// T R I G G E R S /////////////////////////////////////////
--Create trigger for before insert in Request
CREATE OR REPLACE TRIGGER before_insert_request
BEFORE INSERT ON Request
FOR EACH ROW
BEGIN
    IF : NEW.request_id IS NULL THEN 
        SELECT request_id_seq.nextval INTO : NEW.request_id FROM dual;
    END IF;
    IF : NEW.request_date IS NULL THEN
        SELECT TO_DATE(CURRENT_DATE, 'DD-MON-YY') INTO : NEW.request_date FROM dual;
    END IF;
END;
/

--Create trigger for before insert in ERS_User
CREATE OR REPLACE TRIGGER before_insert_user
BEFORE INSERT ON ERS_User
FOR EACH ROW
BEGIN
    IF : NEW.user_id IS NULL THEN
        SELECT user_id_seq.nextval INTO : NEW.user_id FROM dual;
    END IF;
END;
/


--//////////////////// F E A T U R E S  Q U E R I E S //////////////////////////

--Employee viewing their pending and approved requests (given a user_id)
SELECT * FROM Request WHERE requester = 101 AND status = 'PENDING';
SELECT * FROM Request WHERE requester = 101 AND status = 'APPROVED';

--Employee viewing their information (given a user_id)
SELECT user_id, firstName, lastName, email FROM ERS_User WHERE user_id = 101;

--Manager views all requests from all employees
SELECT * FROM Request;

--Manager views all pending requests from all employes (sorted by requester)
SELECT * FROM Request WHERE status = 'PENDING' ORDER BY requester;

--Manager views all approved requests from all employes (sorted by reviewer)
SELECT * FROM Request WHERE status = 'APPROVED' ORDER BY reviewer;

--Manager views all requests by a single employee (given a user_id)
SELECT * FROM Request WHERE requester = 101;

--Manager views all employees
SELECT firstName, lastName, user_id, email FROM ERS_User WHERE isManager = 0;


--//////////////////// T E S T I N G  Q U E R I E S ////////////////////////////

--View all from ERS_User
SELECT * FROM ERS_User;
--View all from Request
SELECT * FROM Request;
--View all requests employees
SELECT * FROM ERS_User NATURAL JOIN Request;
--View all pending requests
SELECT * FROM Request WHERE status = 'PENDING';
--View all approved requests
SELECT * FROM Request WHERE status = 'APPROVED';
--View all denied requests
SELECT * FROM Request WHERE status = 'DENIED';


--Insert into user using procedure
exec insert_user('user1@ERS.com', 'pass1', 'User', 'One', 0);
exec insert_user('user2@ERS.com', 'pass1', 'User', 'Two', 0);
exec insert_user('user3@ERS.com', 'pass1', 'User', 'Three', 0);
exec insert_user('Manager1@ERS.com', 'pass1', 'Manager', 'One', 1);

--Insert into request using procedure
exec insert_request(15.00, 101, 'Testing the procedure, and I spent $15 somehow...');
exec insert_request(10.00, 101, 'Testing the procedure, and I spent $10 somehow...');
exec insert_request(10.00, 103, 'Testing the procedure, and I spent $10 somehow...');
exec insert_request(10.00, 103, 'Testing the procedure, and I spent $10 somehow...');
exec insert_request(10.00, 104, 'Testing the procedure, and I spent $10 somehow...');

--Modify user info, given a user_id
exec modify_user('ModUser1','ModOne1','Manager1@ERS.com','pass2',101);

--Delete a specific user
DELETE FROM ERS_User WHERE user_id = 102;

--Update a specific user
UPDATE ERS_User SET isManager = 1 WHERE user_id = 102;

--Update a specifit request
exec modify_request(119, 'APPROVED', 102);

--View current date
SELECT TO_CHAR(CURRENT_DATE, 'DD-MON-YYYY HH:MI') FROM dual;

SELECT * FROM ERS_User WHERE email = 'user1@ERS.com' AND passwd = 'pass1';

DELETE FROM Request;

COMMIT;