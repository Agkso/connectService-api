package br.com.connectService.dto;

import br.com.connectService.entity.StatusServico;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ServicoResumoDTO(
    Long id,
    String tipoServico,
    LocalDateTime dataHora,
    String localizacao,
    BigDecimal valorLiquido,
    StatusServico status
) {}
