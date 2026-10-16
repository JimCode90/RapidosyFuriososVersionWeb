package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.ClienteEntity;
import org.jimcode.rapidosyfuriosos.entity.ServicioEntity;
import org.jimcode.rapidosyfuriosos.service.ClienteService;
import org.jimcode.rapidosyfuriosos.service.DistritoService;
import org.jimcode.rapidosyfuriosos.service.SexoService;
import org.jimcode.rapidosyfuriosos.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private SexoService sexoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;


    @GetMapping("/cliente/listar")
    public String MostrarCliente(Model model) {
        model.addAttribute("listacliente", clienteService.findAllCustom());
        return "cliente/listarcliente";
    }

    @GetMapping("/cliente/registro")
    public String MostrarRegistrarCliente(Model modelo) {
        modelo.addAttribute("listadistrito", distritoService.findAllCustom());
        modelo.addAttribute("listasexo", sexoService.findAllCustom());
        modelo.addAttribute("listatipodocumento", tipoDocumentoService.findAllCustom());
        return "cliente/registrarcliente";
    }

    @GetMapping("/cliente/actualiza/{id}")
    public String MostrarActualizarCliente(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listadistrito", distritoService.findAllCustom());
        modelo.addAttribute("listasexo", sexoService.findAllCustom());
        modelo.addAttribute("listatipodocumento", tipoDocumentoService.findAllCustom());
        modelo.addAttribute("listacliente", clienteService.findById(id));
        return "cliente/actualizarcliente";
    }

    @GetMapping("/cliente/habilita")
    public String MostrarHabilitarCliente(Model modelo) {
        modelo.addAttribute("listacliente", clienteService.findAll());
        return "cliente/habilitarcliente";
    }


    // acciones de rutas
    @GetMapping("/cliente/eliminar/{id}")
    public String EliminarCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/cliente/habilitar/{id}")
    public String HabilitarCliente(@PathVariable Long id) {
        clienteService.enable(id);
        return "redirect:/cliente/habilita";
    }

    @GetMapping("/cliente/deshabilitar/{id}")
    public String DeshabilitarCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/cliente/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("cliente")
    public ClienteEntity ModeloCliente() {
        return new ClienteEntity();
    }


    // acciones
    @PostMapping("/cliente/registrar")
    public String RegistrarCliente(@ModelAttribute("cliente") ClienteEntity obj) {
        clienteService.add(obj);
        return "redirect:/cliente/listar";
    }

    @PostMapping("/cliente/actualizar/{id}")
    public String ActualizarCliente(@ModelAttribute("cliente") ClienteEntity obj, @PathVariable Long id) {
        clienteService.update(obj, id);
        return "redirect:/cliente/listar";
    }
}
