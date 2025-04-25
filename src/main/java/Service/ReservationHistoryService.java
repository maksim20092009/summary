package Service;

import Model.ReservationHistories;
import Repository.ReservationHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReservationHistoryService {

    @Autowired
    private ReservationHistoryRepository repository;

    public ReservationHistories createReservationHistory(ReservationHistories history) {
        return repository.save(history);
    }

    public List<ReservationHistories> getAllReservationHistories() {
        return repository.findAll();
    }

    public void deleteReservationHistory(Integer id) {
        repository.deleteById(id);
    }
}
