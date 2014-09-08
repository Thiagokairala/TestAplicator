# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table avaliation (
  avaliation_id             bigint not null,
  mention                   integer,
  grade                     integer,
  constraint ck_avaliation_mention check (mention in (0,1,2,3,4,5)),
  constraint pk_avaliation primary key (avaliation_id))
;

create table multiple_question (
  dtype                     varchar(10) not null,
  question_id               bigint not null,
  question_status           integer,
  orientation               varchar(255) not null,
  question_type             integer,
  constraint ck_multiple_question_question_status check (question_status in (0,1)),
  constraint ck_multiple_question_question_type check (question_type in (0,1,2)),
  constraint pk_multiple_question primary key (question_id))
;

create table question (
  question_id               bigint not null,
  question_status           integer,
  orientation               varchar(255) not null,
  question_type             integer,
  constraint ck_question_question_status check (question_status in (0,1)),
  constraint ck_question_question_type check (question_type in (0,1,2)),
  constraint pk_question primary key (question_id))
;

create table right_or_wrong_question (
  dtype                     varchar(10) not null,
  question_id               bigint not null,
  question_status           integer,
  orientation               varchar(255) not null,
  question_type             integer,
  text                      varchar(255),
  answer                    boolean,
  constraint ck_right_or_wrong_question_question_status check (question_status in (0,1)),
  constraint ck_right_or_wrong_question_question_type check (question_type in (0,1,2)),
  constraint pk_right_or_wrong_question primary key (question_id))
;


create table avaliation_question (
  avaliation_avaliation_id       bigint not null,
  question_question_id           bigint not null,
  constraint pk_avaliation_question primary key (avaliation_avaliation_id, question_question_id))
;
create sequence avaliation_seq;

create sequence multiple_question_seq;

create sequence question_seq;

create sequence right_or_wrong_question_seq;




alter table avaliation_question add constraint fk_avaliation_question_avalia_01 foreign key (avaliation_avaliation_id) references avaliation (avaliation_id) on delete restrict on update restrict;

alter table avaliation_question add constraint fk_avaliation_question_questi_02 foreign key (question_question_id) references question (question_id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists avaliation;

drop table if exists avaliation_question;

drop table if exists multiple_question;

drop table if exists question;

drop table if exists right_or_wrong_question;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists avaliation_seq;

drop sequence if exists multiple_question_seq;

drop sequence if exists question_seq;

drop sequence if exists right_or_wrong_question_seq;

