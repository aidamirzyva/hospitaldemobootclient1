package az.orient.client.service;

import az.orient.client.dto.response.RespPatient;
import az.orient.client.dto.response.Response;

import java.util.List;

public interface PatientService {

    Response<List<RespPatient>> getPatientList();
}
