CREATE TABLE bank_user(
id INTEGER,
firstname VARCHAR2(20),
lastname VARCHAR2(20),
username VARCHAR2(20) NOT NULL,
password VARCHAR2(20) NOT NULL,
verified NUMBER DEFAULT 0,
balance NUMBER DEFAULT 0,
admin NUMBER,
CONSTRAINT PK_BANK PRIMARY KEY (id),
CONSTRAINT UK_USERNAME UNIQUE(username)
);

DROP TABLE bank_user;
INSERT INTO bank_user VALUES(null, 'Nicholas', 'McComb', 'Bank_Owner', 'password', 1, 1000000000, 1);
SELECT * FROM bank_user;

CREATE SEQUENCE bank_sequence
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 900
    MINVALUE -1
    NOCACHE;
    
CREATE OR REPLACE TRIGGER before_insert_user
BEFORE INSERT ON bank_user
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT bank_sequence.nextval INTO : NEW.id FROM dual;
    END IF;
END;
/    
    
CREATE OR REPLACE PROCEDURE deposit(target IN NUMBER, amount IN NUMBER)
AS
BEGIN
    UPDATE bank_user SET balance = balance+amount
    WHERE id = target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE withdrawal (target IN NUMBER, amount IN NUMBER)
AS
BEGIN
    UPDATE bank_user SET balance = balance-amount
    WHERE ID = TARGET;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE transfer (target IN NUMBER, source IN NUMBER, amount IN NUMBER)
AS
BEGIN
    UPDATE bank_user SET balance = balance-amount
    WHERE ID = source;
    UPDATE bank_user SET balance = balance+amount
    WHERE ID = target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_first_name(target IN NUMBER, new_name IN VARCHAR2)
AS
BEGIN
    UPDATE bank_user SET firstname = new_name
    WHERE id = TARGET;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_last_name(target IN NUMBER, new_name IN VARCHAR2)
AS
BEGIN
    UPDATE bank_user SET lastname = new_name
    WHERE id = TARGET;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_username(target IN NUMBER, new_name IN VARCHAR2)
AS
BEGIN
    UPDATE bank_user SET username = new_name
    WHERE id = TARGET;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE change_password(target IN NUMBER, new_pw IN VARCHAR2)
AS
BEGIN
    UPDATE bank_user SET password = new_pw
    WHERE id = TARGET;
    COMMIT;
END;
/



