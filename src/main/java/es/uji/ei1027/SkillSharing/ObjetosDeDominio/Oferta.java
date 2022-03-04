package es.uji.ei1027.SkillSharing.ObjetosDeDominio;

import java.util.Date;

public class Oferta {
    private String codigo_oferta;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String descripcion;
    private String dni_alumno;
    private String codigo_habilidad;

    public Oferta() {
    }

    public String getCodigo_oferta() {
        return codigo_oferta;
    }

    public void setCodigo_oferta(String codigo) {
        this.codigo_oferta = codigo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date d) {
        this.fecha_inicio = d;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date d) {
        this.fecha_fin = d;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    public String getDni_alumno() {
        return dni_alumno;
    }

    public void setDni_alumno(String dni) {
        this.dni_alumno = dni;
    }

    public String getCodigo_habilidad() {
        return codigo_habilidad;
    }

    public void setCodigo_habilidad(String codigo) {
        this.codigo_habilidad = codigo;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "codigo_oferta='" + codigo_oferta + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", descripcion='" + descripcion + '\'' +
                ", dni_alumno='" + dni_alumno + '\'' +
                ", codigo_habilidad='" + codigo_habilidad + '\'' +
                '}';
    }
}
