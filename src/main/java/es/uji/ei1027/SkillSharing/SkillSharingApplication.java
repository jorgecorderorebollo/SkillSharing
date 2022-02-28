package es.uji.ei1027.SkillSharing;

import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SkillSharingApplication implements CommandLineRunner {
	private static final Logger log = Logger.getLogger(SkillSharingApplication .class.getName());
	public static void main(String[] args) {
		new SpringApplicationBuilder(SkillSharingApplication.class).run(args);
		//SpringApplication.run(SkillSharingApplication.class, args);
	}
	public void run(String... strings) throws Exception {
		log.info("Ací va el meu codi");
	}


}
