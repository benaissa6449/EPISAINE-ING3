package fr.upec.sirius.episaine.episaine_send_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EpisaineSendNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpisaineSendNotificationApplication.class, args);
	}

}
