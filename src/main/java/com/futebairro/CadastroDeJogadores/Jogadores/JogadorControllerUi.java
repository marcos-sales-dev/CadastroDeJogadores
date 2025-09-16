package com.futebairro.CadastroDeJogadores.Jogadores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/jogadores/ui")
public class JogadorControllerUi {

    private final JogadorService jogadorService;

    public JogadorControllerUi(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping("/listar")
    public String listarJogadores(Model model){
        List<JogadorDTO> jogadores = jogadorService.listarJogadores();
        model.addAttribute("jogadores", jogadores);
        return "listarJogadores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarJogadorPorId(@PathVariable Long id) {
        jogadorService.deletarJogadorPorId(id);
        return "redirect:/jogadores/ui/listar";
    }

    @GetMapping("/detalhes/{id}")
    public String mostrarDetalhesJogador(@PathVariable Long id, Model model){
        JogadorDTO jogador = jogadorService.listarJogadoresPorId(id);
        if (jogador != null){
            model.addAttribute("jogador", jogador);
            return "detalhesjogador";
        } else {
            model.addAttribute("mensagem", "Jogador não encontrado");
            return "listarJogadores";
        }
    }


    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarJogador(Model model) {
        model.addAttribute("jogador", new JogadorDTO());
        return "adicionarJogador";
    }

    @PostMapping("/salvar")
    public String salvarJogador (@ModelAttribute JogadorDTO jogador, RedirectAttributes redirectAttributes){
        jogadorService.criarJogador(jogador);
        redirectAttributes.addFlashAttribute("mensagem", "Jogador cadastrado com sucesso!");
        return "redirect:/jogadores/ui/listar";
    }
}
