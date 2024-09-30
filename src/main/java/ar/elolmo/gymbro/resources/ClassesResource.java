package ar.elolmo.gymbro.resources;


    import ar.elolmo.gymbro.entities.ClassEntity;
    import ar.elolmo.gymbro.entities.Trainer;
    import ar.elolmo.gymbro.resources.dtos.ClassInDTO;
    import ar.elolmo.gymbro.resources.dtos.ClassOutDTO;
    import ar.elolmo.gymbro.services.ClassesService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/classes")
    public class ClassesResource {

        @Autowired
        private ClassesService service;

        @GetMapping
        public List<ClassOutDTO> getAllClasses() {
            return service.findAll().stream().map(ClassOutDTO::convertToDTO).toList();
        }

        @GetMapping("/{id}")
        public ResponseEntity<ClassEntity> getClassById(@PathVariable Integer id) {
            return service.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ClassEntity createClass(@RequestBody @Valid ClassInDTO classes) {
            return service.save(classes.convertToEntity());
        }

        @ResponseStatus(HttpStatus.OK)
        @PutMapping("/{id}")
        public ResponseEntity<ClassEntity> updateClass(@PathVariable Integer id,
                                                       @RequestBody @Valid ClassInDTO classDetails) {
            return  service.findById(id)
//                    .map(ClassInDTO::convertToDTO)
//                    .map(ClassInDTO::convertToEntity)
//                    .map(service::save).get()) ;

                    .map(existingClass -> {
                        existingClass.setName(classDetails.getName());
                        existingClass.setDescription(classDetails.getDescription());
                        Trainer trainer = new Trainer();
                        trainer.setId(classDetails.getTrainerId());
                        existingClass.setTrainer(trainer);

                        return ResponseEntity.ok(service.save(existingClass));
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteClass(@PathVariable Integer id) {
            if (service.findById(id).isPresent()) {
                service.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }


