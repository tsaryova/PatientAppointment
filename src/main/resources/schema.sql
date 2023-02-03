CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
SELECT uuid_generate_v4();

CREATE TABLE IF NOT EXISTS doctor
(
    id bigserial NOT NULL ,
    uuid uuid NOT NULL DEFAULT uuid_generate_v4 (),
    fullname character varying(200) NOT NULL,
    specialization character varying(100) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    CONSTRAINT doctor_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS patient
(
    id bigserial NOT NULL ,
    uuid uuid NOT NULL DEFAULT uuid_generate_v4 (),
    fullname character varying(200) NOT NULL,
    birthday date,
    created_at timestamp without time zone NOT NULL,
    CONSTRAINT patient_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS time_slot
(
    id bigint NOT NULL ,
    doctor_id bigint NOT NULL references doctor(id) ,
    patient_id bigint NOT NULL references patient(id)

);
