delete from time_slot;
delete from patient;
delete from doctor;

insert into doctor(fullname, specialization, created_at) values ('Иванов Иван Иванович', 'Хирург', '2001-09-29 01:22:00');
insert into doctor(fullname, specialization, created_at) values ('Петров Петр Петрович', 'Терапевт', '2010-10-29 10:22:00');
insert into doctor(fullname, specialization, created_at) values ('Васильев Василий Васильевич', 'ЛОР', '2008-02-29 19:22:00');

insert into patient(fullname, birthday, created_at) values ('Больнов Аркадий Николаевич', '1990-09-29', '2001-09-29 01:22:00');
insert into patient(fullname, birthday, created_at) values ('Царева Ангелина Дмитриевна', '1995-10-29', '2010-10-29 10:22:00');
insert into patient(fullname, birthday, created_at) values ('Сидоров Александр Александрович', '2008-02-29', '2008-02-29 19:22:00');

insert into time_slot(doctor_id, patient_id) values ('1', '2');
insert into time_slot(doctor_id, patient_id) values ('1', '3');
insert into time_slot(doctor_id, patient_id) values ('2', '2');