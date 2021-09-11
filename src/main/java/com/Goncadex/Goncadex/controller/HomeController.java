package com.Goncadex.Goncadex.controller;

import com.Goncadex.Goncadex.model.Usuario;
import com.Goncadex.Goncadex.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/user")
    public ModelAndView user() {
        String user = usuarioService.buscarUsuarioLogado();
        Usuario usuario = usuarioService.procurarUsuario(user);
        ModelAndView mv = new ModelAndView("User");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @GetMapping()
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("Index");
        String user = usuarioService.buscarUsuarioLogado();
        mv.addObject("user", user);
        return mv;
    }

    @GetMapping("/registro")
    public ModelAndView registo() {
        ModelAndView mv = new ModelAndView("registro");
        return mv;
    }

    @PostMapping("/registro")
    public String cadastro(String usuario, String senha) {
        usuarioService.cadastrarUsuario(usuario, senha);
        return "redirect:/login";

    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("Login");
        return mv;
    }
}
