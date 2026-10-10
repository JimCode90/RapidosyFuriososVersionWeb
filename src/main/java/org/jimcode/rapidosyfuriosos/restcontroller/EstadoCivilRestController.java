package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.EstadoCivilEntity;
import org.jimcode.rapidosyfuriosos.service.EstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadocivil")
public class EstadoCivilRestController {

    @Autowired
    private EstadoCivilService estadoCivilService;

    @GetMapping
    public List<EstadoCivilEntity> findAll() {
        return estadoCivilService.findAll();
    }

    @GetMapping("/custom")
    public List<EstadoCivilEntity> findAllCustom() {
        return estadoCivilService.findAllCustom();
    }

    @GetMapping("/{id}")
    public EstadoCivilEntity findById(@PathVariable Long id) {
        return estadoCivilService.findById(id);
    }

    @PostMapping
    public EstadoCivilEntity save(@RequestBody EstadoCivilEntity estadoCivilEntity) {
        return estadoCivilService.add(estadoCivilEntity);
    }

    @PutMapping("/{id}")
    public EstadoCivilEntity update(@RequestBody EstadoCivilEntity estadoCivilEntity, @PathVariable Long id) {
        return estadoCivilService.update(estadoCivilEntity, id);
    }

    @DeleteMapping("/{id}")
    public EstadoCivilEntity delete(@PathVariable Long id) {
        return estadoCivilService.delete(id);
    }

    @PatchMapping("/{id}")
    public EstadoCivilEntity enable(@PathVariable Long id) {
        return estadoCivilService.enable(id);
    }

}
