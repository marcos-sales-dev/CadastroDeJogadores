package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class JogadorController {

    //Metodo publico para todos que acessarem a rota
    @GetMapping ("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar jogador (CREATE)
    @PostMapping("/criar")
    public String criarJogador(){
        return "Jogador criado";
    }

    // Mostrar todos os jogadores (READ)
    @GetMapping ("/todos")
    public String mostrarTodosOsJogadores(){
        return "Mostrar jogador";
    }

    // Mostrar jogador por ID (READ)
    @GetMapping ("/todosID")
    public String mostrarTodosOsJogadoresPorId(){
        return "Mostrar jogador por ID";
    }

    // Alterar dados dos jogadores (UPDATE)
    @PutMapping ("/alterarID")
    public String alterarJogadorPorId(){
        return "Alterar jogador por id";
    }

    // Deletar jogador (DELETE)
    @DeleteMapping ("/deletarID")
    public String deletarJogadorPorId(){
        return "Jogador deletado por id";
    }
}
