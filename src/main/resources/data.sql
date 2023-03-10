delete from time_slot;
delete from patient;
delete from doctor;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
SELECT uuid_generate_v4();

insert into doctor(fullname, specialization, uuid, created_at) values ('Иванов Иван Иванович', 'Хирург', uuid_generate_v4 (), current_timestamp);
insert into doctor(fullname, specialization, uuid, created_at) values ('Петров Петр Петрович', 'Терапевт', uuid_generate_v4 (), current_timestamp);
insert into doctor(fullname, specialization, uuid, created_at) values ('Васильев Василий Васильевич', 'ЛОР', uuid_generate_v4 (), current_timestamp);

insert into patient(fullname, birthday, uuid, created_at) values ('Больнов Аркадий Николаевич', '1990-09-29', uuid_generate_v4 (), current_timestamp);
insert into patient(fullname, birthday, uuid, created_at) values ('Царева Ангелина Дмитриевна', '1995-10-29', uuid_generate_v4 (), current_timestamp);
insert into patient(fullname, birthday, uuid, created_at) values ('Сидоров Александр Александрович', '2008-02-29', uuid_generate_v4 (), current_timestamp);

insert into time_slot(doctor_id, patient_id, appointment_time, created_at) values ('1', '2', '2010-10-29 09:30:00', current_timestamp);
insert into time_slot(doctor_id, patient_id, appointment_time, created_at) values ('2', '2', '2010-10-29 10:30:00', current_timestamp);
insert into time_slot(doctor_id, patient_id, appointment_time, created_at) values ('1', '3', '2010-10-29 08:30:00', current_timestamp);
insert into time_slot(doctor_id, appointment_time, created_at) values ('1', '2010-10-29 11:30:00', current_timestamp);
insert into time_slot(doctor_id, appointment_time, created_at) values ('1', '2010-10-29 12:00:00', current_timestamp);
insert into time_slot(doctor_id, appointment_time, created_at) values ('2', '2010-10-29 12:00:00', current_timestamp);
insert into time_slot(doctor_id, appointment_time, created_at) values ('3', '2010-10-29 12:00:00', current_timestamp);
insert into time_slot(doctor_id, appointment_time, created_at) values ('3', '2010-10-29 13:00:00', current_timestamp);
