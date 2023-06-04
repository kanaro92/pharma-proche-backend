package mr.kawkumputer.pharmaprochebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PharmaProcheBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmaProcheBackendApplication.class, args);
	}

	/*@Bean
	public ApplicationRunner runner(final KafkaProducers kafkaProducers){
		String payload = "This is a message with UUID: ".concat(UUID.randomUUID().toString());
		return args -> {
			kafkaProducers.sendMessage(payload);
		};
	}*/
}
