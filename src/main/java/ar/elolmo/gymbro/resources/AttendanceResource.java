package ar.elolmo.gymbro.resources;



import ar.elolmo.gymbro.entities.Attendance;
import ar.elolmo.gymbro.services.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceResource {

    private final AttendanceService service;

    public AttendanceResource(AttendanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return service.save(attendance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Integer id, @RequestBody Attendance attendanceDetails) {
        return service.findById(id)
                .map(existingAttendance -> {
                    existingAttendance.setMember(attendanceDetails.getMember());
                    existingAttendance.setSchedule(attendanceDetails.getSchedule());
                    existingAttendance.setAttendanceDate(attendanceDetails.getAttendanceDate());
                    return ResponseEntity.ok(service.save(existingAttendance));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
