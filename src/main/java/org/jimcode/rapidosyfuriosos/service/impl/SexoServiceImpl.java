package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.SexoEntity;
import org.jimcode.rapidosyfuriosos.repository.SexoRepository;
import org.jimcode.rapidosyfuriosos.service.SexoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexoServiceImpl implements SexoService {

    @Autowired
    private SexoRepository sexoRepository;

    @Override
    public List<SexoEntity> findAll() {
        return sexoRepository.findAll();
    }

    @Override
    public List<SexoEntity> findAllCustom() {
        return sexoRepository.findAllCustom();
    }

    @Override
    public SexoEntity findById(Long id) {
        return sexoRepository.findById(id).get();
    }

    @Override
    public SexoEntity add(SexoEntity sexoEntity) {
        return sexoRepository.save(sexoEntity);
    }

    @Override
    public SexoEntity update(SexoEntity sexoEntity, Long id) {
        SexoEntity sexo = sexoRepository.findById(id).get();
        BeanUtils.copyProperties(sexoEntity, sexo);
        return sexoRepository.save(sexo);
    }

    @Override
    public SexoEntity delete(Long id) {
        SexoEntity sexo = sexoRepository.findById(id).get();
        sexo.setEstado(false);
        return sexoRepository.save(sexo);
    }

    @Override
    public SexoEntity enable(Long id) {
        SexoEntity sexo = sexoRepository.findById(id).get();
        sexo.setEstado(true);
        return sexoRepository.save(sexo);
    }
}
