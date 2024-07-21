package ar.elolmo.gymbro.resources;


    import ar.elolmo.gymbro.entities.Classes;
    import ar.elolmo.gymbro.services.ClassesService;
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/classes")
    public class ClassesResource {

        @Autowired
        private ClassesService service;

        @GetMapping
        public List<Classes> getAllClasses() {
            return service.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Classes> getClassById(@PathVariable Integer id) {
            return service.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public Classes createClass(@RequestBody Classes classes) {
            return service.save(classes);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Classes> updateClass(@PathVariable Integer id, @RequestBody Classes classDetails) {
            return service.findById(id)
                    .map(existingClass -> {
                        existingClass.setName(classDetails.getName());
                        existingClass.setDescription(classDetails.getDescription());
                        existingClass.setTrainer(classDetails.getTrainer());
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


