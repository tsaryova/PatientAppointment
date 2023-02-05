package patientAppointment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import patientAppointment.models.Doctor;
import patientAppointment.models.Patient;
import patientAppointment.models.TimeSlot;
import patientAppointment.repositories.TimeSlotRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public List<TimeSlot> getFreeSlotByOneDoctor(Doctor doctor, LocalDate day) {
        LocalDateTime start = day.atStartOfDay();
        LocalDateTime end = day.atTime(23,59);

        return timeSlotRepository.getFreeSlotByOneDoctor(doctor.getId(), start, end);
    }

    public List<TimeSlot> getSlotByPatient(Patient patient) {
        return timeSlotRepository.getTimeSlotByPatient(patient);
    }
}
