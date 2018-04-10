--The purpose of this script is to show joining between multiple tables
CREATE TABLE new_pokemon(
id NUMBER(6),
name VARCHAR2(40),
CONSTRAINT PK_NEW_POKEMON PRIMARY KEY (id)
);

CREATE TABLE trainer(
id NUMBER(6), 
name VARCHAR2(40),
CONSTRAINT PK_TRAINER PRIMARY KEY (id)  --To make a Primary Key
                                        --CONSTRAINT PK_NAME_OF_TABLE PRIMARY KEY (column_which_is_pk)
);

CREATE TABLE generation (
id NUMBER(6),
pokemon_id NUMBER(6),
generation VARCHAR2(10),
CONSTRAINT PK_GENERATION PRIMARY KEY (id),
CONSTRAINT FK_GENERATION_POKEMON FOREIGN KEY (id) REFERENCES new_pokemon (id)
);

CREATE TABLE pokemon_trainer(
pokemon_id NUMBER(6),
trainer_id NUMBER(6),
CONSTRAINT PK_POKEMON_TRAINER PRIMARY KEY (pokemon_id, trainer_id),
CONSTRAINT FK_POKEMON FOREIGN KEY (pokemon_id) REFERENCES new_pokemon (id),
--To make a foreign key
--CONSTRAINT FK_TABLE_REFERRING_TO FOREIGN KEY (column_that_is_fk_in_this_table) REFERENCES REFERRING_TABLE (PK_IN_REFERRING_TABLE)
CONSTRAINT FK_TRAINER FOREIGN KEY (trainer_id) REFERENCES trainer (id)
);


INSERT INTO NEW_POKEMON VALUES(1, 'Charmander');
INSERT INTO NEW_POKEMON VALUES(2, 'Bulbasaur');
INSERT INTO NEW_POKEMON VALUES(3, 'Squirtle');
INSERT INTO NEW_POKEMON VALUES(4, 'Pikachu');

INSERT INTO generation VALUES(1, 1, 'I'); --Charmander is in Gen I
INSERT INTO generation VALUES(2, 2, 'I'); --Bulbasaur is in Gen I
INSERT INTO generation VALUES(3, 4, 'I'); --Pikachu is Gen I

INSERT INTO trainer VALUES(1, 'Ash Ketchum');
INSERT INTO trainer VALUES(2, 'William');

INSERT INTO pokemon_trainer VALUES(1, 1);
INSERT INTO pokemon_trainer VALUES(1, 2);
INSERT INTO pokemon_trainer VALUES(2, 2);
INSERT INTO pokemon_trainer VALUES(3, 2);
INSERT INTO pokemon_trainer VALUES(4, 2);
INSERT INTO pokemon_trainer (trainer_id, pokemon_id) VALUES(1, 4);

select * from pokemon_trainer;

SELECT t.name, p.name, g.generation FROM pokemon_trainer pt
    INNER JOIN new_pokemon p
    on p.id=pt.pokemon_id --pt.pokemon_id = p.id.....and it didnt work
    INNER JOIN trainer t
    on t.id=pt.trainer_id
    INNER JOIN generation g
    on p.id=g.pokemon_id
    WHERE t.name='William';
    
    
commit;
