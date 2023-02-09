package patient.appointment.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import patient.appointment.dto.DoctorDTO;
import patient.appointment.mappers.DoctorMapper;
import patient.appointment.models.Doctor;
import patient.appointment.service.DoctorService;

@RestController
@RequestMapping(path = "/doctors", produces = "application/json")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable("id") String id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return DoctorMapper.toDTO(doctor);
    }
}
