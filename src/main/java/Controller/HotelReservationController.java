package Controller;

import Model.HotelReservations;
import Service.HotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelReservations")
public class HotelReservationController {

    @Autowired
    private HotelReservationService service;

    @PostMapping
    public HotelReservations createReservation(@RequestBody HotelReservations reservation) {
        return service.createReservation(reservation);
    }

    @GetMapping
    public List<HotelReservations> getAllReservations() {
        return service.getAllReservations();
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        service.deleteReservation(id);
    }
}
