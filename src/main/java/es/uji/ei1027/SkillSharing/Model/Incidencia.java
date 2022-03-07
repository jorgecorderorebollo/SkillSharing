package es.uji.ei1027.SkillSharing.Model;

public class Incidencia {
    private String dni_alumno;
    private String dni_promotor;
    private String nombre_alumno;
    private String nombre_promotor;
    private String descripcion;

    public Incidencia() {
    }
    public String getDni_alumno() {
        return dni_alumno;
    }

    public void setDni_alumno(String dni) {
        this.dni_alumno = dni;
    }

    public String getDni_promotor() {
        return dni_promotor;
    }

    public void setDni_promotor(String dni) {
        this.dni_promotor = dni;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre) {
        this.nombre_alumno = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre_promotor() {
        return nombre_promotor;
    }

    public void setNombre_promotor(String nombre) {
        this.nombre_promotor = nombre;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "dni_alumno='" + dni_alumno + '\'' +
                ", dni_promotor='" + dni_promotor + '\'' +
                ", nombre_alumno='" + nombre_alumno + '\'' +
                ", nombre_promotor='" + nombre_promotor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
