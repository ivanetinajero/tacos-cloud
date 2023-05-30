package net.itinajero.model;

public class Ingrediente {

	private String id;
	private String nombre;
	private Tipo tipo;

	public Ingrediente() {

	}

	public Ingrediente(String id, String nombre, Tipo tipo) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public enum Tipo {
		ENVOLTURA, PROTEINA, VEGETAL, QUESO, SALSA
	}

	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

}
