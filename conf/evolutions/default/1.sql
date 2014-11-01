# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table auto (
  id                        bigint not null,
  marca                     varchar(255),
  constraint pk_auto primary key (id))
;

create sequence auto_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists auto;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists auto_seq;

