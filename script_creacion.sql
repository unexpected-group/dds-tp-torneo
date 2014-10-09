CREATE TABLE partido (
	id_partido PRIMARY KEY,
	fecha,
	estado,
	id_config
	id_inscripcion,
	id_propuesta,
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
	handicap
);

CREATE TABLE calificacion (
	id_calif PRIMARY KEY,
	puntaje,
	descripcion,
	id_jugador,
	id_partido
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
	estado
);

CREATE TABLE inscripcion (
	id_inscripcion PRIMARY KEY,
	id_jugador,
	tipo
);
