package az.orient.client.service;

import az.orient.client.dto.response.RespDoctor;
import az.orient.client.dto.response.RespPatient;
import az.orient.client.dto.response.Response;

import java.util.List;

public interface DoctorService {

    Response<List<RespDoctor>> getDoctorList();
}
