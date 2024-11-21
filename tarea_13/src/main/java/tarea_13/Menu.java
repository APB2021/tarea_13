package tarea_13;

import java.util.Scanner;

/**
 * Clase que maneja el menú interactivo de la aplicación.
 */
public class Menu {

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Crear tablas al inicio
        //GestorBD_SQLite.crearTablas();

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar Departamento");
            System.out.println("2. Insertar Empleado");
            System.out.println("3. Mostrar Departamentos");
            System.out.println("4. Mostrar Empleados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del Departamento: ");
                    String dnombre = sc.nextLine();
                    System.out.print("Localidad: ");
                    String localidad = sc.nextLine();
                    GestorBD_SQLite.insertarDepartamento(dnombre, localidad);
                    break;

                case 2:
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Puesto: ");
                    String puesto = sc.nextLine();
                    System.out.print("Fecha de alta (yyyy-MM-dd): ");
                    String fechaAlta = sc.nextLine();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    System.out.print("Variable: ");
                    double variable = sc.nextDouble();
                    System.out.print("Departamento (ID): ");
                    int dept = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea
                    GestorBD_SQLite.insertarEmpleado(apellido, puesto, fechaAlta, salario, variable, dept);
                    break;

                case 3:
                    GestorBD_SQLite.mostrarDepartamentos();
                    break;

                case 4:
                    GestorBD_SQLite.mostrarEmpleados();
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
