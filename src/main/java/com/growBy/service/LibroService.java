package com.growBy.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growBy.Repository.LibroPaginacionRepository;
import com.growBy.Repository.LibroRepository;
import com.growBy.entity.GbLibro;
import com.growBy.exception.ResourceNotFoundException;
import com.growBy.mapper.LibroMapper;
import com.growBy.model.dto.LibroDTO;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private LibroMapper libroMapper;

	@Autowired
	private LibroPaginacionRepository libroPaginacionRepository;

	@Autowired
	public LibroService(LibroPaginacionRepository libroPaginacionRepository) {
		this.libroPaginacionRepository = libroPaginacionRepository;
	}


	public LibroDTO crearLibro(LibroDTO libro) {
		GbLibro nuevoLibro = libroMapper.toEntity(libro);
		GbLibro libroGuardado = libroRepository.save(nuevoLibro);
		return libroMapper.toDto(libroGuardado);
	}

	public List<LibroDTO> obtenerLibros() {
		List<GbLibro> listaLibro = libroRepository.findAll();
		return listaLibro.stream().map(libroMapper::toDto).toList();
	}


	public Optional<LibroDTO> obtenerLibroPorId(Long id) {

		return libroRepository.findById(id).map(libroMapper::toDto);
	}

	public LibroDTO actualizarLibro(Long id, LibroDTO libroActualizado) {
		
		return libroRepository.findById(id).map(libro -> {

			libro.setTitulo(libroActualizado.getTitulo());
			libro.setIdAutor(libroActualizado.getIdAutor());
			libro.setIsbn(libroActualizado.getIsbn());
			libro.setFechaPublicacion(libroActualizado.getFechaPublicacion());
			libro.setFechaActualizacion(new Date());

			GbLibro libroGuardado = libroRepository.save(libro);

			return new LibroDTO(libroGuardado);
		}).orElseThrow(() -> new ResourceNotFoundException("El libro con id " + id + " no existe."));
	}

	public void eliminarLibro(Long id) {
		System.out.print(id + "ide de prueba eliminar");
		libroRepository.deleteById(id);
	}

	public Map<String, Object> obtenerLibroPaginados(int pagina, int tamanio) {
	    List<GbLibro> listaLibros = libroPaginacionRepository.listarLibroPaginados(pagina, tamanio);
	    List<LibroDTO> librosDTO = listaLibros.stream()
	                                          .map(libroMapper::toDto)
	                                          .collect(Collectors.toList());

	    long totalRegistros = libroPaginacionRepository.contarLibro();

	    Map<String, Object> respuesta = new HashMap<>();
	    respuesta.put("libros", librosDTO);
	    respuesta.put("paginaActual", pagina);
	    respuesta.put("tamanioPagina", tamanio);
	    respuesta.put("totalRegistros", totalRegistros);
	    respuesta.put("totalPaginas", (int) Math.ceil((double) totalRegistros / tamanio));

	    return respuesta;
	}
}