package com.cog.sistemas_atleta.model;

import javax.persistence.*;
import java.time.LocalDate;
import com.cog.sistemas_atleta.model.Atleta; // Cambia si tu Atleta está en otro paquete

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private Double monto;

    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private Atleta atleta;
}
