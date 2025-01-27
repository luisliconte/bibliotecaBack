package com.growBy.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growBy.Repository.LibroRepository;
import com.growBy.Repository.PrestamoPaginacionRepository;
import com.growBy.Repository.PrestamoRepository;
import com.growBy.entity.GbLibro;
import com.growBy.entity.GbPrestamo;
import com.growBy.exception.ResourceNotFoundException;
import com.growBy.mapper.PrestamoMapper;
import com.growBy.model.dto.PrestamoDTO;

@Service
public class PrestamoService {

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private PrestamoMapper prestamoMapper;

	@Autowired
	private PrestamoRepository prestamoRepository;

	private final PrestamoPaginacionRepository prestamoPaginacionRepository;

	@Autowired
	public PrestamoService(PrestamoPaginacionRepository prestamoPaginacionRepository) {
		this.prestamoPaginacionRepository = prestamoPaginacionRepository;
	}

	public PrestamoDTO crearPrestamo(PrestamoDTO prestamo) {
		prestamo.setFechaCreacion(new Date());
		GbPrestamo nuevoPrestamo = prestamoMapper.toEntity(prestamo);
		GbPrestamo prestamoGuardado = prestamoRepository.save(nuevoPrestamo);
		return prestamoMapper.toDto(prestamoGuardado);
	}

	public List<PrestamoDTO> obtenerPrestamo() {
		List<GbPrestamo> listaPrestamo = prestamoRepository.findAll();
		return listaPrestamo.stream().map(prestamoMapper::toDto).toList();
	}

	public Optional<PrestamoDTO> obtenerPrestamoPorId(Long id) {
		return prestamoRepository.findById(id).map(prestamoMapper::toDto);
	}

	public PrestamoDTO actualizarPrestamo(Long id, PrestamoDTO prestamoActualizado) {

		return prestamoRepository.findById(id).map(prestamo -> {

			prestamo.setIdLibro(prestamoActualizado.getIdLibro().intValue());
			prestamo.setIdEstado(prestamoActualizado.getIdEstado());
			prestamo.setFechaPrestamo(prestamoActualizado.getFechaPrestamo());
			prestamo.setFechaDevolucion(prestamoActualizado.getFechaDevolucion());
			prestamo.setFechaActualizacion(new Date());
			
			GbPrestamo prestamoGuardado = prestamoRepository.save(prestamo);

			return new PrestamoDTO(prestamoGuardado);
		}).orElseThrow(() -> new ResourceNotFoundException("El prestamo con id " + id + " no existe."));
	}

	public void eliminarPrestamo(Long id) {
		prestamoRepository.deleteById(id);
	}

	public Map<String, Object> obtenerPrestamosPaginados(int pagina, int tamanio) {
		
		List<GbPrestamo> listaPrestamos = prestamoPaginacionRepository.listarPrestamosPaginados(pagina, tamanio);
		List<PrestamoDTO> prestamoDTO = listaPrestamos.stream().map(prestamoMapper::toDto).collect(Collectors.toList());

		long totalRegistros = prestamoPaginacionRepository.contarPrestamos();

		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("prestamos", prestamoDTO);
		respuesta.put("paginaActual", pagina);
		respuesta.put("tamanioPagina", tamanio);
		respuesta.put("totalRegistros", totalRegistros);
		respuesta.put("totalPaginas", (int) Math.ceil((double) totalRegistros / tamanio));

		return respuesta;
	}

	public Map<String, Object> obtenerPrestamosPorLibro(Long idLibro, int pagina, int tamanio) {
		// Listar préstamos de un libro específico paginados
		List<GbPrestamo> listaPrestamos = prestamoPaginacionRepository.listarPrestamosPorLibroPaginados(idLibro, pagina,
				tamanio);

		List<PrestamoDTO> prestamoDTO = listaPrestamos.stream().map(prestamoMapper::toDto) // Convierte cada entidad
																							// GbLibro a un DTO
				.collect(Collectors.toList());

		long totalRegistros = prestamoPaginacionRepository.contarPrestamosPorLibro(idLibro);

		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("prestamos", prestamoDTO);
		respuesta.put("paginaActual", pagina);
		respuesta.put("tamanioPagina", tamanio);
		respuesta.put("totalRegistros", totalRegistros);
		respuesta.put("totalPaginas", (int) Math.ceil((double) totalRegistros / tamanio));

		return respuesta;
	}

	public boolean verificarDisponibilidad(Long idLibro) {

		Optional<GbLibro> libro = libroRepository.findById(idLibro);

		if (!libro.isPresent()) {
			return false;
		}
		long prestamosActivos = prestamoRepository.contarPrestamosActivosPorLibro(idLibro);
		return prestamosActivos == 0;
	}
}
