package academy.jobintech.jitechpilot;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
		"academy.jobintech.jitechpilot.mapper",
		"academy.jobintech.jitechpilot.serviceImpl",
		"academy.jobintech.jitechpilot.controller",
		"academy.jobintech.jitechpilot.exception"
})
@EntityScan("academy.jobintech.jitechpilot.entity")
@EnableJpaRepositories("academy.jobintech.jitechpilot.repository")
public class JitechpilotApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		SpringApplication.run(JitechpilotApplication.class, args);
	}

}
