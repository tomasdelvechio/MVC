package ar.edu.unlu.mvc.vista;

public enum OpcionesMenu {
    INICIO (0, ""),
    CREAR_TAREA (1, "1) crear tarea"),
    LISTAR_TAREA (2, "2) listar tareas"),
    MARCAR_TAREA_COMPLETA (3, "3) marcar tarea como completada"),
    ELIMINAR_TAREA (4, "4) eliminar tarea"),
    SALIR (5, "5) salir");

    public final int opcion;
    public final String label;

    private OpcionesMenu(int opcion, String label) {
        this.opcion = opcion;
        this.label = label;
    }

    public static String valueOf(int opcion) {
        return OpcionesMenu.values()[opcion].label;
    }

    public static void mostrarOpciones() {
        for (OpcionesMenu e : OpcionesMenu.values()) {
            System.out.println(e.label);
        }
    }

}
