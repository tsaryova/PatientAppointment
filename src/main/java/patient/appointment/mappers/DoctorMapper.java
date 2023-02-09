package patient.appointment.mappers;

import patient.appointment.dto.DoctorDTO;
import patient.appointment.models.Doctor;

import java.util.UUID;

public class DoctorMapper {

    public static DoctorDTO toDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        if(doctor.getFullName() != null)
         doctorDTO.setFullName(doctor.getFullName());
        if(doctor.getSpecialization() != null)
            doctorDTO.setSpecialization(doctor.getSpecialization());
        return doctorDTO;
    }

    public static Doctor toModel(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        if (doctorDTO.getFullName() != null)
            doctor.setFullName(doctorDTO.getFullName());
        if (doctorDTO.getSpecialization() != null)
            doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setUuid(UUID.randomUUID());

        return doctor;
    }
}
