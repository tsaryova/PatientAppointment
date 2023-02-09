package patient.appointment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import patient.appointment.models.Doctor;
import patient.appointment.models.Patient;
import patient.appointment.models.TimeSlot;
import patient.appointment.repositories.DoctorRepository;
import patient.appointment.repositories.PatientRepositiry;
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
    private final PatientRepositiry patientRepositiry;
    private final DoctorRepository doctorRepository;

    public TimeSlot findById(Long id) { return timeSlotRepository.findById(id).get();}
    public List<TimeSlot> findAllSlots() {
        return StreamSupport.stream(timeSlotRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    private List<TimeSlot> getFreeSlotByOneDoctor(Doctor doctor, LocalDate day) {
        LocalDateTime start = day.atStartOfDay();
        LocalDateTime end = day.atTime(23,59);

        return timeSlotRepository.getFreeSlotByOneDoctor(doctor.getId(), start, end);
    }

    public List<TimeSlot> getFreeSlotByOneDoctorId(String doctorId, String day) {
        if (doctorId == null || day == null)
            throw new RuntimeException("Input doctorId or Day");

        LocalDate localDate = LocalDate.parse(day);

        Long idLong = Long.parseLong(doctorId);
        Doctor doctor = doctorRepository.findById(idLong).get();

        if (doctor != null && localDate != null)
            return getFreeSlotByOneDoctor(doctor, localDate);
        throw new RuntimeException("Absent doctor or incorrect date");

    }

    private List<TimeSlot> getSlotByPatient(Patient patient) {
        return timeSlotRepository.getTimeSlotByPatient(patient);
    }
    public List<TimeSlot> getSlotByPatientId(String id) {
        if (id != null) {
            Long idLong = Long.parseLong(id);
            Patient patient = patientRepositiry.findById(idLong).get();
            if (patient != null)
                return getSlotByPatient(patient);
            throw new RuntimeException("Absent Patient");
        }
        throw new RuntimeException("Incorrect id");
    }

    private TimeSlot setPatientToSlot(TimeSlot timeSlot, Patient patient) {
        if (timeSlot.getPatient() == null) {
            TimeSlot currentTimeSlot = timeSlotRepository.findById(timeSlot.getId()).get();
            currentTimeSlot.setPatient(patient);
            return timeSlotRepository.save(currentTimeSlot);
        }
        throw new RuntimeException("This slot is using");
    }

    public TimeSlot setPatientIdToSlotId(String patientId, String slotId) {
        if (patientId == null || slotId == null)
            throw new RuntimeException("Incorrect ids");
        Long idLongPatient = Long.parseLong(patientId);
        Patient patient = patientRepositiry.findById(idLongPatient).get();

        Long idLongSlot = Long.parseLong(slotId);
        TimeSlot slot = timeSlotRepository.findById(idLongSlot).get();
        return setPatientToSlot(slot, patient);
    }
}
