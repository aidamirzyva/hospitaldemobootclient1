package az.orient.client.service.impl;

import az.orient.client.dto.request.ReqLogin;
import az.orient.client.dto.response.RespDoctor;
import az.orient.client.dto.response.RespPatient;
import az.orient.client.dto.response.RespUser;
import az.orient.client.dto.response.Response;
import az.orient.client.service.DoctorService;
import az.orient.client.service.PatientService;
import az.orient.client.service.UserService;
import az.orient.client.util.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:config.properties")
public class DoctorServiceImpl implements DoctorService {

    private final Utility utility;
    private final UserService userService;
    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.usr}")
    private String apiUsr;
    @Value("${api.pwd}")
    private String apiPwd;
   // jeysona kecmek ucun writeValueAsString, jesona baxmaq ucun read

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Response<List<RespDoctor>> getDoctorList() {
        Response<List<RespDoctor>> resp = new Response<>();
        try{

            ReqLogin reqLogin = new ReqLogin();
            reqLogin.setUsername(apiUsr);
            reqLogin.setPassword(apiPwd);
            String reqLoginJson = objectMapper.writeValueAsString(reqLogin);
            String result =utility.sendPost(apiUrl+"user/login",reqLoginJson);
            Response<RespUser> response = objectMapper.readValue(result,new TypeReference<Response<RespUser>>() {});

            if (response.getStatus().getCode() != 1) {
                resp.setStatus(response.getStatus());
                    return resp;
                }//burda asagida jsona kecirilir

            String reqTokenJson = objectMapper.writeValueAsString(response.getT().getRespToken());
            String doctorListResult  = utility.sendPost(apiUrl+"patient/GetPatientList",reqTokenJson);
            resp = objectMapper.readValue(doctorListResult, new TypeReference<Response<List<RespDoctor>>>() {});
            System.out.println(resp);

        }catch (Exception ex){
            ex.printStackTrace();
        }


        return resp;
    }
}
