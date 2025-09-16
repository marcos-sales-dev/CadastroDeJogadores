package com.futebairro.CadastroDeJogadores.Jogadores;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    //Metodo publico para todos que acessarem a rota
    @GetMapping ("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mesagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar jogador (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo jogador", description = "Rota que cria um novo jogador e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Jogador criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Não foi possível criar o jogador")
    })
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
    @Operation(summary = "Lista um jogador por ID", description = "Rota que lista um jogador pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogador encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possível encontrar o jogador")
    })
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
    @Operation(summary = "Altera um jogador por ID", description = "Rota que altera um jogador pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jogador alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possível alterar o jogador")
    })
    public ResponseEntity<?> alterarJogadorPorId(
            @Parameter(description = "Usuário manda o Id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do jogador a ser atualizado no corpo da requisição")
            @RequestBody JogadorDTO jogadorAtualizado){

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
