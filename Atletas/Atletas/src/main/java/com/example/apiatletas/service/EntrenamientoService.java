package com.example.apiatletas.service;

import com.example.apiatletas.model.Entrenamiento;
import com.example.apiatletas.model.Atleta;
import com.example.apiatletas.repository.EntrenamientoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntrenamientoService {
    private final EntrenamientoRepository repo;
    public EntrenamientoService(EntrenamientoRepository repo){ this.repo = repo; }
    public Entrenamiento save(Entrenamiento e){ return repo.save(e); }
    public List<Entrenamiento> findByAtleta(Atleta a){ return repo.findByAtleta(a); }
}
