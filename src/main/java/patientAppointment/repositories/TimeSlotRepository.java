package patientAppointment.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import patientAppointment.models.Patient;
import patientAppointment.models.TimeSlot;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
    @Query(
            value = "SELECT * FROM time_slot ts WHERE ts.doctor_id = ?1 AND ts.patient_id is null AND ts.appointment_time BETWEEN ?2 and ?3",
            nativeQuery = true)
    List<TimeSlot> getFreeSlotByOneDoctor(Long doctorId, LocalDateTime start, LocalDateTime end);

    List<TimeSlot> getTimeSlotByPatient(Patient patient);
}
