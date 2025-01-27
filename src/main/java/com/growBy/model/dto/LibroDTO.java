package com.growBy.model.dto;

import lombok.Data;

import java.util.Date;

import com.growBy.entity.GbLibro;

@Data
public class LibroDTO {

    private Long idLibro;
    private String titulo;
    private Integer idAutor;
    private String isbn;
    private Date fechaPublicacion;
    private Integer idEstado;
    private Date fechaRegistro;
    private Date fechaActualizacion;
    
    public LibroDTO(GbLibro libro) {
        this.idLibro = libro.getIdLibro();
        this.titulo = libro.getTitulo();
        this.idAutor = libro.getIdAutor();
        this.isbn = libro.getIsbn();
        this.fechaPublicacion = libro.getFechaPublicacion();
        this.idEstado = libro.getEstado();
        this.fechaRegistro = libro.getFechaRegistro();
        this.fechaActualizacion = libro.getFechaActualizacion();
    }
    
    
    public LibroDTO() {
    }

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
    
}