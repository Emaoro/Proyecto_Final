package com.example.apiatletas.controller;

import com.example.apiatletas.model.Atleta;
import com.example.apiatletas.service.AtletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/atletas")
public class AtletaController {
    private final AtletaService service;
    public AtletaController(AtletaService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Atleta a){ return ResponseEntity.ok(service.save(a)); }

    @GetMapping
    public ResponseEntity<List<Atleta>> list(){ return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Atleta no encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Atleta a){
        return service.findById(id).map(ex -> {
            a.setId(id);
            return ResponseEntity.ok(service.save(a));
        }).orElseGet(() -> ResponseEntity.status(404).body("Atleta no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
