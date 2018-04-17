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

INSERT INTO bank_user VALUES(null, 'Sarah', 'Jean', 'dummy2', 'password', 1, 50000, 0);
SELECT * FROM bank_user;

BEGIN
    change_first_name(2,'Nicholas');
END;
/

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

CREATE OR REPLACE PROCEDURE new_user(firstname IN VARCHAR2, lastname IN VARCHAR2, username IN VARCHAR2, 
                                    password IN VARCHAR2, verified IN NUMBER, balance IN NUMBER, admin IN NUMBER)
AS
BEGIN
    INSERT INTO bank_user VALUES(null, firstname, lastname, username, password, 0, balance, admin);
    COMMIT;
END;
/
 
 SELECT * FROM bank_user;
    
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
    WHERE id = target;
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
    WHERE id = target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE get_user(target IN VARCHAR2, user_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN user_cursor FOR
    SELECT * FROM bank_user
    WHERE username=target;
END;
/

CREATE OR REPLACE PROCEDURE verify(target IN NUMBER)
AS
BEGIN
    UPDATE bank_user SET verified = 1
    WHERE id=target;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE close_account(target IN NUMBER)
AS
BEGIN
    DELETE FROM bank_user
    WHERE id=target;
    COMMIT;
END;
/
