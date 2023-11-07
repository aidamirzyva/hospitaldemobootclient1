package az.orient.client.controller;

import az.orient.client.dto.response.RespAppointment;
import az.orient.client.dto.response.RespDoctor;
import az.orient.client.dto.response.RespPatient;
import az.orient.client.dto.response.Response;
import az.orient.client.service.AppointmentService;
import az.orient.client.service.DoctorService;
import az.orient.client.service.PatientService;
import az.orient.client.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final AppointmentService appointmentService;
    private  final PatientService patientService;
    private  final DoctorService doctorService;

    @GetMapping({"/","/GetPatientList"})
    public ModelAndView getPatientList(){
        ModelAndView model = new ModelAndView("index");// burda model obyekti yaratdin bunu bildim harda istifade edirsn bunu? videonu acram bax
        Response<List<RespPatient>> result = patientService.getPatientList();
        if (result.getStatus().getCode() == 1) {
            model.addObject("result",result.getT());
        } else {
            model.addObject("msg",result.getStatus().getMessage());
        }
        return model;
    }
    @GetMapping({"/","/GetDoctorList"})
    public ModelAndView getDoctorList(){
        ModelAndView model = new ModelAndView("index");// burda model obyekti yaratdin bunu bildim harda istifade edirsn bunu? videonu acram bax
        Response<List<RespDoctor>> result = doctorService.getDoctorList();
        if (result.getStatus().getCode() == 1) {
            model.addObject("result",result.getT());
        } else {
            model.addObject("msg",result.getStatus().getMessage());
        }
        return model;
    }
    //bu springde gorunus qaytarmaq ucun istifade olunur

    @GetMapping("/GetAppointmentList/{patientId}")
    public ModelAndView getAppointmentList(@PathVariable Long patientId){
        ModelAndView model = new ModelAndView("appointment");
        Response<List<RespAppointment>> result = appointmentService.getAppointmentList(patientId);
        if (result.getStatus().getCode() == 1) {
            model.addObject("result",result.getT());
        } else {
            model.addObject("msg",result.getStatus().getMessage());
        }
        return model;
    }


}
