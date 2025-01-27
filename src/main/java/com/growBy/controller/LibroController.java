package com.growBy.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.growBy.model.dto.LibroDTO;
import com.growBy.service.LibroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/libro")
@Tag(name = "Libros", description = "Operaciones relacionadas con libros")
public class LibroController {


    @Autowired
    private LibroService libroService;
    
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @Operation(summary = "Crear Libro.", description = "Devuelve el libro creado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa"),
        @ApiResponse(responseCode = "500", description = "Error en la base de datos")
    })
    @PostMapping()
    public ResponseEntity<LibroDTO> crearLibro(@RequestBody LibroDTO libro) {
    	LibroDTO nuevoLibro = libroService.crearLibro(libro);
    	
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los libro.", description = "Devuelve una lista de libro disponibles.")
    @GetMapping()
    public ResponseEntity<List<LibroDTO>> obtenerLibros() {
        List<LibroDTO> libros = libroService.obtenerLibros();
        
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @Operation(summary = "Obtener todos los libro por ID.", description = "Devuelve un libro según el ID.")
    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable("id") Long id) {
        Optional<LibroDTO> libro = libroService.obtenerLibroPorId(id);
        
        return libro.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Actualizar libro por ID.", description = "Devuelve el libro ectualizado.")
    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable("id") Long id, @RequestBody LibroDTO libroActualizado) {
        Optional<LibroDTO> libroExistente = libroService.obtenerLibroPorId(id);

        if (libroExistente.isPresent()) {
        	LibroDTO actualizado = libroService.actualizarLibro(id, libroActualizado);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Eliminar libro por ID.", description = "Devuelve un mensaje de la operación.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable("id") Long id) {
        Optional<LibroDTO> libro = libroService.obtenerLibroPorId(id);
        if (libro.isPresent()) {
        	libroService.eliminarLibro(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    

    @GetMapping("paginados")
    @Operation(summary = "Obtener todos los libros paginado segun la pagina y el tamaño.", description = "Devuelve los libros paginado.")
    public ResponseEntity<Map<String, Object>> listarLibro(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio) {

        // Obtener préstamos paginados
        Map<String, Object> resultado = libroService.obtenerLibroPaginados(pagina, tamanio);

        return ResponseEntity.ok(resultado);
    }

}
