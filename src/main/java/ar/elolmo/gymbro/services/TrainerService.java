package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Trainer;
import ar.elolmo.gymbro.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getTrainers(){
        return trainerRepository.findAll();
    }

    public void saveTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
