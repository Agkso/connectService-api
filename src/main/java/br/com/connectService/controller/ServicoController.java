package br.com.connectService.controller;

import br.com.connectService.dto.ServicoResumoDTO;
import br.com.connectService.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<List<ServicoResumoDTO>> listarDisponiveis() {
        List<ServicoResumoDTO> servicos = servicoService.listarDisponiveis();
        return ResponseEntity.ok(servicos);
    }
}
