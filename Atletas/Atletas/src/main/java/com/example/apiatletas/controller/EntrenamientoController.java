package com.example.apiatletas.controller;

import com.example.apiatletas.model.Entrenamiento;
import com.example.apiatletas.service.EntrenamientoService;
import com.example.apiatletas.service.AtletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/entrenamientos")
public class EntrenamientoController {
    private final EntrenamientoService service;
    private final AtletaService atletaService;

    public EntrenamientoController(EntrenamientoService service, AtletaService atletaService){
        this.service = service;
        this.atletaService = atletaService;
    }

    @PostMapping("/{atletaId}")
    public ResponseEntity<?> create(@PathVariable Long atletaId, @Valid @RequestBody Entrenamiento e){
        return atletaService.findById(atletaId)
                .map(a -> {
                    e.setAtleta(a);
                    return ResponseEntity.ok(service.save(e));
                }).orElseGet(() -> ResponseEntity.status(404).body("Atleta no encontrado"));
    }

    @GetMapping("/{atletaId}")
    public ResponseEntity<?> listByAtleta(@PathVariable Long atletaId){
        return atletaService.findById(atletaId)
                .map(a -> ResponseEntity.ok(service.findByAtleta(a)))
                .orElseGet(() -> ResponseEntity.status(404).body("Atleta no encontrado"));
    }
}
