package tarea_13;

import java.sql.*;

/**
 * Esta clase gestiona las operaciones relacionadas con la base de datos SQLite.
 * Incluye la conexión, la creación de tablas, y las inserciones y consultas.
 */
public class GestorBD_SQLite {

    // Ruta fija de la base de datos
    private static final String URL_DB = "jdbc:sqlite:tarea_13.db";

    /**
     * Crea las tablas Departamento y Empleados si no existen.
     */
    public static void crearTablas() {
        String sqlDept = """
            CREATE TABLE IF NOT EXISTS Departamento (
                dept_no INTEGER PRIMARY KEY AUTOINCREMENT,
                dnombre TEXT(15) NOT NULL,
                localidad TEXT(15) NOT NULL
            );
            """;

        String sqlEmp = """
            CREATE TABLE IF NOT EXISTS Empleados (
                empl_no INTEGER PRIMARY KEY AUTOINCREMENT,
                apellido TEXT(10) NOT NULL,
                puesto TEXT(10) NOT NULL,
                fecha_alta DATE NOT NULL,
                salario REAL NOT NULL,
                variable REAL NOT NULL,
                dept INTEGER NOT NULL,
                FOREIGN KEY (dept) REFERENCES Departamento(dept_no)
            );
            """;

        try (Connection conn = ConexionBD_SQLite.conectar(URL_DB); 
             Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(sqlDept);
                stmt.execute(sqlEmp);
                System.out.println("Tablas creadas o ya existentes.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear tablas: " + e.getMessage());
        }
    }

    /**
     * Inserta un nuevo departamento en la base de datos.
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
     * Inserta un nuevo empleado en la base de datos.
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
     * Muestra todos los departamentos registrados en la base de datos.
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

    /**
     * Muestra todos los empleados registrados en la base de datos.
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
