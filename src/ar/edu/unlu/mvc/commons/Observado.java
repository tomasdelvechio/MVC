package ar.edu.unlu.mvc.commons;

public interface Observado {
	void notificarObservers();
	void agregarObservador(Observer o);
}
