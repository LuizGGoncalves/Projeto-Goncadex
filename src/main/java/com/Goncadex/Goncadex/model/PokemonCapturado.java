package com.Goncadex.Goncadex.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="PokemonCapturado")
public class PokemonCapturado extends Pokemon {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int idPokemonCapturado;
        @NotNull
        private String nomePokemonCapturado;
        @NotNull
        private int dono;
        @NotNull
        private String name;
        @NotNull
        private float height;
        @NotNull
        private float weight;
        @NotNull
        private float Ataque;
        @NotNull
        private float defesa;
        @NotNull
        private float velocidade;
        @NotNull
        private float VidaMaxima;
        @NotNull
        private float vidaCombate;
        @NotNull
        private String sprite;

        }

