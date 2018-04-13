--Create a user and password for the Pokemon Database
CREATE USER master_trainer IDENTIFIED BY pokemon;

--Grant privileges to the user
GRANT connect TO master_trainer;
GRANT create any table TO master_trainer;
GRANT create any procedure TO master_trainer;
GRANT create any sequence TO master_trainer;
GRANT create any trigger TO master_trainer;
GRANT insert any table TO master_trainer;
GRANT update any table TO master_trainer;
GRANT delete any table TO master_trainer;
GRANT drop any table TO master_trainer;
GRANT resource TO master_trainer;
--GRANT dba TO master_trainer;
--REVOKE dba FROM master_trainer;
GRANT unlimited tablespace TO master_trainer;


--Create the Pokemon Table
CREATE TABLE pokemon (
id INTEGER,
pokedexEntry INTEGER NOT NULL,
name VARCHAR2(30),
type1 VARCHAR2(10),
type2 VARCHAR2(10) DEFAULT null,    --If you do not provide a value for type2
                                    --it is assigned null
generation INTEGER,
CONSTRAINT PK_POKEMON PRIMARY KEY (id),
CONSTRAINT UK_POKEDEX_ENTRY UNIQUE (pokedexEntry)
);


--Create a Sequence to generate the value for the Pokemon PK's
CREATE SEQUENCE pokemon_sequence
    START WITH 1 
    INCREMENT BY 1
    MAXVALUE 900
    MINVALUE -1
    NOCACHE;


--Create an INSERT trigger on Pokemon to auto-increment the PK
CREATE OR REPLACE TRIGGER before_insert_pokemon
BEFORE INSERT ON pokemon
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN 
        SELECT pokemon_sequence.nextval INTO :NEW.id FROM dual;
    END IF;
END;
/


--Create a Stored Procedure to INSERT a new Pokemon
CREATE OR REPLACE PROCEDURE insert_pokemon(pokedexEntry IN INTEGER,
                name IN VARCHAR2, type1 IN VARCHAR2, type2 IN VARCHAR2, generation IN INTEGER)
AS
BEGIN
    
    INSERT INTO pokemon VALUES(null, pokedexEntry, name, type1, type2, generation);
    COMMIT;
END;
/


--Test 
BEGIN 
    insert_pokemon(3, 'Venusaur', 'Grass', 'Poison', 1);
END;
/

--Procedure to Update a Pokemon
CREATE OR REPLACE PROCEDURE update_pokemon(new_pokedexEntry IN INTEGER, new_name IN VARCHAR2,
                     new_type1 IN VARCHAR2, new_type2 IN VARCHAR2, new_generation IN INTEGER)
AS
BEGIN
    
    UPDATE pokemon SET name = new_name, type1 = new_type1, type2 = new_type2, 
    generation = new_generation
    WHERE pokedexEntry = new_pokedexEntry;
    COMMIT;
END;
/


--Approach 1 when executing Stored Procedures
exec update_pokemon(150, 'MEWTWO IS KING', 'Psychic', 'Dragon', 1);

--Approach 2 when executing Stored Procedures
BEGIN
    update_pokemon(150, 'Mewtwo', 'Psychic', null, 1);
END;
/

--This procedure deletes a pokemon based on their Pokedex Entry
CREATE OR REPLACE PROCEDURE delete_pokemon(new_pokedex_entry IN INTEGER)
AS
BEGIN
    DELETE FROM pokemon WHERE pokedexEntry = new_pokedex_entry;
    COMMIT;
END;
/

exec delete_pokemon(150);


--Procedure to return a single record by Pokedex Entry
CREATE OR REPLACE PROCEDURE get_pokemon(new_pokedex_entry IN INTEGER, 
                            poke_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN poke_cursor FOR
    SELECT pokedexEntry, name, type1, type2, generation FROM pokemon
    WHERE pokedexEntry = new_pokedex_entry;
END;
/

DECLARE
    my_cursor SYS_REFCURSOR;
    pokedex_entry INTEGER;
    name VARCHAR2 (30);
    type1 VARCHAR2 (10);
    type2 varchar2 (10);
    generation INTEGER;
BEGIN
    get_pokemon(3, my_cursor);
    LOOP
        FETCH my_cursor INTO pokedex_entry, name, type1, type2, generation;
        EXIT WHEN my_cursor%notfound;
        dbms_output.put_line(name || ': ' || pokedex_entry);
    END LOOP;
    CLOSE my_cursor;
END;
/
    
















