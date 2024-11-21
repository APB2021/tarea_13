package tarea_13;

import java.sql.*;

/**
 * Esta clase gestiona las operaciones relacionadas con la tabla Departamento.
 * Permite insertar nuevos departamentos y mostrar los existentes en la base de datos.
 */
public class GestorDepartamentos {

    // Ruta fija de la base de datos
    private static final String URL_DB = "jdbc:sqlite:tarea_13.db";

    /**
     * Método para insertar un nuevo departamento en la base de datos.
     * 
     * @param dnombre   El nombre del departamento.
     * @param localidad La localidad del departamento.
     */
    public static void insertarDepartamento(String dnombre, String localidad) {
        String sql = "INSERT INTO Departamento (dnombre, localidad) VALUES (?, ?)";
        try (Connection conn = ConexionBD_SQLite.conectar(URL_DB); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dnombre);
            pstmt.setString(2, localidad);
            pstmt.executeUpdate();
            System.out.println("Departamento insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar departamento: " + e.getMessage());
        }
    }

    /**
     * Método para mostrar todos los departamentos existentes en la base de datos.
     */
    public static void mostrarDepartamentos() {
        String sql = "SELECT * FROM Departamento";
        try (Connection conn = ConexionBD_SQLite.conectar(URL_DB); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Dept No: " + rs.getInt("dept_no") + ", Nombre: " + rs.getString("dnombre")
                        + ", Localidad: " + rs.getString("localidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar departamentos: " + e.getMessage());
        }
    }
}
