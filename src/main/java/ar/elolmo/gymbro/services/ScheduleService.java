package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Schedule;
import ar.elolmo.gymbro.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {


    private final ScheduleRepository repository;

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public List<Schedule> findAll() {
        return repository.findAll();
    }

    public Optional<Schedule> findById(Integer id) {
        return repository.findById(id);
    }

    public Schedule save(Schedule schedule) {
        return repository.save(schedule);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
