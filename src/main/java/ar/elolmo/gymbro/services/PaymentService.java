package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Payment;
import ar.elolmo.gymbro.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {


    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public List<Payment> findAll() {
        return repository.findAll();
    }

    public Optional<Payment> findById(Integer id) {
        return repository.findById(id);
    }

    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
