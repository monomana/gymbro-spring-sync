package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Trainer;
import ar.elolmo.gymbro.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTest {

    private TrainerRepository trainerRepository;

    public ServiceTest(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public String getHello(){
        return "hello";
    }

    public List<Trainer> getTrainers(){
        return trainerRepository.findAll();
    }
}
