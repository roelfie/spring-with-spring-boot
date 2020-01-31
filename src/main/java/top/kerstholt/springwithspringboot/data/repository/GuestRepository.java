package top.kerstholt.springwithspringboot.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.kerstholt.springwithspringboot.data.entity.Reservation;

@Repository
public interface GuestRepository extends CrudRepository<Reservation, Long> {
}
