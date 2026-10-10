package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.EstadoCivilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivilEntity, Long> {

    @Query("select ec from EstadoCivilEntity ec where ec.estado=true")
    List<EstadoCivilEntity> findAllCustom();
}
