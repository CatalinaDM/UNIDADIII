
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
import mx.utng.evaluacion.model.entity.PlanFinanciero;
import mx.utng.evaluacion.model.service.IPlanFinancieroService;

@Controller
@SessionAttributes("planfinanciero")
public class PlanFinancieroController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private IPlanFinancieroService service;


    @GetMapping({"/planfinanciero","/planfinanciero/","/planfinanciero/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado de Plan Financiero");
    model.addAttribute("planfinancieros",service.list());
    return "planfinanciero-list";

    }

        @GetMapping("/planfinanciero/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 

    public String create(Model model){
        model.addAttribute("title","Formulario de Planes Financieros");
        model.addAttribute("planfinanciero", new PlanFinanciero());
        return "planfinanciero-form";
    }

    @PostMapping("/planfinanciero/form") 
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid PlanFinanciero planfinanciero,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de Planes Financieros");
            return "planfinanciero-form";
        }
        service.save(planfinanciero);
        return "redirect:/planfinanciero/list";

    }

    @GetMapping("/planfinanciero/form/{id}")
    public String update(@PathVariable Long id, Model model){
       PlanFinanciero planfinanciero = null;
        if(id>0){
           planfinanciero = service.getById(id);
        }else{
            return "redirect:/planfinanciero/list";
        }
        model.addAttribute("title", "Editar Planes Financieros");
        model.addAttribute("planfinanciero",planfinanciero);
        return "planfinanciero-form";
    }

    @GetMapping("/planfinanciero/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/planfinanciero/list";
    }



}
