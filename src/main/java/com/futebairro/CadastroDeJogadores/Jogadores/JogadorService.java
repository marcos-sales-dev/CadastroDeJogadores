package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;
    private JogadorMapper jogadorMapper;

    public JogadorService(JogadorRepository jogadorRepository, JogadorMapper jogadorMapper) {
        this.jogadorRepository = jogadorRepository;
        this.jogadorMapper = jogadorMapper;
    }

    // Listar todos os meu jogadores
    public List<JogadorModel> listarJogadores(){
        return jogadorRepository.findAll();
    }

    // Listar todos os meu jogadores por ID
    public JogadorModel listarJogadoresPorId(Long id){
        Optional<JogadorModel> jogadorPorId = jogadorRepository.findById(id);
        return jogadorPorId.orElse(null);
    }

    // Criar um novo jogador
    public JogadorDTO criarJogador(JogadorDTO jogadorDTO){
        JogadorModel jogador = jogadorMapper.map(jogadorDTO);
        jogador = jogadorRepository.save(jogador);
        return jogadorMapper.map(jogador);
    }

    // Deletar um jogador - Tem que ser um metodo VOID
    public void deletarJogadorPorId (Long id){
        jogadorRepository.deleteById(id);
    }

    // Atualizar jogador
    public JogadorModel atualizarJogador(Long id, JogadorModel jogadorAtualizado){
        if(jogadorRepository.existsById(id)){
            jogadorAtualizado.setId(id);
            return jogadorRepository.save(jogadorAtualizado);
        }
        return null;
    }
}
