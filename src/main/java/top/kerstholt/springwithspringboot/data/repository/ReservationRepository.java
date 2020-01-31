package top.kerstholt.springwithspringboot.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.kerstholt.springwithspringboot.data.entity.Reservation;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    // When creating a .find*() method in IntelliJ, it will present a popup with all the possible .find*() methods that
    // Spring Data can generate for you. For instance .findReservationByGuestAndRoomOrderByReservationDate().
    Iterable<Reservation> findReservationByReservationDate(Date date);

}
