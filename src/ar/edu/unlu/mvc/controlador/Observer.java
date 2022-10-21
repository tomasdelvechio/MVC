package ar.edu.unlu.mvc.controlador;

import ar.edu.unlu.mvc.modelo.Observado;

public interface Observer {
	void update(Observado observado, String info);
}
