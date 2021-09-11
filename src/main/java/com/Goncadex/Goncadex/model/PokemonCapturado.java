package com.Goncadex.Goncadex.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="PokemonCapturado")
public class PokemonCapturado {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int idPokemonCapturado;
        @NotNull
        private String nomePokemonCapturado;
        @NotNull
        private String raça;
        @NotNull
        private String identificador;
        @NotNull
        private int dono;

        }

