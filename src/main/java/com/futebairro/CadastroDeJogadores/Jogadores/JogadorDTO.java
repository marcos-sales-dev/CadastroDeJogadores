package com.futebairro.CadastroDeJogadores.Jogadores;

import com.futebairro.CadastroDeJogadores.Treinamentos.TreinamentosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogadorDTO {

    private Long id;
    private String nome;
    private String time;
    private String email;
    private String imgUrl;
    private int idade;
    private String posicao;
    private String rank;
    private TreinamentosModel treinamentos;
}
