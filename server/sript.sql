/**
/* lprog database
**/

CREATE TABLE Users(
	id		 				SERIAL PRIMARY KEY,
	username				varchar(40) NOT NULL,
	password				varchar(200) NOT NULL,
	points					integer,
	vitorias				integer,
	derrotas 				integer
);

CREATE TABLE Game(
	id 						SERIAL PRIMARY KEY,
	id_user_1				integer,
	id_user_2				integer,
	portaAvioes1 			integer,
	navioDeGuerra1 			integer,
	cruzador1 				integer,
	submarino1 				integer,
	destruidor1				integer,
	portaAvioes2 			integer,
	navioDeGuerra2 			integer,
	cruzador2 				integer,
	submarino2 				integer,
	destruidor2				integer,
	occurred2				timestamp
);

CREATE TABLE Shot(
	id_user_source			integer,
	id_user_destination		integer,
	game 					integer,
	position				varchar(5),
	occurred 				timestamp
);

CREATE TABLE Message(
	id_user_source			integer,
	id_user_destination		integer,
	Message					text,
	occurred 				timestamp
);

CREATE TABLE PortaAvioes(
	id 						SERIAL PRIMARY KEY,
	p1						varchar(5),
	p2						varchar(5),
	p3						varchar(5),
	p4						varchar(5),
	p5						varchar(5)
);

CREATE TABLE NavioDeGuerra(
	id 						SERIAL PRIMARY KEY,
	p1						varchar(5),
	p2						varchar(5),
	p3						varchar(5),
	p4						varchar(5)
);

CREATE TABLE Cruzador(
	id 						SERIAL PRIMARY KEY,
	p1						varchar(5),
	p2						varchar(5),
	p3						varchar(5)
);

CREATE TABLE Submarino(
	id 						SERIAL PRIMARY KEY,
	p1						varchar(5),
	p2						varchar(5),
	p3						varchar(5)
);

CREATE TABLE Destruidor(
	id 						SERIAL PRIMARY KEY,
	p1						varchar(5),
	p2						varchar(5)
);

									/*////////// FK dos utilizadores/////////////*/

ALTER TABLE Game
ADD CONSTRAINT  fk_id_user_1
FOREIGN KEY (id_user_1) 
REFERENCES Users (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_id_user_2
FOREIGN KEY (id_user_2) 
REFERENCES Users (id)
ON DELETE CASCADE;

									/*////////FK dos barcos do jogador 1/////////*/

ALTER TABLE Game
ADD CONSTRAINT  fk_portaAvioes1
FOREIGN KEY (portaAvioes1) 
REFERENCES PortaAvioes (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_navioDeGuerra1
FOREIGN KEY (navioDeGuerra1) 
REFERENCES NavioDeGuerra (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_cruzador1
FOREIGN KEY (cruzador1) 
REFERENCES Cruzador (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_submarino1
FOREIGN KEY (submarino1) 
REFERENCES Submarino (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_destruidor1
FOREIGN KEY (destruidor1) 
REFERENCES Destruidor (id)
ON DELETE CASCADE;


								/*////////////Fk dos barcos do jogador 2///////*/

ALTER TABLE Game
ADD CONSTRAINT  fk_portaAvioes2
FOREIGN KEY (portaAvioes2) 
REFERENCES PortaAvioes (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_navioDeGuerra2
FOREIGN KEY (navioDeGuerra2) 
REFERENCES NavioDeGuerra (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_cruzador2
FOREIGN KEY (cruzador2) 
REFERENCES Cruzador (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_submarino2
FOREIGN KEY (submarino2) 
REFERENCES Submarino (id)
ON DELETE CASCADE;

ALTER TABLE Game
ADD CONSTRAINT  fk_destruidor2
FOREIGN KEY (destruidor2) 
REFERENCES Destruidor (id)
ON DELETE CASCADE;


								/*////////////////FK dos tiros//////////////////*/

ALTER TABLE Shot
ADD CONSTRAINT  fk_id_user_source
FOREIGN KEY (id_user_source) 
REFERENCES Users (id)
ON DELETE CASCADE;

ALTER TABLE Shot
ADD CONSTRAINT  fk_id_user_destination
FOREIGN KEY (id_user_destination) 
REFERENCES Users (id)
ON DELETE CASCADE;

ALTER TABLE Shot
ADD CONSTRAINT  fk_game
FOREIGN KEY (game) 
REFERENCES Game (id)
ON DELETE CASCADE;


								/*//////////////FK das mensagens///////////////*/

ALTER TABLE Message
ADD CONSTRAINT  fk_id_user_source
FOREIGN KEY (id_user_source) 
REFERENCES Users (id)
ON DELETE CASCADE;

ALTER TABLE Message
ADD CONSTRAINT  fk_id_user_destination
FOREIGN KEY (id_user_destination) 
REFERENCES Users (id)
ON DELETE CASCADE;