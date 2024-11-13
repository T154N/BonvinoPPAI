package models;

import jakarta.persistence.*;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "contrasenia")
	private String contrasenia;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "premium")
	private Boolean premium;


	//CONSTRUCTOR

	public Usuario(String contrasenia, Integer idUsuario, String nombre, Boolean premium) {
		this.contrasenia = contrasenia;
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.premium = premium;
	}

	public Usuario(String contrasenia, String nombre, Boolean premium) {
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"contrasenia='" + contrasenia + '\'' +
				", nombre='" + nombre + '\'' +
				", premium=" + premium +
				'}';
	}

	public Usuario() {}

    //METODOS


	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void esPremium() {

	}

	public void esTuUsuario() {
	}

	public void mostrarNombre() {

	}

	//GETTERS Y SETTERS
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

}