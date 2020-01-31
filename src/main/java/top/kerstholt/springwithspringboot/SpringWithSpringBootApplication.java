package top.kerstholt.springwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kerstholt.springwithspringboot.data.entity.Reservation;
import top.kerstholt.springwithspringboot.data.entity.Room;
import top.kerstholt.springwithspringboot.data.repository.ReservationRepository;
import top.kerstholt.springwithspringboot.data.repository.RoomRepository;

/**
 * The @SpringBootApplication annotation
 * <ol>
 *     <li>designates this class as a @Configuration file</li>
 *     <li>makes this class the root of the (implicit) @ComponentScan</li>
 *     <li>initiates Spring Boot's auto-configuration (based on jars that are on the classpath)</li>
 * </ol>
 */
@SpringBootApplication
public class SpringWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithSpringBootApplication.class, args);
	}

	// REST controller to test the RoomRepository.
	@RestController
	@RequestMapping("/rooms")
	public class RoomController {

		@Autowired
		private RoomRepository roomRepository;

		@GetMapping
		public Iterable<Room> getRooms() {
			return this.roomRepository.findAll();
		}
	}

	@RestController
	@RequestMapping("/reservations")
	public class ReservationController {

		@Autowired
		private ReservationRepository reservationRepository;

		@GetMapping
		public Iterable<Reservation> getReservations() {
			return this.reservationRepository.findAll();
		}
	}
}