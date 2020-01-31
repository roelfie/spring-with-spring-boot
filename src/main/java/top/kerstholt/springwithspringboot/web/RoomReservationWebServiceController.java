package top.kerstholt.springwithspringboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.kerstholt.springwithspringboot.business.domain.RoomReservation;
import top.kerstholt.springwithspringboot.business.service.ReservationService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class RoomReservationWebServiceController {

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // http://localhost:8080/api/reservations?date=2020-01-01
    @GetMapping
    public List<RoomReservation> getReservations(@RequestParam(value="date", required=false) String dateString) {
        Date date = DateUtils.createDateFromString(dateString);
        return reservationService.getRoomReservations(date);
    }
}
