package Repository;

import Model.HotelReservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservations, Integer> {
}
