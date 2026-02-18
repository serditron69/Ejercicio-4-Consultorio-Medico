package org.example;

import org.example.Controller.CitaController;
import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.Service.CitaServiceImpl;
import org.example.View.CitaView;

public class Main {
    public static void main(String[] args) {

        CitaService service = new CitaServiceImpl();
        CitaView view = new CitaView();
        CitaController controller = new CitaController(service, view);

        Cita cita1 = controller.registrarCita("Sergio Juyo", "17-02-2026 ");
        Cita cita2 = controller.registrarCita("Pepito Perez", "17-02-2026 ");
        Cita cita3 = controller.registrarCita("Alejandro Castillo", "17-02-2026 ");


        controller.listarCitas();

        controller.mostrarCitaPorId(2L);

        controller.cambiarEstado(1L, EstadoCita.ATENDIDA);
        controller.cambiarEstado(2L, EstadoCita.CANCELADA);

        controller.cambiarEstado(2L, EstadoCita.ATENDIDA);

        controller.listarCitas();

        controller.eliminarCita(3L);

        controller.listarCitas();


    }
}