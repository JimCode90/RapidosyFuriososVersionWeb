package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.SexoEntity;
import org.jimcode.rapidosyfuriosos.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SexoController {

    @Autowired
    private SexoService servicio;

    // rutas
    @GetMapping("/sexo/listar")
    public String MostrarListarSexo(Model modelo) {
        modelo.addAttribute("listasexo", servicio.findAllCustom());
        return "sexo/listarsexo";
    }

    @GetMapping("/sexo/registro")
    public String MostrarRegistrarSexo() {
        return "sexo/registrarsexo";
    }

    @GetMapping("/sexo/actualiza/{id}")
    public String MostrarActualizarSexo(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listasexo", servicio.findById(id));
        return "sexo/actualizarsexo";
    }

    @GetMapping("/sexo/habilita")
    public String MostrarHabilitarSexo(Model modelo) {
        modelo.addAttribute("listasexo", servicio.findAll());
        return "sexo/habilitarsexo";
    }

    // acciones de rutas
    @GetMapping("/sexo/eliminar/{id}")
    public String EliminarSexo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sexo/listar";
    }

    @GetMapping("/sexo/habilitar/{id}")
    public String HabilitarSexo(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/sexo/habilita";
    }

    @GetMapping("/sexo/deshabilitar/{id}")
    public String DeshabilitarSexo(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/sexo/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("sexo")
    public SexoEntity ModeloSexo() {
        return new SexoEntity();
    }

    // acciones
    @PostMapping("/sexo/registrar")
    public String RegistrarSexo(@ModelAttribute("sexo") SexoEntity obj) {
        servicio.add(obj);
        return "redirect:/sexo/listar";
    }

    @PostMapping("/sexo/actualizar/{id}")
    public String ActualizarSexo(@ModelAttribute("sexo") SexoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/sexo/listar";
    }

}
