package models;

import jakarta.persistence.*;

@Entity
@Table(name = "SIGUIENDO")
public class Siguiendo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_siguiendo")
	private Integer idSiguiendo;

	@OneToOne
	private Bodega bodega;

	@Column(name = "fecha_fin")
	private String fechaFin;

	@Column(name = "fecha_inicio")
	private String fechaInicio;

	@OneToOne
	private Sommelier sommelier;

	@OneToOne
	private Enofilo amigo;

	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_enofilo")
	private Enofilo idEnofilo;

	//CONSTRUCTOR

	public Siguiendo(Enofilo amigo, Bodega bodega, String fechaFin, String fechaInicio, Enofilo idEnofilo, Integer idSiguiendo, Sommelier sommelier) {
		this.amigo = amigo;
		this.bodega = bodega;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.idEnofilo = idEnofilo;
		this.idSiguiendo = idSiguiendo;
		this.sommelier = sommelier;
	}



	public Enofilo getIdEnofilo() {
		return idEnofilo;
	}

	public void setIdEnofilo(Enofilo idEnofilo) {
		this.idEnofilo = idEnofilo;
	}

	public Integer getIdSiguiendo() {
		return idSiguiendo;
	}

	public void setIdSiguiendo(Integer idSiguiendo) {
		this.idSiguiendo = idSiguiendo;
	}

	public Enofilo getAmigo() {
		return amigo;
	}

	public void setAmigo(Enofilo amigo) {
		this.amigo = amigo;
	}

	public Siguiendo() {
	}

	//METODOS
	public void sosDeAmigo() {
	}

	@Override
	public String toString() {
		return "Siguiendo{" +
				"bodega=" + bodega +
				", fechaFin='" + fechaFin + '\'' +
				", fechaInicio='" + fechaInicio + '\'' +
				", sommelier=" + sommelier +
				", amigo=" + amigo +
				'}';
	}

	public Boolean sosDeBodega(String bodegaSeleccionada) {
		if (this.bodega.getNombreBodega().equals(bodegaSeleccionada)) {
			return true;
		} else {
			return false;
		}
	}

	public void sosDeSomelier() {

	}

	public void _sosDeBodega() {

	}

	//GETTERS Y SETTERS
	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Sommelier getSommelier() {
		return sommelier;
	}

	public void setSommelier(Sommelier sommelier) {
		this.sommelier = sommelier;
	}


}