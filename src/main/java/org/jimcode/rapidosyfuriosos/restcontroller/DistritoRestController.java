package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.DistritoEntity;
import org.jimcode.rapidosyfuriosos.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Servicio RESTFul
@RestController
// Definimos la ruta
@RequestMapping("/api/distrito")
public class DistritoRestController {

    // Inyección de dependencia hacia el service
    @Autowired
    private DistritoService distritoService;

    // Consulta o búsqueda -> @GetMapping
    // Mostrar todos los distritos
    @GetMapping
    public List<DistritoEntity> findAll() {
        return distritoService.findAll();
    }

    // Mostrar los distritos habilitados
    @GetMapping("/custom")
    public List<DistritoEntity> findAllCustom() {
        return distritoService.findAllCustom();
    }

    // Buscar distrito por código
    // {id} -> variable de ruta
    @GetMapping("/{id}")
    public DistritoEntity findById(@PathVariable Long id) {
        return distritoService.findById(id);
    }

    // Registrar -> @PostMapping
    // Registrar distrito
    @PostMapping
    public DistritoEntity save(@RequestBody DistritoEntity distritoEntity) {
        return distritoService.add(distritoEntity);
    }

    // Actualizar -> @PutMapping
    // Actualizar distrito
    @PutMapping("/{id}")
    public DistritoEntity update(@RequestBody DistritoEntity distritoEntity, @PathVariable Long id) {
        return distritoService.update(distritoEntity, id);
    }

    // Eliminar -> @DeleteMapping
    // Eliminar distrito
    @DeleteMapping("/{id}")
    public DistritoEntity delete(@PathVariable Long id) {
        return distritoService.delete(id);
    }

    // Habilitar -> Actualización Parcial @PatchMapping
    // Eliminar distrito
    @PatchMapping("/{id}")
    public DistritoEntity enable(@PathVariable Long id) {
        return distritoService.enable(id);
    }

}
