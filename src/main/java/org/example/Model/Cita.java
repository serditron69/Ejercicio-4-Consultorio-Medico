package org.example.Model;

public class Cita {

    private Long id;
    private String nombrePaciente;
    private String fecha;
    private EstadoCita estado;

    public Cita() {
    }

    public Cita(Long id, String nombrePaciente, String fecha) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.estado = EstadoCita.PROGRAMADA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                '}';
    }

    public void establecerFecha(String fecha){
        if (fecha != null && !fecha.isEmpty()){
            this.fecha = fecha;
        } else{
            throw new IllegalArgumentException("la fecha no puede estar vacia");
        }
    }

    public void establecerEstado(EstadoCita estado){
        this.estado = estado;
    }
}
