create table login(
username varchar(50) not null,
password varchar(50));

insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 


create table StRegister(
firstName varchar(50),
lastName varchar(50),
eMail varchar(50),
username varchar(50) not null,
pass varchar(50),
confPass varchar(50),
phone varchar(50),
language varchar(50));

insert into StRegister values("alexz", "davidz", "ald@123.fff.com", "alxdvd11", "alxdvd1", "alxdvd1", "1234567890", "English"); 

