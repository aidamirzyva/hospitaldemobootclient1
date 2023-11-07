package az.orient.client.service;

import az.orient.client.dto.response.RespAppointment;
import az.orient.client.dto.response.Response;

import java.util.List;

public interface AppointmentService {

    Response<List<RespAppointment>> getAppointmentList(Long patientId);
}
