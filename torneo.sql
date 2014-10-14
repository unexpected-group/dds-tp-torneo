create table partidos (
	cod_partido int primary key,
	fecha date not null,
	lugar varchar(50) not null,
	estado varchar(50) not null default 'Pendiente', /* state */
	configuracion int, /* composicion */
	foreign key (configurancion) references configuraciones (cod_configuracion)
);

create table configuraciones (
	cod_configuracion int primary key,
	ordenador int not null,
	armador int not null,
	foreign key (ordenador) references ordenadores (cod_ordenador),
	foreign key (armador) references armadores (cod_armador)
);

create table ordenadores (
	cod_ordenador int primary key,
	descripcion varchar(50)
	/* campos especiales */
);

create table armadores (
	cod_armador int primary key,
	descripcion varchar(50)
	/* campos especiales */
);

create table jugadores (
	cod_jugador int primary key,
	nombre varchar(50) unique not null,
	edad smallint not null,
	fecha_nacimiento date not null,
	handicap real check (handicap between 0 and 10),
	amigo int, /* auto referencia */
	foreign key (amigo) references jugadores (cod_jugador)
);

create table calificaciones (
	cod_calificacion int primary key,
	puntaje real not null check (puntaje between 0 and 10),
	descripcion varchar(50),
	calificado int not null,
	calificador int not null, /* jugador que hace la calificacion */
	partido int not null,
	foreign key (calificado) references jugadores (cod_jugador),
	foreign key (calificador) references jugadores (cod_jugador),
	foreign key (partido) references partidos (cod_partido)
);

create table infracciones (
	cod_infraccion int primary key,
	jugador int not null,
	fecha date not null,
	motivo varchar(50) not null,
	foreign key (jugador) references jugadores (cod_jugador)
);

create table propuestas (
	cod_propuesta int primary key,
	jugador_propuesto int not null,
	/* jugador_proponedor int not null, */
	fecha_formulacion date not null /* default today */,
	fecha_rechazo date check (fecha_rechazo > fecha_formulacion),
	motivo_rechazo varchar(50),
	estado varchar(50), /* state */
	foreign key (jugador_propuesto) references jugadores (cod_jugador)
);

create table inscripciones (
	cod_inscripcion int primary key,
	jugador int not null,
	partido int not null,
	tipo varchar(50) not null, /* composicion */
	foreign key (jugador) references jugadores (cod_jugador),
	foreign key (partido) references partidos (cod_partido)
);
