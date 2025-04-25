package Service;

import Model.Hotels;
import Repository.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository repository;

    public Hotels createHotel(Hotels hotel) {
        return repository.save(hotel);
    }

    public List<Hotels> getAllHotels() {
        return repository.findAll();
    }

    public void deleteHotel(Integer id) {
        repository.deleteById(id);
    }
}