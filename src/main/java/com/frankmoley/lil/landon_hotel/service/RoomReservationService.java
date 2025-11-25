package com.frankmoley.lil.landon_hotel.service;

import com.frankmoley.lil.landon_hotel.data.entity.Room;
import com.frankmoley.lil.landon_hotel.data.repository.GuestRepository;
import com.frankmoley.lil.landon_hotel.data.repository.ReservationRepository;
import com.frankmoley.lil.landon_hotel.data.repository.RoomRepository;
import com.frankmoley.lil.landon_hotel.service.model.RoomRerservation;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;


    public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }


}
