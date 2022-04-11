package es.uji.ei1027.SkillSharing.Controller;

import javax.servlet.http.HttpSession;

import es.uji.ei1027.SkillSharing.Dao.UsuarioDao;
import es.uji.ei1027.SkillSharing.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping("/login")
    public String login(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(usuario != null){
            return calcularRedireccion(usuario);
        }
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("usuario") Usuario usuario,
                             BindingResult bindingResult, HttpSession session) {

        // Comprova que el login siga correcte
        // intentant carregar les dades de l'usuari

        Usuario aux = usuario;
        usuario = usuarioDao.getTipoCiutada(usuario.getUsername(), usuario.getPassword());
        if(usuario == null) {
            usuario = usuarioDao.getTipoGestor(aux.getUsername(), aux.getPassword());
            if(usuario == null){
                bindingResult.rejectValue("username", "badpw", "Usuari inexistent");
                return "login";
            }

        }

        Usuario user = usuarioDao.contrasenyaCiutada(aux.getUsername(), aux.getPassword());
        if (user == null){
            user = usuarioDao.contrasenyaGestor(aux.getUsername(), aux.getPassword());
            if (user == null) {
                bindingResult.rejectValue("password", "badpw", "Contrasenya incorrecta");
                return "login";
            }
        }
        // Autenticats correctament.
        // Guardem les dades de l'usuari autenticat a la sessió
        user.setPassword(null);
        session.setAttribute("usuario", user);

        // Torna a la pàgina principal
        return calcularRedireccion(user);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    private String calcularRedireccion(Usuario usuario){
        switch(usuario.getTipo()){
            case "Ciutada":
                return "redirect:usuario/sesionCiutada";
            case "Gestor":
                return "redirect:usuario/sesionGestor";
            default:
                return "login";
        }
    }
}