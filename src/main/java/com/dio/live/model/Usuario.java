package com.dio.live.model;

import lombok.*;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Usuario {
    private long id;
    private String nome;
    private BigDecimal tolerancia;
    private LocalDateTime finalJornada;
    @ManyToOne
    private CategoriaUsuario categoriaUsuario;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private NivelAcesso nivelAcesso;
    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;
}
