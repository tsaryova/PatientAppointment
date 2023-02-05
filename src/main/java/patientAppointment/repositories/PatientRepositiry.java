package patientAppointment.repositories;

import org.springframework.data.repository.CrudRepository;
import patientAppointment.models.Patient;

public interface PatientRepositiry extends CrudRepository<Patient, Long> {
}
