create table cursos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(255) not null unique,
    categoria varchar(100) not null,

    primary key(id)
);