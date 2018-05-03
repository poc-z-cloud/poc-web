
create table Users (
    UserId int not null,
    UserName varchar(80) null,
    Gender varchar(1) not null,
    Dob date not null,
    constraint pk_Users primary key (UserId)
);

create table Orders (
    orderNo int IDENTITY not null,
    productName varchar(80) null,
    price decimal(10,2) not null,
    qty int not null
);

CREATE TABLE sequence
(
    name               varchar(30)  not null,
    nextid             int          not null,
    constraint pk_sequence primary key (name)
);
