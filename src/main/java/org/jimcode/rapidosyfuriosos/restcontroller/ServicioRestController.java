package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.ServicioEntity;
import org.jimcode.rapidosyfuriosos.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioRestController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<ServicioEntity> findAll() {
        return servicioService.findAll();
    }

    @GetMapping("/custom")
    public List<ServicioEntity> findAllCustom() {
        return servicioService.findAllCustom();
    }

    @GetMapping("/{id}")
    public ServicioEntity findById(@PathVariable Long id) {
        return servicioService.findById(id);
    }

    @PostMapping
    public ServicioEntity save(@RequestBody ServicioEntity servicioEntity) {
        return servicioService.add(servicioEntity);
    }

    @PutMapping("/{id}")
    public ServicioEntity update(@RequestBody ServicioEntity servicioEntity, @PathVariable Long id) {
        return servicioService.update(servicioEntity, id);
    }

    @DeleteMapping("/{id}")
    public ServicioEntity delete(@PathVariable Long id) {
        return servicioService.delete(id);
    }

    @PatchMapping("/{id}")
    public ServicioEntity enable(@PathVariable Long id) {
        return servicioService.enable(id);
    }

}
