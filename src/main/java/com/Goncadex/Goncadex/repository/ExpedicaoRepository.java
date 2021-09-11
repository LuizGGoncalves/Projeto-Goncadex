package com.Goncadex.Goncadex.repository;

import com.Goncadex.Goncadex.model.Expedicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedicaoRepository extends JpaRepository<Expedicao, String> {
    Expedicao findByUser(String user);

}
