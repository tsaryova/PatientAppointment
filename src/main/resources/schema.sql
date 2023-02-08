create table if not exists doctor
(
    id             bigserial    not null
        constraint doctor_pkey
            primary key,
    created_at     timestamp(6) with time zone,
    fullname       varchar(200) not null,
    specialization varchar(100) not null,
    uuid           uuid         not null
);

create table if not exists patient
(
    id         bigserial    not null
        constraint patient_pkey
            primary key,
    birthday   date,
    created_at timestamp(6) with time zone,
    fullname   varchar(200) not null,
    uuid       uuid         not null
);

create table if not exists time_slot
(
    id               bigserial    not null
        constraint time_slot_pkey
            primary key,
    appointment_time timestamp(6) not null,
    created_at       timestamp(6) with time zone,
    doctor_id        bigint       not null
        constraint fk_time_slot_to_doctor
            references doctor,
    patient_id       bigint
        constraint fk_time_slot_to_patient
            references patient
);