package lk.ijse.hibernate.view.tm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserTM {
    private String userID;
    private String userName;
    private String password;

}
