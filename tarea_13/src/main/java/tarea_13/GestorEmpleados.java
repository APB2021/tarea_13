package tarea_13;

import java.sql.*;

/**
 * Esta clase gestiona las operaciones relacionadas con la tabla Empleados.
 * Permite insertar nuevos empleados y mostrar los existentes en la base de datos.
 */
public class GestorEmpleados {

    // Ruta fija de la base de datos
    private static final String URL_DB = "jdbc:sqlite:tarea_13.db";

    /**
     * Método para insertar un nuevo empleado en la base de datos.
     * 
     * @param apellido  El apellido del empleado.
     * @param puesto    El puesto del empleado.
     * @param fechaAlta La fecha de alta del empleado.
     * @param salario   El salario del empleado.
     * @param variable  La parte variable del salario del empleado.
     * @param dept      El identificador del departamento al que pertenece el empleado.
     */
    public static void insertarEmpleado(String apellido, String puesto, String fechaAlta, double salario,
            double variable, int dept) {
        String sql = "INSERT INTO Empleados (apellido, puesto, fecha_alta, salario, variable, dept) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD_SQLite.conectar(URL_DB); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, apellido);
            pstmt.setString(2, puesto);
            pstmt.setString(3, fechaAlta);
            pstmt.setDouble(4, salario);
            pstmt.setDouble(5, variable);
            pstmt.setInt(6, dept);
            pstmt.executeUpdate();
            System.out.println("Empleado insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    /**
     * Método para mostrar todos los empleados existentes en la base de datos.
     */
    public static void mostrarEmpleados() {
        String sql = "SELECT * FROM Empleados";
        try (Connection conn = ConexionBD_SQLite.conectar(URL_DB); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Empleado No: " + rs.getInt("empl_no") + ", Apellido: " + rs.getString("apellido")
                        + ", Puesto: " + rs.getString("puesto") + ", Fecha Alta: " + rs.getString("fecha_alta")
                        + ", Salario: " + rs.getDouble("salario") + ", Variable: " + rs.getDouble("variable")
                        + ", Dept No: " + rs.getInt("dept"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar empleados: " + e.getMessage());
        }
    }
}
