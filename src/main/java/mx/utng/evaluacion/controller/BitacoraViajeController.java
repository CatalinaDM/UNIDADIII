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
import mx.utng.evaluacion.model.entity.BitacoraViaje;
import mx.utng.evaluacion.model.service.IBitacoraViajeService;

@Controller
@SessionAttributes("bitacoraviaje")
public class BitacoraViajeController {
    
    @Autowired //Crea una instancia para que puedas utilizarla sin utlizar = new la clase y sin inicializarla desde un contructor
    private IBitacoraViajeService service;


    @GetMapping({"/bitacoraviaje","/bitacoraviaje/","/bitacoraviaje/list"})
    public String list(Model model){

    model.addAttribute("title", "Listado");
    model.addAttribute("bitacoraviajes",service.list());
    return "bitacoraviaje-list";

    }

    @GetMapping("/bitacoraviaje/form")//Si usas peticion GET lo tienes que hacer encriptado para que sea seguro. 

    public String create(Model model){
        model.addAttribute("title","Formulario de Bitacora de Viajes");
        model.addAttribute("bitacoraviaje", new BitacoraViaje());
        return "bitacoraviaje-form";
    }

    @PostMapping("bitacoraviaje/form") 
    //Peticion POST para guardar datos de forma mas segura 
    public String save(@Valid BitacoraViaje bitacoraviaje,BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title","Formulario de Bitacoras de viajes");
            return "bitacoraviaje-form";
        }
        service.save(bitacoraviaje);
        return "redirect:/bitacoraviaje/list";

    }

    @GetMapping("/bitacoraviaje/form/{id}")
    public String update(@PathVariable Long id, Model model){
        BitacoraViaje bitacoraviaje = null;
        if(id>0){
            bitacoraviaje = service.getById(id);
        }else{
            return "redirect:/bitacoraviaje/list";
        }
        model.addAttribute("title", "Editar Bitacora de Viajes");
        model.addAttribute("bitacoraviaje",bitacoraviaje);
        return "bitacoraviaje-form";
    }

    @GetMapping("/bitacoraviaje/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id>0 ){
            service.delete(id);
        }
        return "redirect:/bitacoraviaje/list";
    }



}
