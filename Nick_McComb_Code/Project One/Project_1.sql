CREATE TABLE reimbursement_request(
id INTEGER PRIMARY KEY,
amount INTEGER NOT NULL,
requester INTEGER NOT NULL,
handler INTEGER,
status VARCHAR2(10),
purpose VARCHAR2(50),
request_date TIMESTAMP,
review_date TIMESTAMP,
CONSTRAINT FK_USER FOREIGN KEY (requester) REFERENCES reimbursement_user (id),
CONSTRAINT FK_ADMIN FOREIGN KEY (handler) REFERENCES admin (id)
);

ALTER TABLE reimbursement_request ADD img_id INTEGER;
ALTER TABLE reimbursement_request ADD handler_comment VARCHAR2(50);

INSERT INTO reimbursement_request VALUES(null, 50.0, 2, 1, 'Denied', 'Steak Dinner', CURRENT_TIMESTAMP, null, null, null);
INSERT INTO reimbursement_request VALUES(null, 75.0, 2, 1, 'Denied', 'Board Games', CURRENT_TIMESTAMP, null, null, 'Inappropriate');
INSERT INTO reimbursement_request VALUES(null, 75.0, 2, 1, 'Approved', 'Work Tools', CURRENT_TIMESTAMP, null, null, 'No Comment');
COMMIT;



CREATE TABLE admin(
id INTEGER,
fname VARCHAR2(15),
lname VARCHAR2(20),
email VARCHAR2(30) NOT NULL,
pw VARCHAR2(20) NOT NULL,
CONSTRAINT PK_ADMIN PRIMARY KEY (id)
);

CREATE TABLE reimbursement_user(
id INTEGER,
fname VARCHAR2(15),
lname VARCHAR2(20),
email VARCHAR2(30) NOT NULL,
pw VARCHAR2(20) NOT NULL,
CONSTRAINT PK_USER PRIMARY KEY (id)
);

ALTER TABLE reimbursement_user
    MODIFY email varchar2(30) UNIQUE;

CREATE SEQUENCE admin_sequence
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 900
    MINVALUE -1
    NOCACHE;
    
CREATE SEQUENCE user_sequence
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 900
    MINVALUE -1
    NOCACHE;    

CREATE SEQUENCE request_sequence
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 900
    MINVALUE -1
    NOCACHE;

CREATE OR REPLACE TRIGGER before_insert_admin
BEFORE INSERT ON admin
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT admin_sequence.nextval INTO : NEW.id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER before_insert_user
BEFORE INSERT ON reimbursement_user
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT user_sequence.nextval INTO : NEW.id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER before_insert_request
BEFORE INSERT ON reimbursement_request
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT request_sequence.NEXTVAL INTO : NEW.id FROM dual;
        SELECT request_sequence.CURRVAL INTO : NEW.img_id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE new_user(fname IN VARCHAR2, lname IN VARCHAR2, email IN VARCHAR2, pw IN VARCHAR2)
AS
BEGIN
    INSERT INTO reimbursement_user VALUES(null, fname, lname, email, pw);
    COMMIT;
END;
/

SELECT * FROM reimbursement_user;

CREATE OR REPLACE PROCEDURE new_admin(fname IN VARCHAR2, lname IN VARCHAR2, email IN VARCHAR2, pw IN VARCHAR2)
AS
BEGIN
    INSERT INTO admin VALUES(null, fname, lname, email, pw);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE new_request(amount IN INTEGER, requester IN INTEGER, purpose IN VARCHAR2)
AS
BEGIN
    INSERT INTO reimbursement_request VALUES(null, amount, requester, null, 'Pending', purpose, CURRENT_TIMESTAMP, null, null, null);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE view_my_requests(id IN INTEGER)
AS
BEGIN

END;
/

CREATE OR REPLACE PROCEDURE change_user_name(new_fname IN VARCHAR2, new_lname IN VARCHAR2, target IN INTEGER)
AS
BEGIN
    UPDATE reimbursement_user SET fname=new_fname, lname=new_lname
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_admin_name(new_fname IN VARCHAR2, new_lname IN VARCHAR2, target IN INTEGER)
AS
BEGIN
    UPDATE admin SET fname=new_fname, lname=new_lname
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_user_email(new_email IN VARCHAR2, target IN INTEGER)
AS
BEGIN
    UPDATE reimbursement_user SET email=new_email
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_admin_email(new_email IN VARCHAR2, target IN INTEGER)
AS
BEGIN
    UPDATE admin SET email=new_email
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_user_pw(new_pw IN VARCHAR2, target IN INTEGER)
AS
BEGIN
    UPDATE reimbursement_user SET pw=new_pw
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_admin_pw(new_pw IN VARCHAR2, target IN INTEGER)
AS
BEGIN
    UPDATE admin SET pw=new_pw
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE resolve(new_status IN VARCHAR2, new_comment IN VARCHAR2, reviewer IN INTEGER, target IN INTEGER)
AS
BEGIN
    UPDATE reimbursement_request SET status=new_status, handler_comment=new_comment, handler=reviewer
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE get_my_pending_requests(my_id IN VARCHAR2, requests OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN requests FOR
    SELECT * FROM reimbursement_request
    WHERE id=requester AND status LIKE('Pending');
END;
/


SELECT * FROM reimbursement_user;