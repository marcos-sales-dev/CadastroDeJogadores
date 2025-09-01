package com.futebairro.CadastroDeJogadores.Jogadores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class JogadorController {

    //Metodo publico para todos que acessarem a rota
    @GetMapping ("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }
}
