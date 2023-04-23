package lk.ijse.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor



@Entity
public class Reservation implements SuperEntity {
    @Id
    private String res_id;
    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Room room;

    private double key_money;
    private String status;
    private Integer qty;

    public Reservation(String res_id, LocalDate date, double key_money, int qty, String status, Room roomID, Student studentID) {
        this.res_id = res_id;
        this.date = date;
        this.key_money = key_money;
        this.qty = qty;
        this.status = status;
        this.room = roomID;
        this.student = studentID;

    }


}




