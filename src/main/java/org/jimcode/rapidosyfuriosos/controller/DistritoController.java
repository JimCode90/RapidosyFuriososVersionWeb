package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.DistritoEntity;
import org.jimcode.rapidosyfuriosos.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DistritoController {
    //inyección de dependencia
    @Autowired
    private DistritoService servicio;

    //inyección de dependencia con el método constructor
    //private DistritoService servicio;

    //public DistritoController(DistritoService servicio) {
    //	this.servicio=servicio;
    //}

    //rutas
    //listar distrito
    @GetMapping("/distrito/listar")
    public String MostrarListarDistrito(Model modelo) {
        modelo.addAttribute("listadistrito",servicio.findAllCustom());
        return "distrito/listardistrito";
    }

    //registrar distrito
    @GetMapping("/distrito/registro")
    public String MostrarRegistrarDistrito() {
        return "distrito/registrardistrito";
    }

    //actualizar distrito
    //{id} -> es una variable de ruta
    @GetMapping("/distrito/actualiza/{id}")
    public String MostrarActualizarDistrito(Model modelo,@PathVariable Long id) {
        modelo.addAttribute("listadistrito",servicio.findById(id));
        return "distrito/actualizardistrito";
    }

    //habilitar distrito
    @GetMapping("/distrito/habilita")
    public String MostrarHabilitarDistrito(Model modelo) {
        modelo.addAttribute("listadistrito",servicio.findAll());
        return "distrito/habilitardistrito";
    }

    //acciones de rutas
    //eliminar
    @GetMapping("/distrito/eliminar/{id}")
    public String EliminarDistrito(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/distrito/listar";
    }

    //habilitar
    @GetMapping("/distrito/habilitar/{id}")
    public String HabilitarDistrito(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/distrito/habilita";
    }

    //eliminar
    @GetMapping("/distrito/deshabilitar/{id}")
    public String DeshabilitarDistrito(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/distrito/habilita";
    }

    // creamos un modelo para pasar datos entre el controlador y la vista
    // y también recibir datos enviados desde el formulario
    @ModelAttribute("distrito")
    public DistritoEntity ModeloDistrito() {
        return new DistritoEntity();
    }

    //acciones
    //registrar
    @PostMapping("/distrito/registrar")
    public String RegistrarDistrito(@ModelAttribute("distrito") DistritoEntity obj) {
        servicio.add(obj);
        return "redirect:/distrito/listar";
    }

    //actualizar
    @PostMapping("/distrito/actualizar/{id}")
    public String ActualizarDistrito(@ModelAttribute("distrito") DistritoEntity obj,
                                     @PathVariable Long id) {
        servicio.update(obj,id);
        return "redirect:/distrito/listar";
    }

}
