package com.Goncadex.Goncadex.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
@Entity
@Table(name="PokemonCapturado")
public class PokemonCapturado {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int idPokemonCapturado;
        @NotNull
        private String nomePokemonCapturado;
        private int dono;

        public int getDono() {
            return dono;
        }

        public void setDono(int dono) {
            this.dono = dono;
        }

        public int getIdPokemonCapturado() {
            return idPokemonCapturado;
        }

        public void setIdPokemonCapturado(int idPokemonCapturado) {
            this.idPokemonCapturado = idPokemonCapturado;
        }

        public String getNomePokemonCapturado() {
            return nomePokemonCapturado;
        }

        public void setNomePokemonCapturado(String nomePokemonCapturado) {
            this.nomePokemonCapturado = nomePokemonCapturado;
        }

    }
