package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final JogadorMapper jogadorMapper;

    public JogadorService(JogadorRepository jogadorRepository, JogadorMapper jogadorMapper) {
        this.jogadorRepository = jogadorRepository;
        this.jogadorMapper = jogadorMapper;
    }

    // Listar todos os meu jogadores
    public List<JogadorDTO> listarJogadores() {
        List<JogadorModel> jogadores = jogadorRepository.findAll();
        return jogadores.stream()
                .map(jogadorMapper::map)
                .collect(Collectors.toList());
    }

    // Listar todos os meu jogadores por ID
    public JogadorDTO listarJogadoresPorId(Long id) {
        Optional<JogadorModel> jogadorPorId = jogadorRepository.findById(id);
        return jogadorPorId.map(jogadorMapper::map).orElse(null);
    }

    // Criar um novo jogador
    public JogadorDTO criarJogador(JogadorDTO jogadorDTO) {
        JogadorModel jogador = jogadorMapper.map(jogadorDTO);
        jogador = jogadorRepository.save(jogador);
        return jogadorMapper.map(jogador);
    }

    // Deletar um jogador - Tem que ser um metodo VOID
    public void deletarJogadorPorId(Long id) {
        jogadorRepository.deleteById(id);
    }

    // Atualizar jogador
    public JogadorDTO atualizarJogador(Long id, JogadorDTO jogadorDTO) {
        Optional<JogadorModel> jogadorExistente = jogadorRepository.findById(id);
        if (jogadorExistente.isPresent()) {
            JogadorModel jogadorAtualizado = jogadorMapper.map(jogadorDTO);
            jogadorAtualizado.setId(id);
            JogadorModel jogadorSalvo = jogadorRepository.save(jogadorAtualizado);
            return jogadorMapper.map(jogadorSalvo);
        }
        return null;


    }
}
