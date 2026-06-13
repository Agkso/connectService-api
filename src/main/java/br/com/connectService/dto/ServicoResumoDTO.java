package br.com.connectService.dto;

import br.com.connectService.entity.StatusServico;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ServicoResumoDTO(
    Long id,
    String tipoServico,
    String categoria,
    String bairro,
    String cidade,
    String estado,
    BigDecimal valor,
    String dataServico,
    String horarioInicio,
    Boolean possuiAssinatura,
    StatusServico status
) {}
