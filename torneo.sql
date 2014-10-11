create table partidos (
	cod_partido int primary key,
	fecha date,
	lugar varchar(50),
	estado varchar(50), /* state */
	configuracion int, /* composicion */
	foreign key (configurancion) references configuraciones (cod_configuracion)
);

create table configuraciones (
	cod_configuracion int primary key,
	armador varchar(50), /* composicion */
	ordenador varchar(50) /* composicion */
);

create table jugadores (
	cod_jugador int primary key,
	nombre varchar(50),
	edad smallint,
	handicap real,
	amigo int, /* auto referencia */
	foreign key (amigo) references jugadores (cod_jugador)
);

create table calificaciones (
	cod_calificacion int primary key,
	puntaje real,
	descripcion varchar(50),
	calificado int,
	calificador int, /* jugador que hace la calificacion */
	partido int,
	foreign key (calificado) references jugadores (cod_jugador),
	foreign key (calificador) references jugadores (cod_jugador),
	foreign key (partido) references partidos (cod_partido)
);

create table infracciones (
	cod_infraccion int primary key,
	jugador int,
	fecha date,
	motivo varchar(50),
	foreign key (jugador) references jugadores (cod_jugador)
);

create table propuestas (
	cod_propuesta int primary key,
	jugador_propuesto int,
	fecha_formulacion date,
	fecha_rechazo date check (fecha_rechazo > fecha_formulacion),
	motivo_rechazo varchar(50),
	estado varchar(50), /* state */
	foreign key (jugador_propuesto) references jugadores (cod_jugador)
);

create table inscripciones (
	cod_inscripcion int primary key,
	jugador int,
	partido int,
	tipo varchar(50), /* composicion */
	foreign key (jugador) references jugadores (cod_jugador),
	foreign key (partido) references partidos (cod_partido)
);
