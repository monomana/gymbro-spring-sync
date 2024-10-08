package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Trainer;
import ar.elolmo.gymbro.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    private TrainerRepository repository;

    public TrainerService(TrainerRepository repository) {
        this.repository = repository;
    }


    public List<Trainer> findAll() {
        return repository.findAll();
    }

    public Optional<Trainer> findById(Integer id) {
        return repository.findById(id);
    }

    public Trainer save(Trainer trainer) {
        return repository.save(trainer);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
