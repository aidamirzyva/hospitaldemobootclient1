package az.orient.client.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespAppointment {
    private Long id;
    private Integer appointmentNo;
    private Double examinationPrice;
    private RespPatient respPatient;


}
