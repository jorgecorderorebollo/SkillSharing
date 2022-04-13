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
        Usuario usuarioTipo = usuarioDao.getTipo(usuario.getUsername());

        if(usuarioTipo == null) {
            bindingResult.rejectValue("username", "badpw", "Usuari inexistent");
            return "login";
        }
        Usuario user = usuarioDao.comprobarPassword(usuario.getUsername(), usuario.getPassword());

        if (user == null){
            bindingResult.rejectValue("password", "badpw", "Password incorrecta");
            return "login";
        }

        user.setPassword(null);
        session.setAttribute("usuario", user);

        return calcularRedireccion(user);
    }

    private String calcularRedireccion(Usuario usuario){
        switch(usuario.getTipo()){
            case "Alumno":
                return "redirect:Usuarios/sesionAlumno";
            case "Promotor":
                return "redirect:Usuarios/sesionPromotor";
            default:
                return "redirect:/login";
        }
    }
}