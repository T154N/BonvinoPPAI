package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SOMMELIER")
public class Sommelier {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name = "id_sommelier")
	private Integer id_sommelier;


	@OneToOne
	private Usuario usuario;

	@Column(name = "fecha_validacion")
	private LocalDateTime fecha_validacion;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "nota_pesentacion")
	private String nota_pesentacion;

	public Sommelier(Integer id_sommelier, Usuario usuario, LocalDateTime fecha_validacion, String nombre, String nota_pesentacion) {
		this.id_sommelier = id_sommelier;
		this.usuario = usuario;
		this.fecha_validacion = fecha_validacion;
		this.nombre = nombre;
		this.nota_pesentacion = nota_pesentacion;
	}

	public Sommelier() {
	}

	public Sommelier(String idSommelier, String idUsuario, String fechaValidacion, String nombre, int notaPresentacion, String ultimaActualizacion) {
	}

	public Integer getId_sommelier() {
		return id_sommelier;
	}

	public Usuario getUsuario() {
		return usuario;
	}



	public String getNombre() {
		return nombre;
	}

	public String getNota_pesentacion() {
		return nota_pesentacion;
	}

	public void setId_sommelier(Integer id_sommelier) {
		this.id_sommelier = id_sommelier;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNota_pesentacion(String nota_pesentacion) {
		this.nota_pesentacion = nota_pesentacion;
	}
}
