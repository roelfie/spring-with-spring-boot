package top.kerstholt.springwithspringboot.business.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.kerstholt.springwithspringboot.data.entity.Guest;
import top.kerstholt.springwithspringboot.data.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    public List<Guest> getGuests() {
        List<Guest> result = new ArrayList<>();

        Iterable<Guest> guests = guestRepository.findAll();
        guests.forEach(result::add);

        return result;
    }
}