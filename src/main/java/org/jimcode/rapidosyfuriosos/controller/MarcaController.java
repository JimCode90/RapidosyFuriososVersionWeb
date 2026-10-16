package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.MarcaEntity;
import org.jimcode.rapidosyfuriosos.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarcaController {

    @Autowired
    private MarcaService servicio;

    // rutas
    @GetMapping("/marca/listar")
    public String MostrarListarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAllCustom());
        return "marca/listarmarca";
    }

    @GetMapping("/marca/registro")
    public String MostrarRegistrarMarca() {
        return "marca/registrarmarca";
    }

    @GetMapping("/marca/actualiza/{id}")
    public String MostrarActualizarMarca(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listamarca", servicio.findById(id));
        return "marca/actualizarmarca";
    }

    @GetMapping("/marca/habilita")
    public String MostrarHabilitarMarca(Model modelo) {
        modelo.addAttribute("listamarca", servicio.findAll());
        return "marca/habilitarmarca";
    }

    // acciones de rutas
    @GetMapping("/marca/eliminar/{id}")
    public String EliminarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/listar";
    }

    @GetMapping("/marca/habilitar/{id}")
    public String HabilitarMarca(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/marca/habilita";
    }

    @GetMapping("/marca/deshabilitar/{id}")
    public String DeshabilitarMarca(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/marca/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("marca")
    public MarcaEntity ModeloMarca() {
        return new MarcaEntity();
    }

    // acciones
    @PostMapping("/marca/registrar")
    public String RegistrarMarca(@ModelAttribute("marca") MarcaEntity obj) {
        servicio.add(obj);
        return "redirect:/marca/listar";
    }

    @PostMapping("/marca/actualizar/{id}")
    public String ActualizarMarca(@ModelAttribute("marca") MarcaEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/marca/listar";
    }

}
