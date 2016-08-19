# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table friend (
  email                         varchar(255) not null,
  fname                         varchar(255),
  lname                         varchar(255),
  photo_url                     varchar(255),
  constraint pk_friend primary key (email)
);


# --- !Downs

drop table if exists friend;

