package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {

    @Query("select td from TipoDocumentoEntity td where td.estado=true")
    List<TipoDocumentoEntity> findAllCustom();
}
