package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.RolEntity;
import org.jimcode.rapidosyfuriosos.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolRestController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<RolEntity> findAll() {
        return rolService.findAll();
    }

    @GetMapping("/custom")
    public List<RolEntity> findAllCustom() {
        return rolService.findAllCustom();
    }

    @GetMapping("/{id}")
    public RolEntity findById(@PathVariable Long id) {
        return rolService.findById(id);
    }

    @PostMapping
    public RolEntity save(@RequestBody RolEntity rolEntity) {
        return rolService.add(rolEntity);
    }

    @PutMapping("/{id}")
    public RolEntity update(@RequestBody RolEntity rolEntity, @PathVariable Long id) {
        return rolService.update(rolEntity, id);
    }

    @DeleteMapping("/{id}")
    public RolEntity delete(@PathVariable Long id) {
        return rolService.delete(id);
    }

    @PatchMapping("/{id}")
    public RolEntity enable(@PathVariable Long id) {
        return rolService.enable(id);
    }

}
