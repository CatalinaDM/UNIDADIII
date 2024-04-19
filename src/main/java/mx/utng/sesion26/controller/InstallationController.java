
/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */
package mx.utng.sesion26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.sesion26.model.entity.Installation;
import mx.utng.sesion26.model.service.IInstallationService;

@Controller
@SessionAttributes("installation")
public class InstallationController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private IInstallationService service;


    @GetMapping({"/installation","/installation/","/installation/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado de instalaciones");
    model.addAttribute("installations",service.list());
    return "installation-list";

    }

        @GetMapping("/installation/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 

    public String create(Model model){
        model.addAttribute("title","Formulario de Instalaciones");
        model.addAttribute("installation", new Installation());
        return "installation-form";
    }

    @PostMapping("/installation/form") 
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid Installation installation,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de Instalaciones");
            return "installation-form";
        }
        service.save(installation);
        return "redirect:/installation/list";

    }

    @GetMapping("/installation/form/{id}")
    public String update(@PathVariable Long id, Model model){
       Installation installation = null;
        if(id>0){
           installation = service.getById(id);
        }else{
            return "redirect:/installation/list";
        }
        model.addAttribute("title", "Editar Instalaciónes");
        model.addAttribute("installation",installation);
        return "installation-form";
    }

    @GetMapping("/installation/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/installation/list";
    }



}
