package es.uji.ei1027.SkillSharing.Model;

public class Usuario {
    String username;
    String password;
    String tipo;

    public Usuario(){

    }
    public Usuario(String username, String password, String tipo){
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
