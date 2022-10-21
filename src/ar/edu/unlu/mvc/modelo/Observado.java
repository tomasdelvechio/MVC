package ar.edu.unlu.mvc.modelo;

import ar.edu.unlu.mvc.controlador.Observer;

public interface Observado {
	void notificarObservers();
	void agregarObservador(Observer o);
}
