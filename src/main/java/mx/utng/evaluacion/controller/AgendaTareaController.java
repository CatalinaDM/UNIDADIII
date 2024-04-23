/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.evaluacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.evaluacion.model.entity.AgendaTarea;
import mx.utng.evaluacion.model.service.IAgendaTareaService;

@Controller
@SessionAttributes("agendatarea")
public class AgendaTareaController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private IAgendaTareaService service;


    @GetMapping({"/agendatarea","/agendatarea/","/agendatarea/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado de Agendas de Tareas");
    model.addAttribute("agendatareas",service.list());
    return "agendatarea-list";

    }

    @GetMapping("/agendatarea/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 

    public String create(Model model){
        model.addAttribute("title","Formulario de las Agendas de Tareas");
        model.addAttribute("agendatarea", new AgendaTarea());
        return "agendatarea-form";
    }

    @PostMapping("/agendatarea/form") 
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid AgendaTarea agendatarea,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de las Agendas de Tareas");
            return "agendatarea-form";
        }
        service.save(agendatarea);
        return "redirect:/agendatarea/list";

    }

    @GetMapping("/agendatarea/form/{id}")
    public String update(@PathVariable Long id, Model model){
        AgendaTarea agendatarea = null;
        if(id>0){
            agendatarea = service.getById(id);
        }else{
            return "redirect:/agendatarea/list";
        }
        model.addAttribute("title", "Editar Agenda de Tareas");
        model.addAttribute("agendatarea",agendatarea);
        return "agendatarea-form";
    }

    @GetMapping("/agendatarea/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/agendatarea/list";
    }



}
