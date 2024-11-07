package com.utn.frc.dsi.bonvino.controllers;

import com.utn.frc.dsi.bonvino.entities.Vino;
import com.utn.frc.dsi.bonvino.services.interfaces.VinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/vino")
@RequiredArgsConstructor
public class VinoController {


    private final VinoService vinoService;

    @GetMapping
    public ResponseEntity<List<Vino>> findAll() {
        return ResponseEntity.ok(vinoService.findAll());
    }

    // Agregar un nuevo cliente
    @PostMapping
    public ResponseEntity<Vino> addClient(@RequestBody Vino vino) {
        try {
            Vino responseValue = vinoService.create(vino);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseValue);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vino> findById(@PathVariable Integer id) {
        try {
            Vino responseValue = vinoService.findById(id);
            return ResponseEntity.ok(responseValue);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Actualizar un cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Vino> updateClient(@PathVariable Integer id, @RequestBody Vino vino) {
        try {
            Vino updatedClient = vinoService.update(id, vino);
            return ResponseEntity.ok(updatedClient);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        try {
            vinoService.delete(id);
            return ResponseEntity.noContent().build();  // Retorna 204 No Content si se eliminó correctamente
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

