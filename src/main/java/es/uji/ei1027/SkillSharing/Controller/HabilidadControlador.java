package es.uji.ei1027.SkillSharing.Controller;

import es.uji.ei1027.SkillSharing.Dao.HabilidadDao;
import es.uji.ei1027.SkillSharing.Model.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/habilidad")
public class HabilidadControlador {
    private HabilidadDao habilidadDao;

    @Autowired
    public void setHabilidadDao(HabilidadDao hDao){
        this.habilidadDao = hDao;
    }

    @RequestMapping("/list")
    public String listHabilidades(Model model){
        model.addAttribute("habilidades", habilidadDao.getHabilidades());
        return "habilidad/list";
    }

    @RequestMapping(value = "/add")
    public String addHabilidad(Model model){
        model.addAttribute("habilidad", new Habilidad());
        return "habilidad/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("habilidad") Habilidad habilidad, BindingResult bindingResult){
        HabilidadValidador habilidadValidador = new HabilidadValidador();
        habilidadValidador.validate(habilidad, bindingResult);
        if(bindingResult.hasErrors())
            return "habilidad/add";
        habilidadDao.addHabilidad((habilidad));
        return "redirect:list";
    }

    @RequestMapping(value="/update/{codigo_habilidad}", method = RequestMethod.GET)
    public String editHabilidad(Model model, @PathVariable String codigo_habilidad){
        model.addAttribute("habilidad", habilidadDao.getHabilidad(codigo_habilidad));
        return "habilidad/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("habilidad") Habilidad habilidad, BindingResult bindingResult){
        HabilidadValidador habilidadValidador = new HabilidadValidador();
        habilidadValidador.validate(habilidad, bindingResult);
        if (bindingResult.hasErrors())
            return "habilidad/update";
        habilidadDao.updateHabilidad(habilidad);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{codigo_habilidad}")
    public String processDelete(@PathVariable String codigo_habilidad){
        habilidadDao.deleteHabilidad(codigo_habilidad);
        return "redirect:../list";
    }
}