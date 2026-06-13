package br.com.connectService.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "servicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoServico;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(name = "data_servico", nullable = false)
    private LocalDate dataServico;

    @Column(name = "horario_inicio", nullable = false)
    private String horarioInicio;

    @Column(name = "horario_fim", nullable = false)
    private String horarioFim;

    @Column(length = 1000)
    private String requisitos;

    @Column(nullable = false)
    private String contratante;

    private Double avaliacao;

    private Boolean possuiAssinatura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusServico status;
}
