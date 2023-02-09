package patient.appointment.mappers;

import patient.appointment.dto.PatientDTO;
import patient.appointment.models.Patient;

public class PatientMapper {

    public static PatientDTO toDTO (Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        if (patient.getFullName() != null)
            patientDTO.setFullName(patient.getFullName());
        if (patient.getBirthday() != null)
            patientDTO.setBirthday(patient.getBirthday());

        return patientDTO;
    }

    public static Patient toModel(PatientDTO patientDTO) {
        Patient patient = new Patient();
        if (patientDTO.getFullName() != null)
            patient.setFullName(patientDTO.getFullName());
        if (patientDTO.getBirthday() != null)
            patient.setBirthday(patientDTO.getBirthday());
        return patient;
    }

}
