package top.kerstholt.springwithspringboot.business.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.kerstholt.springwithspringboot.business.domain.RoomReservation;
import top.kerstholt.springwithspringboot.data.entity.Reservation;
import top.kerstholt.springwithspringboot.data.repository.GuestRepository;
import top.kerstholt.springwithspringboot.data.repository.ReservationRepository;
import top.kerstholt.springwithspringboot.data.repository.RoomRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    // NB because there's only one constructor (@AllArgsConstructor) Spring will automatically use (and autowire)
    // that constructor. If there's more than one constructor, it's probably better to make them explicit.

    public List<RoomReservation> getRoomReservations(Date date) {
        List<RoomReservation> roomReservations = new ArrayList<>();

        Iterable<Reservation> reservationByReservationDate = reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservationByReservationDate.forEach(res -> {
            RoomReservation roomReservation = RoomReservation.builder()
                    .roomId(res.getRoom().getRoomId())
                    .roomName(res.getRoom().getRoomName())
                    .roomNumber(res.getRoom().getRoomNumber())
                    .guestId(res.getGuest().getGuestId())
                    .firstName(res.getGuest().getFirstName())
                    .lastName(res.getGuest().getLastName())
                    .date(res.getReservationDate())
                    .build();
            roomReservations.add(roomReservation);
        });

        return roomReservations;
    }
}
