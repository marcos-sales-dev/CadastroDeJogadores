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

}
