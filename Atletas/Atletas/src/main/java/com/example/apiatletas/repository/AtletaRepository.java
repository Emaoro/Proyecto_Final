package com.example.apiatletas.repository;

import com.example.apiatletas.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {}
