package com.Goncadex.Goncadex.controller;

import com.Goncadex.Goncadex.model.Usuario;
import com.Goncadex.Goncadex.service.ExpedicaoService;
import com.Goncadex.Goncadex.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/expedicao")
public class ExpedicaoController {
    @Autowired
    private ExpedicaoService expedicaoService;
    @Autowired
    private UsuarioService usuarioService;



    @GetMapping()
    public ModelAndView expedicao() {
        ModelAndView mv = new ModelAndView("expedicao");
        Usuario usuario = usuarioService.getUsuarioLogado();
        mv.addObject("usuario",usuario);
        mv.addObject("pokemon",expedicaoService.expedicao());
        return mv;
    }
    @GetMapping("/matar")
    public String matar(){
        expedicaoService.matarpokemon();
        return "redirect:/user";
    }
    @GetMapping("/capturar")
    public String capturar(){
        expedicaoService.capturar();
        return "redirect:/user";
    }
}
