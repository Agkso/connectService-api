package br.com.connectService.config;

import br.com.connectService.entity.Servico;
import br.com.connectService.entity.StatusServico;
import br.com.connectService.entity.TipoPerfil;
import br.com.connectService.entity.Usuario;
import br.com.connectService.repository.ServicoRepository;
import br.com.connectService.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final ServicoRepository servicoRepository;

    public DataLoader(UsuarioRepository usuarioRepository, ServicoRepository servicoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.servicoRepository = servicoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario emp1 = Usuario.builder()
                .nome("Maria de Fátima")
                .email("maria.fatima@email.com")
                .cpf("123.456.789-01")
                .telefone("(11) 98765-4321")
                .tipoPerfil(TipoPerfil.EMPREGADOR)
                .build();

        Usuario emp2 = Usuario.builder()
                .nome("João do Carmo")
                .email("joao.carmo@email.com")
                .cpf("987.654.321-09")
                .telefone("(11) 91234-5678")
                .tipoPerfil(TipoPerfil.EMPREGADOR)
                .build();

        Usuario prest1 = Usuario.builder()
                .nome("Ana Prestadora")
                .email("ana.prestadora@email.com")
                .cpf("456.789.123-12")
                .telefone("(11) 95555-4444")
                .tipoPerfil(TipoPerfil.PRESTADOR)
                .build();

        usuarioRepository.saveAll(Arrays.asList(emp1, emp2, prest1));

        Servico s1 = Servico.builder()
                .tipoServico("Limpeza de Apartamento 2 Quartos")
                .tamanhoLocal("De 50m² a 100m²")
                .quantidadePessoas(3)
                .dataHora(LocalDateTime.of(2026, 6, 15, 9, 0))
                .localizacao("Rua das Figueiras, 450 - Bairro Jardim, Santo André - SP")
                .observacoes("Trazer produtos de limpeza. Temos gatos no local.")
                .valorSugerido(new BigDecimal("200.00"))
                .status(StatusServico.AGUARDANDO_ACEITE)
                .empregador(emp1)
                .build();

        Servico s2 = Servico.builder()
                .tipoServico("Faxina Pesada Pós-Obra")
                .tamanhoLocal("Acima de 100m²")
                .quantidadePessoas(5)
                .dataHora(LocalDateTime.of(2026, 6, 18, 8, 0))
                .localizacao("Av. Paulista, 1000 - Bela Vista, São Paulo - SP")
                .observacoes("Necessário lavadora de alta pressão no local.")
                .valorSugerido(new BigDecimal("500.00"))
                .status(StatusServico.AGUARDANDO_ACEITE)
                .empregador(emp2)
                .build();

        Servico s3 = Servico.builder()
                .tipoServico("Passagem de Roupa")
                .tamanhoLocal("Até 50m²")
                .quantidadePessoas(1)
                .dataHora(LocalDateTime.of(2026, 6, 20, 14, 0))
                .localizacao("Rua Augusta, 1500 - Consolação, São Paulo - SP")
                .observacoes("Ferro de passar já disponível no local.")
                .valorSugerido(new BigDecimal("100.00"))
                .status(StatusServico.AGUARDANDO_ACEITE)
                .empregador(emp1)
                .build();

        servicoRepository.saveAll(Arrays.asList(s1, s2, s3));
        System.out.println(">>> Banco de dados inicializado com dados mockados com sucesso! <<<");
    }
}
