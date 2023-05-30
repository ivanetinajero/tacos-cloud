package net.itinajero.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Tacos")
public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fechaCreacion = new Date();
	@NotNull
	@Size(min = 5, message = "El nombre debe tener 5 caracteres por lo menos")
	private String nombre;
	@Size(min = 1, message = "Debes seleccionar por lo menos 1 ingrediente")
	@ManyToMany
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public void agregarIngredient(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}

	@Override
	public String toString() {
		return "Taco [id=" + id + ", fechaCreacion=" + fechaCreacion + ", nombre=" + nombre + ", ingredientes="
				+ ingredientes + "]";
	}

}
