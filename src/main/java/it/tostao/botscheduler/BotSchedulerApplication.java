package it.tostao.botscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BotSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotSchedulerApplication.class, args);
	}

}
