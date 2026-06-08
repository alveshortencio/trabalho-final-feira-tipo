package com.trabalho.feiratipo.repository;

import com.trabalho.feiratipo.domain.Feira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeiraRepository extends JpaRepository<Feira, Long> {

    boolean existsByLogradouroAndBairroAndAtivaAndIdNot(
        String logradouro, String bairro, boolean ativa, Long id);

    boolean existsByTipoFeiraId(Long tipoFeiraId);
}