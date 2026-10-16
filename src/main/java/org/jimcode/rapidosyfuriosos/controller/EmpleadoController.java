package org.jimcode.rapidosyfuriosos.controller;

import org.jimcode.rapidosyfuriosos.entity.EmpleadoEntity;
import org.jimcode.rapidosyfuriosos.service.DistritoService;
import org.jimcode.rapidosyfuriosos.service.EmpleadoService;
import org.jimcode.rapidosyfuriosos.service.EstadoCivilService;
import org.jimcode.rapidosyfuriosos.service.RolService;
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
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private SexoService sexoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private EstadoCivilService estadoCivilService;

    @Autowired
    private RolService rolService;


    @GetMapping("/empleado/listar")
    public String MostrarListarEmpleado(Model modelo) {
        modelo.addAttribute("listaempleado", empleadoService.findAllCustom());
        return "empleado/listarempleado";
    }

    @GetMapping("/empleado/registro")
    public String MostrarRegistrarEmpleado(Model modelo) {
        modelo.addAttribute("listadistrito", distritoService.findAllCustom());
        modelo.addAttribute("listasexo", sexoService.findAllCustom());
        modelo.addAttribute("listatipodocumento", tipoDocumentoService.findAllCustom());
        modelo.addAttribute("listaestadocivil", estadoCivilService.findAllCustom());
        modelo.addAttribute("listarol", rolService.findAllCustom());
        return "empleado/registrarempleado";
    }

    @GetMapping("/empleado/actualiza/{id}")
    public String MostrarActualizarEmpleado(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("listadistrito", distritoService.findAllCustom());
        modelo.addAttribute("listasexo", sexoService.findAllCustom());
        modelo.addAttribute("listatipodocumento", tipoDocumentoService.findAllCustom());
        modelo.addAttribute("listaestadocivil", estadoCivilService.findAllCustom());
        modelo.addAttribute("listarol", rolService.findAllCustom());
        modelo.addAttribute("listaempleado", empleadoService.findById(id));
        return "empleado/actualizarempleado";
    }

    @GetMapping("/empleado/habilita")
    public String MostrarHabilitarEmpleado(Model modelo) {
        modelo.addAttribute("listaempleado", empleadoService.findAll());
        return "empleado/habilitarempleado";
    }


    // acciones de rutas
    @GetMapping("/empleado/eliminar/{id}")
    public String EliminarEmpleado(@PathVariable Long id) {
        empleadoService.delete(id);
        return "redirect:/empleado/listar";
    }

    @GetMapping("/empleado/habilitar/{id}")
    public String HabilitarEmpleado(@PathVariable Long id) {
        empleadoService.enable(id);
        return "redirect:/empleado/habilita";
    }

    @GetMapping("/empleado/deshabilitar/{id}")
    public String DeshabilitarEmpleado(@PathVariable Long id) {
        empleadoService.delete(id);
        return "redirect:/empleado/habilita";
    }

    // modelo para recibir los datos del formulario
    @ModelAttribute("empleado")
    public EmpleadoEntity ModeloEmpleado() {
        return new EmpleadoEntity();
    }


    // acciones
    @PostMapping("/empleado/registrar")
    public String RegistrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity obj) {
        empleadoService.add(obj);
        return "redirect:/empleado/listar";
    }

    @PostMapping("/empleado/actualizar/{id}")
    public String ActualizarEmpleado(@ModelAttribute("empleado") EmpleadoEntity obj, @PathVariable Long id) {
        empleadoService.update(obj, id);
        return "redirect:/empleado/listar";
    }
}
