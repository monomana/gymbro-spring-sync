package ar.elolmo.gymbro.resources;

import ar.elolmo.gymbro.entities.Trainer;
import ar.elolmo.gymbro.services.ServiceTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestResource {
    private ServiceTest serviceTest;
    public TestResource(ServiceTest serviceTest){
        this.serviceTest = serviceTest;
    }
    @GetMapping(value = "hello")
    public String getHello(){
        return serviceTest.getHello();
    }

    @GetMapping(value = "trainers")
    public List<Trainer> getTrainers(){
        return serviceTest.getTrainers();
    }
}
