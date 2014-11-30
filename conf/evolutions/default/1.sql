# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table armadores (
  tipo                      varchar(31) not null,
  id                        integer auto_increment not null,
  constraint pk_armadores primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table armadores;

SET FOREIGN_KEY_CHECKS=1;

