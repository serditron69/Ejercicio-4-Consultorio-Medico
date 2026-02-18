package org.example.Service;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import java.util.ArrayList;
import java.util.List;

public class CitaServiceImpl implements CitaService {

    private List<Cita> citas = new ArrayList<>();
    private Long contadorId = 1L;

    @Override
    public Cita registrarCita(Long id, String paciente, String fecha){

        Cita nuevaCita = new Cita(contadorId++, paciente, fecha);
        citas.add(nuevaCita);
        return nuevaCita;
    }

    @Override
    public List<Cita> listarCitas() {
        return citas;
    }

    @Override
    public void cambiarEstado(Cita cita, EstadoCita nuevoEstado){
        if (cita.getEstado() == EstadoCita.CANCELADA && nuevoEstado == EstadoCita.ATENDIDA){
            throw new IllegalStateException("no se puede atender una cita cancelada");
        }
        if (cita.getEstado() == EstadoCita.ATENDIDA){
            throw new IllegalStateException("no se puede cambiar el estado de una cita atendida");

        }
        cita.setEstado(nuevoEstado);
    }

    @Override
    public void eliminarCita(Cita cita){
        citas.remove(cita);
    }

    @Override
    public Cita buscarCitaPorId(Long id){
        for (Cita cita : citas){
            if (cita.getId().equals(id)){
                return cita;
            }
        }
        return null;
    }
}
