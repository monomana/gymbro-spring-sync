package ar.elolmo.gymbro.resources;

import ar.elolmo.gymbro.entities.Trainer;
import ar.elolmo.gymbro.services.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "trainers")
public class TrainerResource {

    private final TrainerService service;

    public TrainerResource(TrainerService service){
        this.service = service;
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return service.save(trainer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Integer id, @RequestBody Trainer trainerDetails) {
        return service.findById(id)
                .map(existingTrainer -> {
                    existingTrainer.setFirstName(trainerDetails.getFirstName());
                    existingTrainer.setLastName(trainerDetails.getLastName());
                    existingTrainer.setSpecialization(trainerDetails.getSpecialization());
                    existingTrainer.setPhone(trainerDetails.getPhone());
                    existingTrainer.setEmail(trainerDetails.getEmail());
                    return ResponseEntity.ok(service.save(existingTrainer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
