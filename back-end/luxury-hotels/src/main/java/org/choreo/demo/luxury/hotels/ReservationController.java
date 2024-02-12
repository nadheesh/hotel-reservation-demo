package org.choreo.demo.luxury.hotels;

import org.choreo.demo.luxury.hotels.dto.ReservationRequest;
import org.choreo.demo.luxury.hotels.dto.UpdateReservationRequest;
import org.choreo.demo.luxury.hotels.model.Reservation;
import org.choreo.demo.luxury.hotels.model.Room;
import org.choreo.demo.luxury.hotels.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/roomTypes")
    public ResponseEntity<List<RoomType>> getRoomTypes(@RequestParam String checkinDate,
                                                       @RequestParam String checkoutDate,
                                                       @RequestParam int guestCapacity) {
        // Implement logic to fetch room types
        try {
            List<RoomType> roomTypes = reservationService.getAvailableRoomTypes(checkinDate, checkoutDate, guestCapacity);

            return ResponseEntity.ok(roomTypes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<List<Room>> getRooms(@RequestParam String checkinDate,
                                               @RequestParam String checkoutDate,
                                               @RequestParam String roomType) {
        // Implement logic to fetch rooms
        List<Room> availableRooms = reservationService.findAvailableRooms(checkinDate, checkoutDate, roomType);

        ResponseEntity<List<Room>> response = ResponseEntity.ok()
                .body(availableRooms);
        return response;
    }

    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest reservationRequest) {
        // Implement logic to create a reservation

        List<Room> availableRooms = reservationService.findAvailableRooms(reservationRequest.getCheckinDate(), reservationRequest.getCheckoutDate(), reservationRequest.getRoomType());
        if (availableRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{reservation_id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("reservation_id") Long reservationId,
                                                                @RequestBody UpdateReservationRequest updateReservationRequest) {
        // Implement logic to update a reservation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{reservation_id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("reservation_id") Long reservationId) {
        // Implement logic to delete a reservation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Reservation>> getUserReservations(@PathVariable("userId") String userId) {
        // Implement logic to fetch reservations for a user
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
