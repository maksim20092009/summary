package Service;

import Model.SeasonaOffers;
import Repository.SeasonalOfferRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SeasonalOfferService {

    @Autowired
    private SeasonalOfferRepository repository;

    public SeasonaOffers createOffer(SeasonaOffers offer) {
        return repository.save(offer);
    }

    public List<SeasonaOffers> getAllOffers() {
        return repository.findAll();
    }

    public void deleteOffer(Integer id) {
        repository.deleteById(id);
    }
}