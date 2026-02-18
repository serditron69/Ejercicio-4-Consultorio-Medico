package org.example.View;

import org.example.Model.Cita;
import java.util.List;

public class CitaView {

    public void mostrarCita(Cita cita) {
        System.out.println("------------CITA------------");
        System.out.println("ID: " + cita.getId());
        System.out.println("Paciente: " + cita.getNombrePaciente());
        System.out.println("Fecha: " + cita.getFecha());
        System.out.println("Estado: " + cita.getEstado());
    }

    public void mostrarCitas(List<Cita> citas){
        System.out.println("----------Listas de citas----------");
        for (Cita cita : citas){
            System.out.println("ID: " + cita.getId() + " | Paciente: " + cita.getNombrePaciente() + " | Fecha: " + cita.getFecha() + " | Estado: " + cita.getEstado());
        }
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);

    }
}
