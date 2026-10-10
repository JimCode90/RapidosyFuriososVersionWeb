package org.jimcode.rapidosyfuriosos.service.impl;

import org.jimcode.rapidosyfuriosos.entity.TipoDocumentoEntity;
import org.jimcode.rapidosyfuriosos.repository.TipoDocumentoRepository;
import org.jimcode.rapidosyfuriosos.service.TipoDocumentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumentoEntity> findAll() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public List<TipoDocumentoEntity> findAllCustom() {
        return tipoDocumentoRepository.findAllCustom();
    }

    @Override
    public TipoDocumentoEntity findById(Long id) {
        return tipoDocumentoRepository.findById(id).get();
    }

    @Override
    public TipoDocumentoEntity add(TipoDocumentoEntity tipoDocumentoEntity) {
        return tipoDocumentoRepository.save(tipoDocumentoEntity);
    }

    @Override
    public TipoDocumentoEntity update(TipoDocumentoEntity tipoDocumentoEntity, Long id) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findById(id).get();
        BeanUtils.copyProperties(tipoDocumentoEntity, tipoDocumento);
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public TipoDocumentoEntity delete(Long id) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findById(id).get();
        tipoDocumento.setEstado(false);
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public TipoDocumentoEntity enable(Long id) {
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepository.findById(id).get();
        tipoDocumento.setEstado(true);
        return tipoDocumentoRepository.save(tipoDocumento);
    }
}
