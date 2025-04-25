package Controller;

import Model.Invoices;
import Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping
    public Invoices createInvoice(@RequestBody Invoices invoice) {
        return service.createInvoice(invoice);
    }

    @GetMapping
    public List<Invoices> getAllInvoices() {
        return service.getAllInvoices();
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Integer id) {
        service.deleteInvoice(id);
    }
}
