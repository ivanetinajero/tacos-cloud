package net.itinajero.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import net.itinajero.model.Ingrediente;
import net.itinajero.model.Ingrediente.Tipo;
import net.itinajero.model.OrdenTacos;
import net.itinajero.model.Taco;
import net.itinajero.repository.IIngredientesRepository;

@Controller
@RequestMapping("/design")
@SessionAttributes("ordenTacos")
public class DesignTacoController {
	
	private final IIngredientesRepository ingredientesRepo;
	
	public DesignTacoController(IIngredientesRepository ingredientesRepo) {
		this.ingredientesRepo = ingredientesRepo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		
		List<Ingrediente> ingredients = ingredientesRepo.findAll();		
		Tipo[] tipos = Ingrediente.Tipo.values();
		for (Tipo tipo : tipos) {
			model.addAttribute(tipo.toString().toLowerCase(), filterByType(ingredients, tipo));
		}
		
	}

	@ModelAttribute(name = "ordenTacos")
	public OrdenTacos order() {
		return new OrdenTacos();
	}

	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}

	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute OrdenTacos tacoOrder) {
		
		if (errors.hasErrors()) {
			return "design";
		}
		
		tacoOrder.agregarTaco(taco);
		System.out.println("Processing taco:" + taco);
		return "redirect:/orders/current";
	}

	private Iterable<Ingrediente> filterByType(List<Ingrediente> ingredients, Tipo type) {
		return ingredients.stream().filter(x -> x.getTipo().equals(type)).collect(Collectors.toList());
	}
	
}
