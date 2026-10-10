package org.jimcode.rapidosyfuriosos.restcontroller;

import org.jimcode.rapidosyfuriosos.entity.ClienteEntity;
import org.jimcode.rapidosyfuriosos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClientRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/custom")
    public List<ClienteEntity> findAllCustom() {
        return clienteService.findAllCustom();
    }

    @GetMapping("/{id}")
    public ClienteEntity findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public ClienteEntity save(@RequestBody ClienteEntity clienteEntity) {
        return clienteService.add(clienteEntity);
    }

    @PutMapping("/{id}")
    public ClienteEntity update(@RequestBody ClienteEntity clienteEntity, @PathVariable Long id) {
        return clienteService.update(clienteEntity, id);
    }

    @DeleteMapping("/{id}")
    public ClienteEntity delete(@PathVariable Long id) {
        return clienteService.delete(id);
    }

    @PatchMapping("/{id}")
    public ClienteEntity enable(@PathVariable Long id) {
        return clienteService.enable(id);
    }

}
