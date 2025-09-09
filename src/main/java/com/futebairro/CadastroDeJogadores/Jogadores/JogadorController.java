package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/jogadores")
public class JogadorController {

    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    //Metodo publico para todos que acessarem a rota
    @GetMapping ("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar jogador (CREATE)
    @PostMapping("/criar")
    public JogadorModel criarJogador(@RequestBody JogadorModel jogador){
        return jogadorService.criarJogador(jogador);
    }

    // Mostrar todos os jogadores (READ)
    @GetMapping ("/listar")
    public List<JogadorModel> listarJogadores(){
        return jogadorService.listarJogadores();
    }

    // Mostrar jogadolr por ID (READ)
    @GetMapping ("/listar/{id}")
    public JogadorModel listarJogadoresPorId(@PathVariable Long id){
        return jogadorService.listarJogadoresPorId(id);
    }

    // Alterar dados dos jogadores (UPDATE)
    @PutMapping ("/alterarID")
    public String alterarJogadorPorId(){
        return "Alterar jogador por id";
    }

    // Deletar jogador (DELETE)
    @DeleteMapping ("/deletar/{id}")
    public void deletarJogadorPorId(@PathVariable Long id){
        jogadorService.deletarJogadorPorId(id);
    }
}
