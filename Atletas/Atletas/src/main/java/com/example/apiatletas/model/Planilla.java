package com.example.apiatletas.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "planillas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planilla {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate mes;

    private Double monto;

    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private Atleta atleta;
}
