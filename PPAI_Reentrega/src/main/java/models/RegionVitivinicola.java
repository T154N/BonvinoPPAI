package models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "REGION_VITIVINICOLA")
public class RegionVitivinicola {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_regionVitivinicola;
	private String descripcion;
	private String nombre;
	@OneToMany(mappedBy = "regionVitivinicola")
	private List<Bodega> bodegas;

	//CONSTRUCTOR
	public RegionVitivinicola(Integer id_regionVitivinicola ,String descripcion, String nombre, List<Bodega> bodegas) {
		this.id_regionVitivinicola = id_regionVitivinicola;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.bodegas = bodegas;
	}

	public RegionVitivinicola() {

	}

	//METODOS


	public List<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public Integer getId_regionVitivinicola() {
		return id_regionVitivinicola;
	}

	public void setId_regionVitivinicola(Integer id_regionVitivinicola) {
		this.id_regionVitivinicola = id_regionVitivinicola;
	}

	public void conocerBodega() {

	}

	public void contarBodegas() {

	}

	//GETTERS Y SETTERS

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}