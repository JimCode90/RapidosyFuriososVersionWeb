package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.TipoDocumentoEntity;
import org.jimcode.rapidosyfuriosos.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipodocumento")
public class TipoDocumentoRestController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumentoEntity> findAll() {
        return tipoDocumentoService.findAll();
    }

    @GetMapping("/custom")
    public List<TipoDocumentoEntity> findAllCustom() {
        return tipoDocumentoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public TipoDocumentoEntity findById(@PathVariable Long id) {
        return tipoDocumentoService.findById(id);
    }

    @PostMapping
    public TipoDocumentoEntity save(@RequestBody TipoDocumentoEntity tipoDocumentoEntity) {
        return tipoDocumentoService.add(tipoDocumentoEntity);
    }

    @PutMapping("/{id}")
    public TipoDocumentoEntity update(@RequestBody TipoDocumentoEntity tipoDocumentoEntity, @PathVariable Long id) {
        return tipoDocumentoService.update(tipoDocumentoEntity, id);
    }

    @DeleteMapping("/{id}")
    public TipoDocumentoEntity delete(@PathVariable Long id) {
        return tipoDocumentoService.delete(id);
    }

    @PatchMapping("/{id}")
    public TipoDocumentoEntity enable(@PathVariable Long id) {
        return tipoDocumentoService.enable(id);
    }

}
