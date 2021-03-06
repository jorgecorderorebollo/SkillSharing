package es.uji.ei1027.SkillSharing.Model;

import java.util.Date;

public class Colaboracion {
    private String codigo_colaboracion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private float horas;
    private String evaluacion;
    private String codigo_oferta;
    private String codigo_solicitud;

    public Colaboracion() {
    }

    public String getCodigo_colaboracion() {
        return codigo_colaboracion;
    }

    public void setCodigo_colaboracion(String codigo) {
        this.codigo_colaboracion = codigo;
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

    public float getHoras() {
        return horas;
    }

    public void setHoras(float h) {
        this.horas = h;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String e) {
        this.evaluacion = e;
    }

    public String getCodigo_oferta() {
        return codigo_oferta;
    }

    public void setCodigo_oferta(String codigo) {
        this.codigo_oferta = codigo;
    }

    public String getCodigo_solicitud() {
        return codigo_solicitud;
    }

    public void setCodigo_solicitud(String codigo) {
        this.codigo_solicitud = codigo;
    }

    @Override
    public String toString() {
        return "Colaboracion{" +
                "codigo_colaboracion='" + codigo_colaboracion + '\'' +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", horas=" + horas +
                ", evaluacion='" + evaluacion + '\'' +
                ", codigo_oferta='" + codigo_oferta + '\'' +
                ", codigo_solicitud='" + codigo_solicitud + '\'' +
                '}';
    }
}
