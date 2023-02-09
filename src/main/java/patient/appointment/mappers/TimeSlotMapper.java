package patient.appointment.mappers;

import patient.appointment.dto.TimeSlotDTO;
import patient.appointment.models.TimeSlot;

public class TimeSlotMapper {

    public static TimeSlotDTO toDTO(TimeSlot timeSlot) {
        TimeSlotDTO timeSlotDTO = new TimeSlotDTO();
        if(timeSlot.getAppointmentTime() != null)
            timeSlotDTO.setAppointmentTime(timeSlot.getAppointmentTime());
        if(timeSlot.getDoctor() != null)
            timeSlotDTO.setDoctorDTO(DoctorMapper.toDTO(timeSlot.getDoctor()));
        if(timeSlot.getPatient() != null)
            timeSlotDTO.setPatientDTO(PatientMapper.toDTO(timeSlot.getPatient()));
        return timeSlotDTO;
    }

    public static TimeSlot toModel(TimeSlotDTO timeSlotDTO) {
        TimeSlot timeSlot = new TimeSlot();
        if(timeSlotDTO.getAppointmentTime() != null)
            timeSlot.setAppointmentTime(timeSlotDTO.getAppointmentTime());
        if(timeSlotDTO.getDoctorDTO() != null)
            timeSlot.setDoctor(DoctorMapper.toModel(timeSlotDTO.getDoctorDTO()));
        if(timeSlotDTO.getPatientDTO() != null)
            timeSlot.setPatient(PatientMapper.toModel(timeSlotDTO.getPatientDTO()));
        return timeSlot;
    }

}
