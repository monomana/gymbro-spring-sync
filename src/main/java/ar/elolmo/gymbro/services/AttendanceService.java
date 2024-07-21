package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Attendance;
import ar.elolmo.gymbro.repository.AttendanceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {


    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public List<Attendance> findAll() {
        return repository.findAll();
    }

    public Optional<Attendance> findById(Integer id) {
        return repository.findById(id);
    }

    public Attendance save(Attendance attendance) {
        return repository.save(attendance);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
