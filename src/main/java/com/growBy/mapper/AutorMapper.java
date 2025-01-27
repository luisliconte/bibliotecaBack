package com.growBy.mapper;


import org.springframework.stereotype.Component;

import com.growBy.entity.GbAutor;
import com.growBy.model.dto.AutorDTO;

@Component
public class AutorMapper {

    public GbAutor  toEntity(AutorDTO  autorDTO) {
        if (autorDTO == null) {
            return null;
        }
        GbAutor  gbAutor  = new GbAutor ();
        gbAutor.setIdAutor(autorDTO.getIdAutor());
        gbAutor.setNombre(autorDTO.getNombre());
        gbAutor.setNacionalidad(autorDTO.getNacionalidad());
        gbAutor.setFechaNacimiento(autorDTO.getFechaNacimiento());
        gbAutor.setFechaCreacion(autorDTO.getFechaCreacion());
        gbAutor.setFechaActualizacion(autorDTO.getFechaActualizacion());
        return gbAutor;
    }

    public AutorDTO toDto(GbAutor gbAutor) {
        if (gbAutor == null) {
            return null;
        }
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setIdAutor(gbAutor.getIdAutor());
        autorDTO.setNombre(gbAutor.getNombre());
        autorDTO.setNacionalidad(gbAutor.getNacionalidad());
        autorDTO.setFechaNacimiento(gbAutor.getFechaNacimiento());
        autorDTO.setFechaCreacion(gbAutor.getFechaCreacion());
        autorDTO.setFechaActualizacion(gbAutor.getFechaActualizacion());
        return autorDTO;
    }
}
