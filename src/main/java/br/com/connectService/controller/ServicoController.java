package br.com.connectService.controller;

import br.com.connectService.dto.ServicoDetalheDTO;
import br.com.connectService.dto.ServicoResumoDTO;
import br.com.connectService.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public List<ServicoResumoDTO> listarDisponiveis() {
        return servicoService.listarDisponiveis();
    }

    @GetMapping("/{id}")
    public ServicoDetalheDTO buscarPorId(@PathVariable Long id) {
        return servicoService.buscarPorId(id);
    }
}
