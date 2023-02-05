package patientAppointment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import patientAppointment.models.Doctor;
import patientAppointment.repositories.DoctorRepository;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public void fillInitValues() {
        Doctor doctor1 = new Doctor();
        doctor1.setFullName("Иванов Иван Иванович");
        doctor1.setSpecialization("Хирург");
        doctor1.setUuid(UUID.randomUUID());

        Doctor doctor2 = new Doctor();
        doctor2.setFullName("Петров Петр Петрович");
        doctor2.setSpecialization("Терапевт");
        doctor2.setUuid(UUID.randomUUID());

        Doctor doctor3 = new Doctor();
        doctor3.setFullName("Васильев Василий Васильевич");
        doctor3.setSpecialization("ЛОР");
        doctor3.setUuid(UUID.randomUUID());

        doctorRepository.saveAll(List.of(doctor1, doctor2, doctor3));
    }

}
