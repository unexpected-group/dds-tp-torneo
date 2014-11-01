# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Calificaciones (
  id                        bigint auto_increment not null,
  puntaje                   double,
  descripcion               varchar(255),
  constraint pk_Calificaciones primary key (id))
;

create table Infracciones (
  id                        bigint auto_increment not null,
  fecha                     datetime,
  motivo                    varchar(255),
  constraint pk_Infracciones primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table Calificaciones;

drop table Infracciones;

SET FOREIGN_KEY_CHECKS=1;

