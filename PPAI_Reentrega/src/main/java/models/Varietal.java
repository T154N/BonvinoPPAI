package models;

import jakarta.persistence.*;

@Entity
@Table(name = "VARIETAL")
public class Varietal {

	//ATRIBUTOS
	@Id
	@Column(name = "id_varietal")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVarietal;

	@Column(name = "porcentaje_composicion")
	private Double porcentajeComposicion;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToOne
	private TipoUva tipoUva;


	//CONSTRUCTOR
	public Varietal(String descripcion, Double porcentajeComposicion, TipoUva tipoUva) {
		this.descripcion = descripcion;
		this.porcentajeComposicion = porcentajeComposicion;
		this.tipoUva = tipoUva;
	}

	public Varietal() {
	}

	public  Varietal(Varietal varietal, Boolean crearTipoUva){
		this.descripcion = varietal.getDescripcion();
		this.porcentajeComposicion = varietal.getPorcentajeComposicion();
		if (!crearTipoUva){
			this.tipoUva = varietal.getTipoUva();
		}else {
			this.tipoUva = new TipoUva(varietal.getTipoUva().getDescripcion(), varietal.getTipoUva().getNombre());
			//guargar uva en la base de datos hacelo abi
		}
	}

	//METODOS

	public Integer getIdVarietal() {
		return idVarietal;
	}

	public void setIdVarietal(Integer idVarietal) {
		this.idVarietal = idVarietal;
	}

	public void conocerTiposUva() {
	}

	public void esDeTipoUva() {
	}

	public void mostrarPorcentaje() {

	}


	//GETTERS Y SETTERS
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPorcentajeComposicion() {
		return porcentajeComposicion;
	}

	public void setPorcentajeComposicion(Double porcentajeComposicion) {
		this.porcentajeComposicion = porcentajeComposicion;
	}

	public TipoUva getTipoUva() {
		return tipoUva;
	}

	public void setTipoUva(TipoUva tipoUva) {
		this.tipoUva = tipoUva;
	}
}