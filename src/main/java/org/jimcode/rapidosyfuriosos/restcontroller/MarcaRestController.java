package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.MarcaEntity;
import org.jimcode.rapidosyfuriosos.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaRestController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<MarcaEntity> findAll() {
        return marcaService.findAll();
    }

    @GetMapping("/custom")
    public List<MarcaEntity> findAllCustom() {
        return marcaService.findAllCustom();
    }

    @GetMapping("/{id}")
    public MarcaEntity findById(@PathVariable Long id) {
        return marcaService.findById(id);
    }

    @PostMapping
    public MarcaEntity save(@RequestBody MarcaEntity marcaEntity) {
        return marcaService.add(marcaEntity);
    }

    @PutMapping("/{id}")
    public MarcaEntity update(@RequestBody MarcaEntity marcaEntity, @PathVariable Long id) {
        return marcaService.update(marcaEntity, id);
    }

    @DeleteMapping("/{id}")
    public MarcaEntity delete(@PathVariable Long id) {
        return marcaService.delete(id);
    }

    @PatchMapping("/{id}")
    public MarcaEntity enable(@PathVariable Long id) {
        return marcaService.enable(id);
    }

}
