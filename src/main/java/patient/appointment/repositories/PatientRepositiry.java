package patient.appointment.repositories;

import org.springframework.data.repository.CrudRepository;
import patient.appointment.models.Patient;

public interface PatientRepositiry extends CrudRepository<Patient, Long> {
}
