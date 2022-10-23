package ar.edu.unlu.mvc.modelo;

import java.util.LinkedList;

import ar.edu.unlu.mvc.commons.AdministradorDeTareasObservada;
import ar.edu.unlu.mvc.commons.Observer;

public class AdministradorDeTareas implements AdministradorDeTareasObservada {
	
	private LinkedList<Tarea> tareas = new LinkedList<Tarea>();
	private LinkedList<Observer> observadores = new LinkedList<Observer>();
	
	public void crearTarea(String titulo, String descripcion) {
		Tarea tareaNueva = new Tarea(titulo,descripcion);
		tareas.add(tareaNueva);
		this.notificarObservers();
	}
	
	public void borrarTarea(int id) {	
		tareas.remove(this.buscarTareaPorID(id));
		this.notificarObservers();
	}
	
	public Tarea buscarTareaPorID(int id) {
		for(Tarea t : this.tareas) {
			if (t.getId() == id) return t;
		}
		return null;
	}
	
	public LinkedList<Tarea> getTareas(){
		return this.tareas;
	}

	public void completarTarea(int id) {
		this.buscarTareaPorID(id).marcarCompleta();
	}
	
	@Override
	public void notificarObservers() {
		for(Observer o : this.observadores)
			o.update(this);
	}

	@Override
	public void agregarObservador(Observer o) {
		this.observadores.add(o);
	}

}
