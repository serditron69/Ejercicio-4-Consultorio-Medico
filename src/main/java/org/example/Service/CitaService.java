package org.example.Service;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import java.util.List;

public interface CitaService {

    Cita registrarCita(Long id, String paciente, String fecha);
    List<Cita> listarCitas();
    void cambiarEstado(Cita cita, EstadoCita nuevoEstado);
    void eliminarCita(Cita cita);
    Cita buscarCitaPorId(Long id);
}
