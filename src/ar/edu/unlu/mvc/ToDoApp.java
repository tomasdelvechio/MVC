package ar.edu.unlu.mvc;

import ar.edu.unlu.mvc.controlador.Controlador;
import ar.edu.unlu.mvc.modelo.AdministradorDeTareas;
import ar.edu.unlu.mvc.vista.VistaConsola;

public class ToDoApp {
    public static void main(String[] args) {
        AdministradorDeTareas modelo = new AdministradorDeTareas();
        VistaConsola vista = new VistaConsola();
        Controlador obs = new Controlador(modelo, vista);
        vista.setControlador(obs);
        vista.iniciar();
    }
}
