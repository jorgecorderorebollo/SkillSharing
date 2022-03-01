package es.uji.ei1027.SkillSharing.ObjetosDeDominio;

import java.util.Date;

public class Colaboracion {
    private String codigo_colaboracion;
    private Date startdate;
    private Date enddate;
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
                ", codigo_colaboracion='" + codigo_colaboracion + "\'" +
                ", startdate='" + startdate + "\'" +
                ", enddate='" + enddate + "\'" +
                ", horas='" + horas +
                ", evaluacion='" + evaluacion + "\'" +
                ", codigo_oferta='" + codigo_oferta + "\'" +
                ", codigo_solicitud='" + codigo_solicitud + "\'" +
                "}";
    }
}
