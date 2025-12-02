package com.frankmoley.lil.landon_hotel.web.api;


import com.frankmoley.lil.landon_hotel.data.entity.Reservation;
import com.frankmoley.lil.landon_hotel.data.repository.ReservationRepository;
import com.frankmoley.lil.landon_hotel.web.exception.BadRequestException;
import com.frankmoley.lil.landon_hotel.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;  // ← CORRECT! This is Apache Commons

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam(value="date", required = false)String dateString){
        if(StringUtils.isNotBlank(dateString)){
            Date date = new Date(new java.util.Date().getTime());
            return this.reservationRepository.findAllByReservationDate(date);
        }
        return this.reservationRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @PutMapping("/{roomId}")
    public Reservation getReservation(@PathVariable("roomId")long roomId) {
        Optional<Reservation> reservation = this.reservationRepository.findById(roomId);
        if (reservation.isEmpty()) {
            throw new NotFoundException("reservation not found with id: " + roomId);
        }
        return reservation.get();
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable("id")long roomId, @RequestBody Reservation reservation) {
        if (roomId != reservation.getId()) {
            throw new BadRequestException(("id o on path doesn't match body"));
        }
        return this.reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteReservation(@PathVariable("id")Long roomId) {
        this.reservationRepository.deleteById(roomId);
    }

}
