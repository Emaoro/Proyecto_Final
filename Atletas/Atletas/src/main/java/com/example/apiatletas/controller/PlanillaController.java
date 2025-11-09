package com.example.apiatletas.controller;

import com.example.apiatletas.service.PlanillaService;
import com.example.apiatletas.service.AtletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/planillas")
public class PlanillaController {
    private final PlanillaService service;
    private final AtletaService atletaService;

    public PlanillaController(PlanillaService service, AtletaService atletaService){
        this.service = service;
        this.atletaService = atletaService;
    }

    @PostMapping("/calcular/{atletaId}")
    public ResponseEntity<?> calcular(@PathVariable Long atletaId, @RequestParam String fecha){
        LocalDate mes = LocalDate.parse(fecha);
        return atletaService.findById(atletaId)
                .map(a -> ResponseEntity.ok(service.calcularYGuardar(a, mes)))
                .orElseGet(() -> ResponseEntity.status(404).body("Atleta no encontrado"));
    }
}
