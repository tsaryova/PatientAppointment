package patientAppointment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import patientAppointment.models.Patient;
import patientAppointment.models.TimeSlot;
import patientAppointment.repositories.DoctorRepository;
import patientAppointment.repositories.PatientRepositiry;
import patientAppointment.repositories.TimeSlotRepository;
import patientAppointment.service.TimeSlotService;

import java.time.LocalDate;

@SpringBootApplication
public class PatientAppointmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientAppointmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(DoctorRepository doctorRepository,
                                        PatientRepositiry patientRepositiry,
                                        TimeSlotService timeSlotService,
                                        TimeSlotRepository timeSlotRepository) {
        return args -> {
            var date = LocalDate.of(2010, 10, 29);
            //timeSlotService.getFreeSlotByOneDoctor(doctorRepository.findById(2L).get(), date);
            //timeSlotService.getSlotByPatient(patientRepositiry.findById(2L).get());

//            TimeSlot slot = timeSlotRepository.findById(4L).get();
//            Patient patient = patientRepositiry.findById(2L).get();
//
//            timeSlotService.setPatientToSlot(slot, patient);

        };
    }

}
