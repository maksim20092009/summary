package Controller;

import Model.Payments;
import Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payments createPayment(@RequestBody Payments payment) {
        return service.createPayment(payment);
    }

    @GetMapping
    public List<Payments> getAllPayments() {
        return service.getAllPayments();
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Integer id) {
        service.deletePayment(id);
    }
}