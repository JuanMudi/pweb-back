package com.parcial.web.parcial.controller;

import com.parcial.web.parcial.models.celular.DTO.SimpleCelDTO;
import com.parcial.web.parcial.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/celulares")
public class CelularController {

    @Autowired
    private CelularService celularService;

    @PostMapping
    public ResponseEntity<SimpleCelDTO> createCelular(@RequestBody SimpleCelDTO simpleCelDTO) {
        SimpleCelDTO createdCelular = celularService.createCelular(simpleCelDTO);
        return ResponseEntity.ok(createdCelular);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleCelDTO> updateCelular(@PathVariable UUID id, @RequestBody SimpleCelDTO simpleCelDTO) {
        SimpleCelDTO updatedCelular = celularService.updateCelular(id, simpleCelDTO);
        return ResponseEntity.ok(updatedCelular);
    }

    @GetMapping
    public ResponseEntity<List<SimpleCelDTO>> getAllCelulares() {
        List<SimpleCelDTO> celulares = celularService.getAllCelulares();
        return ResponseEntity.ok(celulares);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimpleCelDTO> getCelularById(@PathVariable UUID id) {
        SimpleCelDTO celular = celularService.getCelularById(id);
        return ResponseEntity.ok(celular);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCelular(@PathVariable UUID id) {
        celularService.deleteCelular(id);
        return ResponseEntity.noContent().build();
    }
}
