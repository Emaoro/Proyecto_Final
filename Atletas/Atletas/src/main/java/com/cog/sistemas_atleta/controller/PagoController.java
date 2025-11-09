package com.cog.sistemas_atleta.controller;

import com.cog.sistemas_atleta.model.Pago;
import com.cog.sistemas_atleta.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping("/calcularPago")
    public Pago calcularPago(@RequestParam int entrenamientos,
                             @RequestParam double bonificacionExtranjero,
                             @RequestParam double bonificacionMejora) {
        return pagoService.calcularPago(entrenamientos, bonificacionExtranjero, bonificacionMejora);
    }

    @GetMapping("/pagos/{atletaId}")
    public List<Pago> obtenerPagos(@PathVariable Long atletaId) {
        return pagoService.consultarPagos(atletaId);
    }
}
