package ar.edu.unlu.mvc.controlador;

import java.util.LinkedList;

import ar.edu.unlu.mvc.commons.AdministradorDeTareasObservada;
import ar.edu.unlu.mvc.commons.Observado;
import ar.edu.unlu.mvc.commons.Observer;
import ar.edu.unlu.mvc.commons.TareaObservada;
import ar.edu.unlu.mvc.modelo.AdministradorDeTareas;
import ar.edu.unlu.mvc.modelo.Tarea;
import ar.edu.unlu.mvc.vista.VistaConsola;

public class Controlador implements Observer {
	
	private AdministradorDeTareas modelo;
	private VistaConsola vista;
	
	public Controlador(AdministradorDeTareas administradorDeTareas, VistaConsola vista) {
		this.modelo = administradorDeTareas;
		this.vista = vista;
	}

	public void update(TareaObservada observado) {
		vista.mostrarTarea(observado);
	}

	public void update(AdministradorDeTareasObservada observado) {
		vista.listarTarea();
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

	@Override
	public void update(Observado observado) {
		// No usar
	}
	
}
