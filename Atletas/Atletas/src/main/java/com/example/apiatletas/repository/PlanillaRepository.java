package com.example.apiatletas.repository;

import com.example.apiatletas.model.Planilla;
import com.example.apiatletas.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PlanillaRepository extends JpaRepository<Planilla, Long> {
    List<Planilla> findByAtletaAndMes(Atleta atleta, LocalDate mes);
}
