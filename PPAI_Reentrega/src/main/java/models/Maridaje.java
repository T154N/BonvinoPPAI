package models;

import jakarta.persistence.*;

@Entity
@Table(name = "MARIDAJE")
public class Maridaje {
	@Id
	@Column(name = "nombre_maridaje")
	private String nombreMaridaje;
	private String descripcion;

	//CONSTRUCTOR
	public Maridaje(String nombreMaridaje, String descripcion) {
		this.nombreMaridaje = nombreMaridaje;
		this.descripcion = descripcion;
	}

	public Maridaje() {
	}
/*
	public Maridaje(Object maridaje, ArrayList<Maridaje> maridajesListaBDD){
		ArrayList<Object> marArray = (ArrayList<Object>) maridaje;
		System.out.println("entro aqui");
		System.out.println(marArray);
		for (Maridaje  maridajeBDD : maridajesListaBDD) {
			if (maridajeBDD.getNombre().equals(marArray.get(0).toString())){
				if(marArray.get(2) == "existe"){
					this.nombre = maridajeBDD.getNombre();
					this.descripcion = maridajeBDD.getDescripcion();
				}
				else{
					this.nombre = marArray.get(0).toString();
					this.descripcion = marArray.get(1).toString();
				}
			}
		}
	}
*/
	//METODOS
	public void maridaConVino() {

	}

	public boolean _sosMaridaje(Maridaje maridajeAPI) {
		if (this.nombreMaridaje.equals(maridajeAPI.getNombre())){
			return true;
		}else {
			return false;
		}
	}
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombreMaridaje;
	}

	public void setNombre(String nombre) {
		this.nombreMaridaje = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}