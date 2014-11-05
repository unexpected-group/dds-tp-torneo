# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table Calificaciones (
  id                        bigint not null,
  puntaje                   double,
  descripcion               varchar(255),
  constraint pk_Calificaciones primary key (id))
;

create table Infracciones (
  id                        bigint not null,
  fecha                     timestamp,
  motivo                    varchar(255),
  constraint pk_Infracciones primary key (id))
;

create sequence Calificaciones_seq;

create sequence Infracciones_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists Calificaciones;

drop table if exists Infracciones;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists Calificaciones_seq;

drop sequence if exists Infracciones_seq;

