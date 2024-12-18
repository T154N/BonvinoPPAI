// ------------------------------------------
// IMPORTACION DE CLASES NECESARIAS y extras
// ------------------------------------------

package Controladores;
//----------------------------------CLASES
import models.*;
//----------------------------------BOUNDARYS
import com.company.PantallaAB.PantallaAB;
import Boundarys.InterfazSB;
import Boundarys.InterfazNotificacion;
//----------------------------------JAVA
import java.util.*;
import javax.swing.*;
import java.time.LocalDate;



// ---------------------------------------------------
// Definicion de la clase controlador
// ---------------------------------------------------

public class ControladorImportarActualizacionVinosBodega {

	// Atributos
	private List<Bodega> bodegaSeleccionada;
	private Maridaje maridaje;
	private TipoUva tipoUva;
	private List<Vino> listaVinosCreados;
	private List<Enofilo> seguidoresDeBodega;
	private List<Bodega> listaBodegas;
	private List<Vino> listaVinos;
	private ArrayList<Maridaje> maridajesList;
	private ArrayList<TipoUva> tipoUvaList;
	private ArrayList<Usuario> listaUsuario;
	private ArrayList<Enofilo> listaEnofilos;
	private ArrayList<Siguiendo> Listasiguiendo;


	// inicializar pantalla
	InterfazSB interfazSB = new InterfazSB();
	InterfazNotificacion interfazNotificacion = new InterfazNotificacion();

	public ControladorImportarActualizacionVinosBodega() {

		this.bodegaSeleccionada = new ArrayList<>();


		this.Listasiguiendo = new ArrayList<>();
		this.listaEnofilos = new ArrayList<>();
		this.listaUsuario = new ArrayList<>();
	}

	// --------------------------------------------------------------------
	// Metodos de clase controlador
	//---------------------------------------------------------------------
	// Cuando se selecciona la opcion de importar actualizacion
	public void opcionImportarActualizacionVinosBodega() {
		// buscar las bodegas que requieren actualizacion
		List<String> listaBodegasConActualizacion = buscarBodegasParaActualizar(listaBodegas);

		if (listaBodegasConActualizacion.isEmpty()){
			// si el array esta vacio, muestra un mensaje de la inexistencia de bodegas para actualizar:
			JOptionPane.showMessageDialog(null, "No hay bodegas para actualizar");
			System.exit(0);
		} else {
			// si el array no esta vacio, llama a la funcion mostrarBodegasParaActualizacion de la pantallaAB
			// a la funcion se le pasa por parametro las bodegas que requieren actualizacion, algunas se crean otras se modifican
			PantallaAB.mostrarBodegasParaActualizar(listaBodegasConActualizacion);
		}
	}

	//
	public List<String> buscarBodegasParaActualizar(List<Bodega> listaBodegas) {
		LocalDate today = LocalDate.now(); // Tomar fecha actual

		// array para la lista de nombres
		List<String> bodegasConActualizacion = new ArrayList<>();
		for (Bodega bodega : listaBodegas) {
			if (bodega.disponibleActualizar(today)) {
				// agregar al array lista nombres
				bodegasConActualizacion.add(bodega.getNombreBodega());
			}}
		// devolver el array con los nombres de la bodega
		return bodegasConActualizacion;
	}

	// Metodo para seleccionar las bodegas
	public void tomarSeleccionBodega(List<String> nombresBodegaSeleccionadas) {
		boolean notificacion = false;
		ArrayList<ArrayList<String>> vinosPantalla = new ArrayList<>();
		ArrayList<String> bodegasActualizadas = new ArrayList<>();
		ArrayList<Vino> vinosParaActualizar;
		for (String nombreBodegaSeleccionada : nombresBodegaSeleccionadas) {
			for (Bodega bodegaBDD : this.listaBodegas) {
				if (bodegaBDD.getNombreBodega().equals(nombreBodegaSeleccionada)) {
					bodegaSeleccionada.add(bodegaBDD);
					bodegasActualizadas.add(bodegaBDD.getNombreBodega());
				}
			}
			//dividir tomar seleccion
			vinosParaActualizar = interfazSB.getImportarActualizacionVinos(nombreBodegaSeleccionada);



		for (Vino vinostr : vinosParaActualizar) {
			ArrayList<String> vinoStringAMostrar = new ArrayList<>();
			Boolean vinoActualizado = actualizarVinosExistentes(vinostr);
			if (vinoActualizado){
				vinoStringAMostrar.add(vinostr.getNombre());
				vinoStringAMostrar.add(vinostr.getAniada().toString());
				vinoStringAMostrar.add(vinostr.getBodega().getNombreBodega());
				vinoStringAMostrar.add(vinostr.getImagenEtiqueta());
				vinoStringAMostrar.add(vinostr.getPrecioARS().toString());
				vinoStringAMostrar.add(vinostr.getNotaDeCataBodega());
				vinoStringAMostrar.add("Actualizado");
			}
			if (!vinoActualizado){

				//buscamos los maridajes y creamos 2 listas, una con los maridajes ya creados y otra con los que no
				ArrayList<Maridaje> maridajesYaCreadas = new ArrayList<>();
				ArrayList<Maridaje> maridajesNOCreadas = new ArrayList<>();
				for (Maridaje maridajeAPI : vinostr.getMaridaje()) {
					Maridaje maridajesYaCreadasIndividual = buscarMaridaje(maridajeAPI);
					if (maridajesYaCreadasIndividual == null) {
						maridajesNOCreadas.add(maridajeAPI);
					}
					else{
						maridajesYaCreadas.add(maridajesYaCreadasIndividual);
					}
				}

				//buscamos los tipos de uva y creamos 2 listas, una con los tipos de uva ya creados y otra con los que no
				ArrayList<Varietal> varietalesConTipoUvaYaCreadas = new ArrayList<>();
				ArrayList<Varietal> varietalesConTipoUvaNOCreadas = new ArrayList<>();
				for (Varietal varietal : vinostr.getVarietal()) {
					Varietal varietalContipoUvaYaCreadasIndividual = buscarTipoUva(varietal);
					if (varietalContipoUvaYaCreadasIndividual == null) {
						varietalesConTipoUvaNOCreadas.add(varietal);
					}
					else{
						varietalesConTipoUvaYaCreadas.add(varietalContipoUvaYaCreadasIndividual);
					}
				}


				crearVino(maridajesYaCreadas, varietalesConTipoUvaYaCreadas, vinostr, bodegaSeleccionada, varietalesConTipoUvaNOCreadas, maridajesNOCreadas);


				vinoStringAMostrar.add(vinostr.getNombre());
				vinoStringAMostrar.add(vinostr.getAniada().toString());
				vinoStringAMostrar.add(vinostr.getBodega().getNombreBodega());
				vinoStringAMostrar.add(vinostr.getImagenEtiqueta());
				vinoStringAMostrar.add(vinostr.getPrecioARS().toString());
				vinoStringAMostrar.add(vinostr.getNotaDeCataBodega());
				vinoStringAMostrar.add("Creado");
				//con los vinostr el eltimo elemento del array es si esta creado o no
				// Anotar el vino creado para mostrarlo en el resumen
			}
			vinosPantalla.add(vinoStringAMostrar);
		}

			if (!(vinosParaActualizar.isEmpty())) {
				ArrayList<String> nombresDeUsuariosSeguidores;
				// Validar que sean bodegas actualizadas
				nombresDeUsuariosSeguidores = buscarSeguidoresBodega(nombreBodegaSeleccionada); // Array Strings de Usuarios
				interfazNotificacion.notificarNovedadVino(nombresDeUsuariosSeguidores, nombreBodegaSeleccionada);
				nombresDeUsuariosSeguidores.clear();

				notificacion = true;
			}

		}
		if (notificacion) {
			JOptionPane.showMessageDialog(null, "Se notifico a los usuarios ");
		}
		PantallaAB.mostrarResumenVinosImportados(vinosPantalla);
	}

	public Boolean actualizarVinosExistentes(Vino vino) {
		for (Bodega bodegaSeleccionada : bodegaSeleccionada){
			if (bodegaSeleccionada.getNombreBodega().equals(vino.getBodega().getNombreBodega())) {
				return bodegaSeleccionada.actualizarDatosVino(vino, listaVinos );
				// Anotar el vino actualizado para mostrarlo en el resumen
				// agregar a un array para mostrar el resumen
			}
		}
		return false;
	}

	public Maridaje buscarMaridaje(Maridaje maridajeAPI) {
		Maridaje result = new Maridaje();

		for (Maridaje m : maridajesList) {
			if (m._sosMaridaje(maridajeAPI)) {
				result = m;
				return result;
			}
		}
		return null;
	}

	public Varietal buscarTipoUva(Varietal varietalApi) {
		Varietal result = new Varietal();
			for (TipoUva tu : tipoUvaList) {
				if (tu._sosTipoUva(varietalApi.getTipoUva())) {
					result = varietalApi;
					return result;
				}
			}
		return null;
	}

	// metodo crear vino, pasarle todas las clases necesarias. Con ayuda de lconstructor
	public void crearVino(ArrayList<Maridaje> maridajesYaCreados, ArrayList<Varietal> tipoUvaYaCreados, Vino vinostr, List<Bodega> bodegaSeleccionada, ArrayList<Varietal> tipoUvaNoCreados, ArrayList<Maridaje> maridajesNoCreados) {
		Vino vino = new Vino(maridajesYaCreados, tipoUvaYaCreados, vinostr, bodegaSeleccionada, tipoUvaNoCreados, maridajesNoCreados);
		listaVinos.add(vino);
	}


	public ArrayList<String> buscarSeguidoresBodega(String Bodega) {
        ArrayList<String> enofilosSiguiendos = new ArrayList<>();
            for (Enofilo enofilo : listaEnofilos) {
                if (enofilo.seguisBodega(Bodega)) {
					enofilosSiguiendos.add(enofilo.getNombreUsuario());
				}
            }
        return enofilosSiguiendos; // Si no se encuentra ningún seguidor
    }

	// finCU
	public void finCU() {
	}

	// --------------------------------------------
	//GETTERS Y SETTERS
	// --------------------------------------------
	public List<Bodega> getBodegaSeleccionada() {
		return bodegaSeleccionada;
	}

	public void setBodegaSeleccionada(List<Bodega> bodegaSeleccionada) {
		this.bodegaSeleccionada = bodegaSeleccionada;
	}

	public Maridaje getMaridaje() {
		return maridaje;
	}

	public void setMaridaje(Maridaje maridaje) {
		this.maridaje = maridaje;
	}

	public TipoUva getTipoUva() {
		return tipoUva;
	}

	public void setTipoUva(TipoUva tipoUva) {
		this.tipoUva = tipoUva;
	}

	public List<Vino> getListaVinosCreados() {
		return listaVinosCreados;
	}

	public void setListaVinosCreados(List<Vino> listaVinosCreados) {
		this.listaVinosCreados = listaVinosCreados;
	}

	public List<Enofilo> getSeguidoresBodega() {
		return seguidoresDeBodega;
	}

	public void setSeguidoresBodega(List<Enofilo> seguidoresDeBodega) {
		this.seguidoresDeBodega = seguidoresDeBodega;
	}


	public void setListaBodegas(List<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}
}