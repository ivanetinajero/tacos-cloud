package net.itinajero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import net.itinajero.model.Ingrediente;
import net.itinajero.model.Ingrediente.Tipo;
import net.itinajero.repository.IIngredientesRepository;

@SpringBootApplication
public class TacosCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacosCloudApplication.class, args);
	}
	
	@Bean
	CommandLineRunner dataLoader(IIngredientesRepository repo) {
		return args -> {
			repo.save(new Ingrediente("FLTO", "Flour Tortilla", Tipo.ENVOLTURA));
			repo.save(new Ingrediente("COTO", "Corn Tortilla", Tipo.ENVOLTURA));
			repo.save(new Ingrediente("GRBF", "Ground Beef", Tipo.PROTEINA));
			repo.save(new Ingrediente("CARN", "Carnitas", Tipo.PROTEINA));
			repo.save(new Ingrediente("TMTO", "Diced Tomatoes", Tipo.VEGETAL));
			repo.save(new Ingrediente("LETC", "Lettuce", Tipo.VEGETAL));
			repo.save(new Ingrediente("CHED", "Cheddar", Tipo.QUESO));
			repo.save(new Ingrediente("JACK", "Monterrey Jack", Tipo.QUESO));
			repo.save(new Ingrediente("SLSA", "Salsa", Tipo.SALSA));
			repo.save(new Ingrediente("SRCR", "Sour Cream", Tipo.SALSA));
		};
	}

}
