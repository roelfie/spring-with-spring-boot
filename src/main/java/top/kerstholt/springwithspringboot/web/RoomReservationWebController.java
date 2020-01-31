package top.kerstholt.springwithspringboot.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.kerstholt.springwithspringboot.business.domain.RoomReservation;
import top.kerstholt.springwithspringboot.business.service.ReservationService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {

    private final ReservationService reservationService;

    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model) {
        Date date = DateUtils.createDateFromString(dateString);
        List<RoomReservation> roomReservations = reservationService.getRoomReservations(date);
        model.addAttribute("roomReservations", roomReservations);

        return "reservations"; // This tells Thymeleaf to find a template named "reservations" & populate it with model.
    }
}
