package models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table(name="BODEGA")
public class Bodega {
	@Id
	@Column(name = "nombre_bodega")
	private String nombreBodega;
	@Column(name = "coordenadas_ubicacion")
	private String coordenadasUbicacion;
	private String descripcion;
	private String historia;
	@Column(name = "periodo_actualizacion")
	private Integer periodoActualizacion;
	@ManyToMany
	@JoinTable(
			name = "BODEGA_EVENTO",
			joinColumns = @JoinColumn(name = "nombre_bodega"),
			inverseJoinColumns = @JoinColumn(name = "id_novedad_evento")
	)
	@Column(name = "novedades_evento")
	private List<NovedadEvento> novedadesEvento;
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "idRegionVitivinicola")
	private RegionVitivinicola regionVitivinicola;
	@Column(name = "ultima_actualizacion")
	private String ultimaActualizacion;

	@OneToMany(mappedBy = "bodega",  cascade = { CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY,orphanRemoval = true)
	private List<Vino> vinos;


	public Bodega() {
	}

	//Constructor
	public Bodega(String coordenadasUbicacion, String descripcion, String historia, String nombre,
				  Integer periodoActualizacion, String ultimaActualizacion) {
		this.coordenadasUbicacion = coordenadasUbicacion;
		this.descripcion = descripcion;
		this.historia = historia;
		this.nombreBodega = nombre;
		this.periodoActualizacion = periodoActualizacion;
		this.ultimaActualizacion = ultimaActualizacion;
	}


	public Bodega(String nombre) {
		this.nombreBodega = nombre;
	}

	public Bodega(String coordenadasUbicacion,
				  String descripcion,
				  String historia,
				  String nombreBodega,
				  int periodoActualizacion,
				  List<NovedadEvento> novedad,
				  RegionVitivinicola region,
				  String ultimaActualizacion) {
		this.coordenadasUbicacion = coordenadasUbicacion;
		this.descripcion = descripcion;
		this.historia = historia;
		this.nombreBodega = nombreBodega;
		this.periodoActualizacion = periodoActualizacion;
		this.novedadesEvento = novedad;
		this.regionVitivinicola = region;
		this.ultimaActualizacion = ultimaActualizacion;
	}

	@Override
	public String toString() {
		return "Bodega{" +
				"coordenadasUbicacion='" + coordenadasUbicacion + '\'' +
				", descripcion='" + descripcion + '\'' +
				", historia='" + historia + '\'' +
				", nombre_bodega='" + nombreBodega + '\'' +
				", periodoActualizacion=" + periodoActualizacion +
				", novedadEvento=" + novedadesEvento +
				", regionVitivinicola=" + regionVitivinicola +
				", ultimaActualizacion='" + ultimaActualizacion + '\'' +
				'}';
	}

	//Metodos
	public void contarResenia() {

	}

	public void mostrarTodosVinos() {
	}

	public boolean disponibleActualizar(LocalDate today) {
		LocalDate fechaUltimaActualizacion = LocalDate.parse(ultimaActualizacion);
		long monthsBetween = ChronoUnit.MONTHS.between(fechaUltimaActualizacion, today);
		return monthsBetween >= periodoActualizacion;
	}

	public Boolean actualizarDatosVino(Vino vinoAPI, List<Vino> listaVinosBDD ) {
		for (Vino vinoBDD : listaVinosBDD){
			if (vinoBDD.sosVinoParaActualizar(vinoAPI)){
				System.out.println("");
				System.out.println("");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Datos actualizados correctamente del vino" + (vinoAPI.getNombre()));
				System.out.println("Precio antes"+ vinoBDD.getPrecioARS() );
				vinoBDD.setPrecioARS(vinoAPI.getPrecioARS());
				System.out.println("Precio Despues: " + (vinoBDD.getPrecioARS().toString()) );
				System.out.println("Etiqueta Antes: " + vinoBDD.getImagenEtiqueta());
				vinoBDD.setImagenEtiqueta(vinoAPI.getImagenEtiqueta());
				System.out.println("Etiquete Despues: " + vinoBDD.getImagenEtiqueta());
				System.out.println("Nota de cata antes: "+ vinoBDD.getNotaDeCataBodega());
				vinoBDD.setNotaDeCataBodega(vinoAPI.getNotaDeCataBodega());
				System.out.println("Nota de cata Despues: "+ vinoBDD.getNotaDeCataBodega());


				// vinoBDD.save();
				return true;
			}
		}
		return false;
	}


	//Getters y Setters
	public String getCoordenadasUbicacion() {
		return coordenadasUbicacion;
	}

	public void setCoordenadasUbicacion(String coordenadasUbicacion) {
		this.coordenadasUbicacion = coordenadasUbicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public Integer getPeriodoActualizacion() {
		return periodoActualizacion;
	}

	public void setPeriodoActualizacion(Integer periodoActualizacion) {
		this.periodoActualizacion = periodoActualizacion;
	}

	public List<NovedadEvento> getNovedadEvento() {
		// begin-user-code
		return novedadesEvento;
		// end-user-code
	}

	public void setNovedadEvento(List<NovedadEvento> novedadEvento) {
		this.novedadesEvento = novedadEvento;
	}

	public RegionVitivinicola getRegionVitivinicola() {
		return regionVitivinicola;
	}

	public void setRegionVitivinicola(RegionVitivinicola regionVitivinicola) {
		this.regionVitivinicola = regionVitivinicola;
	}

	public String getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(String ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
}