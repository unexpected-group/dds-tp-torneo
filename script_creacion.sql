CREATE TABLE partido (
	cod_partido NUMERIC(10, 0) PRIMARY KEY,
	fecha DATETIME,
	estado, /* ESTE ES UN STRING?*/
	cod_config NUMERIC(10, 0),
	cod_inscripcion NUMERIC(10, 0),
	cod_propuesta NUMERIC(10, 0),
	FOREIGN KEY (cod_config) REFERENCES configuracion (cod_config),
	FOREIGN KEY (cod_inscripcion) REFERENCES inscripcion (cod_inscripcion),
	FOREIGN KEY (cod_propuesta) REFERENCES propuesta (cod_propuesta)
);

CREATE TABLE configuracion (
	cod_config NUMERIC(10, 0) PRIMARY KEY,
	armador, /* ESTE ES UN STRING?*/
	ordenador /* ESTE ES UN STRING?*/
);

CREATE TABLE jugador (
	cod_jugador NUMERIC(10, 0) PRIMARY KEY,
	nombre NVARCHAR(30),
	edad SMALLINT,
	cod_jugador NUMERIC(10, 0),
	cod_infraccion NUMERIC(10, 0),
	cod_calif NUMERIC(10, 0),
	handicap SMALLINT,
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador),
	FOREIGN KEY (cod_infraccion) REFERENCES infraccion (cod_infraccion),
	FOREIGN KEY (cod_calif) REFERENCES calificacion (cod_calif)
);

CREATE TABLE calificacion (
	cod_calif NUMERIC(10, 0) PRIMARY KEY,
	puntaje SMALLINT,
	descripcion NVARCHAR(255),
	cod_jugador NUMERIC(10, 0),
	cod_partido NUMERIC(10, 0),
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador),
	FOREIGN KEY (cod_partido) REFERENCES partido (cod_partido)
);

CREATE TABLE infraccion (
	cod_infraccion NUMERIC(10, 0) PRIMARY KEY,
	fecha DATETIME,
	motivo NVARCHAR(255)
);

CREATE TABLE propuesta (
	cod_propuesta NUMERIC(10, 0) PRIMARY KEY,
	cod_jugador NUMERIC(10, 0),
	fecha DATETIME,
	fecha_rechazo DATETIME,
	motivo_rechazo NVARCHAR(255),
	estado NVARCHAR(30),
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador)
);

CREATE TABLE inscripcion (
	cod_inscripcion NUMERIC(10, 0) PRIMARY KEY,
	cod_jugador NUMERIC(10, 0),
	tipo, /* ESTE ES UN STRING?*/
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador)
);
