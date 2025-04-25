package Service;

import Model.Rooms;
import Repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public Rooms createRoom(Rooms room) {
        return repository.save(room);
    }

    public List<Rooms> getAllRooms() {
        return repository.findAll();
    }

    public void deleteRoom(Integer id) {
        repository.deleteById(id);
    }
}
