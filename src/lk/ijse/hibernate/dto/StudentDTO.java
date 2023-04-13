package lk.ijse.hibernate.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {

    private String studentID;
    private String studentName;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;



}
