package com.Goncadex.Goncadex.service;

import com.Goncadex.Goncadex.model.Expedicao;
import com.Goncadex.Goncadex.model.Pokemon;

public interface ExpedicaoService {
    Boolean verificarExpedicao();
    Expedicao criarExpedicao(String pokemonAlvo);
    Expedicao retomarExpedicao();
    Pokemon expedicao();
    void matarpokemon();
    void capturar();
}
