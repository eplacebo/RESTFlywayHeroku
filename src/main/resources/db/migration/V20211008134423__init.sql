create table file
(
    id_file   bigserial
        constraint file_pk
            primary key,
    path_file varchar,
    name_file varchar
);

