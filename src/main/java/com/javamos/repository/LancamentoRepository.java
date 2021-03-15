package com.javamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamos.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{
  
}
