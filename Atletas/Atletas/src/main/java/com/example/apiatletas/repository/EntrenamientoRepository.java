package com.example.apiatletas.repository;

import com.example.apiatletas.model.Entrenamiento;
import com.example.apiatletas.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {
    List<Entrenamiento> findByAtleta(Atleta atleta);
}
