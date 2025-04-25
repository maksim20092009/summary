package Service;

import Model.LoyaltyPrograms;
import Repository.LoyaltyProgramRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LoyaltyProgramsService {

    @Autowired
    private LoyaltyProgramRepository repository;

    public LoyaltyPrograms createLoyaltyPrograms(LoyaltyPrograms loyaltyProgram){
        return repository.save(loyaltyProgram);
    }

    public List<LoyaltyPrograms> getAllLoyaltyPrograms() {
        return repository.findAll();
    }

    public void deleteLoyaltyProgram(Integer id) {
        repository.deleteById(id);
    }
}
