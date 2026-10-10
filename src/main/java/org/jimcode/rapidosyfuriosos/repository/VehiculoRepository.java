package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

    @Query("select v from VehiculoEntity v where v.estado=true")
    List<VehiculoEntity> findAllCustom();
}
