package com.frankmoley.lil.landon_hotel.data.repository;

import com.frankmoley.lil.landon_hotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByReservationDate(Date date);
}
