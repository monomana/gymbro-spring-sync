package ar.elolmo.gymbro.resources;

import ar.elolmo.gymbro.entities.Schedule;
import ar.elolmo.gymbro.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleResource {

    @Autowired
    private ScheduleService service;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Integer id, @RequestBody Schedule scheduleDetails) {
        return service.findById(id)
                .map(existingSchedule -> {
                    existingSchedule.setClasses(scheduleDetails.getClasses());
                    existingSchedule.setTrainer(scheduleDetails.getTrainer());
                    existingSchedule.setStartTime(scheduleDetails.getStartTime());
                    existingSchedule.setEndTime(scheduleDetails.getEndTime());
                    existingSchedule.setDayOfWeek(scheduleDetails.getDayOfWeek());
                    return ResponseEntity.ok(service.save(existingSchedule));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

