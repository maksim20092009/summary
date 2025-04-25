package Controller;

import Model.ReservationHistories;
import Service.ReservationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservationHistories")
public class ReservationHistoryController {

    @Autowired
    private ReservationHistoryService service;

    @PostMapping
    public ReservationHistories createReservationHistory(@RequestBody ReservationHistories history) {
        return service.createReservationHistory(history);
    }

    @GetMapping
    public List<ReservationHistories> getAllReservationHistories() {
        return service.getAllReservationHistories();
    }

    @DeleteMapping("/{id}")
    public void deleteReservationHistory(@PathVariable Integer id) {
        service.deleteReservationHistory(id);
    }
}
