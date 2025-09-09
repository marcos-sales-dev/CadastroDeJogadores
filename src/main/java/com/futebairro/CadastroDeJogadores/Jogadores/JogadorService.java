package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
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
    public JogadorModel criarJogador(JogadorModel jogador){
        return jogadorRepository.save(jogador);
    }

    // Deletar um jogador - Tem que ser um metodo VOID
    public void deletarJogadorPorId (Long id){
        jogadorRepository.deleteById(id);
    }
}
