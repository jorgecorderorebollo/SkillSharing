package es.uji.ei1027.SkillSharing.ObjetosDeDominio;

public class Estudiante {

    private String dni_alumno;
    private String nombre_completo;
    private String email;
    private String password;
    private Boolean baneado;

    public Estudiante() {
    }

    public String getDni_alumno() {
        return dni_alumno;
    }

    public void setDni_alumno(String dni) {
        this.dni_alumno = dni;
    }

    public String getNumFederat() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre) {
        this.nombre_completo = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String ps) {
        this.password = ps;
    }

    public Boolean getBaneado() {
        return baneado;
    }

    public void setBaneado(Boolean ban) {
        this.baneado = ban;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "dni_alumno='" + dni_alumno + "\'" +
                ", nombre_completo='" + nombre_completo + "\'" +
                ", email='" + email + "\'" +
                ", password=" + password +
                ", baneado='" + baneado + "\'" +
                "}";
    }
}
