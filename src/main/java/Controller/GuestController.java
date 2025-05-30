//обработка пользовательских запросов
package Controller;

import Model.Guests;
import Service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService service;

    @PostMapping
    public Guests createGuest(@RequestBody Guests guest) {
        return service.createGuest(guest);
    }

    @GetMapping
    public List<Guests> getAllGuests() {
        return service.getAllGuests();
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Integer id) {
        service.deleteGuest(id);
    }
}
