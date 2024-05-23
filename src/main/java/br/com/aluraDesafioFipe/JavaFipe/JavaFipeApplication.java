package br.com.aluraDesafioFipe.JavaFipe;

import br.com.aluraDesafioFipe.JavaFipe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
