package ar.edu.unlu.mvc.modelo;

import java.util.LinkedList;

import ar.edu.unlu.mvc.commons.Observer;
import ar.edu.unlu.mvc.commons.TareaObservada;

public class Tarea implements TareaObservada{
	private static int id = 0;
	private int idTarea;
	private String titulo;
	private String descripcion;
	private LinkedList<Observer> observadores = new LinkedList<Observer>();
	private boolean completa = false;
	
	public Tarea(String titulo, String descripcion) {
		this.idTarea = id++;
		this.descripcion = descripcion;
		this.titulo = titulo;
	}

	public int getId() {
		return this.idTarea;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public void marcarCompleta() {
		this.completa  = true;
		this.notificarObservers();
	}

	public boolean isCompleta() {
		return completa;
	}
	
	
}
