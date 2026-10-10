package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.EmpleadoEntity;
import org.jimcode.rapidosyfuriosos.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoEntity> findAll() {
        return empleadoService.findAll();
    }

    @GetMapping("/custom")
    public List<EmpleadoEntity> findAllCustom() {
        return empleadoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public EmpleadoEntity findById(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @PostMapping
    public EmpleadoEntity save(@RequestBody EmpleadoEntity empleadoEntity) {
        return empleadoService.add(empleadoEntity);
    }

    @PutMapping("/{id}")
    public EmpleadoEntity update(@RequestBody EmpleadoEntity empleadoEntity, @PathVariable Long id) {
        return empleadoService.update(empleadoEntity, id);
    }

    @DeleteMapping("/{id}")
    public EmpleadoEntity delete(@PathVariable Long id) {
        return empleadoService.delete(id);
    }

    @PatchMapping("/{id}")
    public EmpleadoEntity enable(@PathVariable Long id) {
        return empleadoService.enable(id);
    }

}
