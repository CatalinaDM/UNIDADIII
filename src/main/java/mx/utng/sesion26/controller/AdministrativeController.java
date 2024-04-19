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
import mx.utng.sesion26.model.entity.Administrative;
import mx.utng.sesion26.model.service.IAdministrativeService;

@Controller
@SessionAttributes("administrative")
public class AdministrativeController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private IAdministrativeService service;


    @GetMapping({"/administrative","/administrative/","/administrative/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado");
    model.addAttribute("administratives",service.list());
    return "administrative-list";

    }

    @GetMapping("/administrative/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 

    public String create(Model model){
        model.addAttribute("title","Formulario de Administratives");
        model.addAttribute("administrative", new Administrative());
        return "administrative-form";
    }

    @PostMapping("/administrative/form") 
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid Administrative administrative,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de Administrativos");
            return "administrative-form";
        }
        service.save(administrative);
        return "redirect:/administrative/list";

    }

    @GetMapping("/administrative/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Administrative administrative = null;
        if(id>0){
            administrative = service.getById(id);
        }else{
            return "redirect:/administrative/list";
        }
        model.addAttribute("title", "Editar Administrative");
        model.addAttribute("administrative",administrative);
        return "administrative-form";
    }

    @GetMapping("/administrative/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/administrative/list";
    }



}
