package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.VehiculoEntity;
import org.jimcode.rapidosyfuriosos.service.ClienteService;
import org.jimcode.rapidosyfuriosos.service.ColorService;
import org.jimcode.rapidosyfuriosos.service.MarcaService;
import org.jimcode.rapidosyfuriosos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/vehiculo/listar")
    public String MostrarListarVehiculo(Model modelo) {
        modelo.addAttribute("listavehiculo", vehiculoService.findAllCustom());
        return "vehiculo/listarvehiculo";
    }

    @GetMapping("/vehiculo/registro")
    public String MostrarRegistrarVehiculo(Model modelo) {
        modelo.addAttribute("listamarca", marcaService.findAllCustom());
        modelo.addAttribute("listacolor", colorService.findAllCustom());
        modelo.addAttribute("listacliente", clienteService.findAllCustom());
        return "vehiculo/registrarvehiculo";
    }

    @GetMapping("/vehiculo/actualiza/{id}")
    public String MostrarActualizarVehiculo(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listamarca", marcaService.findAllCustom());
        modelo.addAttribute("listacolor", colorService.findAllCustom());
        modelo.addAttribute("listacliente", clienteService.findAllCustom());
        modelo.addAttribute("listavehiculo", vehiculoService.findById(id));
        return "vehiculo/actualizarvehiculo";
    }

    @GetMapping("/vehiculo/habilita")
    public String MostrarHabilitarVehiculo(Model modelo) {
        modelo.addAttribute("listavehiculo", vehiculoService.findAll());
        return "vehiculo/habilitarvehiculo";
    }


    // acciones de rutas
    @GetMapping("/vehiculo/eliminar/{id}")
    public String EliminarVehiculo(@PathVariable Long id) {
        vehiculoService.delete(id);
        return "redirect:/vehiculo/listar";
    }

    @GetMapping("/vehiculo/habilitar/{id}")
    public String HabilitarVehiculo(@PathVariable Long id) {
        vehiculoService.enable(id);
        return "redirect:/vehiculo/habilita";
    }

    @GetMapping("/vehiculo/deshabilitar/{id}")
    public String DeshabilitarVehiculo(@PathVariable Long id) {
        vehiculoService.delete(id);
        return "redirect:/vehiculo/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("vehiculo")
    public VehiculoEntity ModeloVehiculo() {
        return new VehiculoEntity();
    }


    // acciones
    @PostMapping("/vehiculo/registrar")
    public String RegistrarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity obj) {
        vehiculoService.add(obj);
        return "redirect:/vehiculo/listar";
    }

    @PostMapping("/vehiculo/actualizar/{id}")
    public String ActualizarVehiculo(@ModelAttribute("vehiculo") VehiculoEntity obj, @PathVariable Long id) {
        vehiculoService.update(obj, id);
        return "redirect:/vehiculo/listar";
    }
}
