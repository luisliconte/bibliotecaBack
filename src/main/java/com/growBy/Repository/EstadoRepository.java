package com.growBy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growBy.entity.GbEstado;

@Repository
public interface EstadoRepository extends JpaRepository<GbEstado, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}
