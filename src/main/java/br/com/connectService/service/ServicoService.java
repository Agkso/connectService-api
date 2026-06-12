package br.com.connectService.service;

import br.com.connectService.dto.ServicoResumoDTO;
import br.com.connectService.entity.Servico;
import br.com.connectService.entity.StatusServico;
import br.com.connectService.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Transactional(readOnly = true)
    public List<ServicoResumoDTO> listarDisponiveis() {
        List<Servico> servicos = servicoRepository.findByStatus(StatusServico.AGUARDANDO_ACEITE);
        return servicos.stream()
                .map(this::converterParaResumo)
                .collect(Collectors.toList());
    }

    private ServicoResumoDTO converterParaResumo(Servico servico) {
        return new ServicoResumoDTO(
                servico.getId(),
                servico.getTipoServico(),
                servico.getDataHora(),
                servico.getLocalizacao(),
                servico.getValorLiquido(),
                servico.getStatus()
        );
    }
}
