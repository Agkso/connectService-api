package br.com.connectService.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    private String tamanhoLocal;
    private Integer quantidadePessoas;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String localizacao;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(nullable = false)
    private BigDecimal valorSugerido;

    @Column(nullable = false)
    private BigDecimal valorLiquido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusServico status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empregador_id", nullable = false)
    private Usuario empregador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestador_id")
    private Usuario prestador;

    @PrePersist
    @PreUpdate
    public void calcularValorLiquido() {
        if (this.valorSugerido != null) {
            this.valorLiquido = this.valorSugerido.multiply(new BigDecimal("0.80"));
        }
    }
}
