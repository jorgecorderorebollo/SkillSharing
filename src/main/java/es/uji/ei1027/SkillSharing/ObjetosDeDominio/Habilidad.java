package es.uji.ei1027.SkillSharing.ObjetosDeDominio;

public class Habilidad {
    private String codigo_habilidad;
    private String nombre;
    private String descripcion;
    private String nivel;

    public Habilidad() {
    }

    public String getCodigo_habilidad() {
        return codigo_habilidad;
    }

    public void setCodigo_habilidad(String codigo) {
        this.codigo_habilidad = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String d) {
        this.descripcion = d;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String e) {
        this.nivel = e;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "codigo_habilidad='" + codigo_habilidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
