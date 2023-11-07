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
public class RespPatient {


    private Long patientId;
    private String name;
    private String surname;
    private String pin;
    private String seria;
    private Date dob;
    private String phone;
    private String address;
    private String blood;
    private String email;
}
