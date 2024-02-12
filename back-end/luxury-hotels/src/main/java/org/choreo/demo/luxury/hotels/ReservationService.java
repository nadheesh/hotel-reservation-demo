package org.choreo.demo.luxury.hotels;

import org.choreo.demo.luxury.hotels.dto.ReservationRequest;
import org.choreo.demo.luxury.hotels.model.Reservation;
import org.choreo.demo.luxury.hotels.model.Room;
import org.choreo.demo.luxury.hotels.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    public List<RoomType> getAvailableRoomTypes(String checkinDate, String checkoutDate, int guestCapacity) throws Exception {
        return reservationRepository.findAvailableRoomTypes(LocalDate.parse(checkinDate), LocalDate.parse(checkoutDate), guestCapacity);
    }

    public List<Room> findAvailableRooms(String checkinDate, String checkoutDate, String roomType) {
        return reservationRepository.findAvailableRooms(LocalDate.parse(checkinDate), LocalDate.parse(checkoutDate), roomType);
    }

    public Reservation save(ReservationRequest reservationRequest) {

       // Models.Reservation reservation = new Models.Reservation(reservationRequest.);
        return null;
    }

    // Other methods to manipulate reservations
}
