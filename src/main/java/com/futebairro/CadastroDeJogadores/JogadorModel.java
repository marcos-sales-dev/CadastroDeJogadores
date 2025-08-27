package com.futebairro.CadastroDeJogadores;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

// @Entity ele transforma uma classe em uma entidade do banco de dados
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
public class JogadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String time;
    private String email;
    private int idade;

    public JogadorModel() {
    }

    public JogadorModel(String nome, String time, String email, int idade) {
        this.nome = nome;
        this.time = time;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
