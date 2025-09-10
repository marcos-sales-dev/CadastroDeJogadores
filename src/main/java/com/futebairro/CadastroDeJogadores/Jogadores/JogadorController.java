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
    public JogadorDTO criarJogador(@RequestBody JogadorDTO jogadorDTO) {
        return jogadorService.criarJogador(jogadorDTO);
    }

    // Mostrar todos os jogadores (READ)
    @GetMapping ("/listar")
    public List<JogadorDTO> listarJogadores(){
        return jogadorService.listarJogadores();
    }

    // Mostrar jogadolr por ID (READ)
    @GetMapping ("/listar/{id}")
    public JogadorDTO listarJogadoresPorId(@PathVariable Long id){
        return jogadorService.listarJogadoresPorId(id);
    }

    // Alterar dados dos jogadores (UPDATE)
    @PutMapping ("/alterar/{id}")
    public JogadorDTO alterarJogadorPorId(@PathVariable Long id, @RequestBody JogadorDTO jogadorAtualizado){
        return jogadorService.atualizarJogador(id, jogadorAtualizado);
    }

    // Deletar jogador (DELETE)
    @DeleteMapping ("/deletar/{id}")
    public void deletarJogadorPorId(@PathVariable Long id){
        jogadorService.deletarJogadorPorId(id);
    }
}
