package ar.edu.unlu.mvc.vista;

import java.util.LinkedList;
import java.util.Scanner;

import ar.edu.unlu.mvc.commons.Observado;
import ar.edu.unlu.mvc.controlador.Controlador;
import ar.edu.unlu.mvc.modelo.Tarea;

public class VistaConsola {

	private Controlador controlador;
	private OpcionesMenu opcion = OpcionesMenu.INICIO;

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void mostrarMenu() {
		OpcionesMenu.mostrarOpciones();
	}

	public void iniciar() {
		try (Scanner sc = new Scanner(System.in)) {
			while (opcion != OpcionesMenu.SALIR) {
				mostrarMenu();
				opcion = OpcionesMenu.values()[sc.nextInt()];
				switch (opcion) {
					case CREAR_TAREA:
						crearTarea();
						break;
					case LISTAR_TAREA:
						listarTarea();
						break;
					case MARCAR_TAREA_COMPLETA:
						marcarTareaComoCompletada();
						break;
					case ELIMINAR_TAREA:
						eliminarTarea();
						break;
					default:
						break;
				}
			}
		}
	}

	private void crearTarea() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("ingrese un titulo");
			String titulo = sc.nextLine();
			System.out.println("ingrese una descripcion");
			String descripcion = sc.nextLine();
			controlador.crearTarea(titulo, descripcion);
			System.out.println("Tarea creada..");
		}
	}

	public void listarTarea() {
		LinkedList<Tarea> tareas = controlador.obtenerListaDeTarea();
		for (Tarea t : tareas)
			this.mostrarTarea(t);
	}

	private void eliminarTarea() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("ingrese el id de la tarea a eliminar");
			int id = sc.nextInt();
			controlador.eliminarTarea(id);
			System.out.println("Tarea eliminada..");
		}
	}

	private void marcarTareaComoCompletada() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("ingrese el id de la tarea a marcar como completa");
			int id = sc.nextInt();
			controlador.marcarCompleta(id);
			System.out.println("Tarea modificada..");
		}
	}

	public void mostrarTarea(Observado observado) {
		System.out.println("TAREA: " + ((Tarea) observado).getId() + "--------------------------------");
		System.out.println("Titulo: " + ((Tarea) observado).getTitulo());
		System.out.println("Descripcion: " + ((Tarea) observado).getDescripcion());
		System.out.println("completa?: " + ((Tarea) observado).isCompleta());
		System.out.println("-------------------------------------");
	}

}
