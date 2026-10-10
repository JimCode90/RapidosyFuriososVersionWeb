package org.jimcode.rapidosyfuriosos.repository;

import org.jimcode.rapidosyfuriosos.entity.DistritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistritoRepository extends JpaRepository<DistritoEntity, Long> {
    // Utilizamos el JpaRepository por defecto se configura:
    // Mostrar, Buscar por código, Registrar, Actualizar y Eliminar

    // Agregamos un Query Personalizado, parte de una consulta MYSQL: Select * from distrito where estdis = 1
    // Creamos un Query Personalizado
    @Query("select d from DistritoEntity d where d.estado=true")
    List<DistritoEntity> findAllCustom();
}
