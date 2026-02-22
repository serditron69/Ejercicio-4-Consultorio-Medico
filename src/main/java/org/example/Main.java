package org.example;

import org.example.Controller.CitaController;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.Service.CitaServiceImpl;
import org.example.View.CitaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CitaService service = new CitaServiceImpl();
        CitaView view = new CitaView();
        CitaController controller = new CitaController(service, view);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== SISTEMA DE CITAS MÉDICAS ===");
            System.out.println("1. Registrar cita");
            System.out.println("2. Listar citas");
            System.out.println("3. Cambiar estado de cita");
            System.out.println("4. Eliminar cita");
            System.out.println("5. Buscar cita por ID");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    controller.registrarCita(nombre, fecha);
                    break;

                case 2:
                    controller.listarCitas();
                    break;

                case 3:
                    System.out.print("ID de la cita: ");
                    Long idCambio = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Estados disponibles: PROGRAMADA, CANCELADA, ATENDIDA");
                    System.out.print("Nuevo estado: ");
                    String estadoStr = scanner.nextLine().toUpperCase();
                    try {
                        EstadoCita nuevoEstado = EstadoCita.valueOf(estadoStr);
                        controller.cambiarEstado(idCambio, nuevoEstado);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Estado no válido");
                    }
                    break;

                case 4:
                    System.out.print("ID de la cita a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    controller.eliminarCita(idEliminar);
                    break;

                case 5:
                    System.out.print("ID de la cita a buscar: ");
                    Long idBuscar = scanner.nextLong();
                    controller.mostrarCitaPorId(idBuscar);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 6);

        scanner.close();
    }
}