package tarea_13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD_SQLite {

	private static final String BASE_DE_DATOS_SQLITE = "jdbc:sqlite:tarea_13.db";

	public Connection obtenerConexion() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(BASE_DE_DATOS_SQLITE);
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión: " + e.getMessage());
		}
		return conexion;
	}

	public void cerrarConexion(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
				System.out.println("Conexión cerrada correctamente.");
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión: " + e.getMessage());
			}
		} else {
			System.out.println("La conexión ya está cerrada o es nula.");
		}
	}
}
