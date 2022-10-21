package ar.edu.unlu.mvc.vista;

import java.util.LinkedList;
import java.util.Scanner;

import ar.edu.unlu.mvc.controlador.ObserverConcreto;
import ar.edu.unlu.mvc.modelo.Observado;
import ar.edu.unlu.mvc.modelo.Tarea;

public class VistaConsola {
	
	private ObserverConcreto controlador;
	

	public void setControlador(ObserverConcreto controlador) {
		this.controlador = controlador;
	}
	
	public void mostrarMenu() {
		System.out.println("1) crear tarea");
		System.out.println("2) listar tareas");
		System.out.println("3) marcar tarea como completada");
		System.out.println("4) eliminar tarea");
		System.out.println("5) salir");
	}
	
	public void iniciar() {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 5) {
			mostrarMenu();
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:{
				crearTarea();
				break;
			}
			case 2:{
				listarTarea();
				break;
			}
			case 3:{
				marcarTareaComoCompletada();
				break;
			}
			case 4:{
				eliminarTarea();
				break;
			} default : break;
			
			}
		}
	}

	private void crearTarea() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ingrese un titulo");
		String titulo = sc.nextLine();
		System.out.println("ingrese una descripcion");
		String descripcion = sc.nextLine();
		controlador.crearTarea(titulo, descripcion);
		System.out.println("Tarea creada..");
	}
	
	public void listarTarea() {
		LinkedList<Tarea> tareas = controlador.obtenerListaDeTarea();
		for(Tarea t : tareas) 
			this.mostrarTarea(t);
		
	}

	private void eliminarTarea() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ingrese el id de la tarea a eliminar");
		int id = sc.nextInt();
		controlador.eliminarTarea(id);	
		System.out.println("Tarea eliminada..");
	}

	private void marcarTareaComoCompletada() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ingrese el id de la tarea a marcar como completa");
		int id = sc.nextInt();
		controlador.marcarCompleta(id);	
		System.out.println("Tarea modificada..");
	}

	public void mostrarTarea(Observado observado) {
		System.out.println("TAREA: "+((Tarea)observado).getId()+"--------------------------------");
		System.out.println("Titulo: "+ ((Tarea)observado).getTitulo());
		System.out.println("Descripcion: "+ ((Tarea)observado).getDescripcion());
		System.out.println("completa?: "+ ((Tarea)observado).isCompleta());
		System.out.println("-------------------------------------");
	}

	
}
