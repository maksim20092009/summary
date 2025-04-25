package Controller;

import Model.Rooms;
import Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping
    public Rooms createRoom(@RequestBody Rooms room) {
        return service.createRoom(room);
    }

    @GetMapping
    public List<Rooms> getAllRooms() {
        return service.getAllRooms();
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        service.deleteRoom(id);
    }
}
