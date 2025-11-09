package com.example.apiatletas.util;

import com.example.apiatletas.model.Atleta;
import com.example.apiatletas.model.Entrenamiento;
import java.util.List;

public class PagoCalculator {
    public static double calcular(Atleta atleta, List<Entrenamiento> entrenamientos){
        double base = atleta.getSalarioBase() == null ? 0.0 : atleta.getSalarioBase();
        if(entrenamientos == null || entrenamientos.isEmpty()) return base;

        long num = entrenamientos.size();
        long extranjero = entrenamientos.stream().filter(e -> "extranjero".equalsIgnoreCase(e.getLugar())).count();
        long mejoras = entrenamientos.stream().filter(e -> e.getMejoraMarca()!=null && e.getMejoraMarca()).count();

        return base + num * 10.0 + extranjero * 20.0 + mejoras * 30.0;
    }
}
