package com.example.apiatletas.service;

import com.example.apiatletas.model.Atleta;
import com.example.apiatletas.repository.AtletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaService {

    private final AtletaRepository repo;

    public AtletaService(AtletaRepository repo){
        this.repo = repo;
    }

    public Atleta save(Atleta a){
        return repo.save(a);
    }

    public List<Atleta> findAll(){
        return repo.findAll();
    }

    public Optional<Atleta> findById(Long id){
        return repo.findById(id);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
