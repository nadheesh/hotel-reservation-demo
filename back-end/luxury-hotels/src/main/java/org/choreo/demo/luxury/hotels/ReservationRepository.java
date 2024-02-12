package org.choreo.demo.luxury.hotels;

import org.choreo.demo.luxury.hotels.model.Reservation;
import org.choreo.demo.luxury.hotels.model.Room;
import org.choreo.demo.luxury.hotels.model.RoomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r.room FROM Reservation r WHERE r.checkinDate <= :checkinDate AND r.checkoutDate >= :checkoutDate AND r.room.type.name = :roomType")
    List<Room> findAvailableRooms(@Param("checkinDate") Date checkinDate,
                                  @Param("checkoutDate") Date checkoutDate,
                                  @Param("roomType") String roomType);



    @Query("SELECT rt FROM RoomType rt WHERE rt.guestCapacity >= :guestCapacity AND EXISTS (" +
            "SELECT r FROM Room r WHERE r.type = rt AND NOT EXISTS (" +
            "SELECT res FROM Reservation res WHERE res.room = r " +
            "AND res.checkinDate < :checkoutDate AND res.checkoutDate > :checkinDate))")
    List<RoomType> findAvailableRoomTypes(@Param("checkinDate") LocalDate checkinDate,
                                          @Param("checkoutDate") LocalDate checkoutDate,
                                          @Param("guestCapacity") int guestCapacity);


    @Query("SELECT r FROM Room r WHERE r.type.name = :roomTypeName AND r.number NOT IN (" +
            "SELECT res.room.number FROM Reservation res WHERE res.checkinDate < :checkoutDate AND res.checkoutDate > :checkinDate)")
    List<Room> findAvailableRooms(
            @Param("checkinDate") LocalDate checkinDate,
            @Param("checkoutDate") LocalDate checkoutDate,
            @Param("roomTypeName") String roomTypeName);
}
