package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.ServicioEntity;
import org.jimcode.rapidosyfuriosos.repository.ServicioRepository;
import org.jimcode.rapidosyfuriosos.service.ServicioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<ServicioEntity> findAll() {
        return servicioRepository.findAll();
    }

    @Override
    public List<ServicioEntity> findAllCustom() {
        return servicioRepository.findAllCustom();
    }

    @Override
    public ServicioEntity findById(Long id) {
        return servicioRepository.findById(id).get();
    }

    @Override
    public ServicioEntity add(ServicioEntity servicioEntity) {
        return servicioRepository.save(servicioEntity);
    }

    @Override
    public ServicioEntity update(ServicioEntity servicioEntity, Long id) {
        ServicioEntity servicio = servicioRepository.findById(id).get();
        BeanUtils.copyProperties(servicioEntity, servicio);
        return servicioRepository.save(servicio);
    }

    @Override
    public ServicioEntity delete(Long id) {
        ServicioEntity servicio = servicioRepository.findById(id).get();
        servicio.setEstado(false);
        return servicioRepository.save(servicio);
    }

    @Override
    public ServicioEntity enable(Long id) {
        ServicioEntity servicio = servicioRepository.findById(id).get();
        servicio.setEstado(true);
        return servicioRepository.save(servicio);
    }
}
