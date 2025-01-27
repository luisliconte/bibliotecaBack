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

import com.growBy.model.dto.AutorDTO;
import com.growBy.service.AutorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/autor")
@Tag(name = "Autor", description = "Operaciones relacionadas con Autor")
public class AutorController {


    @Autowired
    private AutorService autorService;
    
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @Operation(summary = "Crear Autor.", description = "Devuelve el autor creado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa"),
        @ApiResponse(responseCode = "500", description = "Error en la base de datos")
    })
    @PostMapping()
    public ResponseEntity<AutorDTO> crearAutor(@RequestBody AutorDTO autorDTO) {
    	AutorDTO nuevoAutor = autorService.crearAutor(autorDTO);
    	
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener todos los autor.", description = "Devuelve una lista de autor disponibles.")
    @GetMapping()
    public ResponseEntity<List<AutorDTO>> obtenerAutor() {
        List<AutorDTO> autor = autorService.obtenerAutor();
        
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @Operation(summary = "Obtener todos los autor por ID.", description = "Devuelve un autor según el ID.")
    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obtenerAutorPorId(@PathVariable("id") Long id) {
        Optional<AutorDTO> autor = autorService.obtenerAutorPorId(id);
        
        return autor.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Actualizar autor por ID.", description = "Devuelve el autor ectualizado.")
    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> actualizarAutor(@PathVariable("id") Long id, @RequestBody AutorDTO autorActualizado) {
   
        Optional<AutorDTO> autorExistente = autorService.obtenerAutorPorId(id);

        if (autorExistente.isPresent()) {
        	AutorDTO actualizado = autorService.actualizarAutor(id, autorActualizado);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Eliminar autor por ID.", description = "Devuelve un mensaje de la operación.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutor(@PathVariable("id") Long id) {
        Optional<AutorDTO> autor = autorService.obtenerAutorPorId(id);
        if (autor.isPresent()) {
        	autorService.eliminarAutor(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    

    @GetMapping("paginados")
    @Operation(summary = "Obtener todos los autor paginado segun la pagina y el tamaño.", description = "Devuelve los libros paginado.")
    public ResponseEntity<Map<String, Object>> listarAutor(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio) {

        Map<String, Object> resultado = autorService.obtenerAutorPaginados(pagina, tamanio);

        return ResponseEntity.ok(resultado);
    }

}
