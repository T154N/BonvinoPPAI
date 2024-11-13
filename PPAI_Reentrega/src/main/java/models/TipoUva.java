package models;

import jakarta.persistence.*;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@Entity
@Table(name = "TIPO_UVA")
public class TipoUva {

	//ATRIBUTOS
	@Id
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	//CONSTRUCTOR
	public TipoUva(String descripcion, String nombre) {
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	//METODOS
	public boolean _sosTipoUva(TipoUva tipoUvaAPI) {
		if (this.nombre.equals(tipoUvaAPI.toString())) {
			return true;
		}else {
			return false;
		}
	}

	public TipoUva() {
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