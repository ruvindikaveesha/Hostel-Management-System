package lk.ijse.hibernate.view.tm;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomTM {
    private String roomID;
    private String roomType;
    private String keyMoney;
    private int roomQty;

}
