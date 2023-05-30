package net.itinajero.model;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Taco {

	@NotNull
	@Size(min=5, message="El nombre debe tener 5 caracteres por lo menos")
	private String nombre;
	@NotNull
	@Size(min=1, message="Debes seleccionar por lo menos 1 ingrediente")
	private List<Ingrediente> ingredientes;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Taco [nombre=" + nombre + ", ingredientes=" + ingredientes + "]";
	}

}
