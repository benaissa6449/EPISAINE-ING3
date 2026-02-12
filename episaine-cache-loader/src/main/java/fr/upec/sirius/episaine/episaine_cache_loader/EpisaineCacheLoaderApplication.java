package fr.upec.sirius.episaine.episaine_cache_loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;;

@SpringBootApplication
@EnableScheduling
public class EpisaineCacheLoaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpisaineCacheLoaderApplication.class, args);
	}

}
