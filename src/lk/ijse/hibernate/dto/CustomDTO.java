package lk.ijse.hibernate.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomDTO {
    private String studentID;
    private String studentName;
    private String address;
    private String contactNo;
    private String dob;
    private String gender;

    private String roomID;
    private String roomType;
    private String keyMoney;
    private String roomQty;

    private String res_id;
    private LocalDate date;
    private double key_money;
    private String status;
    private Integer qty;

    private String userID;
    private String userName;
    private String password;

}


