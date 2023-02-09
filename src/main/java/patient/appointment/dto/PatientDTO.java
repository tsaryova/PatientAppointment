package patient.appointment.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {

    private String fullName;
    private LocalDate birthday;

}
