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

import com.growBy.model.dto.PrestamoDTO;
import com.growBy.service.PrestamoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/prestamo")
@Tag(name = "Prestamo", description = "Operaciones relacionadas con prestamo")
public class PrestamoController {


    @Autowired
    private PrestamoService prestamoService;
    

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @Operation(summary = "Crear prerstamo.", description = "Devuelve el prestamo creado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa"),
        @ApiResponse(responseCode = "500", description = "Error en la base de datos")
    })
    @PostMapping()
    public ResponseEntity<PrestamoDTO> crearPrestamo(@RequestBody PrestamoDTO prestamo) {
    	PrestamoDTO nuevoPrestamo = prestamoService.crearPrestamo(prestamo);
    	
        return new ResponseEntity<>(nuevoPrestamo, HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Obtener todos los prerstamo.", description = "Devuelve una lista de prestamo disponibles.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa"),
        @ApiResponse(responseCode = "404", description = "Prestamo no encontrados")
    })
    public ResponseEntity<List<PrestamoDTO>> obtenerPrestamo() {
        List<PrestamoDTO> prestamo = prestamoService.obtenerPrestamo();
        
        return new ResponseEntity<>(prestamo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener todos los prerstamo por ID.", description = "Devuelve un prestamo según el ID.")
    public ResponseEntity<PrestamoDTO> obtenerPrestamoPorId(@PathVariable("id") Long id) {
        Optional<PrestamoDTO> prestamo = prestamoService.obtenerPrestamoPorId(id);
        
        return prestamo.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar prerstamo por ID.", description = "Devuelve el prestamo ectualizado.")
    public ResponseEntity<PrestamoDTO> actualizarPrestamo(@PathVariable("id") Long id, @RequestBody PrestamoDTO prestamoActualizado) {

        Optional<PrestamoDTO> prestamoExistente = prestamoService.obtenerPrestamoPorId(id);

        if (prestamoExistente.isPresent()) {
        	PrestamoDTO actualizado = prestamoService.actualizarPrestamo(id, prestamoActualizado);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar prerstamo por ID.", description = "Devuelve un mensaje de operación.")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable("id") Long id) {
        Optional<PrestamoDTO> prestamo = prestamoService.obtenerPrestamoPorId(id);
        if (prestamo.isPresent()) {
        	prestamoService.eliminarPrestamo(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    
    @GetMapping("paginados")
    @Operation(summary = "Obtener todos los prerstamo paginado segun la pagina y el tamaño.", description = "Devuelve un prestamo paginado.")
    public ResponseEntity<Map<String, Object>> listarPrestamos(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanio) {

        Map<String, Object> resultado = prestamoService.obtenerPrestamosPaginados(pagina, tamanio);

        return ResponseEntity.ok(resultado);
    }
    
    @GetMapping("/libro/{idLibro}")
    @Operation(summary = "Obtener todos los prerstamo de un libro específico.", description = "Devuelve los prestamos por un libro especófico.")
    public Map<String, Object> obtenerPrestamosPorLibro(
            @PathVariable Long idLibro,
            @RequestParam(defaultValue = "1") int pagina, 
            @RequestParam(defaultValue = "10") int tamanio) {
    	
        return prestamoService.obtenerPrestamosPorLibro(idLibro, pagina, tamanio);
    }
    
    
    @GetMapping("/disponibilidad/{idLibro}")
    @Operation(summary = "Comprobar si un libro esta disponible.", description = "Devuelve un mensaje indicando si el libro esta disponible.")
    public ResponseEntity<String> verificarDisponibilidad(@PathVariable Long idLibro) {
        boolean disponible = prestamoService.verificarDisponibilidad(idLibro);

        if (disponible) {
            return ResponseEntity.ok("El libro está disponible");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("El libro no existe o no está disponible");
        }
    }

}
