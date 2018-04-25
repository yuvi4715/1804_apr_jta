CREATE TABLE employee (
    email VARCHAR2(60),
    pass VARCHAR2(30) NOT NULL,
    empname VARCHAR2(60)NOT NULL,
    
    CONSTRAINT PK_EMPLOYEE PRIMARY KEY (email)
);

CREATE TABLE manager (
    email VARCHAR2(60),
    pass VARCHAR2(30) NOT NULL,
    mananame VARCHAR2(60)NOT NULL,
    
    CONSTRAINT PK_MANAGER PRIMARY KEY (email)
);

CREATE TABLE reimbursement(
    reimbursement_id	INTEGER NOT NULL,
    email VARCHAR2(60) NOT NULL,
    status INTEGER NOT NULL,
    amount NUMBER(9,2) NOT NULL,
    reviewer VARCHAR2(60),
    purpose VARCHAR2(500),
    request_date DATE NOT NULL,
    review_date DATE,
    
    CONSTRAINT PK_REIMBURSEMENT PRIMARY KEY (id),
    CONSTRAINT FK_EMPLOYEE_REIMBURSEMENT FOREIGN KEY(email) REFERENCES employee(email) ON DELETE CASCADE,
    CONSTRAINT FK_MANAGER_REIMBURSEMENT FOREIGN KEY(reviewer) REFERENCES manager(email) ON DELETE CASCADE
);



DROP SEQUENCE reimbursement_id_seq;
CREATE SEQUENCE reimbursement_id_seq
    START WITH 100
    INCREMENT BY 1
    MAXVALUE 100000
    MINVALUE 1
    NOCACHE;


CREATE OR REPLACE PROCEDURE insert_imbursement(amount IN NUMBER, email  IN VARCHAR2, purpose IN VARCHAR2)
AS
BEGIN
    INSERT INTO reimbursement(reimbursement_id, amount, email, purpose) 
        VALUES(null, amount, email, purpose);
    COMMIT;
END;



CREATE OR REPLACE TRIGGER before_insert_reimbursement
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
    IF : NEW.reimbursement_id IS NULL THEN 
        SELECT reimbursement_id_seq.nextval INTO : NEW.reimbursement_id FROM dual;
    END IF;
    IF : NEW.request_date IS NULL THEN
        SELECT TO_DATE(CURRENT_DATE, 'DD-MON-YY') INTO : NEW.request_date FROM dual;
    END IF;
END;