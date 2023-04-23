package lk.ijse.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity(name = "userlogin")
public class UserLogin {
    @Id
    private String user_id;
    @Column(nullable = false)
    private String user_name;
    @Column(nullable = false)
    private String password;

}
