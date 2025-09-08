package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
