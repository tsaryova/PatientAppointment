package patient.appointment.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import patient.appointment.dto.TimeSlotDTO;
import patient.appointment.mappers.TimeSlotMapper;
import patient.appointment.models.TimeSlot;
import patient.appointment.service.TimeSlotService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/time_slots", produces = "application/json")
@RequiredArgsConstructor
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    @GetMapping
    public List<TimeSlotDTO> getSlotByPatient(@RequestParam(name = "patient_id") String patientId) {
        List<TimeSlot> timeSlots = timeSlotService.getSlotByPatientId(patientId);
        List<TimeSlotDTO> timeSlotDTOs = new ArrayList<>();
        for (TimeSlot timeSlot: timeSlots) {
            timeSlotDTOs.add(TimeSlotMapper.toDTO(timeSlot));
        }

        return timeSlotDTOs;
    }


}
