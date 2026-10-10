package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.VehiculoEntity;
import org.jimcode.rapidosyfuriosos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoRestController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<VehiculoEntity> findAll() {
        return vehiculoService.findAll();
    }

    @GetMapping("/custom")
    public List<VehiculoEntity> findAllCustom() {
        return vehiculoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public VehiculoEntity findById(@PathVariable Long id) {
        return vehiculoService.findById(id);
    }

    @PostMapping
    public VehiculoEntity save(@RequestBody VehiculoEntity vehiculoEntity) {
        return vehiculoService.add(vehiculoEntity);
    }

    @PutMapping("/{id}")
    public VehiculoEntity update(@RequestBody VehiculoEntity vehiculoEntity, @PathVariable Long id) {
        return vehiculoService.update(vehiculoEntity, id);
    }

    @DeleteMapping("/{id}")
    public VehiculoEntity delete(@PathVariable Long id) {
        return vehiculoService.delete(id);
    }

    @PatchMapping("/{id}")
    public VehiculoEntity enable(@PathVariable Long id) {
        return vehiculoService.enable(id);
    }

}
