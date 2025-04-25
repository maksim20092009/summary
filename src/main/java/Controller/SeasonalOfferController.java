package Controller;

import Model.SeasonaOffers;
import Service.SeasonalOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class SeasonalOfferController {

    @Autowired
    private SeasonalOfferService service;

    @PostMapping
    public SeasonaOffers createOffer(@RequestBody SeasonaOffers offer) {
        return service.createOffer(offer);
    }

    @GetMapping
    public List<SeasonaOffers> getAllOffers() {
        return service.getAllOffers();
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Integer id) {
        service.deleteOffer(id);
    }
}
