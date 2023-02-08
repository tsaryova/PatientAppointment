package patient.appointment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import patient.appointment.models.Doctor;
import patient.appointment.models.Patient;
import patient.appointment.models.TimeSlot;
import patient.appointment.repositories.TimeSlotRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlot findById(Long id) { return timeSlotRepository.findById(id).get();}
    public List<TimeSlot> findAllSlots() {
        return StreamSupport.stream(timeSlotRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<TimeSlot> getFreeSlotByOneDoctor(Doctor doctor, LocalDate day) {
        LocalDateTime start = day.atStartOfDay();
        LocalDateTime end = day.atTime(23,59);

        return timeSlotRepository.getFreeSlotByOneDoctor(doctor.getId(), start, end);
    }

    public List<TimeSlot> getSlotByPatient(Patient patient) {
        return timeSlotRepository.getTimeSlotByPatient(patient);
    }

    public void setPatientToSlot(TimeSlot timeSlot, Patient patient) {
        if (timeSlot.getPatient() == null) {
            TimeSlot currentTimeSlot = timeSlotRepository.findById(timeSlot.getId()).get();
            currentTimeSlot.setPatient(patient);
            timeSlotRepository.save(currentTimeSlot);
        }
    }
}
