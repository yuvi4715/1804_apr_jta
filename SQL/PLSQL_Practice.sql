--Multiplication Function
CREATE OR REPLACE FUNCTION multiply(x NUMBER, y NUMBER)
RETURN NUMBER
AS 
BEGIN
   return x * y; 
END;
/

DECLARE 
    myVar NUMBER;
BEGIN
    myVar := multiply(10, 20);
    dbms_output.put_line('myVar = ' || myVar);
END;
/

CREATE OR REPLACE FUNCTION the_current_time
RETURN TIMESTAMP
AS
    the_time TIMESTAMP;
BEGIN
    SELECT current_timestamp INTO the_time FROM dual;
    return the_time;
END;
/

DECLARE
    the_time TIMESTAMP;
BEGIN
    the_time := the_current_time;
    dbms_output.put_line('The current time is ' || the_time);
END;
/

SELECT * FROM artist WHERE name LIKE 'A%';

CREATE OR REPLACE PROCEDURE getAllArtistsThatStartWith(letter IN VARCHAR2,
artists OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN artists for
    SELECT artistid, name FROM artist WHERE name LIKE letter||'%';
END;
/

DECLARE
    my_cursor SYS_REFCURSOR;
    artist_name VARCHAR2(60);
    artist_id NUMBER(6);
BEGIN
    getAllArtistsThatStartWith('B', my_cursor);
    LOOP
        FETCH my_cursor INTO artist_name, artist_id;
        EXIT WHEN my_cursor%NOTFOUND;
        dbms_output.put_line(artist_id || ' ' || artist_name);
    END LOOP;
    CLOSE my_cursor;
END;
/
