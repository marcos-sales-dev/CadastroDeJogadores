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
    @Column (name = "id")
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "time")
    private String time;

    @Column (unique = true)
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "idade")
    private int idade;

    @Column (name = "posicao")
    private String posicao;

    @Column (name = "rank")
    private String rank;

    // @ManyToOne - Um jogador tem um único treinamento
    @ManyToOne
    @JoinColumn(name = "treinamentos_id") // Foreign Key ou Chave Estrangeira
    private TreinamentosModel treinamentos;
}
