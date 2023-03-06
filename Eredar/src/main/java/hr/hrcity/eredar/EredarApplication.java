package hr.hrcity.eredar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan
@EnableScheduling
public class EredarApplication {

	public static void main(String[] args) {
		SpringApplication.run(EredarApplication.class, args);
	}

}
