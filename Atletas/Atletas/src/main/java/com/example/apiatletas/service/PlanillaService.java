package com.example.apiatletas.service;

import com.example.apiatletas.model.Planilla;
import com.example.apiatletas.model.Atleta;
import com.example.apiatletas.model.Entrenamiento;
import com.example.apiatletas.util.PagoCalculator;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PlanillaService {
    private final PlanillaRepository repo;
    private final EntrenamientoService entrenamientoService;

    public PlanillaService(PlanillaRepository repo, EntrenamientoService entrenamientoService){
        this.repo = repo;
        this.entrenamientoService = entrenamientoService;
    }

    public Planilla calcularYGuardar(Atleta atleta, LocalDate mes){
        List<Entrenamiento> entrenamientos = entrenamientoService.findByAtleta(atleta);
        double monto = PagoCalculator.calcular(atleta, entrenamientos);
        Planilla p = Planilla.builder().atleta(atleta).mes(mes).monto(monto).build();
        return repo.save(p);
    }

    public List<Planilla> findByAtletaYMes(Atleta atleta, LocalDate mes){
        return repo.findByAtletaAndMes(atleta, mes);
    }
}
