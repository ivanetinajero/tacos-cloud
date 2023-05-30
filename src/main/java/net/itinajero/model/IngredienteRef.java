package net.itinajero.model;

public class IngredienteRef {

	private String ingredient;

	public IngredienteRef() {

	}

	public IngredienteRef(String ingredient) {
		super();
		this.ingredient = ingredient;
	}

	public String getIngredient() {
		return ingredient;
	}

	@Override
	public String toString() {
		return "IngredientRef [ingredient=" + ingredient + "]";
	}

}
