package patient.appointment.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeSlotDTO {

        private LocalDateTime appointmentTime;
        private DoctorDTO doctorDTO;
        private PatientDTO patientDTO;

}
