//реализует бизнес-логику
package Service;

import Model.Guests;
import Repository.GuestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GuestService {

    @Autowired
    private GuestRepository repository;

    public Guests createGuest(Guests guest) {
        return repository.save(guest);
    }

    public List<Guests> getAllGuests() {
        return repository.findAll();
    }

    public void deleteGuest(Integer id) {
        repository.deleteById(id);
    }
}