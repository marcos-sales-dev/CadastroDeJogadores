package com.futebairro.CadastroDeJogadores.Jogadores;

import com.futebairro.CadastroDeJogadores.Treinamentos.TreinamentosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// @Entity ele transforma uma classe em uma entidade do banco de dados
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String time;

    private String email;

    private int idade;

    private String posicao;

    // @ManyToOne - Um jogador tem um único treinamento
    @ManyToOne
    @JoinColumn(name = "treinamentos_id") // Foreign Key ou Chave Estrangeira
    private TreinamentosModel treinamentos;
}
