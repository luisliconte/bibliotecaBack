package com.growBy.mapper;

import org.springframework.stereotype.Component;

import com.growBy.entity.GbPrestamo;
import com.growBy.model.dto.PrestamoDTO;

@Component
public class PrestamoMapper {

    // Convierte la entidad GbPrestamo a un DTO de Prestamo
    public PrestamoDTO toDto(GbPrestamo gbPrestamo) {
        if (gbPrestamo == null) {
            return null;
        }

        PrestamoDTO prestamoDTO = new PrestamoDTO();
        prestamoDTO.setIdPrestamo(gbPrestamo.getIdPrestamo());
        prestamoDTO.setIdLibro(gbPrestamo.getIdLibro().longValue());
        prestamoDTO.setIdEstado(gbPrestamo.getIdEstado());
        prestamoDTO.setFechaPrestamo(gbPrestamo.getFechaPrestamo());
        prestamoDTO.setFechaDevolucion(gbPrestamo.getFechaDevolucion());
        prestamoDTO.setFechaCreacion(gbPrestamo.getFechaCreacion());
        prestamoDTO.setFechaActualizacion(gbPrestamo.getFechaActualizacion());

        return prestamoDTO;
    }

    // Convierte un DTO de Prestamo a la entidad GbPrestamo
    public GbPrestamo toEntity(PrestamoDTO prestamoDTO) {
        if (prestamoDTO == null) {
            return null;
        }

        GbPrestamo gbPrestamo = new GbPrestamo();
        gbPrestamo.setIdPrestamo(prestamoDTO.getIdPrestamo());
        gbPrestamo.setIdLibro(prestamoDTO.getIdLibro().intValue());
        gbPrestamo.setIdEstado(prestamoDTO.getIdEstado());
        gbPrestamo.setFechaPrestamo(prestamoDTO.getFechaPrestamo());
        gbPrestamo.setFechaDevolucion(prestamoDTO.getFechaDevolucion());
        gbPrestamo.setFechaCreacion(prestamoDTO.getFechaCreacion());
        gbPrestamo.setFechaActualizacion(prestamoDTO.getFechaActualizacion());

        return gbPrestamo;
    }
}
