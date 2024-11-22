package tarea_13;

import java.sql.Connection;
import java.util.Scanner;

public class Menu {

	private static final Scanner sc = new Scanner(System.in);

	ConexionBD_SQLite conexionBDSQLite = new ConexionBD_SQLite();
	GestorDepartamentos gestorDepartamentos = new GestorDepartamentos();
	GestorEmpleados gestorEmpleados = new GestorEmpleados();

	public void mostrarMenu() {

		// Establecer conexión a la base de datos
		Connection conexion = conexionBDSQLite.obtenerConexion();
		if (conexion == null) {
			System.out.println("No se pudo conectar a la base de datos. Cerrando la aplicación.");
			return;
		}

		int opcionSeleccionada; // Almacena la opción elegida por el usuario

		String textoMenu = """
				==========================
				    MENÚ PRINCIPAL
				==========================
				1. Insertar Departamento.
				2. Insertar Empleado.
				3. Mostrar Departamentos.
				4. Mostrar Empleados.
				5. Salir.
				==========================
				Seleccione una opción:
				""";

		do {
			System.out.print(textoMenu); // Mostrar el menú al usuario

			// Leer opción seleccionada por usuario:
			opcionSeleccionada = sc.nextInt();

			// Limpiar el buffer
			sc.nextLine();

			switch (opcionSeleccionada) {
			case 1 -> {
				System.out.println("===================================");
				System.out.println("Inserción de un nuevo Departamento:");
				System.out.println("===================================");
				gestorDepartamentos.insertarDepartamento(conexion);
			}
			case 2 -> {
				System.out.println("===============================");
				System.out.println("Inserción de un nuevo Empleado:");
				gestorEmpleados.insertarEmpleado(conexion);
				System.out.println("===============================");
			}
			case 3 -> {
				System.out.println("=======================");
				System.out.println("Lista de Departamentos:");
				System.out.println("=======================");
				gestorDepartamentos.mostrarDepartamentos(conexion);
			}
			case 4 -> {
				System.out.println("===================");
				System.out.println("Lista de Empleados:");
				System.out.println("===================");
				gestorEmpleados.mostrarEmpleados(conexion);
			}
			case 5 -> {
				System.out.println("===============================");
				System.out.println("Gracias por usar la aplicación.");
				System.out.println("===============================");
				conexionBDSQLite.cerrarConexion(conexion);

			}
			default -> {
				System.out.println("================================================");
				System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
				System.out.println("================================================");
			}
			}
		} while (opcionSeleccionada != 5); // Repetir hasta que el usuario elija salir
	}
}