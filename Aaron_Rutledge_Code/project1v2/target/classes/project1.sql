/*
DROP TABLE request;
DROP TABLE supervisor;
DROP TABLE employee;

DROP SEQUENCE employee_seq;
DROP SEQUENCE request_seq;

DROP PROCEDURE insert_employee;
DROP PROCEDURE update_employee;
DROP PROCEDURE update_employee_email;
DROP PROCEDURE insert_supervisor;
DROP PROCEDURE insert_request;
DROP PROCEDURE approve_request;
DROP PROCEDURE deny_request;
*/

--Create Control Sequences
CREATE SEQUENCE employee_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
CREATE SEQUENCE request_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
--Table Statements
CREATE TABLE employee (
    userid INT DEFAULT employee_seq.NEXTVAL,
    email NVARCHAR2(64) UNIQUE,
    first_name NVARCHAR2(64),
    last_name NVARCHAR2(64),
    pass_phrase NVARCHAR2(64),
    hire_date DATE DEFAULT CURRENT_TIMESTAMP,
    hire_status INT DEFAULT 1,
    PRIMARY KEY (userid),
    CHECK (hire_status >= 1),
    CHECK (hire_status <= 2)
    );
/*
Status codes:
0 - invalid, used for error checking
1 - current employee
2 - former employee
*/

CREATE TABLE supervisor (
    managerid INT PRIMARY KEY,
    CONSTRAINT FK_managerid FOREIGN KEY (managerid)
        REFERENCES employee(userid)
);

CREATE TABLE request (
    requestid INT DEFAULT request_seq.NEXTVAL,
    ammount NUMBER(5,2),
    requester INT REFERENCES employee (userid),
    reviewer INT DEFAULT NULL,
    status INT DEFAULT 0,
    image NVARCHAR2(256) DEFAULT 'no image',
    req_date DATE DEFAULT CURRENT_TIMESTAMP,
    rev_date DATE,
    purpose NVARCHAR2(1024),
    PRIMARY KEY (requestid),
    CHECK (status >= 0),
    CHECK (status <= 2),
    CONSTRAINT FK_rev FOREIGN KEY (reviewer)
        REFERENCES supervisor(managerid)
);

/*
Status codes:
0 - pending
1 - approved
2 - declined
3 - reserved
*/

--Create Stored Procedures

--Insert new employee
CREATE OR REPLACE PROCEDURE insert_employee (
    fname IN NVARCHAR2,
    lname IN NVARCHAR2,
    pphrase IN NVARCHAR2,
    email IN NVARCHAR2)
AS
BEGIN
    INSERT INTO employee (first_name, last_name,
                          pass_phrase, email)
        VALUES (fname, lname, pphrase, email);
    COMMIT;
END;
/

--Update employee info. Hire date and id cannot be changed.
--Email is in a seperate function, since it 
--can fail a unique constraint.
CREATE OR REPLACE PROCEDURE update_employee (
    fname IN NVARCHAR2,
    lname IN NVARCHAR2,
    pphrase in NVARCHAR2,
    ident IN INT)
AS
BEGIN
    UPDATE employee SET first_name = fname, 
                        last_name = lname, 
                        pass_phrase = pphrase
    WHERE userid = ident;
    COMMIT;
END;
/

--update employee email
CREATE OR REPLACE PROCEDURE update_employee_email (
    new_email IN NVARCHAR2,
    ident IN INT)
AS
BEGIN
    UPDATE employee SET email = new_email 
    WHERE userid = ident;
    COMMIT;
END;
/

--promote to supervisor
CREATE OR REPLACE PROCEDURE insert_supervisor(
    ident IN INT)
AS
BEGIN
    INSERT INTO supervisor (managerid)
        VALUES (ident);
    COMMIT;
END;
/

--insert request
CREATE OR REPLACE PROCEDURE insert_request(
    amnt IN NUMBER,
    req IN INT,
    img IN NVARCHAR2,
    purp IN NVARCHAR2)
AS
BEGIN
    INSERT INTO request (ammount, requester, image, purpose)
        VALUES (amnt, req, img, purp);
    COMMIT;
END;
/

--Approve a request
CREATE OR REPLACE PROCEDURE approve_request (
    ident IN NUMBER,
    rev IN NUMBER)
AS
BEGIN
    UPDATE request SET  reviewer = rev,
                        status = 1,
                        rev_date = CURRENT_TIMESTAMP
        WHERE REQUESTID = ident;
    COMMIT;
END;
/

--Deny a request
CREATE OR REPLACE PROCEDURE deny_request (
    ident IN NUMBER,
    rev IN NUMBER)
AS
BEGIN
    UPDATE request SET  reviewer = rev,
                        status = 2,
                        rev_date = CURRENT_TIMESTAMP
        WHERE REQUESTID = ident;
    COMMIT;
END;
/



--Testing ground for stored procedures and constraints
exec insert_employee('Alexander', 'Shipp', 'password', 'lolno@mailg.com');
exec insert_employee('Melody', 'Shipp', 'ummmmm', 'rainbows@sunshine.com');
exec insert_employee('Lesly', 'Byrne', 'qwerty', 'burner@tempmail.com');
exec update_employee('Lesly', 'MacByrn', 'qwerty', '3');
exec update_employee_email('lesigh@derp.net', 3);
exec insert_supervisor(1);
--exec insert_supervisor(5);
exec insert_request(9.95,3,null,'Enthuware');
exec insert_request(91.35,3,null,'entertainment');
exec approve_request(1,1);
exec deny_request(2,1);


SELECT * FROM request 
