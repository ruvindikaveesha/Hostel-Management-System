package lk.ijse.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)



@Entity(name = "student")
public class Student implements SuperEntity {
    @Id
    private String student_id;
    @Column(nullable = false)
    private String studentName;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String studentAddress;
    @Column(nullable = false)
    private String contac_no;
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "student")
    @Cascade(CascadeType.ALL)
    List<Reservation> reservations = new ArrayList<>();

    public Student(String studentID, String studentName, String address, String contactNo, LocalDate dob, String gender) {
        this.student_id = studentID;
        this.studentName = studentName;
        this.studentAddress = address;
        this.contac_no = contactNo;
        this.dob = dob;
        this.gender = gender;
    }



}