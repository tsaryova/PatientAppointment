package patient.appointment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patient.appointment.models.Patient;
import patient.appointment.repositories.PatientRepositiry;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepositiry patientRepositiry;

    public void fillInitValues() {
        Patient patient1 = new Patient();
        patient1.setFullName("Больнов Аркадий Николаевич");
        patient1.setBirthday(LocalDate.of(1990, 9, 29));
        patient1.setUuid(UUID.randomUUID());

        Patient patient2 = new Patient();
        patient2.setFullName("Царева Ангелина Дмитриевна");
        patient2.setBirthday(LocalDate.of(1995, 10, 29));
        patient2.setUuid(UUID.randomUUID());

        Patient patient3 = new Patient();
        patient3.setFullName("Сидоров Александр Александрович");
        patient3.setBirthday(LocalDate.of(2008, 10, 8));
        patient3.setUuid(UUID.randomUUID());

        patientRepositiry.saveAll(List.of(patient1, patient2, patient3));
    }
}
