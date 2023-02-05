package patientAppointment.repositories;

import org.springframework.data.repository.CrudRepository;
import patientAppointment.models.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
