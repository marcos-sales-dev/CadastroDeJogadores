package com.futebairro.CadastroDeJogadores.Treinamentos;

import com.futebairro.CadastroDeJogadores.Jogadores.JogadorModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_treinamentos")
public class TreinamentosModel {

    @Id
    private Long id;

    private String nome;

    private String dificuldade;

    // @OneToMany - Um treinamento pode ter vários jogadores
    @OneToMany (mappedBy = "treinamentos")
    private List<JogadorModel> jogadores;
}
