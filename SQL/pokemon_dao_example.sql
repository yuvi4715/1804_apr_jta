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


--Create a Sequence to generate Pokemon PK's
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


















