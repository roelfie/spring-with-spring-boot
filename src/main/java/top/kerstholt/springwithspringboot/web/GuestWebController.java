package top.kerstholt.springwithspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kerstholt.springwithspringboot.business.service.GuestService;
import top.kerstholt.springwithspringboot.data.entity.Guest;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {

    private final GuestService guestService;

    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    // http://localhost:8080/guests
    @GetMapping
    public String getGuests(Model model) {
        List<Guest> guests = guestService.getGuests();
        model.addAttribute("guests", guests);
        return "guests"; // thymeleaf will substitute model into a template called "guests".
    }
}
