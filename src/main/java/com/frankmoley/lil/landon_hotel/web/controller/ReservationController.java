package com.frankmoley.lil.landon_hotel.web.controller;

import com.frankmoley.lil.landon_hotel.data.repository.ReservationRepository;
import com.frankmoley.lil.landon_hotel.service.model.RoomReservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public String getRooms(Model model) {
        model.addAttribute("reservations", this.reservationRepository.findAll());
        return "reservation-list";
    }
}
//public class RoomReservation {
//    private long roomId;
//    private String roomName;
//    private String roomNumber;
//    private long guestId;
//    private String firstName;
//    private String lastName;
//    private long reservationId;
//    private String reservationDate;
//}
