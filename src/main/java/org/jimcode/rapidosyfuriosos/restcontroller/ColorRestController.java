package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.ColorEntity;
import org.jimcode.rapidosyfuriosos.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorRestController {

    @Autowired
    private ColorService colorService;

    @GetMapping
    public List<ColorEntity> findAll() {
        return colorService.findAll();
    }

    @GetMapping("/custom")
    public List<ColorEntity> findAllCustom() {
        return colorService.findAllCustom();
    }

    @GetMapping("/{id}")
    public ColorEntity findById(@PathVariable Long id) {
        return colorService.findById(id);
    }

    @PostMapping
    public ColorEntity save(@RequestBody ColorEntity colorEntity) {
        return colorService.add(colorEntity);
    }

    @PutMapping("/{id}")
    public ColorEntity update(@RequestBody ColorEntity colorEntity, @PathVariable Long id) {
        return colorService.update(colorEntity, id);
    }

    @DeleteMapping("/{id}")
    public ColorEntity delete(@PathVariable Long id) {
        return colorService.delete(id);
    }

    @PatchMapping("/{id}")
    public ColorEntity enable(@PathVariable Long id) {
        return colorService.enable(id);
    }

}
