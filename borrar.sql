use torneo_play;

drop table if exists calificaciones;
drop table if exists infracciones;
drop table if exists propuestas;
drop table if exists inscripciones;
drop table if exists jugadores;
drop table if exists partidos;
drop table if exists configuraciones;
drop table if exists ordenadores;
drop table if exists armadores;
drop view if exists jugadores_malos;
drop procedure if exists obtener_jugadores_malos;
drop procedure if exists obtener_jugadores_traicioneros;
drop procedure if exists obtener_jugadores_mejorables;
drop procedure if exists dar_de_baja_jugador;
