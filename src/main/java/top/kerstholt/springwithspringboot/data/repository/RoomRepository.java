package top.kerstholt.springwithspringboot.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.kerstholt.springwithspringboot.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
