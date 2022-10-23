package ar.edu.unlu.mvc.controlador;

import java.util.LinkedList;

import ar.edu.unlu.mvc.modelo.AdministradorDeTareas;
import ar.edu.unlu.mvc.modelo.Observado;
import ar.edu.unlu.mvc.modelo.Tarea;
import ar.edu.unlu.mvc.vista.VistaConsola;

public class Controlador implements Observer {
	
	private AdministradorDeTareas modelo;
	private VistaConsola vista;
	
	public Controlador(AdministradorDeTareas administradorDeTareas, VistaConsola vista) {
		this.modelo = administradorDeTareas;
	}
	
	@Override
	public void update(Observado observado, String info) {
		if(info.equals("tarea-creada-modificada\"")) {
			vista.mostrarTarea(observado);
		} else if(info.equals("nueva-lista")) {
			vista.listarTarea();
		}
	}
	
	public void crearTarea(String titulo, String descripcion) {
		modelo.crearTarea(titulo, descripcion);
	}

	public LinkedList<Tarea> obtenerListaDeTarea() {
		return modelo.getTareas();
	}

	public void eliminarTarea(int id) {
		modelo.borrarTarea(id);
	}

	public void marcarCompleta(int id) {
		modelo.completarTarea(id);
	}
	
}
