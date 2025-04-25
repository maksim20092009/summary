package Service;

import Model.HotelReservations;
import Repository.HotelReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HotelReservationService {

    @Autowired
    private HotelReservationRepository repository;

    public HotelReservations createReservation(HotelReservations reservation) {
        return repository.save(reservation);
    }

    public List<HotelReservations> getAllReservations() {
        return repository.findAll();
    }

    public void deleteReservation(Integer id) {
        repository.deleteById(id);
    }
}
