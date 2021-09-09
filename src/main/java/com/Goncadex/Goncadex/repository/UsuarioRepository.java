package com.Goncadex.Goncadex.repository;

import com.Goncadex.Goncadex.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.print.DocFlavor;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query(value = "select * from Usuario where usuario = ?1 ", nativeQuery = true)
    Usuario findBynome(String nome);
}
