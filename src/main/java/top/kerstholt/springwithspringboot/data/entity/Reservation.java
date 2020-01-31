package top.kerstholt.springwithspringboot.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@SuppressWarnings("ALL")
@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @Column(name="RESERVATION_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long reservationId;

    @Column(name="RES_DATE")
    private Date reservationDate;

    // Add @JsonBackReference (and @JsonManagedReference at the @OneToMany side)
    // to avoid infinite recursion (StackOverflowError) in the Jackson serialization process.
    // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    @JsonBackReference
    private Room room;

    @ManyToOne
    @JoinColumn(name = "GUEST_ID")
    @JsonBackReference
    private Guest guest;

}