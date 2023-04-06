create database if not exists smart;
use smart;

create user if not exists 'restaurant'@'localhost' identified by 'smart';
grant all privileges on smart.* to 'restaurant'@'localhost';
