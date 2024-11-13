package models;

public class TipoUva {

	//ATRIBUTOS
	private String descripcion;
	private String nombre;

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