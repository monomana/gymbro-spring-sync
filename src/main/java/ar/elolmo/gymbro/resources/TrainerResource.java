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

    private TrainerService trainerService;

    public TrainerResource(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping()
    public List<Trainer> getTrainers(){
        return trainerService.getTrainers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/post")
    public void saveTrainer(@RequestBody Trainer trainer){

        trainerService.saveTrainer(trainer);
        // return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(1).toUri()).build();
    }
}
