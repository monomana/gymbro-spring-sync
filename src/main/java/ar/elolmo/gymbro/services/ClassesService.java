package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Classes;
import ar.elolmo.gymbro.entities.Trainer;
import ar.elolmo.gymbro.repository.ClassesRepository;
import ar.elolmo.gymbro.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService {

    private ClassesRepository repository;

    public ClassesService(ClassesRepository repository) {
        this.repository = repository;
    }

    public List<Classes> findAll() {
        return repository.findAll();
    }

    public Optional<Classes> findById(Integer id) {
        return repository.findById(id);
    }

    public Classes save(Classes classes) {
        return repository.save(classes);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
