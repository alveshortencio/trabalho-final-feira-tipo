package com.trabalho.feiratipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabalho.feiratipo.domain.TipoFeira;

@Repository
public interface TipoFeiraRepository extends JpaRepository<TipoFeira, Long> {
}