package br.com.connectService.dto;

import br.com.connectService.entity.StatusServico;

import java.math.BigDecimal;
import java.util.List;

public record ServicoDetalheDTO(
        Long id,
        String tipoServico,
        String categoria,
        BigDecimal valor,
        String dataServico,
        String horarioInicio,
        String horarioFim,
        String bairro,
        String cidade,
        String estado,
        String endereco,
        List<String> requisitos,
        String contratante,
        Double avaliacao,
        StatusServico status
) {}

