package patient.appointment.endpoint;

import localhost._8080.schedule_ws.GetAllSlotsRequest;
import localhost._8080.schedule_ws.GetAllSlotsResponse;
import localhost._8080.schedule_ws.GetSlotByIdRequest;
import localhost._8080.schedule_ws.GetSlotByIdResponse;
import localhost._8080.schedule_ws.SlotInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import patient.appointment.models.TimeSlot;
import patient.appointment.service.TimeSlotService;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ScheduleEndPoint {
    public static final String NAMESPACE_URI = "http://localhost:8080/schedule-ws";
    private TimeSlotService timeSlotservice;

    public ScheduleEndPoint(){}

    @Autowired
    public ScheduleEndPoint(TimeSlotService timeSlotservice) {
        this.timeSlotservice = timeSlotservice;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSlotByIdRequest")
    @ResponsePayload
    public GetSlotByIdResponse getSlotById(@RequestPayload GetSlotByIdRequest request) {
        GetSlotByIdResponse response = new GetSlotByIdResponse();
        TimeSlot timeSlot = timeSlotservice.findById(request.getSlotId());
        SlotInfo slot = new SlotInfo();

        slot.setId(timeSlot.getId());
        slot.setAppointmentTime(timeSlot.getAppointmentTime().toString());
        slot.setDoctorName(timeSlot.getDoctor().getFullName());
        slot.setPatientName(timeSlot.getPatient().getFullName());
        response.setSlotInfo(slot);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllSlotsRequest")
    @ResponsePayload
    public GetAllSlotsResponse getAllSlotsResponse(@RequestPayload GetAllSlotsRequest request) {
        GetAllSlotsResponse response = new GetAllSlotsResponse();

        List<SlotInfo> slots = new ArrayList<>();
        List<TimeSlot> timeSlots = timeSlotservice.findAllSlots();

        for (TimeSlot timeSlot : timeSlots) {
            SlotInfo slot = new SlotInfo();
            slot.setId(timeSlot.getId());
            if (timeSlot.getAppointmentTime() != null)
             slot.setAppointmentTime(timeSlot.getAppointmentTime().toString());
            if (timeSlot.getDoctor() != null)
                slot.setDoctorName(timeSlot.getDoctor().getFullName());
            if (timeSlot.getPatient() != null)
                slot.setPatientName(timeSlot.getPatient().getFullName());
            slots.add(slot);
        }
        response.getSlotInfo().addAll(slots);

        return response;
    }


}
