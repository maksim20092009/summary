package Service;

import Model.Invoices;
import Repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    public Invoices createInvoice(Invoices invoice) {
        return repository.save(invoice);
    }

    public List<Invoices> getAllInvoices() {
        return repository.findAll();
    }

    public void deleteInvoice(Integer id) {
        repository.deleteById(id);
    }
}