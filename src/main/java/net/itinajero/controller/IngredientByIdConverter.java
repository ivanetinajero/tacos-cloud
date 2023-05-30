package net.itinajero.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import net.itinajero.model.Ingrediente;
import net.itinajero.repository.IIngredientesRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingrediente> {

	private IIngredientesRepository ingredientesRepo;
	
	public IngredientByIdConverter(IIngredientesRepository ingredientesRepo) {
		this.ingredientesRepo = ingredientesRepo;
	}
	
	@Override
	public Ingrediente convert(String id) {
		return ingredientesRepo.findById(id).orElse(null);
	}

}
