package patientAppointment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import patientAppointment.repositories.DoctorRepository;
import patientAppointment.repositories.PatientRepositiry;
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
                                        TimeSlotService timeSlotService) {
        return args -> {
            var date = LocalDate.of(2010, 10, 29);
            //timeSlotService.getFreeSlotByOneDoctor(doctorRepository.findById(2L).get(), date);
            //timeSlotService.getSlotByPatient(patientRepositiry.findById(2L).get());

        };
    }

}
