package com.growBy.mapper;


import org.springframework.stereotype.Component;

import com.growBy.entity.GbLibro;
import com.growBy.model.dto.LibroDTO;

import java.util.Date;

@Component
public class LibroMapper {

    public GbLibro toEntity(LibroDTO libroDTO) {
        if (libroDTO == null) {
            return null;
        }
        GbLibro libro = new GbLibro();
        libro.setIdLibro(libroDTO.getIdLibro());
        libro.setTitulo(libroDTO.getTitulo());
        libro.setIdAutor(libroDTO.getIdAutor());
        libro.setIsbn(libroDTO.getIsbn());
        libro.setFechaPublicacion(libroDTO.getFechaPublicacion());
        libro.setEstado(libroDTO.getIdEstado());
        libro.setFechaRegistro(libroDTO.getFechaRegistro() != null ? libroDTO.getFechaRegistro() : new Date());
        libro.setFechaActualizacion(new Date());
        return libro;
    }

    public LibroDTO toDto(GbLibro libro) {
        if (libro == null) {
            return null;
        }
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setIdLibro(libro.getIdLibro());
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setIdAutor(libro.getIdAutor());
        libroDTO.setIsbn(libro.getIsbn());
        libroDTO.setFechaPublicacion(libro.getFechaPublicacion());
        libroDTO.setIdEstado(libro.getEstado());
        libroDTO.setFechaRegistro(libro.getFechaRegistro());
        libroDTO.setFechaActualizacion(libro.getFechaActualizacion());
        return libroDTO;
    }
}
