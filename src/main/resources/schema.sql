CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
SELECT uuid_generate_v4();

CREATE TABLE IF NOT EXISTS doctor
(
    id bigserial NOT NULL,
    uuid uuid NOT NULL DEFAULT uuid_generate_v4 (),
    fullname character varying(200) NOT NULL,
    specialization character varying(100) NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT doctor_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS patient
(
    id bigserial NOT NULL,
    uuid uuid NOT NULL DEFAULT uuid_generate_v4 (),
    fullname character varying(200) NOT NULL,
    birthday date,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT patient_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS time_slot
(
    id bigserial NOT NULL ,
    doctor_id bigint NOT NULL references doctor(id) on delete cascade,
    patient_id bigint references patient(id) on delete cascade,
    appointment_time date NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT slot_pkey PRIMARY KEY (id)

);
