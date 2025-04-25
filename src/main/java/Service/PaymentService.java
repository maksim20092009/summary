package Service;

import Model.Payments;
import Repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payments createPayment(Payments payment) {
        return repository.save(payment);
    }

    public List<Payments> getAllPayments() {
        return repository.findAll();
    }

    public void deletePayment(Integer id) {
        repository.deleteById(id);
    }
}
