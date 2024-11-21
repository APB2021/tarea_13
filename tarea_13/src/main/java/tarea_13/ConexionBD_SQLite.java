package tarea_13;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta clase gestiona la conexión a la base de datos SQLite.
 * Permite obtener una conexión a la base de datos seleccionada por el usuario.
 */
public class ConexionBD_SQLite {

    /**
     * Método para obtener la conexión a la base de datos SQLite.
     * La conexión se establece utilizando la URL de la base de datos proporcionada.
     *
     * @param urlDb La URL de la base de datos a la que se debe conectar.
     * @return La conexión a la base de datos, o null si ocurre un error.
     */
    public static Connection conectar(String urlDb) {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(urlDb);
        } catch (Exception e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        }
        return conexion;
    }
}
