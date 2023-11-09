create database ssm_db;

use ssm_db;


create table tb1_book(
    id int auto_increment primary key ,
    type varchar(255),
    name varchar(255),
    description varchar(255)
);