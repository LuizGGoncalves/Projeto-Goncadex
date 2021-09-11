package com.Goncadex.Goncadex.service;

import com.Goncadex.Goncadex.model.Usuario;

public interface UsuarioService {
    void cadastrarUsuario(String nome, String senha);
    Usuario procurarUsuario(String nome);
    String buscarUsuarioLogado();
    Usuario getUsuarioLogado();

}
