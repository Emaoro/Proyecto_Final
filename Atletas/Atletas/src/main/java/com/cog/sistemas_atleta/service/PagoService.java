package com.cog.sistemas_atleta.service;

import com.cog.sistemas_atleta.model.Pago;
import com.cog.sistemas_atleta.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago calcularPago(int entrenamientos, double bonificacionExtranjero, double bonificacionMejora) {
        double pagoBase = entrenamientos * 50; // ejemplo
        double total = pagoBase + bonificacionExtranjero + bonificacionMejora;

        Pago pago = new Pago();
        pago.setEntrenamientos(entrenamientos);
        pago.setBonificacionExtranjero(bonificacionExtranjero);
        pago.setBonificacionMejora(bonificacionMejora);
        pago.setPagoTotal(total);

        return pagoRepository.save(pago);
    }

    public List<Pago> consultarPagos(Long atletaId) {
        return pagoRepository.findByAtletaId(atletaId);
    }
}
