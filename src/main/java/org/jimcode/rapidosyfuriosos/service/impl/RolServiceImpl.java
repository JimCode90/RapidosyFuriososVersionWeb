package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.RolEntity;
import org.jimcode.rapidosyfuriosos.repository.RolRepository;
import org.jimcode.rapidosyfuriosos.service.RolService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolEntity> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public List<RolEntity> findAllCustom() {
        return rolRepository.findAllCustom();
    }

    @Override
    public RolEntity findById(Long id) {
        return rolRepository.findById(id).get();
    }

    @Override
    public RolEntity add(RolEntity rolEntity) {
        return rolRepository.save(rolEntity);
    }

    @Override
    public RolEntity update(RolEntity rolEntity, Long id) {
        RolEntity rol = rolRepository.findById(id).get();
        BeanUtils.copyProperties(rolEntity, rol);
        return rolRepository.save(rol);
    }

    @Override
    public RolEntity delete(Long id) {
        RolEntity rol = rolRepository.findById(id).get();
        rol.setEstado(false);
        return rolRepository.save(rol);
    }

    @Override
    public RolEntity enable(Long id) {
        RolEntity rol = rolRepository.findById(id).get();
        rol.setEstado(true);
        return rolRepository.save(rol);
    }
}
