create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(255) not null unique,
    fechaCreacion datetime not null,
    status tinyint not null,
    autorId bigint not null,
    cursoId bigint not null,

primary key(id)
);