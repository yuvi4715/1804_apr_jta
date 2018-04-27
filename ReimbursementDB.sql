


CREATE TABLE employee (

email VARCHAR2(60),
password VARCHAR2(60),
authorization NUMBER(1),

CONSTRAINT email_pk PRIMARY KEY (email)
);


CREATE TABLE request (

requestID NUMBER(10),
email VARCHAR2(60),
reason VARCHAR2(1000),
amount NUMBER(10),
status VARCHAR2(30),
manager VARCHAR2(60),
image VARCHAR2(100),

CONSTRAINT requestID_PK PRIMARY KEY (requestID),
CONSTRAINT email_FK  FOREIGN KEY (email) REFERENCES employee(email)
);

SELECT requestid, email, reason, amount, status, manager, image from REQUEST;
SELECT *from EMPLOYEE;





CREATE SEQUENCE seq_request
MINVALUE 1
START WITH 1
INCREMENT BY 1
NOCACHE;


insert into EMPLOYEE VALUES ('kim@wayne.com', 'park', 0);

insert into REQUEST VALUES (seq_request.nextval,'bruce@wayne.com','batmobile lost a wheel',10000, 'pending','Lucius','image5');

drop table request; 

commit;

SELECT email, password, authorization FROM EMPLOYEE where email = 'tester@test.com' and PASSWORD = 'test';



CREATE OR REPLACE PROCEDURE insertrequest (email VARCHAR2, reason VARCHAR2, amount NUMBER,  image VARCHAR2)
AS
BEGIN

insert into REQUEST VALUES (seq_request.nextval,email,reason,amount, 'pending','N/A','image5');

END;
/

call insertrequest('tester@test.com','scuba gear',1000,'image0')




select * from request;

commit;



