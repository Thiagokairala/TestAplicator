# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table answer (
  answer_id                 bigint not null,
  question_id               bigint,
  answer_text               varchar(255) not null,
  is_correct                boolean not null,
  constraint pk_answer primary key (answer_id))
;

create table multiple_question (
  dtype                     varchar(10) not null,
  question_id               bigint not null,
  subject_id                bigint,
  question_status           integer,
  orientation               varchar(255) not null,
  question_type             integer,
  constraint ck_multiple_question_question_status check (question_status in (0,1)),
  constraint ck_multiple_question_question_type check (question_type in (0,1,2)),
  constraint pk_multiple_question primary key (question_id))
;

create table question (
  question_id               bigint not null,
  subject_id                bigint,
  question_status           integer,
  orientation               varchar(255) not null,
  question_type             integer,
  constraint ck_question_question_status check (question_status in (0,1)),
  constraint ck_question_question_type check (question_type in (0,1,2)),
  constraint pk_question primary key (question_id))
;

create sequence answer_seq;

create sequence multiple_question_seq;

create sequence question_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists answer;

drop table if exists multiple_question;

drop table if exists question;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists answer_seq;

drop sequence if exists multiple_question_seq;

drop sequence if exists question_seq;

