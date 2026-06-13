package br.com.connectService.mapper;

import br.com.connectService.dto.ServicoDetalheDTO;
import br.com.connectService.dto.ServicoResumoDTO;
import br.com.connectService.entity.Servico;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicoMapper {

    public ServicoResumoDTO toResumoDTO(Servico servico) {
        return new ServicoResumoDTO(
                servico.getId(),
                servico.getTipoServico(),
                servico.getCategoria(),
                servico.getBairro(),
                servico.getCidade(),
                servico.getEstado(),
                servico.getValor(),
                servico.getDataServico().toString(),
                servico.getHorarioInicio(),
                servico.getPossuiAssinatura(),
                servico.getStatus()
        );
    }

    public ServicoDetalheDTO toDetalheDTO(Servico servico) {
        List<String> requisitos =
                servico.getRequisitos() == null
                        ? List.of()
                        : Arrays.stream(servico.getRequisitos().split(";"))
                        .map(String::trim)
                        .toList();

        return new ServicoDetalheDTO(
                servico.getId(),
                servico.getTipoServico(),
                servico.getCategoria(),
                servico.getValor(),
                servico.getDataServico().toString(),
                servico.getHorarioInicio(),
                servico.getHorarioFim(),
                servico.getBairro(),
                servico.getCidade(),
                servico.getEstado(),
                servico.getEndereco(),
                requisitos,
                servico.getContratante(),
                servico.getAvaliacao(),
                servico.getStatus()
        );
    }
}