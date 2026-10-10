package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.SexoEntity;
import org.jimcode.rapidosyfuriosos.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sexo")
public class SexoRestController {

    @Autowired
    private SexoService sexoService;

    @GetMapping
    public List<SexoEntity> findAll() {
        return sexoService.findAll();
    }

    @GetMapping("/custom")
    public List<SexoEntity> findAllCustom() {
        return sexoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public SexoEntity findById(@PathVariable Long id) {
        return sexoService.findById(id);
    }

    @PostMapping
    public SexoEntity save(@RequestBody SexoEntity sexoEntity) {
        return sexoService.add(sexoEntity);
    }

    @PutMapping("/{id}")
    public SexoEntity update(@RequestBody SexoEntity sexoEntity, @PathVariable Long id) {
        return sexoService.update(sexoEntity, id);
    }

    @DeleteMapping("/{id}")
    public SexoEntity delete(@PathVariable Long id) {
        return sexoService.delete(id);
    }

    @PatchMapping("/{id}")
    public SexoEntity enable(@PathVariable Long id) {
        return sexoService.enable(id);
    }

}
