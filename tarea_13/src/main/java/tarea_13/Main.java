package tarea_13;

/**
 * Clase principal que inicia la aplicación.
 * Esta clase solo se encarga de llamar al menú interactivo.
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     * Llama al menú interactivo para que el usuario seleccione o cree una base de datos y realice acciones sobre ella.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Llamamos al menú para que el usuario seleccione o cree una base de datos
        Menu.mostrarMenu();
    }
}
