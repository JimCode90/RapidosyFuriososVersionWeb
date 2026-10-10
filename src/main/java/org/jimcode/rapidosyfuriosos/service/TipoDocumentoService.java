package org.jimcode.rapidosyfuriosos.service;

import org.jimcode.rapidosyfuriosos.entity.TipoDocumentoEntity;

import java.util.List;

public interface TipoDocumentoService {

    // Mostrar tipos documento
    List<TipoDocumentoEntity> findAll();

    // Mostrar tipos documento habilitado
    List<TipoDocumentoEntity> findAllCustom();

    // Buscar tipo documento por código
    TipoDocumentoEntity findById(Long id);

    // Registrar tipo documento
    TipoDocumentoEntity add(TipoDocumentoEntity tipoDocumentoEntity);

    // Actualizar tipo documento
    TipoDocumentoEntity update(TipoDocumentoEntity tipoDocumentoEntity, Long id);

    // Eliminar de manera lógica un tipo documento
    TipoDocumentoEntity delete(Long id);

    // Habilitar un tipo documento
    TipoDocumentoEntity enable(Long id);
}
