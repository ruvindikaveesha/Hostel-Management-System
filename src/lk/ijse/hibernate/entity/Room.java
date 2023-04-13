package lk.ijse.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)


@Entity(name = "room")
public class Room implements SuperEntity {

    @Id
    private String room_type_id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String key_money;
    @Column(nullable = false)
    private int qty;


    @OneToMany(mappedBy = "room")
    @Cascade(CascadeType.ALL)
   List<Reservation> roomDetails=new ArrayList<>();

    public Room(String roomID, String roomType, String keyMoney, int roomQty) {
        this.room_type_id=roomID;
        this.type=roomType;
        this.key_money=keyMoney;
        this.qty=roomQty;
    }
}
