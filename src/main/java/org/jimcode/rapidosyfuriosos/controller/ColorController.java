package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.ColorEntity;
import org.jimcode.rapidosyfuriosos.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ColorController {

    @Autowired
    private ColorService servicio;

    // rutas
    @GetMapping("/color/listar")
    public String MostrarListarColor(Model modelo) {
        modelo.addAttribute("listacolor", servicio.findAllCustom());
        return "color/listarcolor";
    }

    @GetMapping("/color/registro")
    public String MostrarRegistrarColor() {
        return "color/registrarcolor";
    }

    @GetMapping("/color/actualiza/{id}")
    public String MostrarActualizarColor(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listacolor", servicio.findById(id));
        return "color/actualizarcolor";
    }

    @GetMapping("/color/habilita")
    public String MostrarHabilitarColor(Model modelo) {
        modelo.addAttribute("listacolor", servicio.findAll());
        return "color/habilitarcolor";
    }

    // acciones de rutas
    @GetMapping("/color/eliminar/{id}")
    public String EliminarColor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/color/listar";
    }

    @GetMapping("/color/habilitar/{id}")
    public String HabilitarColor(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/color/habilita";
    }

    @GetMapping("/color/deshabilitar/{id}")
    public String DeshabilitarColor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/color/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("color")
    public ColorEntity ModeloColor() {
        return new ColorEntity();
    }

    // acciones
    @PostMapping("/color/registrar")
    public String RegistrarColor(@ModelAttribute("color") ColorEntity obj) {
        servicio.add(obj);
        return "redirect:/color/listar";
    }

    @PostMapping("/color/actualizar/{id}")
    public String ActualizarColor(@ModelAttribute("color") ColorEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/color/listar";
    }

}
