package lk.ijse.hibernate.view.tm;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentTM {
    private String studentID;
    private String studentName;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;
}
