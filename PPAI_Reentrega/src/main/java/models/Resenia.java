package models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESENIAS")
public class Resenia {
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name = "id_resenia")
	private Integer idResenia;

	@Column(name = "comentario")
	private String comentario;

	@Column(name = "es_premium")
	private Boolean esPremium;

	@Column(name = "fecha_resenia")
	private LocalDateTime fechaResenia;

	@Column(name = "puntaje")
	private Integer puntaje;

	@ManyToOne
	@JoinColumn(name = "vino", referencedColumnName = "vino", nullable = false)
	private Vino vino;

	//CONSTRUCTOR




	public Resenia(String comentario, Boolean esPremium, LocalDateTime fechaResenia, Integer idResenia, Integer puntaje) {
		this.comentario = comentario;
		this.esPremium = esPremium;
		this.fechaResenia = fechaResenia;
		this.idResenia = idResenia;
		this.puntaje = puntaje;
	}

	public Resenia(String comentario, Boolean esPremium, LocalDateTime fechaResenia, Integer idResenia, Integer puntaje, Vino vino) {
		this.comentario = comentario;
		this.esPremium = esPremium;
		this.fechaResenia = fechaResenia;
		this.idResenia = idResenia;
		this.puntaje = puntaje;
		this.vino = vino;
	}

	public Resenia(){

	}

	//METODOS




	public Vino getVino() {
		return vino;
	}

	public void setVino(Vino vino) {
		this.vino = vino;
	}

	public Integer getIdResenia() {
		return idResenia;
	}

	public void setIdResenia(Integer idResenia) {
		this.idResenia = idResenia;
	}

	public void esPremium() {

	}

	public void sosDeEnofilo() {

	}

	public void sosDeSomelier() {

	}

	//GETTERS Y SETTERS
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Boolean getEsPremium() {
		return esPremium;
	}

	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

	public LocalDateTime getFechaResenia() {
		return fechaResenia;
	}

	public void setFechaResenia(LocalDateTime fechaResenia) {
		this.fechaResenia = fechaResenia;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

}