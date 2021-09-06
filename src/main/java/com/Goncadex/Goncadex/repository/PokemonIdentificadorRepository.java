package com.Goncadex.Goncadex.repository;

import com.Goncadex.Goncadex.model.PokemonIdentificador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonIdentificadorRepository extends JpaRepository<PokemonIdentificador, String> {
}
