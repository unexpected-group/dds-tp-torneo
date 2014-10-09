CREATE TABLE partido (
	id_partido PRIMARY KEY,
	fecha,
	estado,
	id_config
	id_inscripcion,
	id_propuesta,
	FOREIGN KEY (id_config) REFERENCES configuracion (id_config),
	FOREIGN KEY (id_inscripcion) REFERENCES inscripcion (id_inscripcion),
	FOREIGN KEY (id_propuesta) REFERENCES propuesta (id_propuesta)
);

CREATE TABLE configuracion (
	id_config PRIMARY KEY,
	armador,
	ordenador
);

CREATE TABLE jugador (
	id_jugador PRIMARY KEY,
	nombre,
	edad,
	id_jugador,
	id_infraccion,
	id_calif,
	handicap,
	FOREIGN KEY (id_jugador) REFERENCES jugador (id_jugador),
	FOREIGN KEY (id_infraccion) REFERENCES infraccion (id_infraccion),
	FOREIGN KEY (id_calif) REFERENCES calificacion (id_calif)
);

CREATE TABLE calificacion (
	id_calif PRIMARY KEY,
	puntaje,
	descripcion,
	id_jugador,
	id_partido,
	FOREIGN KEY (id_jugador) REFERENCES jugador (id_jugador),
	FOREIGN KEY (id_partido) REFERENCES partido (id_partido)
);

CREATE TABLE infraccion (
	id_infraccion PRIMARY KEY,
	fecha,
	motivo
);

CREATE TABLE propuesta (
	id_propuesta PRIMARY KEY,
	id_jugador,
	fecha,
	fecha_rechazo,
	motivo_rechazo,
	estado,
	FOREIGN KEY (id_jugador) REFERENCES jugador (id_jugador)
);

CREATE TABLE inscripcion (
	id_inscripcion PRIMARY KEY,
	id_jugador,
	tipo,
	FOREIGN KEY (id_jugador) REFERENCES jugador (id_jugador)
);
