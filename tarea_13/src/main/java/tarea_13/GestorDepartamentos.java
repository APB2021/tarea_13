package tarea_13;

import java.sql.*;
import java.util.Scanner;

public class GestorDepartamentos {

	private static Scanner sc = new Scanner(System.in);

	public void insertarDepartamento(Connection conexion) {

		System.out.print("Nombre del Departamento: ");
		String nombreDepartamento = sc.nextLine();
		System.out.print("Localidad: ");
		String localidad = sc.nextLine();

		String sql = "INSERT INTO Departamento (dnombre, localidad) VALUES (?, ?)";

		try {

			PreparedStatement sentencia = conexion.prepareStatement(sql);

			sentencia.setString(1, nombreDepartamento);
			sentencia.setString(2, localidad);
			sentencia.executeUpdate();
			System.out.println("Departamento insertado con éxito.");
		} catch (SQLException e) {
			System.out.println("Error al insertar departamento: " + e.getMessage());
		}
	}

	public void mostrarDepartamentos(Connection conexion) {

		String sql = "SELECT * FROM Departamento";

		try {

			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(sql);

			while (resultado.next()) {

				System.out.println("Departamento Nº: " + resultado.getInt("dept_no") + ", Nombre: "
						+ resultado.getString("dnombre") + ", Localidad: " + resultado.getString("localidad"));
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar departamentos: " + e.getMessage());
		}
	}
}
