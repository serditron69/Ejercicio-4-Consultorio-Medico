package org.example.Controller;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.View.CitaView;
import java.util.List;

public class CitaController {

    private final CitaService service;
    private final CitaView view;

    public CitaController(CitaService service, CitaView view){
        this.service = service;
        this.view = view;
    }

    public Cita registrarCita(String paciente, String fecha){
        Cita cita = service.registrarCita(null, paciente, fecha);
        view.mostrarMensaje("Cita Registrada - ID: " + cita.getId() + " Estado: " + cita.getEstado());
        return cita;
    }

    public void listarCitas(){
        List<Cita> citas = service.listarCitas();
        view.mostrarCitas(citas);
    }

    public void mostrarCitaPorId(Long id){
        Cita cita = service.buscarCitaPorId(id);
        if (cita != null){
            view.mostrarCita(cita);
        }else {
            view.mostrarMensaje("no se encontrol cita con ID: " + id);
        }
    }

    public void cambiarEstado(Long id, EstadoCita nuevoEstado){
        Cita cita = service.buscarCitaPorId(id);
        if (cita != null){
            try{
                service.cambiarEstado(cita, nuevoEstado);
                view.mostrarMensaje("estado cambiado a: " + nuevoEstado);
            } catch (IllegalStateException e){
                view.mostrarMensaje("Error: " + e.getMessage());
            }
        } else {
            view.mostrarMensaje("No se encontro cita con ID: " + id);
        }
    }

    public void eliminarCita(Long id){
        Cita cita = service.buscarCitaPorId(id);
        if (cita != null){
            service.eliminarCita(cita);
            view.mostrarMensaje("Cita eliminada");
        }else {
            view.mostrarMensaje("No se encontro cita con ID: " + id);
        }
    }
}
