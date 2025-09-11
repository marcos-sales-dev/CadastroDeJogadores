package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.stereotype.Component;

@Component
public class JogadorMapper {
    public JogadorModel map(JogadorDTO jogadorDTO){
        JogadorModel jogadorModel = new JogadorModel();
        jogadorModel.setId(jogadorDTO.getId());
        jogadorModel.setNome(jogadorDTO.getNome());
        jogadorModel.setEmail(jogadorDTO.getEmail());
        jogadorModel.setIdade(jogadorDTO.getIdade());
        jogadorModel.setPosicao(jogadorDTO.getPosicao());
        jogadorModel.setTime(jogadorDTO.getTime());
        jogadorModel.setImgUrl(jogadorDTO.getImgUrl());
        jogadorModel.setRank(jogadorDTO.getRank());
        jogadorModel.setTreinamentos(jogadorDTO.getTreinamentos());

        return jogadorModel;
    }

    public JogadorDTO map(JogadorModel jogadorModel){
        JogadorDTO jogadorDTO = new JogadorDTO();
        jogadorDTO.setId(jogadorModel.getId());
        jogadorDTO.setNome(jogadorModel.getNome());
        jogadorDTO.setEmail(jogadorModel.getEmail());
        jogadorDTO.setIdade(jogadorModel.getIdade());
        jogadorDTO.setPosicao(jogadorModel.getPosicao());
        jogadorDTO.setTime(jogadorModel.getTime());
        jogadorDTO.setImgUrl(jogadorModel.getImgUrl());
        jogadorDTO.setRank(jogadorModel.getRank());
        jogadorDTO.setTreinamentos(jogadorModel.getTreinamentos());

        return jogadorDTO;
    }
}
