package ar.elolmo.gymbro.resources;

import ar.elolmo.gymbro.entities.Payment;
import ar.elolmo.gymbro.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping
    public List<Payment> getAllPayments() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return service.save(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Integer id, @RequestBody Payment paymentDetails) {
        return service.findById(id)
                .map(existingPayment -> {
                    existingPayment.setMember(paymentDetails.getMember());
                    existingPayment.setAmount(paymentDetails.getAmount());
                    existingPayment.setPaymentDate(paymentDetails.getPaymentDate());
                    existingPayment.setPaymentMethod(paymentDetails.getPaymentMethod());
                    return ResponseEntity.ok(service.save(existingPayment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
