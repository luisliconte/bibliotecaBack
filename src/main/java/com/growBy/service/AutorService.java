package com.growBy.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growBy.Repository.AutorPaginacionRepository;
import com.growBy.Repository.AutorRepository;
import com.growBy.entity.GbAutor;
import com.growBy.exception.ResourceNotFoundException;
import com.growBy.mapper.AutorMapper;
import com.growBy.model.dto.AutorDTO;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private AutorMapper autorMapper;

	@Autowired
	private AutorPaginacionRepository autorPaginacionRepository;

	@Autowired
	public AutorService(AutorPaginacionRepository autorPaginacionRepository) {
		this.autorPaginacionRepository = autorPaginacionRepository;
	}


	public AutorDTO crearAutor(AutorDTO autorDTO) {
		GbAutor nuevoAutor = autorMapper.toEntity(autorDTO);
		GbAutor autorGuardado = autorRepository.save(nuevoAutor);
		return autorMapper.toDto(autorGuardado);
	}


	public List<AutorDTO> obtenerAutor() {
		List<GbAutor> listaAutor = autorRepository.findAll();
		return listaAutor.stream().map(autorMapper::toDto).toList();
	}

	public Optional<AutorDTO> obtenerAutorPorId(Long id) {

		return autorRepository.findById(id).map(autorMapper::toDto);
	}

	public AutorDTO actualizarAutor(Long id, AutorDTO autorActualizado) {

		return autorRepository.findById(id).map(autor -> {

			autor.setNombre(autorActualizado.getNombre());
			autor.setNacionalidad(autorActualizado.getNacionalidad());
			autor.setFechaNacimiento(autorActualizado.getFechaNacimiento());
			autor.setFechaActualizacion(new Date());

			GbAutor autorGuardado = autorRepository.save(autor);

			return new AutorDTO(autorGuardado);
		}).orElseThrow(() -> new ResourceNotFoundException("El autor con id " + id + " no existe."));
	}


	public void eliminarAutor(Long id) {
		autorRepository.deleteById(id);
	}

	public Map<String, Object> obtenerAutorPaginados(int pagina, int tamanio) {

	    List<GbAutor> listaAutor = autorPaginacionRepository.listarAutorPaginados(pagina, tamanio);
	    List<AutorDTO> autorDTO = listaAutor.stream()
	                                          .map(autorMapper::toDto)
	                                          .collect(Collectors.toList());

	    long totalRegistros = autorPaginacionRepository.contarAutor();

	    Map<String, Object> respuesta = new HashMap<>();
	    respuesta.put("autor", autorDTO);
	    respuesta.put("paginaActual", pagina);
	    respuesta.put("tamanioPagina", tamanio);
	    respuesta.put("totalRegistros", totalRegistros);
	    respuesta.put("totalPaginas", (int) Math.ceil((double) totalRegistros / tamanio));

	    return respuesta;
	}
}