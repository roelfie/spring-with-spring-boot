package top.kerstholt.springwithspringboot.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@SuppressWarnings("ALL")
@Entity
@Table(name="GUEST")
public class Guest {

    @Id
    @Column(name="GUEST_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long guestId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="STATE")
    private String state;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(mappedBy="guest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Reservation> reservations = new ArrayList<>();

}
