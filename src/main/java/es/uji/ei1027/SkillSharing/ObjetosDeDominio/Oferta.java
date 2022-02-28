package es.uji.ei1027.SkillSharing.ObjetosDeDominio;

import java.util.Date;

public class Oferta {
    private String codigo_oferta;
    private Date startdate;
    private Date enddate;
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date d) {
        this.startdate = d;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date d) {
        this.enddate = d;
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
                "codigo_habilidad='" + codigo_habilidad + "\'" +
                ", codigo_oferta='" + codigo_oferta + "\'" +
                ", startdate='" + startdate + "\'" +
                ", enddate='" + enddate + "\'" +
                ", descripcion='" + descripcion + "\'" +
                ", dni_alumno='" + dni_alumno + "\'" +
                ", codigo_habilidad='" + codigo_habilidad + "\'" +
                "}";
    }
}
