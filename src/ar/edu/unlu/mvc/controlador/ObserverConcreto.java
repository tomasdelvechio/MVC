package ar.edu.unlu.mvc.controlador;

import java.util.LinkedList;

import ar.edu.unlu.mvc.modelo.AdministradorDeTareas;
import ar.edu.unlu.mvc.modelo.Observado;
import ar.edu.unlu.mvc.modelo.Tarea;
import ar.edu.unlu.mvc.vista.VistaConsola;

public class ObserverConcreto implements Observer {
	
	private AdministradorDeTareas modelo;
	private VistaConsola vista;
	
	public ObserverConcreto(AdministradorDeTareas administradorDeTareas, VistaConsola vista) {
		this.modelo = administradorDeTareas;
	}

	
	public static void main (String[] args) {
		AdministradorDeTareas modelo = new AdministradorDeTareas();
		VistaConsola vista = new VistaConsola();
		ObserverConcreto obs = new ObserverConcreto(modelo,vista);
		vista.setControlador(obs);
		vista.iniciar();
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
