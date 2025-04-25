package Controller;

import Model.Hotels;
import Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping
    public Hotels createHotel(@RequestBody Hotels hotel) {
        return service.createHotel(hotel);
    }

    @GetMapping
    public List<Hotels> getAllHotels() {
        return service.getAllHotels();
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Integer id) {
        service.deleteHotel(id);
    }
}
