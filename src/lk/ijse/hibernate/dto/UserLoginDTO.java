package lk.ijse.hibernate.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLoginDTO {
    private String userID;
    private String userName;
    private String password;
}
