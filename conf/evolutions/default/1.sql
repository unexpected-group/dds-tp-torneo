# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table infraccion (
  id                        bigint not null,
  fecha                     timestamp,
  motivo                    varchar(255),
  constraint pk_infraccion primary key (id))
;

create sequence infraccion_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists infraccion;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists infraccion_seq;

