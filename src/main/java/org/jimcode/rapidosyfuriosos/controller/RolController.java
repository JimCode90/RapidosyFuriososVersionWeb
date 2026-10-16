package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.RolEntity;
import org.jimcode.rapidosyfuriosos.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RolController {

    @Autowired
    private RolService servicio;

    // rutas
    @GetMapping("/rol/listar")
    public String MostrarListarRol(Model modelo) {
        modelo.addAttribute("listarol", servicio.findAllCustom());
        return "rol/listarrol";
    }

    @GetMapping("/rol/registro")
    public String MostrarRegistrarRol() {
        return "rol/registrarrol";
    }

    @GetMapping("/rol/actualiza/{id}")
    public String MostrarActualizarRol(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listarol", servicio.findById(id));
        return "rol/actualizarrol";
    }

    @GetMapping("/rol/habilita")
    public String MostrarHabilitarRol(Model modelo) {
        modelo.addAttribute("listarol", servicio.findAll());
        return "rol/habilitarrol";
    }

    // acciones de rutas
    @GetMapping("/rol/eliminar/{id}")
    public String EliminarRol(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/rol/listar";
    }

    @GetMapping("/rol/habilitar/{id}")
    public String HabilitarRol(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/rol/habilita";
    }

    @GetMapping("/rol/deshabilitar/{id}")
    public String DeshabilitarRol(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/rol/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("rol")
    public RolEntity ModeloRol() {
        return new RolEntity();
    }

    // acciones
    @PostMapping("/rol/registrar")
    public String RegistrarRol(@ModelAttribute("rol") RolEntity obj) {
        servicio.add(obj);
        return "redirect:/rol/listar";
    }

    @PostMapping("/rol/actualizar/{id}")
    public String ActualizarRol(@ModelAttribute("rol") RolEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/rol/listar";
    }

}
