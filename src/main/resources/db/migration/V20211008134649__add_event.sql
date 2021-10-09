create table event
(
    id_event    bigserial
        constraint event_pk
            primary key,
    date_event  timestamp with time zone,
    id_file_ref bigint,
    id_user_ref bigint
);

