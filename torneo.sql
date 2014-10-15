create table if not exists ordenadores (
	cod_ordenador int primary key auto_increment,
	descripcion varchar(50) not null
);

create table if not exists armadores (
	cod_armador int primary key auto_increment,
	descripcion varchar(50) not null
);

create table if not exists configuraciones (
	cod_configuracion int primary key auto_increment,
	ordenador int not null,
	armador int not null,
	foreign key (ordenador) references ordenadores (cod_ordenador),
	foreign key (armador) references armadores (cod_armador)
);

create table if not exists partidos (
	cod_partido int primary key auto_increment,
	fecha date not null,
	lugar varchar(50) not null,
	estado varchar(50) not null default 'Pendiente', /* state */
	configuracion int, /* composicion */
	foreign key (configuracion) references configuraciones (cod_configuracion)
);

create table if not exists jugadores (
	cod_jugador int primary key auto_increment,
	nombre varchar(50) unique not null,
	edad smallint not null,
	fecha_nacimiento date not null,
	handicap real check (handicap between 0 and 10),
	amigo int, /* auto referencia */
	foreign key (amigo) references jugadores (cod_jugador)
);

create table if not exists calificaciones (
	cod_calificacion int primary key auto_increment,
	puntaje real not null check (puntaje between 0 and 10),
	descripcion varchar(50),
	calificado int not null,
	calificador int not null, /* jugador que hace la calificacion */
	partido int not null,
	foreign key (calificado) references jugadores (cod_jugador),
	foreign key (calificador) references jugadores (cod_jugador),
	foreign key (partido) references partidos (cod_partido)
);

create table if not exists infracciones (
	cod_infraccion int primary key auto_increment,
	jugador int not null,
	fecha date not null,
	motivo varchar(50) not null,
	foreign key (jugador) references jugadores (cod_jugador)
);

create table if not exists propuestas (
	cod_propuesta int primary key auto_increment,
	jugador int not null, /* jugador que hace la propuesta */
    jugador_propuesto int not null,
	fecha_formulacion date not null,
	fecha_rechazo date check (fecha_rechazo > fecha_formulacion),
	motivo_rechazo varchar(50),
	estado varchar(50), /* state */
    foreign key (jugador) references jugadores (cod_jugador),
	foreign key (jugador_propuesto) references jugadores (cod_jugador)
);

create table if not exists inscripciones (
	cod_inscripcion int primary key auto_increment,
	jugador int not null,
	partido int not null,
	tipo varchar(50) not null, /* composicion */
	foreign key (jugador) references jugadores (cod_jugador),
	foreign key (partido) references partidos (cod_partido)
);


insert into ordenadores (descripcion)
values
	('Handicap'),
	('Promedio del Ultimo Partido'),
    ('Promedio de las Ultimas Calificaciones');

insert into armadores (descripcion)
values
	('Posiciones Pares e Impares'),
    ('Posiciones Preestablecidas');

insert into configuraciones (ordenador, armador)
values (1, 1);

insert into partidos (fecha, lugar, configuracion)
values ('2014-10-10', 'Pilar', 1);

insert into jugadores (nombre, edad, fecha_nacimiento, amigo)
values
	('Gaston', 28, '1986-10-10', null),
    ('Franco', 26, '1988-10-10', null),
    ('Matias', 25, '1989-10-10', null),
    ('Ariel', 25, '1989-10-10', null),
    ('Pollo', 27, '1987-10-10', null),
    ('Nicolas', 33, '1981-10-10', null),
    ('Demian', 31, '1983-10-10', null),
    ('Pablo', 28, '1986-10-10', null),
    ('Ernesto', 27, '1987-10-10', null),
    ('Federico', 26, '1988-10-10', null);

/*
drop table if exists calificaciones;
drop table if exists infracciones;
drop table if exists propuestas;
drop table if exists inscripciones;
drop table if exists jugadores;
drop table if exists partidos;
drop table if exists configuraciones;
drop table if exists ordenadores;
drop table if exists armadores;
*/
