package com.example.apiatletas.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "entrenamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entrenamiento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String lugar;

    private Boolean mejoraMarca;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private Atleta atleta;
}
