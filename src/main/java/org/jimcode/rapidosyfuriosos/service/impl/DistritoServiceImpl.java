package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.DistritoEntity;
import org.jimcode.rapidosyfuriosos.repository.DistritoRepository;
import org.jimcode.rapidosyfuriosos.service.DistritoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Indicamos que es un servicio
@Service
// Implementamos el servicio
public class DistritoServiceImpl implements DistritoService {

    // Inyección de dependencias hacia el repositorio
    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoEntity> findAll() {
        return distritoRepository.findAll();
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return distritoRepository.findAllCustom();
    }

    @Override
    public DistritoEntity findById(Long id) {
        return distritoRepository.findById(id).get();
    }

    @Override
    public DistritoEntity add(DistritoEntity distritoEntity) {
        return distritoRepository.save(distritoEntity);
    }

    @Override
    public DistritoEntity update(DistritoEntity distritoEntity, Long id) {
        DistritoEntity distrito = distritoRepository.findById(id).get();
        BeanUtils.copyProperties(distritoEntity, distrito);
        return distritoRepository.save(distrito);
    }

    @Override
    public DistritoEntity delete(Long id) {
        DistritoEntity distrito = distritoRepository.findById(id).get();
        distrito.setEstado(false);
        return distritoRepository.save(distrito);
    }

    @Override
    public DistritoEntity enable(Long id) {
        DistritoEntity distrito = distritoRepository.findById(id).get();
        distrito.setEstado(true);
        return distritoRepository.save(distrito);
    }
}
