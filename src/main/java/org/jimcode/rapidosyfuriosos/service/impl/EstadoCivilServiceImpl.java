package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.EstadoCivilEntity;
import org.jimcode.rapidosyfuriosos.repository.EstadoCivilRepository;
import org.jimcode.rapidosyfuriosos.service.EstadoCivilService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService
{
    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @Override
    public List<EstadoCivilEntity> findAll() {
        return estadoCivilRepository.findAll();
    }

    @Override
    public List<EstadoCivilEntity> findAllCustom() {
        return estadoCivilRepository.findAllCustom();
    }

    @Override
    public EstadoCivilEntity findById(Long id) {
        return estadoCivilRepository.findById(id).get();
    }

    @Override
    public EstadoCivilEntity add(EstadoCivilEntity estadoCivilEntity) {
        return estadoCivilRepository.save(estadoCivilEntity);
    }

    @Override
    public EstadoCivilEntity update(EstadoCivilEntity estadoCivilEntity, Long id) {
        EstadoCivilEntity estadoCivil = estadoCivilRepository.findById(id).get();
        BeanUtils.copyProperties(estadoCivilEntity, estadoCivil);
        return estadoCivilRepository.save(estadoCivil);
    }

    @Override
    public EstadoCivilEntity delete(Long id) {
        EstadoCivilEntity estadoCivil = estadoCivilRepository.findById(id).get();
        estadoCivil.setEstado(false);
        return estadoCivilRepository.save(estadoCivil);
    }

    @Override
    public EstadoCivilEntity enable(Long id) {
        EstadoCivilEntity estadoCivil = estadoCivilRepository.findById(id).get();
        estadoCivil.setEstado(true);
        return estadoCivilRepository.save(estadoCivil);
    }
}
