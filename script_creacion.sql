CREATE TABLE partido (
	cod_partido PRIMARY KEY,
	fecha,
	estado,
	cod_config
	cod_inscripcion,
	cod_propuesta,
	FOREIGN KEY (cod_config) REFERENCES configuracion (cod_config),
	FOREIGN KEY (cod_inscripcion) REFERENCES inscripcion (cod_inscripcion),
	FOREIGN KEY (cod_propuesta) REFERENCES propuesta (cod_propuesta)
);

CREATE TABLE configuracion (
	cod_config PRIMARY KEY,
	armador,
	ordenador
);

CREATE TABLE jugador (
	cod_jugador PRIMARY KEY,
	nombre,
	edad,
	cod_jugador,
	cod_infraccion,
	cod_calif,
	handicap,
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador),
	FOREIGN KEY (cod_infraccion) REFERENCES infraccion (cod_infraccion),
	FOREIGN KEY (cod_calif) REFERENCES calificacion (cod_calif)
);

CREATE TABLE calificacion (
	cod_calif PRIMARY KEY,
	puntaje,
	descripcion,
	cod_jugador,
	cod_partido,
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador),
	FOREIGN KEY (cod_partido) REFERENCES partido (cod_partido)
);

CREATE TABLE infraccion (
	cod_infraccion PRIMARY KEY,
	fecha,
	motivo
);

CREATE TABLE propuesta (
	cod_propuesta PRIMARY KEY,
	cod_jugador,
	fecha,
	fecha_rechazo,
	motivo_rechazo,
	estado,
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador)
);

CREATE TABLE inscripcion (
	cod_inscripcion PRIMARY KEY,
	cod_jugador,
	tipo,
	FOREIGN KEY (cod_jugador) REFERENCES jugador (cod_jugador)
);
