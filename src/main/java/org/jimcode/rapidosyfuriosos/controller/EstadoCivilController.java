package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.EstadoCivilEntity;
import org.jimcode.rapidosyfuriosos.service.EstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstadoCivilController {

    @Autowired
    private EstadoCivilService servicio;

    // rutas
    @GetMapping("/estadocivil/listar")
    public String MostrarListarEstadoCivil(Model modelo) {
        modelo.addAttribute("listaestadocivil", servicio.findAllCustom());
        return "estadocivil/listarestadocivil";
    }

    @GetMapping("/estadocivil/registro")
    public String MostrarRegistrarEstadoCivil() {
        return "estadocivil/registrarestadocivil";
    }

    @GetMapping("/estadocivil/actualiza/{id}")
    public String MostrarActualizarEstadoCivil(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listaestadocivil", servicio.findById(id));
        return "estadocivil/actualizarestadocivil";
    }

    @GetMapping("/estadocivil/habilita")
    public String MostrarHabilitarEstadoCivil(Model modelo) {
        modelo.addAttribute("listaestadocivil", servicio.findAll());
        return "estadocivil/habilitarestadocivil";
    }

    // acciones de rutas
    @GetMapping("/estadocivil/eliminar/{id}")
    public String EliminarEstadoCivil(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/estadocivil/listar";
    }

    @GetMapping("/estadocivil/habilitar/{id}")
    public String HabilitarEstadoCivil(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/estadocivil/habilita";
    }

    @GetMapping("/estadocivil/deshabilitar/{id}")
    public String DeshabilitarEstadoCivil(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/estadocivil/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("estadocivil")
    public EstadoCivilEntity ModeloEstadoCivil() {
        return new EstadoCivilEntity();
    }

    // acciones
    @PostMapping("/estadocivil/registrar")
    public String RegistrarEstadoCivil(@ModelAttribute("estadocivil") EstadoCivilEntity obj) {
        servicio.add(obj);
        return "redirect:/estadocivil/listar";
    }

    @PostMapping("/estadocivil/actualizar/{id}")
    public String ActualizarEstadoCivil(@ModelAttribute("estadocivil") EstadoCivilEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/estadocivil/listar";
    }

}
