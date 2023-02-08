package patient.appointment.repositories;

import org.springframework.data.repository.CrudRepository;
import patient.appointment.models.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
