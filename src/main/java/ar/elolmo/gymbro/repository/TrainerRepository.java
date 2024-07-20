package ar.elolmo.gymbro.repository;

import ar.elolmo.gymbro.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
   // List<Trainers> findAll();
}
