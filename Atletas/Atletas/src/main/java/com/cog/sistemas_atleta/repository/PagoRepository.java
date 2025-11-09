package com.cog.sistemas_atleta.repository;

import com.cog.sistemas_atleta.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByAtletaId(Long atletaId);
}
