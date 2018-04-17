--Following are examples to practise for different type of SQL languages
-- types here refers to sub types such as DDL, DML, DQL, DCL, TCL
-- other types of SQL are T-SQL used for SQL Server, PL/SQL for Oracle, mysql for MySql and these are not sub types


--Create a simple table with no constraints
CREATE TABLE tablea (
    a_id     NUMBER NOT NULL,
    a_name   VARCHAR2(100)
);

--DML   insert, update, delete
--DQL   select
--DDL   create, alter, drop
--DCL   grant, revoke
--TCL   rollback, commit, savepoint

--DML practise
select * from TableA;
delete from TableA;
insert into TableA values (1, 'IT');
insert into TableA values (2, 'Logan');
insert into TableA values (3, 'Guardians of the galaxy');
insert into TableA values (4, 'Star wars - seventh one');
insert into TableA values (5, 'Planet of the apes');
insert into TableA values (6, 'Dunkirk');
insert into TableA values (7, 'Kingsman');
insert into TableA values (8, 'Lord of the rings');
insert into TableA values (9, 'Gladiator');

update tablea set A_ID = 10 where A_ID = 9;

--Example for how to add constraints to an existing table
ALTER TABLE TABLEA 
ADD CONSTRAINT AID_PK PRIMARY KEY (A_ID);

UPDATE TABLEA SET A_NAME = 'FAST AND FURIOUS' WHERE A_ID = 9;

--Example for how to change a column name of an existing table
ALTER TABLE TABLEA 
RENAME COLUMN A_NAME TO MOVIE_NAMES; 

--Another example to change a column name of existing table
ALTER TABLE TABLEA 
RENAME COLUMN A_ID TO M_ID; 

--Create another table called FLASHCARDS
CREATE TABLE FLASHCARDS(
FC_ID NUMBER NOT NULL,
FC_QUESTION VARCHAR2 (100),
FC_ANSWERS VARCHAR2(100),
CONSTRAINT FCID_PK PRIMARY KEY (FC_ID)
);

INSERT INTO FLASHCARDS VALUES (1, 'CAN YOU OVERLOAD A MAIN METHOD?','YES');
INSERT INTO FLASHCARDS VALUES (2, 
'HOW DO YOU CREATE A THREAD?',
'EXTEND THREAD CLASS OR IMPLEMENT RUNNABLE INTERFACE');

INSERT INTO FLASHCARDS VALUES (3, 'WHAT IS STATIC POLYMORPHISM?',
'OVERLOADING - SAME METHOD WITH DIFFERENT NUMBER, ORDER, DATA TYPE OF PARAMETERS');

--alternative syntax for insert 
INSERT INTO FLASHCARDS (FC_ID, FC_ANSWERS, FC_QUESTION)
VALUES (1,'YES', 'CAN YOU OVERLOAD A MAIN METHOD?');

SELECT * FROM FLASHCARDS;

DROP TABLE FLASHCARDS; 

COMMIT;

create user testuser IDENTIFIED by p4ssw0rd;
grant connect, resource to testuser;
--GRANT DBA TO testuser WITH ADMIN OPTION;

select table_name from all_tables;
desc flashcards;
select * from dual;

create table A(ID NUMBER (10) PRIMARY KEY,NAME VARCHAR2(20));
create table B(ID NUMBER (10) PRIMARY KEY,NAME VARCHAR2(20));
create table C(ID NUMBER (10) PRIMARY KEY,NAME VARCHAR2(20));
create table D(ID NUMBER (10) PRIMARY KEY,NAME CHAR(25));

insert into A values (1, 'Tom Brady');
insert into A values (2, 'Russell Wilson');
insert into A values (3, 'Levon Bell');
insert into A values (4, 'Peyton Manning');
insert into A values (5, 'Cam Newton');
insert into B values (1, 'Tom Brady');
insert into B values (3, 'Levon Bell');
insert into B values (5, 'Cam Newton');
insert into B values (6, 'Marshawn Lynch');
insert into B values (7, 'DeSean Jackson');
insert into C values (1, 'Tom Brady');
insert into C values (2, 'Russell Wilson');
insert into C values (3, 'Levon Bell');
insert into C values (6, 'Marshawn Lynch');
insert into C values (8, 'Robert Griffin');
insert into C values (9, 'Eli Manning');

insert into D values (1, 'Tom Brady');
insert into D values (2, 'Russell Wilson');
insert into D values (3, 'Levon Bell');
insert into D values (4, 'Peyton Manning');
insert into D values (5, 'Cam Newton');
insert into D values (6, 'Marshawn Lynch');
insert into D values (7, 'DeSean Jackson');
insert into D values (8, 'Robert Griffin');
insert into D values (9, 'Eli Manning');
insert into D values (10, 'Greg Olsen');

select * from a;
select * from b;
select * from c;

--joins --inner join, outer joins (left, right, full)
--inner join
--mrtg_sngl_fm_mth_hst_dtls xyz
SELECT * FROM A INNER JOIN B ON A.ID = B.ID;
SELECT * FROM A tablea_sdet_rds_1709
INNER JOIN B tableb_sdet_rds_1709
ON tablea_sdet_rds_1709.ID = tableb_sdet_rds_1709.ID;

SELECT A.ID, A.NAME FROM A INNER JOIN B ON A.ID = B.ID;
SELECT A.ID, A.NAME FROM A INNER JOIN B ON A.NAME = B.NAME;
--set operators --intersect, union, union all, minus
--Intersect
select * from A
intersect
select * from B;

--join more than 2 tables
SELECT * FROM A INNER JOIN B ON A.ID = B.ID INNER JOIN C on B.ID = C.ID;
SELECT * FROM A INNER JOIN B ON A.ID = B.ID INNER JOIN C on B.NAME = C.NAME;

SELECT *
FROM a
    LEFT JOIN b ON a.id = b.id;
    
SELECT * FROM B LEFT JOIN A ON A.ID = B.ID;

SELECT * FROM A RIGHT JOIN B ON A.ID = B.ID;
SELECT * FROM B RIGHT JOIN A ON A.ID = B.ID;

SELECT
    *
FROM
    a
    INNER JOIN b ON a.id = b.id     --4 COLUMNS, 3 ROWS
    INNER JOIN c ON b.id = c.id     --6 COLUMNS, 2 ROWS
    LEFT JOIN c ON c.id = a.id      --8 columns, 2 rows
    RIGHT JOIN d ON d.id = c.id;    --10 columns, 10 rows
;

SELECT
    a.id, b.name, d.id, d.name
FROM
    a
    INNER JOIN b ON a.id = b.id     --4 COLUMNS, 3 ROWS
    INNER JOIN c ON b.id = c.id     --6 COLUMNS, 2 ROWS
    LEFT JOIN c ON c.id = a.id      --8 columns, 2 rows
    RIGHT JOIN d ON d.id = c.id;    --10 columns, 10 rows


SELECT * FROM A 
FULL JOIN B 
ON A.ID = B.ID;     --4 COLUMNS, 7 ROWS

SELECT * FROM A 
INNER JOIN B
ON A.ID = B.ID;     --4 COLUMNS, 3 ROWS

SELECT * FROM C
INNER JOIN D
ON C.ID = D.ID;     --4 COLUMNS, 6 ROWS

SELECT *
FROM a
    INNER JOIN b ON a.id = b.id
    FULL OUTER JOIN 
        (SELECT D.ID, D.NAME
        FROM
            c
            INNER JOIN d ON c.id = d.id) E
    ON a.ID = E.ID;       --8 COLUMNS, 7 ROWS
    

select * from a full join c on a.id= c.id;

select * from a
union 
select * from  c;   --2 columns, 8 rows

select * from a
union all
select * from  c;   --2 columns, 11 rows

select id, name from a
union all
select id, name from  c   --2 columns, 11 rows
order by id;

--wild card characters
-- % means multiple character matching
-- _ single character matching
-- like is the keyword used for pattern matching using wild card characters
SELECT * FROM D WHERE D.NAME LIKE 'L%';
SELECT * FROM D WHERE D.NAME LIKE '%Manning%';
SELECT * FROM D WHERE D.NAME LIKE 'R%';
SELECT * FROM D WHERE D.NAME LIKE '%Ma%';
SELECT * FROM D WHERE D.NAME LIKE '%ton%';
SELECT trim(d.name) FROM D WHERE trim(D.NAME) LIKE '%Brad_';


--functions --scalar and aggregate
--scalar functions
--upper, lower, length, substr, concat, instr, ltrim, rtrim
select * from d;
select d.id, upper(d.name) from d;
select d.id, lower(d.name) from d;

--2 characters from name and 2 characters another name column & concatenate both
select concat (concat (upper(substr(d.name, 1,3)), ' '), 
        upper(substr(a.name, 1,2))) 
from d
full join a on a.id = d.id 
where a.name is not null
and d.name is not null;

select length(d.name) from d;
select length(ltrim(d.name)) from d;
select length(rtrim(d.name)) from d;
select length(trim(d.name)) from d;

select * from dual;
select instr('HelloWorld','World') from dual;
select instr(trim(d.name),'Manning') from d;
desc d;

select * from invoice where customerid=5;
select * from invoice where invoiceid=122;
select count(*) from invoice where customerid=5;
desc invoice;

select * from customer where customerid=5;
select count(*) from customer where customerid=5;
desc customer;

select count(*) from INVOICELINE where invoiceid=122;
select * from INVOICELINE inner join invoice 
on invoice.INVOICEID = INVOICELINE.INVOICEID
where invoice.CUSTOMERID = 5
;

desc invoiceline;

select customer.customerid, invoice.INVOICEID from invoice 
    inner join customer 
    on invoice.CUSTOMERID = customer.CUSTOMERID
    inner join INVOICELINE
    on invoice.INVOICEID = INVOICELINE.INVOICEID
    where invoice.CUSTOMERID = 5
    ;

delete from (select * from invoice 
    inner join customer 
    on invoice.CUSTOMERID = customer.CUSTOMERID
    inner join INVOICELINE
    on invoice.INVOICEID = INVOICELINE.INVOICEID
    where invoice.CUSTOMERID = 5
    );

rollback;

select * from invoiceline where INVOICEID = 100;
delete from invoiceline where INVOICEID = 100;

select * from invoice where invoiceid = 100;
delete from invoice where invoiceid = 100;

-- always turn this on for sys out
set serveroutput on;

--Stored procedures or transactional store procedures
--Simple example to create a stored procedure
create or replace procedure delete_invoice (inve Number)
as
begin
    delete from invoiceline where INVOICEID = inve;
    delete from invoice where invoiceid = inve;
    commit;
end;
/

exec delete_invoice(100);
exec delete_invoice(122);

--Hello world example to create stored procedure
create or replace procedure HelloWorld
is
begin
    DBMS_OUTPUT.PUT_LINE('hello world!!');
end;
/
--how to execute stored procecured - 1st approach
exec HELLOWORLD;

--2nd approach
begin
    HELLOWORLD;
end;
/

--functions
create or replace function multiply(x Number, y Number)
return Number
as results Number;
begin
    results := x * y;
    return results;
end;
/

declare                 --approach 1 to call a function
    toPrint Number;
begin
    toPrint := multiply(10,20);
    DBMS_OUTPUT.PUT_LINE(toPrint);
end;
/
select multiply (20,30) from dual;  --approach 2 to call a function

select avg(total) from invoice;
select * from invoiceline;
select count(invoiceline.QUANTITY), invoiceline.invoiceid from invoiceline 
group by invoiceline.quantity, invoiceline.invoiceid;

select sum(unitprice)/count(quantity) from invoiceline;
--group by invoiceid;

create or replace function invoice_average return number
is
    average number;
begin
    select sum(unitprice)/count(quantity) into average from invoiceline;
    return average;
end;
/
select invoice_average from dual;

Create sequence a_seq
	minvalue 1
	maxvalue 1000
	start with 1
	increment by 1;

-- post increament
select a_seq.currval, A_SEQ.NEXTVAL, A_SEQ.CURRVAL, A_SEQ.NEXTVAL from dual;

--post increament
select A_SEQ.currval from dual;
select A_SEQ.nextval from dual;

-- CHANGING CONNECTION TO MY SCHEMA. DON'T WANT TO CREATE A TABLE IN CHINOOK SCHEMA
CREATE TABLE ACTIVE_PLAYERS (
    PLAYER_ID NUMBER(10),
    PLAYER_NAME VARCHAR2(20),
    CREATION_TIME TIMESTAMP
);

CREATE TABLE PLAYERS_AUDIT_TRAIL(
    PLAYER_NAME VARCHAR2(20),
    CREATION_TIME TIMESTAMP,
    CREATED_USER VARCHAR2(10)
);

--ALTER TABLE table_name
--ADD column_name datatype;
--(add, modify, drop)

ALTER TABLE PLAYERS_AUDIT_TRAIL
modify CREATED_USER varchar2(20);


Create sequence RDS_SEQ
	minvalue 1
	maxvalue 1000
	start with 1
	increment by 1;


select * from active_players;
select * from PLAYERS_AUDIT_TRAIL;

create or replace trigger insert_players
after insert on ACTIVE_PLAYERS for each row
begin
    insert into PLAYERS_AUDIT_TRAIL values 
    (:new.PLAYER_NAME, :new.CREATION_TIME, user );
end;
/

create or replace trigger DELETE_PLAYERS
BEFORE DELETE on ACTIVE_PLAYERS for each row
begin
    insert into PLAYERS_AUDIT_TRAIL values 
    (:new.PLAYER_NAME, :new.CREATION_TIME, user );
end;
/

INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Collin Kapernick', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Andy Dalton', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Eric Decker', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Joe Flacco', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Andrew Luck', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Matt Ryan', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Drew Brees', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'AJ Green', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Antonio Gates', SYSTIMESTAMP);

DELETE FROM ACTIVE_PLAYERS;

-- CURSORS
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
--cursor as a pass by reference
CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES(JOHN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN JOHN_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE
    EMPLOYEE_CURSOR SYS_REFCURSOR;
    FIRST_NAME VARCHAR2(30);
    LAST_NAME VARCHAR2(30);
BEGIN
    EMPLOYEE_NAMES(EMPLOYEE_CURSOR);
    LOOP
        FETCH EMPLOYEE_CURSOR INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN EMPLOYEE_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(UPPER(LAST_NAME)|| ',' || UPPER(FIRST_NAME));
    END LOOP;
END;
/

SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968' ;
--CURSOR RETURN FROM FUNCTION
CREATE OR REPLACE FUNCTION AFTER1968 RETURN SYS_REFCURSOR
IS 
EMPLOYEE_CURSOR SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_CURSOR  FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968' ;
    RETURN EMPLOYEE_CURSOR;
END;
/
SELECT AFTER1968 FROM DUAL;


--CHANGING BACK TO MY SCHEMA
CREATE or replace VIEW JOIN_VW2 AS
    SELECT
    a.id as AID, a.name as ANAME, b.ID as BID, b.NAME as BNAME,
    c.id as CID, c.NAME as CNAME, d.ID as DID, d.NAME as DNAME
FROM
    a
    INNER JOIN b ON a.id = b.id     --4 COLUMNS, 3 ROWS
    INNER JOIN c ON b.id = c.id     --6 COLUMNS, 2 ROWS
    LEFT JOIN c ON c.id = a.id      --8 columns, 2 rows
    RIGHT JOIN d ON d.id = c.id;    --10 columns, 10 rows

create or replace view join_vw as 
SELECT 
    a.id as AID, a.name as ANAME, b.ID as BID, b.NAME as BNAME,
    E.ID as EID, E.NAME as ENAME
FROM a
    INNER JOIN b ON a.id = b.id
    FULL OUTER JOIN 
        (SELECT D.ID, D.NAME
        FROM
            c
            INNER JOIN d ON c.id = d.id) E
    ON a.ID = E.ID;       --8 COLUMNS, 7 ROWS

create or replace view helloworld as
select * from A;

select * from JOIN_VW2;
select * from JOIN_VW;

create index players_idx
on active_players (player_id);

select * from active_players;

commit;

savepoint ap_921201742845;

INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Kirk Cousin', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'Aaron Rodgers', SYSTIMESTAMP);

savepoint ap_921201743125;

INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'tom', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'mike', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'peter', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'john', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'yuvi', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'frank', SYSTIMESTAMP);
INSERT INTO ACTIVE_PLAYERS values (RDS_SEQ.NEXTVAL, 'joe', SYSTIMESTAMP);

savepoint ap_98w9e46t;


rollback to SAVEPOINT ap_921201743125;


Create table employee 
      (
      emp_id number(10) primary key,
      emp_name varchar2(200),
      salary number (38)
      );
      
insert into employee values (1, 'A', 100);
insert into employee values (2, 'A', 200);
insert into employee values (3, 'A', 300);
insert into employee values (4, 'A', 400);
insert into employee values (5, 'A', 500);
insert into employee values (6, 'A', 600);
insert into employee values (7, 'A', 700);

 Select emp_name, salary from
  (select emp_name, salary ,Row_Number() over(order by salary desc) 
    as myrow from employee) abc
  where abc.myrow = 3;
  
  CREATE USER LOGIN_TEST_DB IDENTIFIED BY p4ssw0rd;
GRANT DBA TO LOGIN_TEST_DB WITH ADMIN OPTION;

--chinook examples
select * from invoice;

--count, min, max, sum, avg
select count(*) from invoice;
select count(*) from invoiceline;
select sum(i.TOTAL) from invoice i;
select AVG(i.TOTAL) from invoice i;
select MAX(i.TOTAL) from invoice i;
select MIN(i.TOTAL) from invoice i;

select * from invoice i 
order by i.BILLINGCITY;

select i.BILLINGCITY from invoice i
group by i.BILLINGCITY;

select count(distinct(i.BILLINGCITY)) from invoice i;
select count(distinct(i.INVOICEDATE)) from invoice i;
select count(distinct(a.TITLE)) from album a;
select count(distinct(a.NAME)) from artist a;

SELECT
     c.FIRSTNAME,  sum(il.quantity), sum(il.UNITPRICE)
FROM
    invoice i
    INNER JOIN invoiceline il ON i.invoiceid = il.invoiceid
    inner join customer c on c.customerid = i.customerid 
    where i.CUSTOMERID > 10
    group by c.FIRSTNAME, il.quantity
    having sum(il.quantity) > 30
    order by c.FIRSTNAME
    ;
    
select * from INVOICELINE;

--One
create user testuser IDENTIFIED by p4ssw0rd;
grant connect, resource to testuser;

drop user testuser;
commit;

create user jta1712 IDENTIFIED by jta1712;
grant connect, resource to jta1712;
GRANT new_DBA TO jta1712 WITH ADMIN OPTION;
--drop user jta1712;
commit;

--good to know only
select * from all_tables;
select * from all_constraints where table_name = 'TEAMS';
desc dual; --not descending order
--desc in the front means describe
--desc at the end of query is descending order
desc SYSTEM_PRIVILEGE_MAP;
select * from SYSTEM_PRIVILEGE_MAP;

--create table with no primary key
create table Player (name VARCHAR2(50),position VARCHAR2(50));

-- disadvantage of not having primary key
insert into Player values('Tom Brady', 'Quarter Back');

-- to retreive data from player table run the below line
select * from player;
--* refers to all records in a table

--try to insert duplicate records in a table
-- insert tom brady's with same position
insert into Player values('Tom Brady', 'Quarter Back');

--delete all records or truncate and then add primary key
delete from Player;
commit;
rollback;

alter table Player 
add player_id Number(10) Primary KEY;

desc Player;

alter table Player modify name Not null;

--primary key - unique identifier and also its not null
--contains uniqueness and not null feature (both unique key constraint 
--and not null constraint)
--primary can't be null. unique can have one null value

--insert records now
insert into Player (PLAYER_ID,NAME, POSITION, team_id) 
values(1, 'Tom Brady', 'QB', 1);
insert into Player values ('Russel Wilson', 'QB', 2, 2);
insert into Player values ('Deshaun Watson', 'QB', 3, 6);
insert into Player values ('Aaron Rodgers', 'QB', 4, 10);
insert into Player values ('Cam Newton', 'QB', 5, 11);
insert into Player values ('Colin Capernick', 'QB', 6, 12);
insert into Player values ('Matt Ryan', 'QB', 7, 4);
insert into Player values ('Kirk Cousins', 'QB', 8, 8);
insert into Player values ('Jarred Gof', 'QB', 9, 10);
insert into Player values ('Peyton Manning', 'QB', 10,9);
insert into Player values ('Eli Manning', 'QB', 11, 3);
insert into Player values ('Drew Brees', 'QB', 12, 5);
insert into Player values ('Ben Rothilsberg', 'QB', 13, 10);
insert into Player values ('Jay Cutler', 'QB', 14, 10);
insert into Player values ('Matt Stafford', 'QB', 15, 10);
insert into Player values ('Joe Flacco', 'QB', 16, 7);

select * from Player;

create table Teams (
id number(10) Primary key, 
team_name varchar2(50),
city varchar2(20)
);

delete from Player;

alter table Player
add team_id number(10);

ALTER table Player
ADD FOREIGN KEY (team_id) References Teams(id);

ALTER table Player
modify team_id NOT NULL ;

select * from Player;
select * from Teams;

insert into Teams values (1,'Patriots','New England');
insert into Teams values (2,'Sea Hawks','Seattle');
insert into Teams values (3,'Giants','New York');
insert into Teams values (4,'Falcons','Atlanta');
insert into Teams values (5,'Saints','New Orleans');
insert into Teams values (6,'Texans','Houston');
insert into Teams values (7,'Ravens','Baltimore');
insert into Teams values (8,'Red Skins','DC');
insert into Teams values (9,'Broncos','Denver');

--join is another way to say inner join
--aliases can be used for table name or column names
select * from player p join teams t 
on p.TEAM_ID = t.ID;

select * from player p inner join teams t 
on p.TEAM_ID = t.ID;
--rename column name in the result set (query result)
--Selected only the columns that we needed
--aliases for the table
-- inner join
--chose the order in column names were displayed
select 
    p.TEAM_ID as TEAMID,
    p.NAME as Player_Name,
    T.CITY as Playing_FOR,
    t.TEAM_NAME as Favorite_Teams
from player p join teams t 
    on p.TEAM_ID = t.ID;
--outer join
select *
from player p right join teams t 
    on p.TEAM_ID = t.ID;
    
select *
from teams t left join player p  
    on p.TEAM_ID = t.ID;
    
delete from player where player.PLAYER_ID = 8;
commit;
-- default order is ascending
-- we can modify it to descending or mention explicitly ascending too
-- order by - display the records in the order we specify for the field
select count(p.position),p.POSITION
from teams t left join player p  
    on p.TEAM_ID = t.ID
group by p.position
order by p.POSITION
;

insert into Player values('AJ Green', 'WR', 17, 1);
insert into Player values ('Antonio Brown', 'WR', 18, 2);
insert into Player values ('Julio Jones', 'WR', 19, 3);
insert into Player values ('Levon Bell', 'RB', 20, 4);
insert into Player values ('Marshawn Lynch', 'RB', 21, 5);

--scalar & aggreegate functions
--scalar - TRIM, LTRIM, RTRIM, Round, ABS, Trunc, Length, RPad, LPad,
-- String functions, Substr, to_char, Inst, replace

-- aggregate - sum, max, min, count, avg, 


--inner join vs outer join
--inner join vs intersect
--right vs left outer join
--union vs union all
--scalar vs aggregate
--order by vs group by
--where vs having
--join vs sub query
--function vs stored procedures
--count vs sum

create sequence playerseq 
    minvalue 20
    maxvalue 60000
    start with 20
    increment by 2;
    
insert into Player values ('Beast mode', 'RB', playerseq.nextval, 5);

select * from player;

create sequence movieseq 
    minvalue 1
    maxvalue 60000
    start with 1
    increment by 2;

select * from player;

create table MovieNames(
    MovieID Number(10),
    MovieName varchar2(100),
    MovieGenre varchar2(10),
    ReleasedYear date
);

create table movies_audit_trail(
    moviename varchar2(100),
    createdby varchar2(25),
    creationtime TIMESTAMP
);

select * from movienames;
select * from MOVIES_AUDIT_TRAIL;

create or replace trigger movie_audits
after insert on movienames for each row
begin
    insert into MOVIES_AUDIT_TRAIL values(:NEW.moviename, user, SYSTIMESTAMP);
end;
/

insert into movienames values(movieseq.NEXTVAL,'Father figures','comedy', 
to_date('2017', 'yyyy') );
insert into movienames values(movieSEQ.NEXTVAL,'Star Wars - Last Jedi','SCi-Fi', 
to_date('2017', 'yyyy') );
insert into movienames values(movieseq.NEXTVAL,'Jumanji','comedy', 
to_date('2017', 'yyyy') );
insert into movienames values(movieseq.NEXTVAL,'Down sizing','comedy', 
to_date('2017', 'yyyy') );
insert into movienames values(movieseq.NEXTVAL,'Wonder','Family', 
to_date('2017', 'yyyy') );


--Two

--data types
--char, varchar, varchar2, nvarchar, date, timestampe, number
--blob, clob

--varchar & varchar2
-- varchar - reserved type for future to differntiate null 
-- and empty string
-- varchar2 - doesn't differentiate between null or empty string

--varchar vs nvachar vs char

--bare bone syntax for functions, procedures, views, index, triggers
--create or replace function/view/procedure/triggers/index name(input parameters)
--return variable
--as -- should contain all the variables that you want to initialize
--begin -- this where you code starts
--end -- code ends
--;/
create or replace function multiply(i Number, j Number)
return Number
as myResult Number;
begin
    myResult := i * j;
    return myResult;
end
;
/
--execute function - approach 1
declare
    myVar Number;
begin
    myVar := multiply(10,20);
    DBMS_OUTPUT.PUT_Line(myVar);
end
;
/

-- approach 2
select multiply(20,30) from dual;

create or replace function getPlayerName(playerid Number)
return varchar
as playerName varchar(30);
anotherVariable varchar(20);
begin
    select p.NAME into playerName
    from jta1712.Player p
    where p.PLAYER_ID = playerid;
    anotherVariable := replace(playerName, 'a','e');
    return anotherVariable;
end
;
/
--this function will return player name when player id is available
create or replace function getPlayerID(playername varchar)
return Number
as playerID varchar(30);
begin
    select p.PLAYER_ID into playerID
    from jta1712.Player p
    where p.name = playername;
    return playerID;
end
;
/
--calling a function in select statement
select getplayername(2) from dual;
--calling a function in where clause of select statement
select * from teams join player
    on teams.id = player.TEAM_ID
where 
    teams.ID = getPlayerID('Russel Wilson');

desc dual;
select * from dual;

select * from all_constraints where table_name = 'TEAMS';

select * from player;
select count(*) from player;
select count(*) from player where PLAYER_ID > 4;
select * from player where PLAYER_ID = 10;
select * from player where player.name like 'D%';



--Three

--stored procedures
select count(*) from invoice;
select count(*) from invoiceline;

savepoint save_12222017_1118;
--sub query
delete from (select * from INVOICELINE where INVOICEID >= 412);

rollback;
delete from invoice where INVOICEID >= 412;
commit;

create or replace procedure printMessage(actualMessage Varchar2)
as
begin
    DBMS_OUTPUT.PUT_LINE(actualMessage);
end;
/

exec PRINTMESSAGE('hello world');
exec PRINTMESSAGE('another message');

begin
    PRINTMESSAGE('another approach to call stored procedures');
end;
/

create or replace procedure deleteInvoice(invoicenumber Number)
as
begin
    delete from (select * from INVOICELINE where INVOICEID >= invoicenumber);
    delete from invoice where INVOICEID >= invoicenumber;
    commit;
end;
/

--approach 1
exec deleteInvoice(412);

rollback;
--approach 2
begin
    deleteInvoice(410);
end;
/

desc employee;
select * from employee;
select firstname, lastname from employee;
select concat(upper(substr(firstname, 1,3)), lastname) from employee;

create or replace procedure getNames(YuviCursor OUT SYS_Refcursor)
as
begin
    open YuviCursor for select concat(upper(substr(firstname, 1,3)), lastname) 
    from employee;
end
;
/

declare
    anotherCursorVariable Sys_Refcursor;
    FullName varchar2(25);
begin
    getNames(anotherCursorVariable);
    Loop
        Fetch anotherCursorVariable into FullName;
        exit when anotherCursorVariable%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE('Employe full name is ' || FullName );
    End Loop;
end;
/

create sequence seq1
    minvalue 1
    maxvalue 100
    start with 1
    increment by 1;

select seq1.currval, SEQ1.NEXTVAL, seq1.currval, SEQ1.NEXTVAL from dual;

begin
    DBMS_OUTPUT.PUT_LINE(seq1.currval);
    DBMS_OUTPUT.PUT_LINE(seq1.nextval);
    DBMS_OUTPUT.PUT_LINE(seq1.currval);
end;
/

select seq1.currval from dual;
select SEQ1.NEXTVAL from dual;



