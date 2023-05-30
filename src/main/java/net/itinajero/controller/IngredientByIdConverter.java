package net.itinajero.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import net.itinajero.model.Ingrediente;
import net.itinajero.model.Ingrediente.Tipo;

@Component
public class IngredientByIdConverter implements Converter<String, Ingrediente> {

	private Map<String, Ingrediente> ingredientMap = new HashMap<>();

	public IngredientByIdConverter() {
		ingredientMap.put("FLTO", new Ingrediente("FLTO", "Flour Tortilla", Tipo.ENVOLTURA));
		ingredientMap.put("COTO", new Ingrediente("COTO", "Corn Tortilla", Tipo.ENVOLTURA));
		ingredientMap.put("GRBF", new Ingrediente("GRBF", "Ground Beef", Tipo.PROTEINA));
		ingredientMap.put("CARN", new Ingrediente("CARN", "Carnitas", Tipo.PROTEINA));
		ingredientMap.put("TMTO", new Ingrediente("TMTO", "Diced Tomatoes", Tipo.VEGETAL));
		ingredientMap.put("LETC", new Ingrediente("LETC", "Lettuce", Tipo.VEGETAL));
		ingredientMap.put("CHED", new Ingrediente("CHED", "Cheddar", Tipo.QUESO));
		ingredientMap.put("JACK", new Ingrediente("JACK", "Monterrey Jack", Tipo.QUESO));
		ingredientMap.put("SLSA", new Ingrediente("SLSA", "Salsa", Tipo.SALSA));
		ingredientMap.put("SRCR", new Ingrediente("SRCR", "Sour Cream", Tipo.SALSA));
	}

	@Override
	public Ingrediente convert(String id) {
		return ingredientMap.get(id);
	}

}
