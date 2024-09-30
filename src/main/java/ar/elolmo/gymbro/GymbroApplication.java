package ar.elolmo.gymbro;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class GymbroApplication {


	public static void main(String[] args) {
		SpringApplication.run(GymbroApplication.class, args);
	}

	/*setting timezone to GMT*/
//	@PostConstruct
//	public void init(){
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
//	}
}
