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
import mx.utng.sesion26.model.entity.Subject;
import mx.utng.sesion26.model.service.ISubjectService;

@Controller
@SessionAttributes("subject")
public class SubjectController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private ISubjectService service;


    @GetMapping({"/subject","/subject/","/subject/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado");
    model.addAttribute("subjects",service.list());
    return "subject-list";

    }

    @GetMapping("/subject/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 

    public String create(Model model){
        model.addAttribute("title","Formulario de Materias");
        model.addAttribute("subject", new Subject());
        return "subject-form";
    }

    @PostMapping("subject/form") 
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid Subject subject,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de materias");
            return "subject-form";
        }
        service.save(subject);
        return "redirect:/subject/list";

    }

    @GetMapping("/subject/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Subject subject = null;
        if(id>0){
            subject = service.getById(id);
        }else{
            return "redirect:/subject/list";
        }
        model.addAttribute("title", "Editar Materia");
        model.addAttribute("subject",subject);
        return "subject-form";
    }

    @GetMapping("/subject/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/subject/list";
    }



}
