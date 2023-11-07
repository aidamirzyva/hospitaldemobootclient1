package az.orient.client.service.impl;

import az.orient.client.dto.response.RespAppointment;
import az.orient.client.dto.response.Response;
import az.orient.client.dto.response.RespPatient;
import az.orient.client.service.AppointmentService;
import az.orient.client.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:config.properties")
public class AppointmentServiceImpl implements AppointmentService {
    private final Utility utility;

    @Value("${api.url}")
    private String apiUrl;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response<List<RespAppointment>> getAppointmentList(Long patientId) {
        Response<List<RespAppointment>> response = null;
        try {
            String url = apiUrl + "appointment/GetAppointmentListByPatientId/" + patientId;
            String result = utility.sendGet(url);
            response = objectMapper.readValue(result, new TypeReference<Response<List<RespAppointment>>> () {});
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return response;

    }
    }
