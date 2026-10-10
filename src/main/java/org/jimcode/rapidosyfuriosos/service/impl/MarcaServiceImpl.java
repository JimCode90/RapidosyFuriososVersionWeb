package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.MarcaEntity;
import org.jimcode.rapidosyfuriosos.repository.MarcaRepository;
import org.jimcode.rapidosyfuriosos.service.MarcaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<MarcaEntity> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public List<MarcaEntity> findAllCustom() {
        return marcaRepository.findAllCustom();
    }

    @Override
    public MarcaEntity findById(Long id) {
        return marcaRepository.findById(id).get();
    }

    @Override
    public MarcaEntity add(MarcaEntity marcaEntity) {
        return marcaRepository.save(marcaEntity);
    }

    @Override
    public MarcaEntity update(MarcaEntity marcaEntity, Long id) {
        MarcaEntity marca = marcaRepository.findById(id).get();
        BeanUtils.copyProperties(marcaEntity, marca);
        return marcaRepository.save(marca);
    }

    @Override
    public MarcaEntity delete(Long id) {
        MarcaEntity marca = marcaRepository.findById(id).get();
        marca.setEstado(false);
        return marcaRepository.save(marca);
    }

    @Override
    public MarcaEntity enable(Long id) {
        MarcaEntity marca = marcaRepository.findById(id).get();
        marca.setEstado(true);
        return marcaRepository.save(marca);
    }
}
