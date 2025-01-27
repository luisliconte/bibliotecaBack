package com.growBy.model.dto;

import lombok.Data;
import java.util.Date;

import com.growBy.entity.GbPrestamo;

@Data
public class PrestamoDTO {

    private Long idPrestamo;
    private Long idLibro;
    private Integer idEstado;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    
	public PrestamoDTO(GbPrestamo prestamo) {
		this.idPrestamo = prestamo.getIdPrestamo();
		this.idLibro = prestamo.getIdLibro().longValue();
		this.idEstado = prestamo.getIdEstado();
		this.fechaPrestamo = prestamo.getFechaPrestamo();
		this.fechaDevolucion = prestamo.getFechaDevolucion();
		this.fechaCreacion = prestamo.getFechaCreacion();
		this.fechaActualizacion = prestamo.getFechaActualizacion();
	}

    public PrestamoDTO() {
    }
	
	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
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
