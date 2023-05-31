package net.itinajero.forms;

import org.springframework.security.crypto.password.PasswordEncoder;

import net.itinajero.model.Usuario;

public class RegistrationForm {

	private String username;
	private String password;
	private String nombre;
	private String calle;
	private String ciudad;
	private String estado;
	private String codigoPostal;
	private String telefono;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Usuario toUser(PasswordEncoder passwordEncoder) {
		return new Usuario(username, passwordEncoder.encode(password), nombre, calle, ciudad, estado, codigoPostal, telefono);
	}

	@Override
	public String toString() {
		return "RegistrationForm [username=" + username + ", password=" + password + ", nombre=" + nombre + ", calle="
				+ calle + ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal + ", telefono="
				+ telefono + "]";
	}

}
