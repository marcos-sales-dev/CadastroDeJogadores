package com.futebairro.CadastroDeJogadores.Treinamentos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("treinamentos")
public class TreinamentosController {

    // GET -- Mandar uma requisição para mostrar os treinamentos
    @GetMapping ("/listar")
    public String listarTreinamento(){
        return "Treinamentos listados com sucesso.";
    }

    // POST -- Mandar uma requisição para criar os treinamentos
    @PostMapping ("/criar")
    public String criarTreinamento(){
        return "Treinamento criado com sucesso.";
    }

    // PUT -- Mandar uma requisição para alterar os treinamentos
    @PutMapping ("/alterar")
    public String alterarTreinamento(){
        return "Treinamento alterado com sucesso.";
    }

    // DELETE -- Mandar requisição para deletar os treinamentos
    @DeleteMapping ("/deletar")
    public String deletarTreinamento(){
        return "Treinamento deletado com sucesso.";
    }

}
