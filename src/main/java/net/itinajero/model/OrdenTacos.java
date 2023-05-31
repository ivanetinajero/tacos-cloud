package net.itinajero.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="OrdenesTacos")
public class OrdenTacos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fechaRegistro = new Date();
	@NotBlank(message="El nombre de entrega es requerido")
	private String nombreEntrega;
	@NotBlank(message="La calle de entrega es requerido")
	private String calleEntrega;
	@NotBlank(message="La ciudad de entrega es requerido")
	private String ciudadEntrega;
	@NotBlank(message="El estado de entrega es requerido")
	private String estadoEntrega;
	@NotBlank(message="El código postal de entrega es requerido")
	private String cpEntrega;
	@CreditCardNumber(message="El número de la tarjeta de crédito no es válido")
	private String numeroTarjeta="5555555555554444";
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",	message="El formato correcto debe ser MM/YY")
	private String expiracionTarjeta;
	@Digits(integer=3, fraction=0, message="El CVV no es válido")
	private String cvvTarjeta;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "OrdenesTacos_Tacos",
		joinColumns = @JoinColumn(name = "idOrdenTaco"),
		inverseJoinColumns = @JoinColumn(name = "idTaco")
	)
	private List<Taco> tacos = new ArrayList<>();

	public String getNombreEntrega() {
		return nombreEntrega;
	}

	public void setNombreEntrega(String nombreEntrega) {
		this.nombreEntrega = nombreEntrega;
	}

	public String getCalleEntrega() {
		return calleEntrega;
	}

	public void setCalleEntrega(String calleEntrega) {
		this.calleEntrega = calleEntrega;
	}

	public String getCiudadEntrega() {
		return ciudadEntrega;
	}

	public void setCiudadEntrega(String ciudadEntrega) {
		this.ciudadEntrega = ciudadEntrega;
	}

	public String getEstadoEntrega() {
		return estadoEntrega;
	}

	public void setEstadoEntrega(String estadoEntrega) {
		this.estadoEntrega = estadoEntrega;
	}

	public String getCpEntrega() {
		return cpEntrega;
	}

	public void setCpEntrega(String cpEntrega) {
		this.cpEntrega = cpEntrega;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getExpiracionTarjeta() {
		return expiracionTarjeta;
	}

	public void setExpiracionTarjeta(String expiracionTarjeta) {
		this.expiracionTarjeta = expiracionTarjeta;
	}

	public String getCvvTarjeta() {
		return cvvTarjeta;
	}

	public void setCvvTarjeta(String cvvTarjeta) {
		this.cvvTarjeta = cvvTarjeta;
	}

	public List<Taco> getTacos() {
		return tacos;
	}

	public void setTacos(List<Taco> tacos) {
		this.tacos = tacos;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}
	
	@Override
	public String toString() {
		return "OrdenTacos [id=" + id + ", fechaRegistro=" + fechaRegistro + ", nombreEntrega=" + nombreEntrega
				+ ", calleEntrega=" + calleEntrega + ", ciudadEntrega=" + ciudadEntrega + ", estadoEntrega="
				+ estadoEntrega + ", cpEntrega=" + cpEntrega + ", numeroTarjeta=" + numeroTarjeta
				+ ", expiracionTarjeta=" + expiracionTarjeta + ", cvvTarjeta=" + cvvTarjeta + ", tacos=" + tacos + "]";
	}
		
}
