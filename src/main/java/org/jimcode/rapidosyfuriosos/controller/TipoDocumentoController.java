package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.TipoDocumentoEntity;
import org.jimcode.rapidosyfuriosos.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService servicio;

    // rutas
    @GetMapping("/tipodocumento/listar")
    public String MostrarListarTipoDocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAllCustom());
        return "tipodocumento/listartipodocumento";
    }

    @GetMapping("/tipodocumento/registro")
    public String MostrarRegistrarTipoDocumento() {
        return "tipodocumento/registrartipodocumento";
    }

    @GetMapping("/tipodocumento/actualiza/{id}")
    public String MostrarActualizarTipoDocumento(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listatipodocumento", servicio.findById(id));
        return "tipodocumento/actualizartipodocumento";
    }

    @GetMapping("/tipodocumento/habilita")
    public String MostrarHabilitarTipoDocumento(Model modelo) {
        modelo.addAttribute("listatipodocumento", servicio.findAll());
        return "tipodocumento/habilitartipodocumento";
    }

    // acciones de rutas
    @GetMapping("/tipodocumento/eliminar/{id}")
    public String EliminarTipoDocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/listar";
    }

    @GetMapping("/tipodocumento/habilitar/{id}")
    public String HabilitarTipoDocumento(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/tipodocumento/habilita";
    }

    @GetMapping("/tipodocumento/deshabilitar/{id}")
    public String DeshabilitarTipoDocumento(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/tipodocumento/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("tipodocumento")
    public TipoDocumentoEntity ModeloTipoDocumento() {
        return new TipoDocumentoEntity();
    }

    // acciones
    @PostMapping("/tipodocumento/registrar")
    public String RegistrarTipoDocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity obj) {
        servicio.add(obj);
        return "redirect:/tipodocumento/listar";
    }

    @PostMapping("/tipodocumento/actualizar/{id}")
    public String ActualizarTipoDocumento(@ModelAttribute("tipodocumento") TipoDocumentoEntity obj, @PathVariable Long id) {
        servicio.update(obj, id);
        return "redirect:/tipodocumento/listar";
    }

}
