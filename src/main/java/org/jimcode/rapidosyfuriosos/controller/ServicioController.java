package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.ServicioEntity;
import org.jimcode.rapidosyfuriosos.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicioController {

    @Autowired
    private ServicioService servicio;

    // rutas
    @GetMapping("/servicio/listar")
    public String MostrarListarServicio(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAllCustom());
        return "servicio/listarservicio";
    }

    @GetMapping("/servicio/registro")
    public String MostrarRegistrarServicio() {
        return "servicio/registrarservicio";
    }

    @GetMapping("/servicio/actualiza/{id}")
    public String MostrarActualizarServicio(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listaservicio", servicio.findById(id));
        return "servicio/actualizarservicio";
    }

    @GetMapping("/servicio/habilita")
    public String MostrarHabilitarServicio(Model modelo) {
        modelo.addAttribute("listaservicio", servicio.findAll());
        return "servicio/habilitarservicio";
    }

    // acciones de rutas
    @GetMapping("/servicio/eliminar/{id}")
    public String EliminarServicio(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/servicio/listar";
    }

    @GetMapping("/servicio/habilitar/{id}")
    public String HabilitarServicio(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/servicio/habilita";
    }

    @GetMapping("/servicio/deshabilitar/{id}")
    public String DeshabilitarServicio(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/servicio/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("servicio")
    public ServicioEntity ModeloServicio() {
        return new ServicioEntity();
    }

    // acciones
    @PostMapping("/servicio/registrar")
    public String RegistrarServicio(@ModelAttribute("servicio") ServicioEntity obj) {
        servicio.add(obj);
        return "redirect:/servicio/listar";
    }

    @PostMapping("/servicio/actualizar/{id}")
    public String ActualizarServicio(@ModelAttribute("servicio") ServicioEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/servicio/listar";
    }

}
