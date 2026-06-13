package br.com.connectService.service;

import br.com.connectService.dto.ServicoDetalheDTO;
import br.com.connectService.dto.ServicoResumoDTO;
import br.com.connectService.entity.Servico;
import br.com.connectService.entity.StatusServico;
import br.com.connectService.exception.ServicoNotFoundException;
import br.com.connectService.mapper.ServicoMapper;
import br.com.connectService.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ServicoMapper servicoMapper;

    @Transactional(readOnly = true)
    public List<ServicoResumoDTO> listarDisponiveis() {
        return servicoRepository
                .findByStatus(StatusServico.AGUARDANDO_ACEITE)
                .stream()
                .map(servicoMapper::toResumoDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public ServicoDetalheDTO buscarPorId(Long id) {
        Servico servico = servicoRepository
                .findById(id)
                .orElseThrow(() ->
                        new ServicoNotFoundException("Serviço ID: " + id + " não encontrado"));

        return servicoMapper.toDetalheDTO(servico);
    }
}