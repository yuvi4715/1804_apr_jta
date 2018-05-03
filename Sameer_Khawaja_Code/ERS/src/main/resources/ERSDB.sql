CREATE USER master_user IDENTIFIED BY p4ssw0rd;
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
GRANT unlimited tablespace TO master_user;

/*
Create 3 tables: Employee, Manager, Request

*/

CREATE TABLE employee
(
    employee_id INTEGER,
    employee_firstname VARCHAR2(30) NOT NULL,
    employee_lastname VARCHAR2(30) NOT NULL,
    employee_email VARCHAR2(40) NOT NULL,
    employee_username VARCHAR2(40) NOT NULL,
    employee_password VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_EMPLOYEE_ID PRIMARY KEY  (employee_id),
    CONSTRAINT UK_EMPLOYEE_EMAIL UNIQUE (employee_email)
);

CREATE TABLE manager
(
    manager_id INTEGER,
    manager_firstname VARCHAR2(30) NOT NULL,
    manager_lastname VARCHAR2(30) NOT NULL,
    manager_email VARCHAR2(40) NOT NULL,
    manager_username VARCHAR2(40) NOT NULL,
    manager_password VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_MANAGER_ID PRIMARY KEY  (manager_id),
    CONSTRAINT UK_MANAGER_EMAIL UNIQUE (manager_email)
);


--if employee/manager is delete, does it delete the request?
CREATE TABLE request
(
    request_id INTEGER,
    request_amount NUMBER(10,2),
    requester VARCHAR2(40),
    reviewed_by VARCHAR2(40),
    status VARCHAR2(20) DEFAULT 'UNAPPROVED',
    purpose VARCHAR(100),
    
    CONSTRAINT FK_REQUESTER FOREIGN KEY (requester) REFERENCES  employee(employee_email),
    CONSTRAINT FK_REVIEWED_BY FOREIGN KEY (reviewed_by) REFERENCES  manager(manager_email)  
);



--Create a Sequence to generate Employee PK's
CREATE SEQUENCE employee_sequence
    START WITH 1
    INCREMENT BY 2
    NOCACHE;
	
--Create a Sequence to generate Manager PK's
CREATE SEQUENCE manager_sequence
    START WITH 2
    INCREMENT BY 2
    NOCACHE; 
	
--Create a Sequence to generate Manager PK's
CREATE SEQUENCE request_sequence
    START WITH 1
    INCREMENT BY 1
    CACHE 10; 
	
	
--Create an INSERT trigger on Employee to auto-increment the PK
CREATE OR REPLACE TRIGGER before_insert_employee
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
    IF :NEW.EMPLOYEE_ID IS NULL THEN
        SELECT employee_sequence.nextval INTO : NEW.EMPLOYEE_ID FROM dual;
    END IF;
END;
/

--Create an INSERT trigger on manager to auto-increment the PK
CREATE OR REPLACE TRIGGER before_insert_manager
BEFORE INSERT ON manager
FOR EACH ROW
BEGIN
    IF :NEW.MANAGER_ID IS NULL THEN
        SELECT manager_sequence.nextval INTO : NEW.MANAGER_ID FROM dual;
    END IF;
END;
/

--Create an INSERT trigger on manager to auto-increment the PK
CREATE OR REPLACE TRIGGER before_insert_request
BEFORE INSERT ON request
FOR EACH ROW
BEGIN
    IF :NEW.REQUEST_ID IS NULL THEN
        SELECT request_sequence.nextval INTO : NEW.REQUEST_ID FROM dual;
    END IF;
END;
/



--Stored Procedures--
-------------------------------------------------------------------------------------------------------------------------------------
--Create a Stored Procedure to INSERT a new Employee
CREATE OR REPLACE PROCEDURE insert_employee(
							e_fn VARCHAR2,
							e_ln VARCHAR2,
							e_em VARCHAR2,
                            e_un VARCHAR2,
							e_p VARCHAR2)
							
AS
BEGIN
    INSERT INTO employee VALUES(NULL, e_fn , e_ln, e_em, e_un, e_p);
    COMMIT;
END;
/

--Create a Stored Procedure to INSERT a new Manager
CREATE OR REPLACE PROCEDURE insert_manager(
							m_fn VARCHAR2,
							m_ln VARCHAR2,
							m_em VARCHAR2,
                            m_un VARCHAR2,
							m_p VARCHAR2)
							
AS
BEGIN
    INSERT INTO manager VALUES(NULL, m_fn , m_ln, m_em, m_un, m_p);
    COMMIT;
END;
/



--Create a Stored Procedure to INSERT a new Request
CREATE OR REPLACE PROCEDURE insert_request(
							amount NUMBER,
							req VARCHAR2,
							rev VARCHAR2,
							stat VARCHAR2,
							purp VARCHAR)
AS
BEGIN
    INSERT INTO request VALUES(NULL, amount, req, rev, stat, purp);
    COMMIT;
END;
/


CREATE OR REPLACE PROCEDURE update_employee(e_fn VARCHAR2,
							e_ln VARCHAR2,
							e_em VARCHAR2,
                            e_un VARCHAR2,
							e_p VARCHAR2)--approve entered user
AS
BEGIN
    UPDATE employee
    SET employee_firstname = e_fn
    Where employee_username = e_un;
    
    UPDATE employee
    SET employee_lastname = e_ln
    Where employee_username = e_un;
    
    UPDATE employee
    SET employee_email = e_em
    Where employee_username = e_un;
    
    UPDATE employee
    SET employee_password = e_p
    Where employee_username = e_un;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE update_request(
                            req_id INTEGER,
                            m_em VARCHAR2,
							stat VARCHAR2)--approve entered user
AS
BEGIN
    UPDATE request
    SET reviewed_by = m_em
    Where request_id = req_id;
    
    UPDATE request
    SET status = stat
    Where request_id = req_id;
    COMMIT;
END;
/


begin
update_request(61, '', 'PENDING');
end;
/


begin
insert_request(61, 'l@t', '', 'PENDING', 'purp');
end;
/

begin
insert_employee('l', 'l', 'l@t', 'l', 'l');
end;
/

begin
insert_manager('q', 'q', 'q@t', 'q', 'q');
end;
/


INSERT INTO manager VALUES(2, 'k', 'k', 'k', 'k', 'k');


SELECT * FROM employee;
SELECT * FROM manager;
SELECT * FROM request;

/*
DROP TABLE employee;
DROP TABLE manager;
DROP TABLE request;
*/