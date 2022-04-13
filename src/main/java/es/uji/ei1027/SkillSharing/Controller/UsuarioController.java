package es.uji.ei1027.SkillSharing.Controller;

import es.uji.ei1027.SkillSharing.Dao.UsuarioDao;
import es.uji.ei1027.SkillSharing.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Usuarios")
public class UsuarioController {
    private UsuarioDao usuarioDao;

    @Autowired
    public void setUsuarioDao(UsuarioDao usuarioDao){
        this.usuarioDao = usuarioDao;
    }

    @RequestMapping(value = "/sesionAlumno")
    public String loginAlumno(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(usuario == null || !usuario.getTipo().equals("Alumno")){
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        return "Usuarios/sesionAlumno";
    }

    @RequestMapping(value = "/sesionPromotor")
    public String loginPromotor(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(usuario== null || !usuario.getTipo().equals("Promotor")){
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        return "Usuarios/sesionPromotor";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}