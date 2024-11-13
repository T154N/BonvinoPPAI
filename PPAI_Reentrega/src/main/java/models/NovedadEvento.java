package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "NOVEDAD_EVENTO")
public class NovedadEvento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_novedad_evento")
	private Integer idNovedadEvento;
	@Column(name = "codigo_descuento_premium")
	private String codigoDescuentoPremium;
	private String descripcion;
	@Column(name = "es_solo_premium")
	private Boolean esSoloPremium;
	@Column(name = "fecha_hora_evento")
	private LocalDateTime fechaHoraEvento;
	@Column(name = "nombre_evento")
	private String nombreEvento;
	@ManyToMany(mappedBy = "novedadesEvento")
	private List<Bodega> bodegas;


	public NovedadEvento(int idNovedadEvento, int esSoloPremium, String fechaHoraEvento, String codDescPremium, String descripcion, String nombreEvento) {
	}

	public NovedadEvento() {

	}

	public String getCodigoDescuentoPremium() {
		return codigoDescuentoPremium;
	}

	public void setCodigoDescuentoPremium(String codigoDescuentoPremium) {
		this.codigoDescuentoPremium = codigoDescuentoPremium;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEsSoloPremium() {
		return esSoloPremium;
	}

	public void setEsSoloPremium(Boolean esSoloPremium) {
		this.esSoloPremium = esSoloPremium;
	}

	public LocalDateTime getFechaHoraEvento() {
		return fechaHoraEvento;
	}

	public void setFechaHoraEvento(LocalDateTime fechaHoraEvento) {
		this.fechaHoraEvento = fechaHoraEvento;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public void esPremium() {

	}

	public void estaEnPeriodo() {
	}

	public void mostrarDescripcion() {
	}

    public Integer getIdNovedadEvento() {
        return idNovedadEvento;
    }

    public void setIdNovedadEvento(Integer idNovedadEvento) {
        this.idNovedadEvento = idNovedadEvento;
    }
}