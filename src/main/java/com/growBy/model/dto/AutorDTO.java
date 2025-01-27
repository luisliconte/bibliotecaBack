package com.growBy.model.dto;

import lombok.Data;
import java.util.Date;

import com.growBy.entity.GbAutor;

@Data
public class AutorDTO {

    private Long idAutor;
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    
	public AutorDTO(GbAutor gbAutor) {
		this.idAutor = gbAutor.getIdAutor();
		this.nombre = gbAutor.getNombre();
		this.nacionalidad = gbAutor.getNacionalidad();
		this.fechaNacimiento = gbAutor.getFechaNacimiento();
		this.fechaCreacion = gbAutor.getFechaCreacion();
		this.fechaActualizacion = gbAutor.getFechaActualizacion();
	}

	public AutorDTO() {

	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
    
    
}
