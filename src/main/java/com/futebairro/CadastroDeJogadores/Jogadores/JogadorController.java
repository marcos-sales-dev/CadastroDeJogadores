package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarJogador(@RequestBody JogadorDTO jogadorDTO) {
        JogadorDTO novoJogador = jogadorService.criarJogador(jogadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Jogador criado com sucesso: " + novoJogador.getNome() + " ID: " + novoJogador.getId());
    }

    // Mostrar todos os jogadores (READ)
    @GetMapping ("/listar")
    public ResponseEntity<List<JogadorDTO>> listarJogadores(){
       List<JogadorDTO> jogadores = jogadorService.listarJogadores();
       return ResponseEntity.ok(jogadores);
    }

    // Mostrar jogadolr por ID (READ)
    @GetMapping ("/listar/{id}")
    public ResponseEntity<?> listarJogadoresPorId(@PathVariable Long id){

        JogadorDTO jogador = jogadorService.listarJogadoresPorId(id);
        if (jogador !=null){
            return ResponseEntity.ok(jogador);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Jogador com id " + id + " não existe no banco de dados.");
        }
    }

    // Alterar dados dos jogadores (UPDATE)
    @PutMapping ("/alterar/{id}")
    public ResponseEntity<?> alterarJogadorPorId(@PathVariable Long id, @RequestBody JogadorDTO jogadorAtualizado){

        JogadorDTO jogador = jogadorService.atualizarJogador(id, jogadorAtualizado);
        if (jogador != null) {
            return ResponseEntity.ok(jogador);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Jogador com id " + id + " não existe no banco de dados.");
        }

    }

    // Deletar jogador (DELETE)
    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity<String> deletarJogadorPorId(@PathVariable Long id){

        if (jogadorService.listarJogadoresPorId(id) !=null) {
            jogadorService.deletarJogadorPorId(id);
            return ResponseEntity.ok("Jogador com ID: " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O jogador com o id " + id + " não encontrado.");
        }
    }
}
