package tarea_13;

import java.sql.*;
import java.util.Scanner;

public class GestorEmpleados {

	private static Scanner sc = new Scanner(System.in);

	public void insertarEmpleado(Connection conexion) {

		System.out.print("Apellido: ");
		String apellido = sc.nextLine();
		System.out.print("Puesto: ");
		String puesto = sc.nextLine();
		System.out.print("Fecha de alta (aaaa-mm-dd): ");
		String fechaAlta = sc.nextLine();
		System.out.print("Salario: ");
		double salario = sc.nextDouble();
		System.out.print("Variable: ");
		double variable = sc.nextDouble();
		System.out.print("Nº Departamento: ");
		int dept = sc.nextInt();
		// Limpiar el buffer:
		sc.nextLine();

		String sql = "INSERT INTO Empleados (apellido, puesto, fecha_alta, salario, variable, dept) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			
			sentencia.setString(1, apellido);
			sentencia.setString(2, puesto);
			sentencia.setString(3, fechaAlta);
			sentencia.setDouble(4, salario);
			sentencia.setDouble(5, variable);
			sentencia.setInt(6, dept);
			sentencia.executeUpdate();
			System.out.println("Empleado insertado con éxito.");
		} catch (SQLException e) {
			System.out.println("Error al insertar empleado: " + e.getMessage());
		}
	}

	public void mostrarEmpleados(Connection conexion) {
		
		String sql = "SELECT * FROM Empleados";
		
		try {
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(sql);
			while (resultado.next()) {
				System.out.println("Empleado Nº: " + resultado.getInt("empl_no") + ", Apellido: "
						+ resultado.getString("apellido") + ", Puesto: " + resultado.getString("puesto")
						+ ", Fecha Alta: " + resultado.getString("fecha_alta") + ", Salario: "
						+ resultado.getDouble("salario") + ", Variable: " + resultado.getDouble("variable")
						+ ", Dept No: " + resultado.getInt("dept"));
			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar empleados: " + e.getMessage());
		}
	}
}