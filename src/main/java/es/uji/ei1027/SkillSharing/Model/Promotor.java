package es.uji.ei1027.SkillSharing.Model;

public class Promotor {
    private String dni_promotor;
    private String nombre_completo;
    private String email;
    private String password;

    public Promotor() {
    }

    public String getDni_promotor() {
        return dni_promotor;
    }

    public void setDni_promotor(String dni) {
        this.dni_promotor = dni;
    }

    public String getNombre_completo() {
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

    @Override
    public String toString() {
        return "Promotor{" +
                "dni_promotor='" + dni_promotor + '\'' +
                ", nombre_completo='" + nombre_completo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
