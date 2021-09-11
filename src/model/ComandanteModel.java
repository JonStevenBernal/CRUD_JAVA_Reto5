package model;

public class ComandanteModel {
    private int codigoComandante;
    private String nombreComandante;
    private String apellidoComandante;
    private int anioServicioComandante;
    private String escuelaComandante;
    private String fechaIngresoComandante;

    /**
     *
     * @param codigoComandante
     * @param nombreComandante
     * @param apellidoComandante
     * @param anioServicioComandante
     * @param escuelaComandante
     * @param fechaIngresoComandante
     */

    public ComandanteModel(int codigoComandante, String nombreComandante, String apellidoComandante, int anioServicioComandante, String escuelaComandante, String fechaIngresoComandante) {
        this.codigoComandante = codigoComandante;
        this.nombreComandante = nombreComandante;
        this.apellidoComandante = apellidoComandante;
        this.anioServicioComandante = anioServicioComandante;
        this.escuelaComandante = escuelaComandante;
        this.fechaIngresoComandante = fechaIngresoComandante;
    }

    public ComandanteModel(String nombreComandante, String apellidoComandante, int anioServicioComandante, String escuelaComandante, String fechaIngresoComandante) {
        this.nombreComandante = nombreComandante;
        this.apellidoComandante = apellidoComandante;
        this.anioServicioComandante = anioServicioComandante;
        this.escuelaComandante = escuelaComandante;
        this.fechaIngresoComandante = fechaIngresoComandante;
    }

    public int getCodigoComandante() {
        return codigoComandante;
    }

    public String getNombreComandante() {
        return nombreComandante;
    }

    public String getApellidoComandante() {
        return apellidoComandante;
    }

    public int getAnioServicioComandante() {
        return anioServicioComandante;
    }

    public String getEscuelaComandante() {
        return escuelaComandante;
    }

    public String getFechaIngresoComandante() {
        return fechaIngresoComandante;
    }

    public void setCodigoComandante(int codigoComandante) {
        this.codigoComandante = codigoComandante;
    }

    public void setNombreComandante(String nombreComandante) {
        this.nombreComandante = nombreComandante;
    }

    public void setApellidoComandante(String apellidoComandante) {
        this.apellidoComandante = apellidoComandante;
    }

    public void setAnioServicioComandante(int anioServicioComandante) {
        this.anioServicioComandante = anioServicioComandante;
    }

    public void setEscuelaComandante(String escuelaComandante) {
        this.escuelaComandante = escuelaComandante;
    }

    public void setFechaIngresoComandante(String fechaIngresoComandante) {
        this.fechaIngresoComandante = fechaIngresoComandante;
    }


    public Object[] toArray(){
        Object[] data = {codigoComandante, nombreComandante, apellidoComandante, anioServicioComandante, escuelaComandante, fechaIngresoComandante};
        return data;
    }


    public String toString() {
        return this.nombreComandante;
    }

    /*
    public String toString() {
        String codigo = Integer.toString(this.codigoComandante);
        return codigo;
    }

     */

}
