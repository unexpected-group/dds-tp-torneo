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
	handicap int check (handicap between 0 and 10),
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
	estado varchar(50), /* state - ACEPTADA / PENDIENTE / RECHAZADA */
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
values
	('2014-8-10', 'Pilar', 1),
	('2014-9-23', 'Puerto Madero', 1);

insert into jugadores (nombre, edad, fecha_nacimiento, handicap)
values
	('Gaston', 28, '1986-10-10', 7),
	('Franco', 26, '1988-10-10', 8),
	('Matias', 25, '1989-10-10', 6),
	('Ariel', 25, '1989-10-10', 2),
	('Pollo', 27, '1987-10-10', 3),
	('Nicolas', 33, '1981-10-10', 6),
	('Demian', 31, '1983-10-10', 3),
	('Pablo', 28, '1986-10-10', 7),
	('Ernesto', 27, '1987-10-10', 5),
	('Federico', 26, '1988-10-10', 5),
	('Juan', 21, '1993-10-10', 8),
	('Agustin', 21, '1993-10-10', 9),
	('Manuel', 21, '1993-10-10', 4),
	('Esteban', 21, '1993-10-10', 5),
	('Lucas', 30, '1984-10-10', 8);

insert into inscripciones (jugador, partido, tipo)
values
	(1, 1, 'Estandar'),
	(2, 1, 'Estandar'),
	(3, 1, 'Estandar'),
	(4, 1, 'Estandar'),
	(5, 1, 'Estandar'),
	(6, 1, 'Estandar'),
	(7, 1, 'Estandar'),
	(8, 1, 'Estandar'),
	(9, 1, 'Estandar'),
	(10, 1, 'Estandar'),
	(11, 1, 'Estandar'),
	(12, 1, 'Estandar'),
	(13, 1, 'Estandar'),
	(14, 1, 'Estandar'),
	(15, 1, 'Estandar');

insert into infracciones (jugador, fecha, motivo)
values
	(7, '2014-10-10', 'Llego tarde al partido'),
	(2, '2014-10-15', 'Tarjeta amarilla'),
	(3, '2014-10-14', 'Escupio a un jugador'),
	(4, '2014-11-22', 'Llego a los 20 fouls'),
    (4, '2014-10-16', 'Tarjeta amarilla'),
    (4, '2014-10-16', 'Tarjeta roja'),
    (4, '2014-10-17', 'Tarjeta azul'),
	(5, '2014-11-23', 'Tarjeta roja'),
	(6, '2014-12-12', 'Golpeo al arbitro');

insert into propuestas (jugador, jugador_propuesto, fecha_formulacion)
values
	(1, 3, '2014-9-4'),
	(1, 5, '2014-9-4'),
	(4, 7, '2014-9-4');

delimiter //

create procedure jugadores_malos ()
begin
	select nombre, edad, fecha_nacimiento, handicap
    from jugadores
    where handicap < 6;
end //

create procedure jugadores_traicioneros ()
begin
	select nombre, edad, fecha_nacimiento, count(i.cod_infraccion)
    from jugadores j
    join infracciones i on j.cod_jugador = i.jugador
    where i.fecha > date_sub(curdate(), interval 1 month)
    group by nombre, edad, fecha_nacimiento
    having count(i.cod_infraccion) > 3;
end //

create procedure jugadores_mejorables ()
begin
	select nombre, edad, fecha_nacimiento, handicap
    from jugadores
    where handicap < 6
    and edad < 25;
end //

delimiter ;
