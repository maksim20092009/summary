package Controller;

import Model.LoyaltyPrograms;
import Service.LoyaltyProgramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loyaltyPrograms")
public class LoyaltyProgramController {

    @Autowired
    private LoyaltyProgramsService service;

    @PostMapping
    public LoyaltyPrograms createLoyaltyProgram(@RequestBody LoyaltyPrograms loyaltyProgram) {
        return service.createLoyaltyPrograms(loyaltyProgram);
    }

    @GetMapping
    public List<LoyaltyPrograms> getAllLoyaltyPrograms() {
        return service.getAllLoyaltyPrograms();
    }

    @DeleteMapping("/{id}")
    public void deleteLoyaltyProgram(@PathVariable Integer id) {
        service.deleteLoyaltyProgram(id);
    }
}