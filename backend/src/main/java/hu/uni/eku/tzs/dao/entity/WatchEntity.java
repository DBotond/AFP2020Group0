package hu.uni.eku.tzs.dao.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "watch")
public class WatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int balance;
    //@Enumerated(EnumType.STRING)
}
