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
import mx.utng.sesion26.model.entity.Student;
import mx.utng.sesion26.model.service.IStudentService;

@Controller
@SessionAttributes("student")
public class StudentController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private IStudentService service;


    @GetMapping({"","/","/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado");
    model.addAttribute("students",service.list());
    return "/list";

    }

    @GetMapping("/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 

    public String create(Model model){
        model.addAttribute("title","Formulario de Estudiantes");
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/form") 
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid Student student,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de estudiantes");
            return "form";
        }
        service.save(student);
        return "redirect:/list";

    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Student student = null;
        if(id>0){
            student = service.getById(id);
        }else{
            return "redirect:/list";
        }
        model.addAttribute("title", "Editar Estudiante");
        model.addAttribute("student",student);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
